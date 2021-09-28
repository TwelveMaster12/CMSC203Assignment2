/*
* Class: CMSC203
* Instructor: Khandan Vahabzadeh Monshi
* Description: Data Element Class - RNG - This file will generate a random number between 1 and 100
* Main Class - RandomNumberGuesser - A game that prompts the user to guess a number between 1 and 100, and gives hints to help the user guess the number.
* Due: 9/28/2021
* Platform/compiler: Eclipse IDE
* I pledge that I have completed the programming assignment
independently.
I have not copied the code from a student or any source.
I have not given my code to any student.
Print your Name here: Frank Deeegbe
*/

import java.util.Scanner;
public class RandomNumberGuesser {

	public static void main(String[] args) {
		//attributes
		int lowGuess = 0;
		int highGuess = 100;
		int nextGuess;
		int randNum;

		String cont = "yes";
		//scanner class
		Scanner scan = new Scanner(System.in);
		//no need to instantiated (RNG class)
		randNum = RNG.rand();
		
		
		System.out.println("Enter your first guess");
			
		do {
		nextGuess = scan.nextInt();
		//newline character
		scan.nextLine();
		System.out.println("Number of guesses is " + (RNG.getCount() + 1));
		
		RNG.inputValidation(nextGuess, (lowGuess), (highGuess));
		
		if(nextGuess > randNum) {
			System.out.println("The guess was too high!");
			if (nextGuess < highGuess)
				highGuess = nextGuess;
		}
		if(nextGuess < randNum) {
			System.out.println("The guess was too low!");
			if(nextGuess > lowGuess)
				lowGuess = nextGuess;
		}
		if(randNum == nextGuess) {
			System.out.println("The guess was correct! Play again? (yes or no)");
			//reset attributes
			lowGuess = 0;
			highGuess = 100;
			//reset count and random number
			RNG.resetCount();
			cont = scan.nextLine();
			//play again??
			randNum = RNG.rand();
			//enter first guess in case the player wants to play again
			if (cont.equals("yes")) {
				System.out.println("Enter your first guess");
			}
		}
		
		
		
		}
		while (cont.equalsIgnoreCase("yes"));
		System.out.println("Thanks for playing! -Frank Deegbe");
	}		
}
