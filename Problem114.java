// www.projecteuler.net Problem 114
public class Problem114 {
	private static final int ROW_LENGTH = 50;
	private static final long NOT_SOLVED = -1;
	private static long solutions [];

	private static void initializeSolutions(){
		solutions = new long[ROW_LENGTH+1];
		for (int i=0; i<=ROW_LENGTH; i++) {
			solutions[i] = NOT_SOLVED;
		}
	}

	// recursively count the ways. 
	// takes 48 s with pure recursion
	// takes 82 ms when storing pre-computed values
	private static long countWays(int length) {
		if (solutions[length] != NOT_SOLVED) {
			return solutions[length];
		} else if (length==0) {
			// length 0 handles base cases
			solutions[length] = 1;
			return 1;
		} else if (length==1) {
			solutions[length] = 1;
			return 1;
		} else if (length==2) {
			solutions[length] = 1;
			return 1;
		} else if (length==3) {
			solutions[length] = 2;
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
			solutions[length] = totalWays;
			return totalWays;
		}
	}

	public static void main(String [] args) {
		initializeSolutions();
		System.out.println(countWays(ROW_LENGTH));
	}
}