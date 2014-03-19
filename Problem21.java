// www.projecteuler.net Problem 21
public class Problem21{

	public static void main(String [] args) {
		int[] d;
		d = new int[10001];  // we'll ignore d[0];

		for (int i = 1; i<10001; i++) {
			// compute d(i)
			int divisorSum = 0 ;
			for (int j = 1; j<=1 + i/2; j++) {
				if (i%j == 0) {
					divisorSum += j;
				}
			}
			d[i]=divisorSum;
		}
		int amicableSum = 0;
		for (int a=1; a<=10000; a++) {
			int b = d[a];
			if (a<b) {		// careful to not double count a,b and b,a
				if (b>=1 && b<=10000) {
					if (d[b] == a) {
						amicableSum += (a+b);
						System.out.println("Pair: " + a + ", b: " + b);
					}
				}
			}
		}
		System.out.println(amicableSum);
	}
}