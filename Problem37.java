// www.projecteuler.net Problem37
public class Problem37 {
	private static Primes primeGetter = new Primes();

	private static boolean isTruncatable(long n) {
		String s = Long.toString(n);
		int l = s.length();
		// trim from right
		for (int i = l; i>0; i--) {
			String ss = s.substring(0,i);
			Long ll = Long.valueOf(ss);
			if (!primeGetter.isPrime(ll)) {
				return false;
			}
		}
		// trim from left
		for (int i = 0; i<l; i++) {
			String ss = s.substring(i,l);
			Long ll = Long.valueOf(ss);
			if (!primeGetter.isPrime(ll)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String [] args) {
		
		int truncatables = 0;
		long sum = 0;
		// first four primes 2,3,5,7 defined as not truncatable so start with 5th prime
		for (int i=5; truncatables < 11; i++) {
			long p = primeGetter.getNth(i);
			if (isTruncatable(p)) {
				System.out.println("p: " + p + " is truncatable!");
				truncatables += 1;
				sum += p;
			}
		}
		System.out.println(sum);
	}
}