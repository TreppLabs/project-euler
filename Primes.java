// incremental prime finder
// compute them on-demand

import java.util.ArrayList;


public class Primes {
	private long maxNumberSearched;
	private long maxPrimeFound;

	private ArrayList<Long> primesFound;
	private int numPrimesFound;

	public Primes() {
		maxNumberSearched = 0;
		maxPrimeFound = 0;
		numPrimesFound = 0;
		primesFound = new ArrayList<Long> ();
		primesFound.add(((long) -99));  // dummy 0-th value should never be touched!  we're indexing from 1
	}

	public boolean isPrime(long l) {

		// extend our list of primes if necessary in order to search for l
		while (maxPrimeFound < l) {
			this.getNext();
		}

		// now binary search for l
		int lo = 1;
		int hi = numPrimesFound;

		while (true) {
			int mid = (lo+hi) / 2;
			long midPrime = primesFound.get(mid);
			if (midPrime == l) {
				return true;
			} else if (Math.abs(hi-lo) <= 1) {
				// bottom out case
				// actually all base cases at once, so we don't have to be precise about even/odd 1-or-2
				if ((primesFound.get(lo) == l) || (primesFound.get(hi) == l)) {
					return true;
				} else {
					return false;
				} 
			} else if (midPrime < l) {
				lo = mid;
			} else {
				hi = mid;
			}
		}
	}

	public long getNth(int n) {
		if (numPrimesFound < n) {
			for (int i = numPrimesFound+1; i <= n; i++) {
				this.getNext();
			}
		}
		return primesFound.get(n);
	}

	private long getNext() {
		boolean primeFound = false;

		if (numPrimesFound == 0) {
			primesFound.add(2l);
			maxPrimeFound = 2;
			numPrimesFound = 1;
			maxNumberSearched = 2;
			return (long) 2;
		}

		for (long i = maxNumberSearched+1; !primeFound; i++) {
			// test if i is prime
			// divide by all primes <= sqrt(i)
			// if one divides evenly, then i is composite
			// but if we get to sqrt, then i is prime
			boolean divisorFound = false;
			long stoppingPoint = ((long) Math.sqrt(i)) + 1;
			for (int k = 1; primesFound.get(k) < stoppingPoint; k++) {
				if (i % primesFound.get(k) == 0) {
					divisorFound = true;
					break;
				}
			}
			if (!divisorFound) {
				numPrimesFound += 1;
				primeFound = true;
				maxPrimeFound = i;
				primesFound.add(i);
			}
			maxNumberSearched += 1;
		}
		return primesFound.get(numPrimesFound);
	}
}