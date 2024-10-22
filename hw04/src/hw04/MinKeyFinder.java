package hw04;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Find the key associated with the minimum value in a binary tree using key value pairs.
 */
public class MinKeyFinder implements CS232Visitor<String, Integer> {

	private String minKey;
	private int minValue;
	private boolean firstNode;

	public MinKeyFinder() {
		minKey = null;
		firstNode = true;
		
	}

	/**
	 * {@inheritDoc}
	 */
	/**
	 * The visit method will be invoked at each node in a tree. The order in
	 * which the nodes are visited is determined by the method that is used
	 * (e.g. visitPreOrder, visitInOrder, visitPostOrder, visitLevelOrder)
	 * 
	 * @param key
	 *            the key stored at the node.
	 * @param value
	 *            the value stored at the node.
	 */
	public void visit(String key, Integer value) {
		
		if (firstNode) {
			minKey = key;
			minValue = value;
			firstNode = false;
		} else {
			if (value < minValue) {
				minKey = key;
				minValue = value;
			}
		}
		
	}

	/**
	 * Get the key associated with the minimum value in the tree.
	 * 
	 * @return the key associated with the minimum value.
	 */
	public String getMinKey() {
		return minKey;
	}
	
	public static void main(String[] args) {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
		Integer[] values = {1, 2, 3, 4, 5, 6, 7, -8, 9, 10};
		
		CS232LinkedBinaryTree<String, Integer> tree = new CS232LinkedBinaryTree<String, Integer>(keys, values);

		MinKeyFinder mkf = new MinKeyFinder();
		tree.visitPreOrder(mkf);
		System.out.println(mkf.getMinKey());
	}
}
