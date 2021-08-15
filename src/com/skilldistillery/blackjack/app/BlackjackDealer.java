package com.skilldistillery.blackjack.app;

import java.util.Collections;
import java.util.List;
import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Card;
import com.skilldistillery.blackjack.entities.Player;



public class BlackjackDealer extends Player {
	private BlackjackHand dealerHand;
	private Deck cards;
	private int handValue;

	public BlackjackDealer() {
		super();
		cards = new Deck();
		dealerHand = new BlackjackHand();
		super.setName("Dealer");

	}

	public void addCard(Card card) {
		dealerHand.addCard(card);
	}

	public Card dealCard() {
		return cards.dealCard();
	}

	public int getHandValue() {
		handValue = dealerHand.getHandValue();
		return handValue;
	}

	public void dealersFirstHand() {
		List<Card> dealerCards = dealerHand.getCards();
		System.out.print("\nDealer has ");
		for (int i = 0; i < dealerCards.size(); i++) {
			if (i == 0) {
				System.out.print("****** of ***** ");
			} else {
				System.out.println(dealerCards.get(i) + " ");
			}
		}
	}
	
	public void showDealersHand() {
		List<Card> dealerCards = dealerHand.getCards();
		System.out.print("\nDealer has ");
		for (int i = 0; i < dealerCards.size(); i++) {
				System.out.println(dealerCards.get(i) + " ");
			}
		}
	
	public boolean isBlackjack() {
		if (getHandValue() == 21) {
			System.out.println("\nDealer has blackjack! Dealer wins!");
			List<Card> dealerCards = dealerHand.getCards();
			for (Card card : dealerCards) {
				System.out.println(card);
			}
			return true;
		}
		return false;
	}

	public boolean isBust() {
		if (getHandValue() > 21) {
			System.out.println("\n*** Dealer busted! ***");
			showDealersHand();
			return true;
		}
		return false;
	} 
	
	public boolean isTwentyOne() {
		if (getHandValue() == 21) {
			System.out.println("\nDealer has twenty one!");
			List<Card> dealerCards = dealerHand.getCards();
			for (Card card : dealerCards) {
				System.out.println(card);
			}
			return true;
		}
		return false;
	}


	public void printDeck() {
		List<Card> cardDeck = cards.getCards();
		for (Card card : cardDeck) {
			System.out.println(card);
		}
	}

	public void dealerShuffle() {
		List<Card> cardDeck = cards.getCards();
		Collections.shuffle(cardDeck);
	}
	
	public int getDeckSize() {
		List<Card> cardDeck = cards.getCards();
		return cardDeck.size();
		
	}
	
	public void clear() {
		dealerHand.clear();
	}


}