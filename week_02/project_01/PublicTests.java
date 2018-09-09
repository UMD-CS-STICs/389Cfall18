import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class PublicTests {

    @Test
    public void testBuildBlock1() {
        // Fun fact: Hashes based on actual bitcoin Block #503123
        byte[] prevBlockHash = "000000000000000000625fd5bca9257adaa35322d5b80f19bfe220afed2a5e2f".getBytes();
        ArrayList<byte[]> txs = new ArrayList<>();
        // add 8 transactions
        txs.add("c2bbeb925d0936f6302c6bb3817ea80f6eea9488fecfbc1c5ff7f981b30fb136".getBytes());
        txs.add("2495f5520bad7d1e9dab39247f36d1ea6fc3d6f0e47ce0845ce302b18dcb3887".getBytes());
        txs.add("2fe5c88761321ba06f82936f31f58df306105ed9b60e35b3863c3c69d802aeed".getBytes());
        txs.add("c63359e170156e138b199a9e4a26c5518440299d343104fd241cdcaa9409d607".getBytes());
        txs.add("9dc09a7f132ba441baddf721061d42b1400628f0c9c8c9624e2800bf47597c8a".getBytes());
        txs.add("8d095ac5807ec698cfb83e80ec4231d528ec94a9925f89849beed7bab2714812".getBytes());
        txs.add("009641a940eab4c5e712c69ad7d635dae31247a8927b8ecac447eb4156aadd50".getBytes());
        txs.add("00c50e4cee642b646f96903707c03760ad6f6d86c4c5299773519803c62d59d0".getBytes());

        byte[] targetTree = {-45, -49, -3, 55, -16, 45, 6, -122, 61, 99, -121, 43, 51, -10, -91, -57, -126,
                90, -49, -28, 111, 58, 96, 82, -27, -63, 85, -98, -128, -36, 52, -113};

        Block block = new Block(prevBlockHash, txs);
        block.buildBlock();

        assertEquals(28051, block.getNonce());
        assertArrayEquals(targetTree, block.getMerkleTree());
        assertEquals((byte) 0, block.getBlockHash()[0]);
        assertEquals((byte) 0, block.getBlockHash()[1]);

        System.out.println("Test 1 passed!");
    }

    @Test
    public void testBuildBlock2() {
        // Fun fact: Hashes based on actual bitcoin Block #503123
        byte[] prevBlockHash = "000000000000000000625fd5bca9257adaa35322d5b80f19bfe220afed2a5e2f".getBytes();
        ArrayList<byte[]> txs = new ArrayList<>();
        // add 8 transactions
        txs.add("262e27ceaab2d223794826e003e67671ca3841e4aec01893c917e5881be51c8c".getBytes());
        txs.add("111335efc62d77c017e15416e671ce99b619659c5ba008cb2225647042783d38".getBytes());
        txs.add("7ba7e2737ed2d3fa037432904c062c38aa5798a228fbb8fae3c70b0966b4581b".getBytes());
        txs.add("2ac34a3f97e9ca1358276d2e9985875f191db2a8b19091d65a2458ec8b0fb300".getBytes());
        txs.add("8950867da133f0f80d6ff173ffa184a22fb81ab636db49b2d640417923c77d01".getBytes());
        txs.add("96e2d3f04180f05b1a8d5efab5982042afacc524bf89f42c5659a513fe6ae830".getBytes());
        txs.add("f8e5c241d76c38d3be15c87bfc549ac22ab45806b06a02df19056030a4b305b4".getBytes());
        txs.add("73167620ba2470b182974efe32bc3b6796a62bd101187dd5330139234b54f35e".getBytes());

        byte[] targetTree  = {-20, -65, -45, -32, 116, -65, -28, 52, 81, -92, 68, -65, 38, -58,
                -5, 100, 12, 102, -79, 93, 0, -112, 111, 121, -12, 93, 28, 9, 23, 104, 8, -124};

        Block block = new Block(prevBlockHash, txs);
        block.buildBlock();

        assertEquals(44175, block.getNonce());
        assertArrayEquals(targetTree, block.getMerkleTree());
        assertEquals((byte) 0, block.getBlockHash()[0]);
        assertEquals((byte) 0, block.getBlockHash()[1]);

        System.out.println("Test 2 passed!");
    }

    @Test
    public void testBuildMerkleTree1() {
        // Fun fact: Hashes based on actual bitcoin Block #503123
        ArrayList<byte[]> txs = new ArrayList<>();
        // add 4 transactions
        txs.add("2b9e9fde10b36ab329741f7a9aa390333e54905fa3b5342881bd0d4477c0d52d".getBytes());
        txs.add("f81f0f875c8cf7b2bbbc4b7e42acbad823ade3ad242fddc66b29d353147aea9a".getBytes());
        txs.add("0ab60c7e81ed77541b045f517eac9bf072ade0def5713698bbdc0ba6c8a68de2".getBytes());
        txs.add("84ff2c3c58a7aaab93de6b93e66a4277659ac9e3cf5020e6ce9e0bc2ea2f48f0".getBytes());

        Block block = new Block();
        byte[] merkleTree = block.buildMerkleTree(txs);

        byte[] targetTree = {-35, 34, 87, 50, 118, 98, -122, 10, 82, -43, -100, -19, 52, -55, -84, 47,
                -22, -44, 104, -88, 22, -121, 61, 73, -63, -80, 83, -58, 115, 48, 127, -92};

        assertEquals(targetTree.length, merkleTree.length);
        assertArrayEquals(targetTree, merkleTree);

        System.out.println("Test 3 passed!");
    }

    @Test
    public void testBuildMerkleTree2() {
        // Fun fact: Hashes based on actual bitcoin Block #503123
        ArrayList<byte[]> txs = new ArrayList<>();
        // add 16 transactions
        txs.add("756c3d42ebc238968eedec068f7685b6fd4583a061e48f5f0bf656cfe7a688bf".getBytes());
        txs.add("4e279044c66af8461715d24bc9ba33228c85d192161ea1f4f41056dc17d6660f".getBytes());
        txs.add("e503f1e703e42e920d212172a558de596fb4e2bcc66961593dd5995e9c1b796c".getBytes());
        txs.add("1b3cdc68b5084b9e1af9b13819c218ca8922fde5882f7620686847b27465f37f".getBytes());
        txs.add("912a5ec578240f923ffbb9dbaf7581bee41641288a4c4c5c5ffb3d2d831b909d".getBytes());
        txs.add("4f367a5daa67830fb7e340aac807a5e499a6e69f719d4a1a6bf7aabd888db267".getBytes());
        txs.add("8a43adc866d9a237bafcdf04d449de60b19e3c3f6b88fa5e966544aa9f94c1ad".getBytes());
        txs.add("b179d62da8efe984894b8d89fdb8b51275375c262cb3ca52fdab5e173a65a4d7".getBytes());
        txs.add("27a79cc267a322e0af1db654c18542afa28284a97ab7982a64e20ad835e6e4ee".getBytes());
        txs.add("4f03b7f6326edfda781f604225f702265cd65547ec2e26fa15de5db2e3881b04".getBytes());
        txs.add("c364a2bc25600e170e51a648f28be06473cbd336a464e44abf77b6180d28c5bb".getBytes());
        txs.add("388c82aace604b394f33307099f6cf7e5b918e8ddc23fb869c337c6ecb2fa302".getBytes());
        txs.add("d752c152cf7b50033048a0caf4826f450ab38427458edf5cd5146a575ef9f556".getBytes());
        txs.add("285f5caf359a81cf2cb13747e87d41b6ea98bd1568e52adbc0757f58fd7fe4b5".getBytes());
        txs.add("6a099ded9f2cf01225694e590bc9ff86dbaf037e15fec0f5cdac73adce8e2ce1".getBytes());
        txs.add("dec39c0a2f049fcf535a811e3315cfbfde279c359cb61afdf452d2c185bdf823".getBytes());

        Block block = new Block();
        byte[] merkleTree = block.buildMerkleTree(txs);

        byte[] targetTree = {85, 116, -34, 97, -89, 57, -20, -125, 32, -72, 38, -30, 64, -66, 80, -99, 103, -52,
                47, 61, 24, 22, -73, 61, -17, -12, -49, 78, 103, 82, 14, -16};

        assertEquals(targetTree.length, merkleTree.length);
        assertArrayEquals(targetTree, merkleTree);

        System.out.println("Test 4 passed!");
    }

    @Test
    public void testIsValidBlock() {
        Block b = new Block();

        byte[] prevBlockHash = "000000000000000000625fd5bca9257adaa35322d5b80f19bfe220afed2a5e2f".getBytes();
        byte[] merkleTree = {-45, -49, -3, 55, -16, 45, 6, -122, 61, 99, -121, 43, 51, -10, -91, -57, -126,
                90, -49, -28, 111, 58, 96, 82, -27, -63, 85, -98, -128, -36, 52, -113};
        int nonce = 28051;
        byte[] blockHash = {0, 0, -81, -75, 120, 106, -103, -96, -64, -34, 122, -55, 115, -55, -52, 44, -8, -60,
                71, -41, 2, 2, -123, 13, 71, -2, 5, -26, -94, 116, -88, 49};

        assertTrue(b.isValidBlock(prevBlockHash, merkleTree, nonce, blockHash));

        System.out.println("Test 5 passed!");
    }

    @Test
    public void testIsInvalidBlock1() {
        Block b = new Block();

        byte[] prevBlockHash = "000000000000000000625fd5bca9257adaa35322d5b80f19bfe220afed2a5e2f".getBytes();
        byte[] merkleTree  = {-20, -65, -45, -32, 116, -65, -28, 52, 81, -92, 68, -65, 38, -58,
                -5, 100, 12, 102, -79, 93, 0, -112, 111, 121, -12, 93, 28, 9, 23, 104, 8, -124};
        int nonce = 32146;
        byte[] blockHash = {0, 0, -25, 119, -100, -14, -46, -91, -21, 101, -66, 58, 47, -71, -18, -121, 34, -80,
                -113, -116, -65, -118, 39, -48, -53, -17, 32, -115, -37, 103, 103, -110};

        assertFalse(b.isValidBlock(prevBlockHash, merkleTree, nonce, blockHash));

        System.out.println("Test 6 passed!");
    }

    @Test
    public void testIsInvalidBlock2() {
        Block b = new Block();

        byte[] prevBlockHash = "000000000000000000625fd5bca9257adaa35322d5b80f19bfe220afed2a5e2f".getBytes();
        byte[] merkleTree  = {-20, -65, -45, -32, 116, -65, -28, 52, 81, -92, 68, -65, 38, -58,
                -5, 100, 12, 102, -79, 93, 0, -112, 111, 121, -12, 93, 28, 9, 23, 104, 8, -124};
        int nonce = 44175;
        byte[] blockHash = {0, 0, -25, 117, -100, -14, -46, -76, -21, 101, -66, 58, 47, -71, -18, -121, 34, -80,
                -113, -116, -65, -17, 39, -48, -81, -17, 32, -115, -37, 103, 103, -110};

        assertFalse(b.isValidBlock(prevBlockHash, merkleTree, nonce, blockHash));

        System.out.println("Test 7 passed!");
    }

    @Test
    public void testIsInvalidBlock3() {
        Block b = new Block();

        byte[] prevBlockHash = "000000000000000000625fd5bca9257adaa35322d5b80f19bfe220afed2a5e2f".getBytes();
        byte[] merkleTree  = {-20, -65, -45, -32, 116, -65, -28, 52, 81, -92, 68, -65, 38, -58,
                -5, 100, 12, 102, -79, 93, 0, -112, 111, 121, -12, 93, 28, 9, 23, 104, 8, -124};
        int nonce = 44175;
        byte[] blockHash = {39, -60, -25, 119, -100, -14, -46, -91, -21, 101, -66, 58, 47, -71, -18, -121, 34, -80,
                -113, -116, -65, -118, 39, -48, -53, -17, 32, -115, -37, 103, 103, -110};

        assertFalse(b.isValidBlock(prevBlockHash, merkleTree, nonce, blockHash));

        System.out.println("Test 8 passed!");
    }
}