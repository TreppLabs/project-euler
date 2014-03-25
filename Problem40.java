// www.projecteuler.net  Problem 40
// d1 × d10 × d100 × d1000 × d10000 × d100000 × d1000000

public class Problem40 {
	public static void main(String [] args) {
		boolean quitting = false;
		int runningCharCount = 0;
		int nextD = 1;
		int product = 1;

		for (int i=1; !quitting; i++) {
			String s = Integer.toString(i);
			int rcc = runningCharCount;
			runningCharCount += s.length();
			if (rcc < nextD && runningCharCount >= nextD) {
				// found next one
				int pos = nextD-rcc-1;
				product *= ((int) s.charAt(pos)-'0');
				nextD = nextD*10;
			}
			if (nextD > 1000000) {
				quitting = true;
			}
		}
		System.out.println(product);
	}
}
