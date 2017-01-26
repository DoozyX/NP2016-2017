package exercises.exercise4.p2;

import java.util.Scanner;

/**
 * Problem 2.
 * • Maximum sum problem: There is a robot sent to
 * Mars, to collect as much newly discovered stones as
 * possible. The surface of Mars is represented as a
 * table А (m x n), and in each square the number of
 * stones is shown.
 * • The robot starts from the upper left corner, and
 * should travel to the lower right corner. The robot can
 * be moved right or down only. Write a program that
 * gives the maximal number of stones the robot can
 * collect.
 * <p>
 * test
 * 5 5
 * 0 5 10 6 7
 * 2 3 4 8 10
 * 3 2 50 6 9
 * 4 5  8 1 0
 * 90 2 10 3 9
 */
public class MaximumSum {
	public static void main(String[] args) {
		int m, n;
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		int[][] best = new int[n][m];

		best[0][0] = arr[0][0];

		for (int i = 1; i < m; i++) {
			best[0][i] = arr[0][i] + best[0][i - 1];
		}
		for (int i = 1; i < n; i++) {
			best[i][0] = arr[i][0] + best[i - 1][0];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				best[i][j] = Math.max(best[i - 1][j], best[i][j - 1]) + arr[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(best[i][j] + " ");
			}
			System.out.println();
		}
	}
}
