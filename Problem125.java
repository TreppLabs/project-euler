// www.projecteuler.net problem 125
public class Problem125{

	private static boolean isPalindromic(long number) {
		String s = Long.toString(number);
		int l = s.length();
		for (int i = 0; i <= l/2; i++) {
			if (s.charAt(i) != s.charAt(l-i-1)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String [] args) {
		long limit = ((long)1e8)-1L;
		long palindromicSum = 0;
		for (int i=1; i<=Math.sqrt(limit); i++) {
			long sqSum = 0;
			for (int j=i; sqSum < limit; j++) {
				sqSum += j*j;
				if (i != j) {  // don't want a single square like 3*3 = 9 (per hint that 11 palindromics below 1000)
					if (sqSum <= limit) {
						if (isPalindromic(sqSum)) {
							palindromicSum += sqSum;
							System.out.println("i: " + i + ", j: " + j + ", sqSum: " + sqSum + ", palSum: " + palindromicSum);
							// hmmm... are some Palindromics repeated??  Sort output | uniq to find out
							// YEP 2 are repeated!
							// System.out.println(sqSum);
						}
					}
				}
			}
		}
	}
}