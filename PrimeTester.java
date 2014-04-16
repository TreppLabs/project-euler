//import Primes;

public class PrimeTester {
	public static void main(String [] args) {
		Primes primeGetter = new Primes();

		for (int i=1; i<=1000000; i++) {
			long p = primeGetter.getNext();
			if (i%5000 == 0) {
				System.out.println(i + "-th prime is " + p);
			}
		}
	}
}