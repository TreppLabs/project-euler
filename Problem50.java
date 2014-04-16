// www.projecteuler.net Problem 50
//
// curious, the second exmaple in the problem statement is worded differently from the first example or the actual problem
//   it asks for the sum of "primes smaller than BLAAH"
//   the others ask for a "prime which is smaller than BLAAH"  
// as stated, their second example should be 76099, not 953, since:
//   prime p: 76099 is sum of: 163 consecutive smaller primes, biggest is 997

// Note: this runs a bit slower than 1 minute
// we could merge the two inner loops easily

public class Problem50 {
	public static final long MAX_PRIME_VALUE = 999999;

	public static void main(String [] args) {

		Primes primeGetter = new Primes();

		int maxSummands = 0;

		int j = 1;
		// for every prime p ...
		for (long p = primeGetter.getNth(j); p<=MAX_PRIME_VALUE; p = primeGetter.getNth(++j)) {
			// ... start testing summations at each smaller primes p2 ...
			int k = 1;
			for (long p2 = primeGetter.getNth(k); p2<=p; p2 = primeGetter.getNth(++k)) {
				long summation = p2;
				int numberSummands = 1;
				// ... add subsequent primes p3 until we hit or overshoot p
				int l = k + 1;
				for (long p3 = primeGetter.getNth(l); summation<=p; p3 = primeGetter.getNth(++l)) {
					summation += p3;
					numberSummands += 1;
					if (summation == p) {
						if (numberSummands > maxSummands) {
							maxSummands = numberSummands;
							// announce that we've beaten prior record
							System.out.println("prime p: " + p + " is sum of: " + numberSummands + " consecutive smaller primes, biggest is " + p3);
						}
					}
				}
			}
		}
	}
}