package com.isometricmultimedia.binaryconvert;

import java.util.Random;

public class BinaryConvertComponent {

	public static final int MAX_CHALLENGES = 10;
	public static final int DIGITS = 10;

	public static String[] challenge = new String[MAX_CHALLENGES];
	public static int difficulty = 0; // difficulty is 1 - 5, hard to easy

	public static void main(String[] args) {

		difficulty = 2;
		challenge = prepChallenges(difficulty);

		for (int i = 0; i < challenge.length; i++) {
			System.out.println(challenge[i]);
		}

		System.exit(0);
	}

	private static String[] prepChallenges(int difficulty) {

		String[] ch1 = new String[MAX_CHALLENGES];
		String[] ch2 = new String[MAX_CHALLENGES];
		Random rnd = new Random();
		int maxRnd = (int) (Math.pow(2, DIGITS - difficulty) - 1);

		System.out.println("Max Random Value: " + maxRnd + " -- Difficulty: " + difficulty + " -- Total Challenges: " + MAX_CHALLENGES);

		for (int i = 0; i < MAX_CHALLENGES; i++) {
			int currDec = rnd.nextInt(maxRnd);
			int bit = 1;

			ch1[i] = "";
			ch2[i] = "";

			for (int j = 0; j < DIGITS; j++) {
				ch1[i] += Integer.toString((((currDec & bit) == 0) ? 0 : 1));
				bit *= 2;
			}

			for (int k = ch1[i].length() - 1; k >= 0; k--) { //Reverse the string at ch1[i] and place it in ch2[i]
				ch2[i] += ch1[i].charAt(k);
			}

			ch2[i] += "-" + Integer.toString(currDec) + "-" + Integer.toHexString(currDec);
		}
		return ch2;
	}

}
