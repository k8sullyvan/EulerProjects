
public class p001_ThreesAndFives {
	
	public static void main(String[] args) {
		new p001_ThreesAndFives();
	}

	public p001_ThreesAndFives() {
		
		int sum = 0;
		for (int i = 0; i<1000; i++) {
			if (i % 3 == 0 || i % 5 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
	}

}
