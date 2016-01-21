
public class p003_LargestPrime {
	
	public static void main(String[] args) {
		new p003_LargestPrime();
	}

	public p003_LargestPrime() {
		long num = 600851475143L;
		System.out.println(getLargestFactor(num));
		
	}
	
	private long getLargestFactor(long num) {
		long factor = firstFactor(num);
		if (factor != num) {
			getLargestFactor(num / factor);
		}
		return factor;
	}

	private long firstFactor(long num) {
		if (num <= 0) {
			return num;
		}
		for (long i = 2; i < num / 2; i++) {
			if (num % i == 0) {
				return i;
			}
		}
		
		return num;
	}
}
