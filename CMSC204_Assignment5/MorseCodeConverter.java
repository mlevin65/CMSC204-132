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
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * @author Miles Levine
 *
 */
public class MorseCodeConverter {
	private static MorseCodeTree tree = new MorseCodeTree();

	/**
	 * 
	 */
	public MorseCodeConverter() {
		
	}
	
	/**
	 * returns a string with all the data in the tree in LNR order with an space in between them.
	 * @return the data in the tree in LNR order separated by a space.
	 */
	public static String printTree() {
		String print = "";
		ArrayList<String> treeData = new ArrayList<String>();
		treeData = tree.toArrayList();
		
		for (int i = 0; i < treeData.size(); i++) {
			print += treeData.get(i) + " ";
		}
		//removes the space at the end
		return print.trim();
	}

	
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘).
	 * @param code the morse code
	 * @return text the English translation
	 */
	public static String convertToEnglish(String code) {
		String text = "";
		String[] words;
		String[] letters;
		//splitting the code
		words = code.split(" / ");
		
		//for loop to go through each letter of the word
		for(int i = 0; i < words.length; i++) {		
			//splitting the letters in the word into a new array.
			letters = words[i].split(" ");
			
			for(int j = 0; j < letters.length; j++) {
				text += tree.fetch(letters[j]);  
			}
			text += " ";
		}  
		
		//take off spaces
		text = text.trim();
		
		return text;
	}
	/**
	 * Converts a file of Morse code into English Each letter is delimited by a space (‘ ‘). Each word is delimited by a ‘/’.
	 * @param codeFile name of the File that contains Morse Code
	 * @return the English translation of the file
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		try {
			Scanner inputFile;
			String text = "";
			inputFile = new Scanner(codeFile);
			
			//reads the contents of the file
			while (inputFile.hasNext()) {
				text += (inputFile.nextLine());
			}
			inputFile.close();
			
			return convertToEnglish(text);
			
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
			throw new FileNotFoundException();
		}
	}
}