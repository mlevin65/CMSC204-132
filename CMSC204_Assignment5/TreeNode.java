/*
 * Class: CMSC204 
 * Instructor: Prof. Kuijt
 * Description: Write the classes required to create a Morse Code Converter Utility. 
 * Your Morse Code Converter Utility will be using a generic linked binary tree with generic TreeNodes to convert Morse Code into English. 
 * There is no GUI requirement for this assignment. You are supplied a GUI for testing purposes. 
 * Due: 11/28/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Miles Levine
*/

/**
 * @author Miles Levine
 *
 * @param <T>
 */
public class TreeNode<T> {
	
	protected T data;
	protected TreeNode<T> leftChild;  
	protected TreeNode<T> rightChild;
	
	
	/**
	 * Create a new TreeNode with left and right child set to null and data set to the dataNode
	 * @param dataNode
	 */
	public TreeNode (T dataNode) {
		this.data = dataNode;
		this.leftChild = null;
		this.rightChild = null;
	}
	
	/**
	 * used for making deep copies
	 * @param node
	 */
	public TreeNode (TreeNode<T> node) {
		this.data = node.data;
		this.leftChild = node.leftChild;
		this.rightChild = node.rightChild;
	}
	
	/**
	 * Return the data within this TreeNode
	 * @return
	 */
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
}