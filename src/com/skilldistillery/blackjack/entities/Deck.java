package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				cards.add(new Card(suit, rank));

			}
		}

	}

	public int cardsLeftInDeck() {
		return cards.size();
	}

	public Card dealCard() {
		return cards.remove(0);
	}

	public void dealCard(Hand hand) {
		Card newCard = cards.remove(0);
		hand.addCard(newCard);
		;
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}


	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

}