// projecteuler.net  problem 6
public class Problem6 {
	
	public static void main(String [] args) {
		long sumSq = 0;
		long sum = 0;
		long sqSum = 0;
		for (long i = 1; i < 101; i++) {
			sumSq += i*i;
			sum += i;
		}
		System.out.println(sum*sum - sumSq);
	}
}