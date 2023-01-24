/*
 * Class: CMSC204 
 * Instructor: Prof. Kuijt
 * Description: You will be creating a utility class that converts an infix 
 * expression to a postfix expression, a postfix expression to an infix 
 * expression and evaluates a postfix expression.
 * Due: 10/2/2022
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Miles Levine
*/

/**
 * @author Miles Levine
 *
 */
public class Notation {
	
	/**
	 * Convert the Postfix expression to the Infix expression
	 * @param postfix the postfix expression in string format
	 * @return the infix expression in string format
	 * @throws InvalidNotationFormatException if the postfix expression format is invalid
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {
		//Make the generic parameter String format
		MyStack<String> stack = new MyStack<>();
		//convert the postfix string to a char array
		char[] array = postfix.toCharArray();
		try {
			//for loop that goes through each element in the char array
			for(char c : array) {
				if (Character.isDigit(c)) {
					stack.push(Character.toString(c));
					
				}
				//if any element is an operator
				if (c == 42 || c == 47 || c == 43 || c == 45) {
					if (stack.size() <= 1) {
						throw new InvalidNotationFormatException();
					}
					String top = stack.pop();
					String second = stack.pop();
					String s = "(" + second + c + top + ")";
					stack.push(s);
				}
			}
		}
		//Exception handling
		catch (StackUnderflowException sue) {
			throw new InvalidNotationFormatException();
		}
		catch (StackOverflowException soe) {
			throw new InvalidNotationFormatException();
		}
		//if the size of the stack is greater than 1 then throw invalid format exception
		if (stack.size() >= 2) {
			throw new InvalidNotationFormatException();
		}
		return stack.toString();
	}
	
	/**
	 * Convert an infix expression into a postfix expression
	 * @param infix the infix expression in string format
	 * @return the postfix expression in string format
	 * @throws InvalidNotationFormatException if the infix expression format is invalid
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {
		//Make the generic parameter a Character.
		MyQueue<Character> queue = new MyQueue<>();
		MyStack<Character> stack = new MyStack<>();
		//convert the infix to a char array
		char[] array = infix.toCharArray();
		
		try {
			for (char c : array) {
				//testing if each element of the character array is a digit.
				if (Character.isDigit(c)) {
					queue.enqueue(c);
				}
				//testing if each element of the character array is a "("
				if (c == 40) {
					stack.push(c);
				}
				//testing if each element of the character array is a "*, /, +, -"
				if (c == 42 || c == 47 || c == 43 || c == 45) {
					if (!queue.isEmpty()) {
						char ch = stack.top();
						//if any element of the char array is an operator and and if the top of the stack is also an operator,
						//then pop that element and add it using enqueue method
						if (ch == 42 || ch == 47 || c == 45 && ch == 45 || c == 45 && ch == 43
								|| c == 43 && ch == 45 || c == 43 && ch == 43) {
							queue.enqueue(stack.pop());
						}
					}
					stack.push(c);
				}
				//testing if any element is a ")" 
				if (c == 41) {
					while (stack.top() != 40) {
						queue.enqueue(stack.pop());
						if (stack.top() == null) {
							throw new InvalidNotationFormatException();
						}
					}
					stack.pop();
				}
			}
		}
		//exception handling 
		catch (QueueOverflowException qoe) {
			throw new InvalidNotationFormatException();
		}
		catch (StackOverflowException soe) {
			throw new InvalidNotationFormatException();
		}
		catch (StackUnderflowException sue) {
			throw new InvalidNotationFormatException();
		}
		return queue.toString();
	}
	
	/**
	 * Evaluates a postfix expression from a string to a double
	 * @param postfixExpr the postfix expression in String format
	 * @return the evaluation of the postfix expression as a double
	 * @throws InvalidNotationFormatException if the postfix expression format is invalid
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {
		MyStack<Double> stack = new MyStack<>();	
		//converts the String postfixExpr to a char array
		char[] array = postfixExpr.toCharArray();
		try {
			for (char c : array) {
				//testing if any element is a digit
				if (Character.isDigit(c)) {
					stack.push(Double.parseDouble(Character.toString(c)));
				
				}
				//testing if any element is a "("
				if (c == 40) {
					stack.push(Double.parseDouble(Character.toString(c)));
				
				}
				//testing if each element is an operator
				if (c == 42 || c == 47 || c == 43 || c == 45) {
					if (stack.size() <= 1) {
						throw new InvalidNotationFormatException();
					}
					//declare right and left variables 
					double right = stack.pop();
					double left = stack.pop();
					
					//testing if any element is a "+"
					if(c == 43) {
						stack.push(left + right);	
					}
					//testing if any element is a "-"
					if(c == 45) {
						stack.push(left - right);
					}
					//testing if any element is a "*"
					if (c == 42) {
						stack.push(left * right);
					}
					//testing if any element is a "/"
					if (c == 47) {
						stack.push(left / right);
					}

				}
			}
		}
		//Exception handling
		catch (StackOverflowException soe) {
			throw new InvalidNotationFormatException();
		}
		catch (StackUnderflowException sue) {
			throw new InvalidNotationFormatException();
		}
		//if the size of the stack is greater than 1 then throw invalid format exception
		if (stack.size() >= 2) {
			throw new InvalidNotationFormatException();
		}
		
		//convert to double format
		return Double.parseDouble(stack.toString());
	}

}

