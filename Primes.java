// incremental prime finder
import java.util.ArrayList;


public class Primes {
	private long maxNumberSearched;

	private ArrayList<Long> primesFound;
	private int numPrimesFound;

	public Primes() {
		maxNumberSearched = 0;
		numPrimesFound = 0;
		primesFound = new ArrayList<Long> ();
		primesFound.add(((long) -99));  // dummy 0-th value should never be touched!  we're indexing from 1
	}

	public long getNext() {
		boolean primeFound = false;

		if (numPrimesFound == 0) {
			primesFound.add(2l);
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
				primesFound.add(i);
			}
			maxNumberSearched += 1;
		}
		return primesFound.get(numPrimesFound);
	}
}