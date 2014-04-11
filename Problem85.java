// www.projecteuler.net Problem 85

// start with grid with i=1 row
// calc F(i,j) for successive j until F > 2000000
// then continue for increasing i ... until F(i,1)> 2000000
// track smallest diff and corresponding area

public class Problem85{
	private static int F(int i, int j) {
		// specific answer for i rows, j cols
		if (i==0 || j==0) {
			// hack to handle loop indexing below
			return 1;
		}
		int count = 0;
		for (int k=1; k<=i; k++) {
			for (int l=1; l<=j; l++) {
				count += (i+1-k)*(j+1-l);
			}
		}
		return count;
	}

	public static void main(String [] args) {
		int smallestDiff = Integer.MAX_VALUE;
		int correspondingArea = 0;
		
		for (int i=1; F(i-1,1) < 2000000; i++) {
			for (int j=1; F(i,j-1) < 2000000; j++) {
				int diff = Math.abs(F(i,j)-2000000);
				if (diff < smallestDiff) {
					smallestDiff = diff;
					correspondingArea = i*j;
				}
			}
		}
		System.out.println(correspondingArea);
	}
}