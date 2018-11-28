pragma solidity ^0.5.0;
contract Pool {

    struct Player {
        uint choice;
        bool sent;
    }
    
    mapping(address => Player) players;
    address payable[] addresses;
    mapping(address => bool) malicious;
    uint8 num_of_players;
    uint8 max_players;
    bool protocol_is_finished;

    // You can assume num is always >= 2
    // You can assume that at least one winner will be an honest participant
    constructor (uint8 num) public {
        if (num < 2) {
            revert();
        }
        // Create a new Pool system. The pool is first come first serve. The
        // number of players in this instance of the pool is determined by num
        // when the contract is initiated. Players are required to submit their
        // choice of the winning team along with a deposit of 1 ETH. When
        // all players have submitted their choice, the winning players are
        // automatically determined, and the deposits are then split evenly
        // among the winning player. If a player tries to submit two choices
        // (i.e., change their bet at any point), they are marked as malicious
        // and are not allowed to collect money even if they are one of the
        // winners. If a player is marked as malicious but is on the winning
        // team, the total deposits should just be distributed among the honest
        // winners. If a player is marked as malicious but is on the losing team,
        // they can be ignored because they would not have won any money anyway.
        max_players = num;
        num_of_players = 0;
    }
    
    // Send in your choice $(num).
    function choice(uint8 num) public payable {
        // If they send any more or less than 1 ETH or we've already run and
        // completed the protocol, revert
        if (msg.value != 1 ether || protocol_is_finished) {
            revert();
        }
        Player storage sender = players[msg.sender];
        // if a player is trying make a choice that is not 0 or 1, or is
        // trying to change their vote, return the ether to them and penalize
        // them by marking their deposit to be sent to the honest
        // winner(s)
        if (sender.sent || (num != 0 && num != 1)) {
            malicious[msg.sender] = true;
            msg.sender.transfer(1 ether);
            return;
        }
        addresses.push(msg.sender);
        sender.sent = true;
        sender.choice = num;
        num_of_players++;
        // if all players have joined, determine the winner and send money
        if (num_of_players == max_players) {
            payWinner();
        }
    }
    
    // You can always assume at least one winner is honest
    function payWinner() public {
        if (protocol_is_finished) revert();
        uint winningTeam = uint(blockhash(block.number-1)) % 2;
        uint8 num_of_winners = 0;
        for (uint8 i = 0; i < num_of_players; i++) {
            if (players[addresses[i]].choice == winningTeam &&
                !malicious[addresses[i]]) {
                num_of_winners++;
            }
        }
        uint payout = (num_of_players * 1000) / num_of_winners;
        for (uint8 j = 0; j < num_of_players; j++) {
            if (players[addresses[j]].choice == winningTeam &&
                !malicious[addresses[j]]) {
                addresses[j].transfer(payout * 1 finney);
            }
        }
        protocol_is_finished = true;
    }
}