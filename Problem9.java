// projecteuler.net Problem 9
public class Problem9 {
	public static void main(String [] args) {
		boolean done = false;
		for (int a = 1; a < 1001 && !done; a++) {
			for (int b = 1; b < 1001 && !done; b++) {
				for (int c = 1; c < 1001 && !done; c++) {
					if (a+b+c == 1000 && (a*a + b*b == c*c)) {
						System.out.println(a*b*c);
						System.out.println("a,b,c" + a + ". " + b + ", " + c);
						done = true;
					}
				}
			}
		}
	}
}