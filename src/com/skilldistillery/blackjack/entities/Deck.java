package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck;



public Deck() {
// Create a list to hold the cards
	deck = new ArrayList<Card>(52);
	// Fill the deck with cards
	// Need to iterate over both fields to make the whole deck
	for (Suit s: Suit.values()) { // first makes 4 suites
		for (Rank r : Rank.values()) { // makes 14 ranks for each suit
			deck.add(new Card(s,r)); // add cards to the deck
		}
	}
}
public Card dealCard() { //needs remove instead of get to pick the card up
	return deck.remove(0);
}
public int checkDeckSize() {
	return deck.size();
		}
public void shuffle(){
	Collections.shuffle(deck);
}
}
