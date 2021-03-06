// projecteuler.net problem 94


// NOT SOLVED !!!
// probably because the numbers are too large and insufficient precision
// probably need a diff formula for Area of Triangle
// Heron's forumula generates numbers on the order of p**4  (closer to p**4 * (8/27))
// which is almost 40 digits

public class Problem94 {

	// return area of triangle via Heron's formula
	private static double triArea(int s1, int s2, int s3) {
		// the "half perimeter"
		double p = (s1 + s2 + s3)/2.0;
		double areaSq = p * (p - s1) * (p - s2) * (p - s3);
		return java.lang.Math.sqrt(areaSq);
	}


	// within our sloppy tolerance, is d an integer?
	//   THIS MUST NOT WORK WITH ENOUGH PRECISION
	public static boolean isInt(double d) {
		return ((d % 1) == 0);
	}

	public static void main(String [] args) {
		// assuming that 1-1-2 is not a triangle, (2-2-1 is not an AET) so starting with 2-2-3
		long cumulativePerim = 0;
		int countOfAETris = 0;

		for (int i = 1; i < ((long) (1000000000/3)+2); i++) {   // sloppy, see *** below
			int j = i + 1;
			double area = 0.0;
			boolean isInt = false;

			if (i + i + j > 1000000000) {
				// low-budget check to handle approx roundoff, *** above
				System.out.println("skipping: " + i + " + " + i + " + " + j);  // a couple of these print out
				continue;
			}

			area = triArea(i, i, j);
			isInt = isInt(area);

			if (isInt) {
				countOfAETris += 1;
				cumulativePerim += (i+i+j);
				//System.out.println("i, i, j: " + i + ", " + i + ", " + j);
				//System.out.println("area: " + area);
			}

			if (i + j + j > 1000000000) {
				// low-budget check to handle approx roundoff, *** above
				System.out.println("skipping: " + i + " + " + j + " + " + j);
				continue;
			}

			area = triArea(i, j, j);
			isInt = isInt(area);


			if (isInt) {
				countOfAETris += 1;
				cumulativePerim += (i+j+j);
				//System.out.println("i, j, j: " + i + ", " + j + ", " + j);
				//System.out.println("area: " + area);
			}
		}
		System.out.println("Cumulative Perim: " + cumulativePerim);
		System.out.println("Number of AETs: " + countOfAETris);
	}
	
}