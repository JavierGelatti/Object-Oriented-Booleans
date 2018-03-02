package main;

import java.util.Scanner;

public class MainBefore {

	public static void main(String[] args) {
		int n = getIntegerFromUser();
		
		if (n > 0 || n == 0) {
			print("The number is greater than or equal to zero");
		} else {
			print("The number is a negative number");
		}
	}

	private static void print(String text) {
		System.out.println(text);
	}

	private static int getIntegerFromUser() {
		try (Scanner input = new Scanner(System.in)) {
			System.out.println("Input an integer: ");
			return input.nextInt();
		}
	}

}
