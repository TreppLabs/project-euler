// projecteuler.net Problem 17
public class Problem17 {

	private static String[] digits = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	private static String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	private static String[] tens = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

	// others
	// hundred thousand and

	private static int nonSpaceCharCount(String s) {
		int count = 0;
		for (int i = 0; i<s.length(); i++) {
			if (s.charAt(i) != ' ') {
				count += 1;
			}
		}
		return count;
	}

	public static void main(String [] args) {
		int charCount = 0;
		for (int i = 1; i < 1001; i++) {
			int o = i % 10;         // ones
			int t = (i / 10) % 10;  // tens
			int h = (i / 100) % 10; // hundreds

			String hundredPrefix="";
			if (h!=0) {
				hundredPrefix = digits[h] + " hundred";
				if (i%100 != 0) {
					hundredPrefix = hundredPrefix + " and ";
				}
			}

			String number = hundredPrefix;

			if (t==0) {
				number = number + digits[o];
			} else if (t==1) {
				number = number + teens[o];
			} else {
				number = number + tens[t-1];
				if (o!=0) {
					number = number + " " + digits[o];
				}
			}

			if (i==1000) {
				number = "one thousand";
			}
			int cc = nonSpaceCharCount(number);
			charCount += cc;
			System.out.println(">>" + number + "<<" + " cc=" + cc);
		}
		System.out.println(charCount);
	}
}