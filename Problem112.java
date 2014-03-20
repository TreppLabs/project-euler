// www.projecteuler.net Problem 112
public class Problem112 {

	private static boolean isBouncy(int n) {
		return (!isIncreasing(n) && !isDecreasing(n));
	}

	private static boolean isIncreasing(int n) {
		String s = Integer.toString(n);
		for (int i=0; i<s.length()-1; i++) {
			if (s.charAt(i) > s.charAt(i+1)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isDecreasing(int n) {
		String s = Integer.toString(n);
		for (int i=0; i<s.length()-1; i++) {
			if (s.charAt(i) < s.charAt(i+1)) {
				return false;
			}
		}
		return true;
	}


	public static void main(String [] args) {
		int bounciesFound = 0;
		int lowest99er = 0;
		boolean done = false;
		for (int i=1; !done; i++ ){
			if (isBouncy(i)) {
				bounciesFound += 1;
				//if (i%1000==0) {
				//	// monitor progress
				//	System.out.println("for i=" + i + ", bouncy % = " + ((double)bounciesFound)/i);
				//}
				if (((double)bounciesFound)/i == 0.99) {
					done = true;
					lowest99er = i;
				}
			}
		}
		System.out.println("99er: " + lowest99er);
	}
}