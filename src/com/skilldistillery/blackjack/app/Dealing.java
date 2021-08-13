package com.skilldistillery.blackjack.app;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Deck;

public class Dealing {
	
	public static void main(String[] args) {
		Dealing app = new Dealing();
		//Write a program to ask a user how many cards they want.
		app.launch();
	}

	private void launch() {
		Deck deck = new Deck();
		try {
		Scanner kb = new Scanner(System.in);
		System.out.println("How many cards would you like?");
		int numCards = kb.nextInt();
		kb.nextLine();
		List<Card> hand = new ArrayList<>();
		for (int numReq =0; numReq < numCards; numReq++) {
			hand.add(deck.dealCard());
		}
		
		// need a hand to hold the cards 
		
		for (Card card : hand) {
			System.out.println(card);
		}
		kb.close();
		} catch (Exception e) {
			System.err.println("Error");
		}
//Handle the case where users enter a non-integer or a number greater than 52: print an error message.
//			if (numCards > 52) {
//				System.err.println("Error: Cards Cannot Exceed 52");
//				}
//Deal the cards and display them on the screen. Also display the total value of all cards.
}
}