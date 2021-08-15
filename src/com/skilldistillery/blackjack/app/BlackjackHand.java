package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Hand;

public class BlackjackHand extends Hand {
	private int playerHandValue;

	BlackjackHand() {

	}

	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			return true;
		}
		return false;
	}

	public int getHandValue() {
		playerHandValue = 0;

	for (Card card : hand) {
		playerHandValue = card.getValue() + playerHandValue; 
		
	}
		return playerHandValue;
	}

}