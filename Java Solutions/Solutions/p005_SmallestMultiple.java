import java.util.ArrayList;

public class p005_SmallestMultiple {

	public static void main(String[] args) {
		new p005_SmallestMultiple(1, 20);
	}
	
	public p005_SmallestMultiple(int low, int high) {
		if (low >= high) {
			throw new IllegalArgumentException();
		}
		int lowestProduct = low++;
		for (int i = low; i <= high ; i++) {
			lowestProduct = getLowestMultiple(i, lowestProduct);
		}
		System.out.println(lowestProduct);
	}
	
	/**
	 * Provides the lowest common multiple of two given numbers, for example the
	 * lowest common multiple of 4 and 18 is 36
	 * 
	 * @param a
	 * @param b
	 * @return lowest common multiple
	 */
	private int getLowestMultiple(int a, int b) {
		
		ArrayList<Integer> aFactorList = getPrimeFactors(a);
		ArrayList<Integer> bFactorList = getPrimeFactors(b);
		
		ArrayList<Integer> commonFactors = new ArrayList<Integer>();
		
		for (int bFactor : bFactorList) {
			commonFactors.add(bFactor);
			if (aFactorList.contains(bFactor)) aFactorList.remove(new Integer(bFactor));
			
		}

		commonFactors.addAll(aFactorList);
		int lowestMultiple = commonFactors.stream().reduce(1, 	
				(product, i) -> product *= i,
				(product1, product2) -> product1 * product2);
		
		return lowestMultiple;
	}

	/**
	 * For a given int returns the prime factors, for example the prime factors of 12 are [2, 2, 3]
	 * @param n
	 * @return ArrayList<Integer> of the Prime Factors
	 */
	private ArrayList<Integer> getPrimeFactors(int n) {
		ArrayList<Integer> factors = new ArrayList<Integer>(3);
		int factor;
		int num = n;
		do {
			factor = firstFactor(num);
			factors.add(factor);
			num = num / factor;
		} while (num > 1);

		return factors;
	}

	/**
	 * Gets one prime factors of a number
	 * @param num
	 * @return
	 */
	private int firstFactor(int num) {
		if (num <= 1) {
			return num;
		}
		for (int i = 2; i <= num; i++) {
			if (num % i == 0) {
				return i;
			}
		}
		
		return num;
	}
}
