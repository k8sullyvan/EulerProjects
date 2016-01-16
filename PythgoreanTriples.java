
public class PythgoreanTriples {

	/**
	 * A Pythgorean Triples is a set of three natural numbers, a < b < c, for
	 * which, a^2 + b^2 = c^2. There exists exactly one Pythagorean triplet for
	 * which a + b + c = 1000.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new PythgoreanTriples();
	}

	public PythgoreanTriples() {
		for (int b = 1; b < 1000; b++) {
			//a<b therefore let's not both checking values where 'a' is greater than a given value of 'b'
			for (int a = 1; a < b; a++) {
				int c = getPerfectSquareRoot(a*a + b*b);
				int total = a + b + c;
				if (c > b && total == 1000) {
					System.out.println("a = " + a + ", b = " + b + ", c= " + c + "\t\t\t a+b+c=" + total);
				}
			}
		}
	}

	//Only returns a value if the num is a perfect square, e.g. 4 returns 2, but 5 returns 0
	private int getPerfectSquareRoot(int num) {
		Double sqrt = Math.sqrt(num);
		if ((sqrt == Math.floor(sqrt)) && !Double.isInfinite(sqrt)) {
			return sqrt.intValue();
		}
		return 0;
	}

}
