// www.projecteuler.net Problem 44
import java.util.ArrayList;
import java.util.List;

public class Problem44 {

	// calculation shows that diff between P(n) and P(n+1) = 3n+1
	// but sum P(n) + P(N+1) grows like n**2
	// so as we search successive values of n, finding workable k,j pairs
	// we are going to have to "look ahead" to nearly P(j**2)

	// P(n) will be found in pentagonals.get(n-1);
	private static List<Integer> pentagonals = new ArrayList<Integer>();

	private static long penta(int n) {
		// compute on demand
		if (pentagonals.size() >= n) {
			return pentagonals.get(n-1);
		} else {
			for (int i=pentagonals.size()+1; i<=n; i++) {
				pentagonals.add((i*(3*i - 1)) / 2);
			}
			return pentagonals.get(n-1);
		}
	}

	private static boolean isPenta(long n) {
		// faster if binary search in pentagonals, but sequential will suffice

		// start by puffing up the list of pentagonals if needed
		if (pentagonals.size()==0) penta(1);
		for (int s = pentagonals.size(); pentagonals.get(s-1) < n; penta(++s)) { }

		// start at beginning and look for match
		for (int i=1; i<=pentagonals.size(); i++) {
			if (pentagonals.get(i-1) == n) return true;
		}
		return false;
	}


	public static void main(String [] args) {

		int bestK = 0;
		int bestJ = 0;
		boolean solutionFound = false;
		boolean noSmallerSolutionExists = false;
		long smallestDifference = Long.MAX_VALUE;

		for (int k=1; !solutionFound && !noSmallerSolutionExists; k++) {
			long pk = penta(k);
			for (int j=1; j<k; j++) {
				long pj = penta(j);
				if (isPenta(pk-pj) && isPenta(pk+pj)) {
					if (!solutionFound) {
						// first solution found!
						solutionFound = true;
						bestK = k;
						bestJ = j;
						smallestDifference = pk-pj;
					} else {
						if (pk-pj < smallestDifference) {
							bestK = k;
							bestJ = j;
							smallestDifference = pk-pj;
						}
					}
				}
				// last time through k-loop, see if we have found the smallest possible solution
				if (j==k-1) {
					if (smallestDifference < 3*k-1) noSmallerSolutionExists = true;
				}
			}
		}
		System.out.println("k: " + bestK + ", j: " + bestJ + ", P(k): " + penta(bestK) + ", P(j): " + penta(bestJ));
		System.out.println(smallestDifference);
	}
}