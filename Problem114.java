// www.projecteuler.net Problem 114
public class Problem114 {
	private static int rowLength = 50;

	// recursively count the ways. 
	// could store values to avoid repeat calculations, but this ran in 48 seconds as is
	private static long countWays(int length) {
		if (length==0) {
			// length 0 handles base cases
			return 1;
		} else if (length==1) {
			return 1;
		} else if (length==2) {
			return 1;
		} else if (length==3) {
			return 2;  // 3 blacks or one red
		} else {
			// handle different cases....4 or more
			long totalWays = 0;
			// start with a black, leaves length-1
			totalWays += countWays(length-1);
			// or ... one long red fills whole thing
			totalWays += 1;
			// or ... red of length 3 or more , followed by a black
			for (int redLength = 3; redLength < length; redLength++) {
				totalWays += countWays(length - redLength - 1);
			}
			return totalWays;
		}
	}

	public static void main(String [] args) {
		System.out.println(countWays(rowLength));
	}
}