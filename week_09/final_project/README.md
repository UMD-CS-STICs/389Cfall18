# Final Project: Ethereum Smart Contract

## Due Date

This project is due on *Friday, December 7th at 11:59:59PM*. The late deadline is *Monday, December 10th at 11:59:59PM* for 15% penalty.

## Overview

In this project, you'll get to create your own Ethereum smart contract — not a simplification, but a real contract that can be deployed on Ethereum's network! **You have the option to work solo or with a partner, though we highly encourage working with a partner since smart contracts can be complex**. You'll get to:

- manage participants in the contract
- recieve and allocate ether via functions in your contract
  
You have free reign over what type of application you want to make (more on that below), but you must first get approval from John and I. In order to get permission, send an email to both of us outlining the purpose of your contract and how it will satisfy the the following constraints:

- Must be able to handle a variable amount of participants
- Must have at least one payable function
- Must punish any dishonest participants in the contract
- Must disallow new participants after the contract is over/finished (if your contract has a terminal state)

**When you turn in your solidity file, you must provide a written description of what your contract does, how it should run (i.e., if I want to participate in your contract, how am I supposed to call functions, what should be the expected behavior, etc.), and how it satisfies the constraints above (i.e., how are malicious participants handled, what mechanism terminates your contract if it's supposed to terminate, etc.). You will not get credit if you forget to include the write-up and we cannot figure out how your contract is supposed to run.**

## Types of Contracts

We will discuss this more during class when we enter our Ethereum weeks, but Ethereum's smart contract platform is useful for creating several different types of applications. We've listed a few below, along with a description and some reading materials, but feel free to choose a type of application that is not listed here!

- [ERC-20](https://en.wikipedia.org/wiki/ERC-20) (Ethereum tokens) - these contracts create tokens that run on top of Ethereum's network, such as EOS, Filecoin, OmiseGo, and more. Here is an example of an ERC-20 token, [VeChain](https://etherscan.io/address/0xd850942ef8811f2a866692a623011bde52a462c1#code). This contract implements the 6 required functions, plus functions for creating the initial token sale.
- [ERC-721](http://erc721.org/) (Ethereum collectibles) - these contracts create [non-fungible](https://en.wikipedia.org/wiki/Non-fungible_token) tokens that can be used as collectibles. The most famous example of this is cryptokitties, which is a platform that allows participants to create and trade kittens that are represented by Ethereum tokens. The value in ERC-721 tokens is that your collectibles are owned by your address, which means there is always proof-of-ownership for your collectibles, and your trades are protected cryptographically, so long as you don't lose your private keys.
- Voting (Ethereum decentralized voting) - these contracts create a voting structure that allows participants to vote on options based on whatever rules you decide to set. A good example of this can be found in the default contract on [Remix](remix.ethereum.org).
- Betting (Ethereum gambling) - these contracts create decentralized gambling platforms, where participants can bet without having to trust the honest behavior of other participants. An example can be found in this directory in the `pool.sol` contract.

**Note that for all of the types of contracts provided, you must add or change some functionality to the contract to make it significantly different than the examples provided.**

### IDE Instructions

While you are allowed to use whatever text editor you'd like to complete this project (Sublime, Atom, Emacs, etc.), we **strongly** recommend you use Ethereum's Remix IDE, which can be found at [remix.ethereum.org](remix.ethereum.org). This IDE includes a compiler and debugger, which will be super useful for writing your contract correctly. Remix comes with a compiler and debugger, and is very useful for performing specific actions to test your contract. You can create a new file, or just replace the code in the default file (ballot.sol). It is not a requirement of solidity to name your contract the same thing as the file, although in the real world it is good practice. We also recommend using Remix since we will go in depth on how to use Remix in class over the second half of the semester.

**Please remember to copy your code regularly into a local file on your computer. If your browser crashes or you close your tab on accident and your cookie is not saved for some reason, all of your code will be gone when you revisit remix.etherem.org.**

## Submission

When you are finished, submit a zip file to the submit server containing your custom contract and write-up. Only one partner needs to submit the zip.
