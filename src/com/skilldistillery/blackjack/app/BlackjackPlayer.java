package com.skilldistillery.blackjack.app;

import com.skilldistillery.blackjack.entities.Hand;
import com.skilldistillery.blackjack.entities.Player;

import java.util.List;

import com.skilldistillery.blackjack.entities.Card;

	public class BlackjackPlayer extends Player {
		private BlackjackHand playerHand;
		private int handValue;

		public BlackjackPlayer() {
			playerHand = new BlackjackHand();
			super.setName("Player 1");
		}

		public void addCard(Card card) {
			playerHand.addCard(card);
		}
		
		public Hand getPlayerHand() {
			List<Card> playerCards = playerHand.getCards();
			System.out.print("\nPlayer has ");
			for (Card card : playerCards) {
				System.out.print(card + " ");
			}
			System.out.println();
			return playerHand;
		}

		public int getHandValue() {
			handValue = playerHand.getHandValue();
			return handValue;
		}
		
		public boolean isBlackjack() {
			if (getHandValue() == 21) {
				System.out.println("\nPlayer has blackjack! Player wins!");
				List<Card> playerCards = playerHand.getCards();
				for (Card card : playerCards) {
					System.out.println(card);
				}
				return true;
			}
			return false;
		}

		public boolean isBust() {
			if (getHandValue() > 21) {
				System.out.println("\n*** You busted! ***");
				return true;
			}
			return false;
		} 
		
		public boolean isTwentyOne() {
			if (getHandValue() == 21) {
				System.out.println("\nPlayer has twenty one!");
				List<Card> playerCards = playerHand.getCards();
				for (Card card : playerCards) {
					System.out.println(card);
				}
				return true;
			}
			return false;
		}
		
		public void clear() {
			playerHand.clear();
		}

	}