# Project 2: Verifying Transactions

## Due Date

This codelab is due on *Friday, October 12th at 11:59:59PM*. The late deadline is *Monday, October 15th at 11:59:59PM* for 15% penalty.

## Overview

In this codelab, you'll get to act as a node on Bitcoin's network whose job is to verify incoming transactions. You'll get to:
- verify signatures and create new UTXOs
- keep track of and update the UTXO pool as you verify transactions
  
Note that a transaction can reference another in the same block. Also, among the transactions received in a single block, more than one transaction may spend the same output. This would of course be a double-spend, and hence invalid. This means that transactions can’t be validated in isolation; it is a tricky problem to choose a subset of transactions that are together valid.
You will be provided with a `Transaction` class that represents a Bitcoin transaction and has inner classes Transaction.Output and Transaction.Input.
  
A transaction output consists of a value and a public key to which it is being paid. For the public keys, we use the built-in Java `PublicKey` class.
  
A transaction input consists of the hash of the transaction that contains the previous output, the index of this output in that transaction (indices are simply integers starting from 0), and a digital signature. For the input to be valid, the signature it contains must be a valid signature over the previous transaction with the public key in the spent output. More specifically, the raw data that is signed is obtained from the `getRawDataToSign(int index)` method. To verify a signature, you will have to use the `verifySignature()` method included in the provided file Crypto.java:
  
`public static boolean verifySignature(PublicKey pubKey, byte[] message, byte[] signature)`
  
This method takes a public key, a message and a signature, and returns true if and only `signature` correctly verifies over message with the public key `pubKey`.
  
Note that you are only given code to verify signatures, and this is all that you will need for this assignment. The computation of signatures is done outside the Transaction class by an entity that knows the appropriate private keys.
  
A transaction consists of a list of inputs, a list of outputs and a unique transaction ID. The Transaction class also contains methods to add and remove an input, add an output, compute digests to sign/hash, add a signature to an input, and compute and store the hash of the transaction once all inputs/outputs/signatures have been added.
  
You will also be provided with a `UTXO` class that represents an unspent transaction output. A UTXO contains the hash of the transaction from which it originates as well as its index within that transaction. We have included `equals`, `hashCode`, and `compareTo` functions in `UTXO` that allow the testing of equality and comparison between two UTXOs, but it is not likely that you will need to use all of the methods.
  
Lastly, you will be provided with a `UTXOPool` class that represents the current set of outstanding UTXOs and contains a map from each UTXO to its corresponding transaction output. This class contains constructors to create a new empty `UTXOPool` or a copy of a given `UTXOPool`, and methods to:
- Add and remove UTXOs from the pool
- Get the output corresponding to a given UTXO
- Check if a UTXO is in the pool
- Get a list of all UTXOs in the pool.

You will be responsible for implementing a file called `TxHandler.java` that implements the following API:
   
```java
public class TxHandler {
  
  public TxHandler (UTXOPool utxoPool) {
    /*
     * Creates a public ledger whose current UTXOPool (collection of unspent
     * transaction outputs) is utxoPool. This should make a defensive copy of
     * utxoPool by using the UTXOPool(UTXOPool uPool) constructor.
     */
  }
  
  public boolean isValidTx (Transaction tx) {
    /*
     * Returns true if
     * (1) all outputs claimed by tx as inputs are in the current UTXO pool,
     * (2) the signatures on each input of tx are valid,
     * (3) no UTXO is claimed multiple times by tx,
     * (4) all of tx’s output values are non-negative, and
     * (5) the sum of tx’s input values is greater than or equal to the sum of its output values; and false otherwise. */
  }
  
  public Transaction[] handleTxs (Transaction[] possibleTxs) {
    /*
     * Handles each call by receiving an unordered array of proposed
     * transactions, checking each transaction for correctness,
     * returning a mutually valid array of accepted transactions,
     * and updating the current UTXO pool as appropriate.
     */
  }

}

```
 
Your implementation of `handleTxs()` should return a mutually valid transaction set of maximal size (one that can’t be enlarged simply by adding more transactions). It does not need to compute a set of maximum size (one for which there is no larger mutually valid transaction set). Based on the transactions it has chosen to accept, `handleTxs` should also update its internal `UTXOPool` to reflect the current set of unspent transaction outputs, so that future calls to `handleTxs()` and `isValidTx()` are able to correctly process/validate transactions that claim outputs from transactions that were accepted in a previous call to `handleTxs()`.

## Setting Up

Before starting this codelab, run `git pull` in your terminal in the `389Cfall18` directory to update your local copy of the class repository. This will pull in the project_02 folder, which has all of the files you need to complete the project, including testing libraries.

If you have not already cloned the class repository, run `git clone https://github.com/UMD-CS-STICs/389Cfall18.git`. This will automatically pull in the most up-to-date files.

### Eclipse Instructions

**Note:** These instructions were created using Eclipse Oxygen. If you are having trouble with another version, try to mirror the instructions using your version.

1. Open Eclipse
2. Click File -> Import...
3. Under General, select "Projects from Folder or Archive", then click next.
4. Click Directory, then navigate to and select the "project_2" folder and open it. Then click Finish.
5. Your project should be set up correctly at this point. Make sure the public tests will run.
6. (Optional if you have errors with libraries) Select all the jar files in the project's "lib" folder in the Eclipse project directory. Right click them while selected, choose -> "Build Path" -> "Add to Build Path".

### IntelliJ Instructions

1. Open IntelliJ
2. Click "Import Project"
3. Find & open the "project_2" folder
3. Click "Next" until the dialogue is finished
   * Make sure you are using JDK 1.8
   * Once you click "Finish", IntelliJ should create all of the appropriate folders for you and source your jar files correctly.
4. Done! If you open the PublicTests file and click run, it should run smoothly! (You will fail all the tests though since you haven't implemented any code yet.)
5. You are now free to implement the methods in the TxHandler.java file.

### Command Line Instructions

**Note:** These commands assume you're running them from the 'project_2' directory.

When using the command line, you can use whatever text editor you like (such as Emacs, Vim, or Sublime Text). Whenever you want to run the public tests to check your progress, do the following:
1. `export CLASSPATH=".:/path/to/jar/hamcrest-core-1.3.jar:/path/to/jar/junit-4.12.jar"`
   * Make sure that /path/to/jar is substituted with the path to the jar file on your system (i.e., /Documents/389Cfall18/.../hamcrest-core-1.3.jar)
   * On Windows, separate the jars by semicolon, not a comma
   * You only have to do this once per Terminal session
2. `javac solution/*.java`
3. `mv solution/*.class public_tests/`
2. `cd public_tests/`
3. `javac *.java`
3. `java org.junit.runner.JUnitCore PublicTests`
4. Done! PublicTests will now run and you can see the results of the public tests.

## Submission

When you are finished, submit a zip file to the submit server containing **only** `TxHandler.java`.
