import java.util.stream.IntStream;

public class LargestPalindrome {
	
	private static int p = 0;
	private static String largestPalindrome = "";

	public static void main(String[] args) {
		new LargestPalindrome();
	}

	public LargestPalindrome() {
		int p = 0;
		IntStream.rangeClosed(100, 999).forEachOrdered(i -> 
			IntStream.rangeClosed(i, 999).forEachOrdered(j -> 
			largestPalindrome = i*j > p && isPalindrome(i*j) ? (i + " *\t" + j + " =\t" + i*j) : largestPalindrome));
		
		System.out.println(largestPalindrome);
	}

	private boolean isPalindrome(int num) {
		p = Math.max(p, num);
		char[] digits = String.valueOf(num).toCharArray();
		return isPalindrome(digits, 0, digits.length - 1);
	}

	private boolean isPalindrome(char[] digits, int i, int j) {
		if (i >= j) {
			return true;
		}
		return digits[i] == digits[j] && isPalindrome(digits, ++i, --j);
	}

}
