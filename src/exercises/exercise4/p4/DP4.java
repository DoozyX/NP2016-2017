package exercises.exercise4.p4;

import java.util.Arrays;


public class DP4 {
	public static void main(String[] args) throws Exception {
		int i, j = 0;
		System.out.println("Paricki so dinamicko programiranje");
		int COINS = 5;
		int SUMS = 24;
		int coins[] = new int[]{1, 2, 5, 8, 10};
		int coinsNum[] = new int[SUMS + 1];
		for (i = 0; i < COINS; i++)
			coinsNum[coins[i]] = 1;

		System.out.println("a " + Arrays.toString(coinsNum));

		for (i = 0; i < SUMS; i++) {
			if (coinsNum[i] == 0)
				continue;
			for (j = 0; j < COINS; ++j) {
				if (i + coins[j] <= SUMS) {
					if ((coinsNum[i + coins[j]] == 0) ||
							(coinsNum[i + coins[j]] > coinsNum[i] + 1)) {
						coinsNum[i + coins[j]] = coinsNum[i] + 1;
					}
				}
			}
			System.out.println("a " + Arrays.toString(coinsNum));
		}
		System.out.println(Arrays.toString(coinsNum));

		int n = 25;
		int coins1[] = new int[]{1, 2, 5, 8, 10};
		int coinsNum1[] = new int[n];
		for (i = 1; i < n; i++) {
			coinsNum1[i] = i;
		}
		for (i = 0; i < coins1.length; i++)
			coinsNum1[coins1[i]] = 1;

		for (i = 1; i < coins1.length; i++) {
			for (j = 1; j < n; j++) {
				if (j - coins1[i] > 0) {
					if (1 + coinsNum1[j - coins1[i]] < coinsNum1[j]) {
						coinsNum1[j] = 1 + coinsNum1[j - coins1[i]];
					}
				}
			}
		}
		System.out.println(Arrays.toString(coinsNum1));
	}
}