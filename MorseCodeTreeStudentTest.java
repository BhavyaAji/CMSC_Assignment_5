import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class MorseCodeTreeStudentTest {

	@Test
	public void testBuildTree() {
		MorseCodeTree tree = new MorseCodeTree();
		assertNotNull(tree.getRoot());
	}

	@Test
	public void testInsert() {
		MorseCodeTree tree = new MorseCodeTree();
		tree.insert(".-", "a");
		assertEquals("a", tree.fetch(".-"));
	}

	@Test
	public void testGetRoot() {
		MorseCodeTree tree = new MorseCodeTree();
		assertNotNull(tree.getRoot());
	}

	@Test
	public void testSetRoot() {
		MorseCodeTree tree = new MorseCodeTree();
		TreeNode<String> newRoot = new TreeNode<>("x");
		tree.setRoot(newRoot);
		assertEquals("x", tree.getRoot().getData());
	}

	@Test
	public void testAddNode() {
		MorseCodeTree tree = new MorseCodeTree();
		tree.addNode(tree.getRoot(), ".", "e");
		assertEquals("e", tree.fetch("."));
	}

	@Test
	public void testFetch() {
		MorseCodeTree tree = new MorseCodeTree();
		assertEquals("s", tree.fetch("..."));
	}

	@Test
	public void testFetchNode() {
		MorseCodeTree tree = new MorseCodeTree();
		assertEquals("t", tree.fetchNode(tree.getRoot(), "-"));
	}

	@Test
	public void testDelete() {
		MorseCodeTree tree = new MorseCodeTree();
		assertThrows(UnsupportedOperationException.class, () -> {
			tree.delete("a");
		});
	}

	@Test
	public void testUpdate() {
		MorseCodeTree tree = new MorseCodeTree();
		assertThrows(UnsupportedOperationException.class, () -> {
			tree.update();
		});
	}

	@Test
	public void testToArrayList() {
		MorseCodeTree tree = new MorseCodeTree();
		ArrayList<String> list = tree.toArrayList();
		assertNotNull(list);
	}

	@Test
	public void testLNRoutputTraversal() {
		MorseCodeTree tree = new MorseCodeTree();
		ArrayList<String> list = new ArrayList<>();
		tree.LNRoutputTraversal(tree.getRoot(), list);
		assertNotNull(list);
	}
}