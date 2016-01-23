import java.util.stream.IntStream;

public class p006_SumSquareDifference {

	public static void main(String[] args) {
		new p006_SumSquareDifference();

	}

	public p006_SumSquareDifference() {
		System.out.format("SumSquareDifference for 10 is %d\n", sumSquareDifference(10));
		System.out.format("SumSquareDifference for 100 is %d\n", sumSquareDifference(100));
	}
	
	private int sumSquareDifference(int num) {
		if (num < 1) {
			throw new IllegalArgumentException();
		}
		
		int sum = IntStream.rangeClosed(1, num).sum();
		int squareSum = IntStream.rangeClosed(1, num).map(i -> i*i).sum();
		
		return (sum * sum - squareSum);
	}
}
