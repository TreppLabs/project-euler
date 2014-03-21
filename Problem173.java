// www.projecteuler.net Problem 173
public class Problem173 {
	public static void main(String [] args) {
		int maxTiles = 1000000;
		long laminaeCount = 0;
		for (long i = 3; i <= 2+(maxTiles/4); i++) {
			for (long j = i-2; j > 0; j -= 2) {
				if ((i*i-j*j) <= maxTiles) {
					laminaeCount += 1;
					//System.out.println("i: " + i + ", j: " + j + ", tiles: " + (i*i-j*j) + ", laminaeCount: " + laminaeCount);
				}
			}
		}
		System.out.println(laminaeCount);
	}
}