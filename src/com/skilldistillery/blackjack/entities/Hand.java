package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	protected List<Card> hand = new ArrayList<Card>();
	private int handValue;

// need a constructor 
	public Hand() {
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public void setHandValue(int handValue) {
		this.handValue = handValue;
	}

	public void addCard(Card card) {
		hand.add(card);
	}

	public void clear() {
		hand.clear();
	}

	public int getHandValue() {
		handValue = 0;
		for (Card card : hand) {
			handValue = handValue + card.getValue();
		}
		return handValue;

	}
	public List<Card> getCards(){
		return hand;
	}


	public void showCards() {
		for (Card card : hand) {
			System.out.println(card);
		}
	}

	public void add(Card dealCard) {
		// TODO Auto-generated method stub

	}

}
