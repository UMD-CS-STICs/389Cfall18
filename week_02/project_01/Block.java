import com.google.common.hash.Hashing;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;

public class Block {

  /* Use the Google Guava module to hash all of your values like so:

     byte[] hash = Hashing.sha256().hashBytes(myByteArray).asBytes();

     The hashBytes method takes a byte array and returns a HashCode,
     so the asBytes() method will return the HashCode as a byte
     array so that you can rehash values easily.

     Side note: As we mentioned in class, SHA-256 is used so that it
     is near impossible to figure out an initial value v if only given
     the hash of v. If you want, you can convince yourself of that by
     trying it here! See if you can guess a byte array just given the
     target Merkle tree hashes present in the public tests! (Spoiler
     Alert: you can't, but it might still be fun to experiment some and
     see how similar values still spit out wildly different hashes :))
  */

  private byte[] prevBlockHash;
  private ArrayList<byte[]> txs;
  private int nonce;
  private byte[] blockHash;
  private byte[] merkleTree;

  public Block(byte[] prevBlockHash, ArrayList<byte[]> txs) {
    this.prevBlockHash = prevBlockHash;
    this.txs = txs;
  }

  public Block() {
    /* Leave empty */
  }

  public byte[] intToByteArray(int nonce) {
    return ByteBuffer.allocate(4).order(ByteOrder.BIG_ENDIAN).putInt(nonce).array();
  }

  /* Build your Merkle tree here. You will need to group your transactions
     together in order (i.e., 0-1, 2-3, 4-5, ... (n - 1)-n) so that you can
     hash the proper root together with the previous block hash and nonce.
     See the project description for more details on tree structure.
   */
  public byte[] buildMerkleTree(ArrayList<byte[]> txs) {
    /* Your code here */
    return null;
  }

  /* Build your block here. You will need to create a Merkle
     tree out of your transaction list, and hash the root together
     with the previous block id and the correct nonce. Remember, the
     nonce must yield two leading 0s for simplicity (i.e., the
     first two values in your byte array should be 0). When you
     have the correct number of leading 0s, store the byte array in
     this.blockHash

     NOTE: IN ORDER TO REACH THE PROPER TARGET, YOU MUST CONCATENATE YOUR DATA
     IN THIS ORDER: (1) prevBlockHash, (2) merkleTree root, (3) nonce
   */
  public void buildBlock() {
    /* Your code here */
  }

  /* This method is intended to validate blocks. Remember that for a block
     to be valid, it has to have the correct number of leading 0s (in
     this case, 2) and if you hash the published prevBlockHash, merkleTree,
     and nonce together, it should equal the published hash of the block (target).
   */
  public boolean isValidBlock(byte[] prevBlockHash, byte[] merkleTree, int nonce, byte[] target) {
    /* Your code here */
    return false;
  }

  public int getNonce() {
    return this.nonce;
  }

  public byte[] getMerkleTree() {
    return this.merkleTree;
  }

  public byte[] getBlockHash() {
    return this.blockHash;
  }

}
