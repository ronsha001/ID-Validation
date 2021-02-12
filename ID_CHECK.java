import java.util.Scanner;

public class ID_CHECK {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int ID = 0;
		int checkDigit = 0;
		int IDcheckDigit = 0;
		int mod1 = 1000;
		int div1 = 100;
		int mod2 = 100;
		int div2 = 10;
		int temp = 0;
		int temp2 = 0;
		while (ID < 10000000 || ID > 999999999) {
			System.out.print("Enter ID: ");
			ID = s.nextInt();
			if (ID < 10000000 || ID > 999999999) {
				System.err.println("Invalid ID");
			}
		}
		IDcheckDigit = ID % 10;

		int checkCalc = 0;
		for (int i = 0; i < 4; i++) {
			checkCalc = (ID % mod1 / div1) * 1;
			checkDigit += checkCalc;
			mod1 *= 100;
			div1 *= 100;
		}
		for (int i = 0; i < 4; i++) {
			checkCalc = (ID % mod2 / div2) * 2;
			checkDigit += checkCalc % 10;
			checkDigit += checkCalc % 100 / 10;
			mod2 *= 100;
			div2 *= 100;
		}
		temp = checkDigit;
		if (temp >= 10) {
			temp /= 10;
		}
		for (int i = 0; i <= temp; i++) {
			temp2 += 10;
		}

		if (temp2 - checkDigit == IDcheckDigit) {
			System.out.println("Valid ID Number.");
		} else {
			System.err.println("Fake ID Number !");
		}

	}

}
