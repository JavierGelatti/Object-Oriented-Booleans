package main;

import java.util.Scanner;
import static booleans._Boolean.asBoolean;

public class MainAfter {

	public static void main(String[] args) {
		int n = getIntegerFromUser();
		
		asBoolean(n > 0).or(asBoolean(n == 0)).ifTrue(() -> {
			print("The number is greater than or equal to zero");
		}).ifFalse(() -> {
			print("The number is a negative number");
		});
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
