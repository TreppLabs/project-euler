// projecteuler.net Problem 15
import java.math.BigInteger;

public class Problem15 {

	private static BigInteger factorial(int num) {
		BigInteger result = new BigInteger("1");
		for (int i=1; i<=num; i++) {
			result = result.multiply(BigInteger.valueOf((long)(i)));
		}
		return result;
	}

	public static void main(String [] args) {
		// go right 20 times, down 20 times
		// just gotta choose where to place rightward moves in that sequence
		// this is just "40 choose 20" which I can't do in my head or on a calculator
		// 40! / (20! * 20!)
		// longs not long enough..
		BigInteger numRoutes = factorial(40).divide(factorial(20).multiply(factorial(20)));
		System.out.println(numRoutes.toString());
	}
}