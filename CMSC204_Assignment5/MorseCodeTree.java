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

import java.util.*;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	public String str;
	public TreeNode<String> root = null;

	
	
	public MorseCodeTree() {
		//creating the tree
		buildTree();
	}
	
	/**
	 * This is the recursive method that fetches the data of the TreeNode
	 * that corresponds with the code
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of fetchNode
	 * @return the data corresponding to the code
	 */
	@Override
	public String fetchNode(TreeNode<String> root, String code) {  
		// If only 1 character exists in the code
		if (code.length() == 1) {
			// if '.' get the data from the left child of root
			if (code.equals(".")) {
				str = root.leftChild.getData();
			}
			
			//if '-' get the data from the right child of root
			else {
				str = root.rightChild.getData();
			}
		}
		else { 
			// if '.', the root becomes the left child
			if(code.substring(0, 1).equals(".")) {
				//recursive call
				fetchNode(root.leftChild, code.substring(1));
			}
			
			//if '-', the root becomes the right child
			else {
				//recursive call
				fetchNode(root.rightChild, code.substring(1));  
			}
		}
		return str;  
	}
	
	/**
	 * This is a recursive method that adds element to the correct position 
	 * in the tree based on the code.
	 * 
	 * @param root the root of the tree for this particular recursive instance of addNode
	 * @param code the code for this particular recursive instance of addNode
	 * @param letter the data of the new TreeNode to be added
	 */
	@Override
	public void addNode(TreeNode<String> root, String code, String letter) {
		//if only 1 character exists in the code
		if(code.length() == 1) {
			//if ".", add to root's left child
			if (code.equals(".")) {
				root.leftChild = new TreeNode<String>(letter);
			}
			//if "-", add to root's right child
			else {
				root.rightChild = new TreeNode<String>(letter);
			}
		}
		else {
			// if '.', the root becomes the left child
			if(code.substring(0, 1).equals(".")) {
				//recursive call
				addNode(root.leftChild, code.substring(1), letter);
			}
			
			//if "-", the root becomes the right child
			else {
				//recursive call
				addNode(root.rightChild, code.substring(1), letter);  
			}
		}
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		return null;
	}
	
	/**
	 * This method builds the LinkedConverterTree by inserting TreeNodes<T>
	 * into their proper locations
	 * 
	 */
	@Override
	public void buildTree() {
		//root
		root = new TreeNode<String>("");
		
		//1st row
		insert(".", "e");
		insert("-", "t");
		
		//2nd row
		insert("..", "i");
		insert(".-", "a");
		insert("-.", "n");
		insert("--", "m");
		
		//3rd row
		insert("...", "s");
		insert("..-", "u");
		insert(".-.", "r");
		insert(".--", "w");
		insert("-..", "d");
		insert("-.-", "k");
		insert("--.", "g");
		insert("---", "o");
		
		//4th row
		insert("....", "h");
		insert("...-", "v");
		insert("..-.", "f");
		insert(".-..", "l");
		insert(".--.", "p");
		insert(".---", "j");
		insert("-...", "b");
		insert("-..-", "x");
		insert("-.-.", "c");
		insert("-.--", "y");
		insert("--..", "z");
		insert("--.-", "q");  
	}
	
	/**
	 * Adds result to the correct position in the tree based on the code
	 * This method will call the recursive method addNode
	 * 
	 * @param code the code for the new node to be added
	 * 
	 */
	@Override
	public void insert(String code, String letter) {
		//adding the result
		addNode(root, code, letter);
	}
	
	/**
	 * Fetch the data in the tree based on the code
	 * This method will call the recursive method fetchNode
	 * 
	 * @param code the code that describes the traversals within the tree
	 * @return the result that corresponds to the code
	 */
	@Override
	public String fetch(String code) {
		//calls the fetchNode method
		String result = fetchNode(root, code);
		return result;
	}
	
	/**
	 * This operation is not supported for a LinkedConverterTree
	 * @param data data of node to be deleted
	 * @return reference to the current tree
	 * @throws UnsupportedOperationException
	 */
	@Override
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		return null;
	}
	
	/**
	 * The recursive method to put the contents of the linked converter tree in an ArrayList<T> 
	 * LNR (Inorder)
	 * @param root the root of the tree for this particular recursive instance
	 * @param list the ArrayList that will hold the contents of the tree in LNR order
	 */
	@Override
	public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
		//if the tree is not empty
		if(root != null) {
			LNRoutputTraversal(root.leftChild, list);
			list.add(root.getData());
			LNRoutputTraversal(root.rightChild, list);
		}
	}
	
	/**
	 * Returns an ArrayList of the items in the linked converter Tree in LNR (Inorder) Traversal order
	 * Used for testing to make sure tree is built correctly
	 * @return an ArrayList of the items in the linked Tree
	 */
	@Override
	public ArrayList<String> toArrayList() {
		ArrayList<String> items = new ArrayList<String>();
		LNRoutputTraversal(root, items); 
		return items;
	}
	
	//setters and getters
	/**
	 * sets the root of the Tree
	 * @param newNode a TreeNode<T> that will be the new root
	 */
	@Override
	public void setRoot(TreeNode<String> newNode) {
		root = newNode;  
	}
	
	/**
	 * Returns a reference to the root
	 * @return reference to root
	 */
	@Override
	public TreeNode<String> getRoot() {
		return this.root;
	}
	
}