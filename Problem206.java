// www.projecteuler.net Problem 206
//1_2_3_4_5_6_7_8_9_0
public class Problem206 {

	private static boolean specialMatch(long l) {
		String lString = Long.toString(l);
		if (lString.length() < 19) {
			return false;
		}
		for (int i=1; i<=9; i++) {
			if (lString.charAt(2*i-2) != Integer.toString(i).charAt(0)) {
				return false;
			}
		}
		if (lString.charAt(18) != '0') {
			return false;
		}
		return true;
	}

	public static void main(String [] args) {
		long startNum = (long) Math.sqrt(1000000000000000000L);
		long  stopNum = (long) Math.sqrt(1999999999999999999L);
		//System.out.println("startNum: " + startNum + ", stopNum: " + stopNum);
		for (long i = startNum; i < stopNum; i += 1) {
			//if (i % 10000000L == 0) {
			//	System.out.println("i: " + i + ", i*i: " + i*i);
			//}
			if (specialMatch(i*i)) {
				System.out.println(i);
				break;
			}
		}
	}
}