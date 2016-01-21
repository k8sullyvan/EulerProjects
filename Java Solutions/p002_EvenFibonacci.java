
public class p002_EvenFibonacci {

	public static void main(String[] args) {
		new p002_EvenFibonacci();
	}

	public p002_EvenFibonacci() {
		// Initialize the first starting numbers of the Fibonacci sequence which
		// follow a pattern of "1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ..."
		// or "odd, odd, even, odd, odd, even, ..."
		
		int fib1 = 1;
		int fib2 = 1;
		int fibEven = fib1 + fib2;

		int evenSum = 0;

		while (fibEven < 4000000) {
			evenSum += fibEven;
			fib1 = fib2 + fibEven;
			fib2 = fibEven + fib1;
			fibEven = fib1 + fib2;
		}

		System.out.println(
				"The sum of the even-valued terms of the Fibonacci sequence less that 4 million is " + evenSum);
	}

}
