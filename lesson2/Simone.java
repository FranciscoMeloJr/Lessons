package tp6305.francisco;

import java.util.ArrayList;
import java.util.Scanner;

public class Simone {
	static int participants = 0;
	static int male = 0;

	// season:
	static int[] arraySeasonMale = new int[4];
	static int[] arraySeasonFemale = new int[4];
	// group:
	static int[] arrayGroupMale = new int[5];
	static int[] arrayGroupFemale = new int[5];

	// color:
	static int[] arrayColorFemale = new int[3];
	static int[] arrayColorMale = new int[3];

	// Group+color:
	static int[] arrayAgeGroupColor1 = new int[5];
	static int[] arrayAgeGroupColor2 = new int[5];
	static int[] arrayAgeGroupColor3 = new int[5];

	// Group+season
	static int[] arrayAgeGroupSeason1 = new int[5];
	static int[] arrayAgeGroupSeason2 = new int[5];
	static int[] arrayAgeGroupSeason3 = new int[5];
	static int[] arrayAgeGroupSeason4 = new int[5];

	static ArrayList<Participant> listParticipant = new ArrayList<Participant>();

	public static void main(String[] args) {

		System.out.println("Welcome");
		Scanner sc = new Scanner(System.in);
		System.out.println("Want to enter information? y or n : ");
		char choice = sc.next().charAt(0);
		while (choice == 'y') {
			participants++;
			System.out.println("The gender? ");
			char Gender = sc.next().charAt(0);
			if (Gender == 'm' || Gender == 'M') {
				male++;
			}
			if (validateGender(Gender)) {
				System.out.println("What is the age group?: ");
				int AgeGroup = sc.nextInt();
				if (validateAge(AgeGroup)) {
					System.out.println("What is the season wanted?: ");
					int seasonGroup = sc.nextInt();
					if (validateSeason(seasonGroup)) {
						System.out.println("What is the prefered color?: ");
						int prefColor = sc.nextInt();
						if (validateColor(prefColor)) {
							System.out.println("Want to enter information? y or n : ");
							choice = sc.next().charAt(0);
							putinfo(participants, Gender, AgeGroup, seasonGroup, prefColor);
						}
					}
				}
			}
		}
		showStatistics();
	}

	private static boolean validateAge(int AgeGroup) {
		if (AgeGroup < 1 || AgeGroup > 5)
			return false;
		return true;
	}

	private static boolean validateSeason(int seasonGroup) {
		if (seasonGroup < 1 || seasonGroup > 4)
			return false;
		return true;
	}

	private static boolean validateColor(int prefColor) {
		if (prefColor < 1 || prefColor > 3)
			return false;
		return true;
	}

	private static boolean validateGender(char Gender) {
		if (Gender == 'f' || Gender == 'F' || Gender == 'm' || Gender == 'M')
			return true;
		return false;
	}

	private static void putinfo(int id, char gender, int AgeGroup, int seasonGroup, int prefColor) {
		AgeGroup--;
		seasonGroup--;

		if (gender == 'm') {
			arrayGroupMale[AgeGroup]++;
			arraySeasonMale[seasonGroup]++;
			arrayColorMale[prefColor]++;
		} else {
			arrayGroupFemale[AgeGroup]++;
			arraySeasonFemale[seasonGroup]++;
			arrayColorFemale[prefColor]++;
		}
		// para cada grupo de idade, porcentagem de pessoas que ecolheram cada
		// estação e porcentagem que escolheram cada cor.

		if (prefColor == 1) {
			arrayAgeGroupColor1[AgeGroup]++;
		}
		if (prefColor == 2) {
			arrayAgeGroupColor2[AgeGroup]++;
		}
		if (prefColor == 3) {
			arrayAgeGroupColor3[AgeGroup]++;
		}

		if (seasonGroup == 1) {
			arrayAgeGroupSeason1[AgeGroup]++;
		}
		if (seasonGroup == 2) {
			arrayAgeGroupSeason2[AgeGroup]++;
		}
		if (seasonGroup == 3) {
			arrayAgeGroupSeason3[AgeGroup]++;
		}
		if (seasonGroup == 4) {
			arrayAgeGroupSeason4[AgeGroup]++;
		}

		listParticipant.add(new Participant(id, gender, AgeGroup, seasonGroup, prefColor));
	}

	/* Function to show statistics: */
	static void showStatistics() {
		System.out.println("Statistics");

		/*
		 * 
		 * - Total de participantes - Total de homens - Total de mulheres - para
		 * casa estação, porcentagem de homens e mulheres - para cada cor,
		 * porcentagem de homens e mulheres - para cada grupo de idade,
		 * porcentagem de pessoas que ecolheram cada estação e porcentagem que
		 * escolheram cada cor.
		 */

		System.out.println("Total " + participants);
		System.out.println("male " + male);
		System.out.println("female " + (participants - male));

		// Season:
		for (int i = 0; i < arraySeasonMale.length; i++) {
			System.out.println("Season " + (i + 1) + " male " + arraySeasonMale[i] + " female " + arraySeasonFemale[i]);
		}
		// Color:
		for (int i = 0; i < arrayColorMale.length; i++) {
			System.out.println("Color " + (i + 1) + " male " + arrayColorMale[i] + " female " + arrayColorFemale[i]);
		}

		// Season:
		for (int i = 0; i < arrayAgeGroupSeason1.length; i++) {
			if (arrayAgeGroupSeason1[i] != 0)
				System.out.println("Season 1, Age Group " + (i + 1) + " " + arrayAgeGroupSeason1[i]);

		}
		for (int i = 0; i < arrayAgeGroupSeason2.length; i++) {
			if (arrayAgeGroupSeason2[i] != 0)
				System.out.println("Season 2, Age Group " + (i + 1) + " " + arrayAgeGroupSeason2[i]);

		}
		for (int i = 0; i < arrayAgeGroupSeason3.length; i++) {
			if (arrayAgeGroupSeason3[i] != 0)
				System.out.println("Season 3, Age Group " + (i + 1) + " " + arrayAgeGroupSeason3[i]);

		}
		for (int i = 0; i < arrayAgeGroupSeason4.length; i++) {
			if (arrayAgeGroupSeason4[i] != 0)
				System.out.println("Season 4, Age Group " + (i + 1) + " " + arrayAgeGroupSeason4[i]);
		}

		// Color:
		for (int i = 0; i < arrayAgeGroupColor1.length; i++) {
			if (arrayAgeGroupColor1[i] != 0)
				System.out.println("Color 1, Age Group " + (i + 1) + " " + arrayAgeGroupColor1[i]);
		}
		for (int i = 0; i < arrayAgeGroupColor2.length; i++) {
			if (arrayAgeGroupColor2[i] != 0)
				System.out.println("Color 2, Age Group " + (i + 1) + " " + arrayAgeGroupColor2[i]);
		}
		for (int i = 0; i < arrayAgeGroupColor3.length; i++) {
			if (arrayAgeGroupColor3[i] != 0)
				System.out.println("Color 3, Age Group " + (i + 1) + " " + arrayAgeGroupColor3[i]);
		}

	}

	static class Participant {

		int id;
		char gender;
		int ageGroup;
		int seasonGroup;
		int prefColour;

		Participant(int id, char gender, int age, int season, int color) {
			this.id = id;
			this.gender = gender;
			this.ageGroup = age;
			this.seasonGroup = season;
			this.prefColour = color;

		}
	}
}
