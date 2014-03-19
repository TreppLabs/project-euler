// projecteuler.net Problem 28
public class Problem28 {
	
	public static void main(String [] args) {
		int dimension=1001;
		int sum = 0;

		sum = sum + 1;  // center

		for (int i=3; i <= dimension; i+=2) {
			sum = sum + i*i - 0*(i-1);
			sum = sum + i*i - 1*(i-1);
			sum = sum + i*i - 2*(i-1);
			sum = sum + i*i - 3*(i-1);
		}
		System.out.println(sum);
	}
}