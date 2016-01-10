import java.util.Stack;

/**
 * This class tests for the presence of matching parentheses, for example
 * "(()[])" matches because this combination of brackets means that everything
 * is valid algebraically, however this combination "(([)])" would be invalid
 * as the brackets do not match
 */
public class MatchingParentheses {

	Stack<Character> parenthesesStack = new Stack<Character>();

	public static void main(String[] args) {
		new MatchingParentheses();
	}

	public MatchingParentheses() {
		// Testing with empty parentheses
		System.out.println("(()) \t\t\t" + isMatch("(())"));
		System.out.println(")(()) \t\t\t" + isMatch(")(())"));
		System.out.println("[]{}() \t\t\t" + isMatch("[]{}()"));
		System.out.println("[]{}({}) \t\t" + isMatch("[]{}({})"));
		System.out.println("[(]{}({}) \t\t" + isMatch("[(]{}({})"));
		System.out.println("[(]{})({}) \t\t" + isMatch("[(]{})({})"));

		// Testing with mixed characters (only alphabetical and numerical)
		System.out.println("(This is true) \t\t" + isMatch("(This is true)"));
		System.out.println("(This is false)) \t" + isMatch("(This is false))"));
		System.out.println("(This is ([]true)) \t" + isMatch("(This is ([]true))"));
		System.out.println("({This is ([]False})) \t" + isMatch("({This is ([]False}))"));

	}

	private Boolean isMatch(String pattern) {
		// Convert the String into only a char array of the parentheses,
		// removing the other characters
		char[] digits = String.valueOf(pattern.replaceAll("([0-9a-zA-Z\\s])", "")).toCharArray();

		// Adding a white space character so the Stack is never Empty
		parenthesesStack.push(' ');
		for (char c : digits) {
			// Add non-matching characters to the stack to check later
			if (!parenthesesMatch(c))
				parenthesesStack.push(c);
		}
		// All parentheses have been paired if only the white space character
		// remains
		return parenthesesStack.pop() == ' ';
	}

	private Boolean parenthesesMatch(char c) {
		Boolean pairMatch = false;

		// Checks to see if the current character matches those in the stack
		switch (c) {
		case ')':
			pairMatch = parenthesesStack.peek().equals('(');
			break;
		case ']':
			pairMatch = parenthesesStack.peek().equals('[');
			break;
		case '}':
			pairMatch = parenthesesStack.peek().equals('{');
		default:
			break;
		}

		if (pairMatch)
			parenthesesStack.pop();
		return pairMatch;
	}
}
