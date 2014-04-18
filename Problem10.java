// www.projecteuler.net Problem10
public class Problem10 {
	private static final int UPPER_BOUND = 2000000;

	public static void main(String [] args) {
		Primes primeGetter = new Primes();
		long sum = 0;
		for (int i=1; primeGetter.getNth(i) < UPPER_BOUND; i++) {
			long p = primeGetter.getNth(i);
			sum += p;
		}
		System.out.println(sum);
	}
}