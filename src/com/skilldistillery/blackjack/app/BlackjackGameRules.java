package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.Deck;
import com.skilldistillery.blackjack.entities.Player;

public class BlackjackGameRules {
	private BlackjackPlayer bjPlayer;
	private BlackjackDealer dealer;
	private Scanner kb; 

	public static void main(String[] args) {
		BlackjackGameRules app = new BlackjackGameRules();
		app.run();
	}

	private void run() {
		kb = new Scanner(System.in);
		welcome();
		kb.close();
	}

	private void welcome() {
		System.out.println("\u2665 \u2660 \u2666 \u2663 \u2665 \u2660 \u2666 \u2663");
		System.out.println("Welcome to the SD30 Blackjack Simulator!");
		System.out.println("Don't worry, we don't play for cash!");
		System.out.println("Enter 1 to Play");
		System.out.println("Enter 2 to Exit");
		System.out.println("\u2665 \u2660 \u2666 \u2663 \u2665 \u2660 \u2666 \u2663");
		System.out.println(" ");
		int selection = kb.nextInt();
		System.out.println(" ");
		switch (selection) {
		case 1:
			newGame();
			break;
		case 2:
			System.out.println("Goodbye!");
			break;
		default:
			System.err.println("Error. Please enter 1 or 2.");
			selection = kb.nextInt();
			break;
		}
	}

	public void newGame() {
		bjPlayer = new BlackjackPlayer();
		dealer = new BlackjackDealer();
		dealer.dealerShuffle();

		bjPlayer.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());

		bjPlayer.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());

		bjPlayer.getPlayerHand();
		System.out.println("Player: " + bjPlayer.getHandValue());
		System.out.println();
		dealer.dealersFirstHand();

		checkBlackjack();

		if (dealer.getHandValue() < 21 && bjPlayer.getHandValue() < 21) {
			hitOrStay();
		}

	}

	private void continueGame() {
		System.out.println("\nWould you like to play another hand?");
		System.out.println("\nEnter 1 to Play");
		System.out.println("Enter 2 to Exit");
		System.out.print("\u2665 \u2660 \u2666 \u2663 \u2665 \u2660 \u2666 \u2663");
		int selection = kb.nextInt();
		switch (selection) {
		case 1:
			newHand();
			break;
		case 2:
			System.out.println("\u2665 \u2660 \u2666 \u2663 Hope you enjoyed it! \u2665 \u2660 \u2666 \u2663");
			System.exit(0);
			break;
		default:
			System.err.println("Error. Please enter 1 or 2.");
			selection = kb.nextInt();
			break;
		}

	}

	private void newHand() {
		clear();
		checkDeck();
		bjPlayer.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());

		bjPlayer.addCard(dealer.dealCard());
		dealer.addCard(dealer.dealCard());

		bjPlayer.getPlayerHand();
		System.out.println("Player: " + bjPlayer.getHandValue());
		System.out.println();
		dealer.dealersFirstHand();

		checkBlackjack();

		if (dealer.getHandValue() < 21 && bjPlayer.getHandValue() < 21) {
			hitOrStay();
		}

	}

	private void hitOrStay() {
		System.out.println("\nTo HIT enter 1");
		System.out.println("To STAY enter 2");
		System.out.println(" ");
		int selection = kb.nextInt();

		switch (selection) {
		case 1:
			playerHit();
			break;
		case 2:
			System.out.println("Player has selected stay. Dealer's move.");
			if (bjPlayer.getHandValue() <= 21 && dealer.getHandValue() < 17) {
				dealerHit();
				dealer.isBust();
				continueGame();
			}

			if (bjPlayer.getHandValue() == dealer.getHandValue()) {
				System.out.println("\n\u2665 \u2660 \u2666 \u2663 Tie! Standoff! \u2665 \u2660 \u2666 \u2663");
				dealer.showDealersHand();
				continueGame();

			} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < 21) {
				bjPlayer.isTwentyOne();
				bjPlayer.isBust();
				checkWin();
			}

			break;

		default:
			System.err.println("Error. Please enter 1 or 2.");
			selection = kb.nextInt();
			break;
		}
	}

	private void playerHit() {
		bjPlayer.addCard(dealer.dealCard());
		bjPlayer.isBust();
		bjPlayer.getPlayerHand();
		System.out.println("Player: " + bjPlayer.getHandValue());
		if (bjPlayer.getHandValue() < 22) {
			hitOrStay();
		}
		continueGame();
	}

	private void dealerHit() {
		while (dealer.getHandValue() < 17) {
			dealer.addCard(dealer.dealCard());
			System.out.println("\nDealer hits!");
		}

		if (bjPlayer.isTwentyOne() && dealer.isTwentyOne()) {
			System.out.println("\n \u2665 \u2660 \u2666 \u2663 Tie! Standoff! \u2665 \u2660 \u2666 \u2663");
			clear();

		} else if (dealer.getHandValue() > 16 && dealer.getHandValue() < 22) {
			checkWin();
		}

	}

	private void checkWin() {
		if (bjPlayer.getHandValue() == dealer.getHandValue()) {
			System.out.println("\n \u2665 \u2660 \u2666 \u2663 Tie! Standoff! \u2665 \u2660 \u2666 \u2663");

		}
		if (bjPlayer.getHandValue() > dealer.getHandValue() || dealer.getHandValue() > 21) {
			System.out.println("\n\u2665 \u2660 \u2666 \u2663 You win! Congratulations! \u2665 \u2660 \u2666 \u2663");

		}
		if (bjPlayer.getHandValue() < dealer.getHandValue() || bjPlayer.getHandValue() > 21) {
			System.out.println("\n\u2665 \u2660 \u2666 \u2663 Dealer wins! \u2665 \u2660 \u2666 \u2663");

		}
		dealer.showDealersHand();
		continueGame();
	}

	private boolean checkBlackjack() {
		if (dealer.isBlackjack()) {
			continueGame();
			return true;
		}
		if (dealer.getHandValue() < 21 && bjPlayer.isBlackjack()) {
			continueGame();
			return true;

		} else {
			return false;
		}

	}

	private void checkDeck() {
		if (dealer.getDeckSize() < 14) {
			System.out.println("\n Reshuffling deck.");
			dealer = new BlackjackDealer();
			dealer.dealerShuffle();
		}
	}

	private void clear() {
		bjPlayer.clear();
		dealer.clear();

	}

}
