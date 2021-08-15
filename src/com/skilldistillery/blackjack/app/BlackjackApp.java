package com.skilldistillery.blackjack.app;

public class BlackjackApp {

	public static void main(String[] args) throws InterruptedException {
		BlackjackApp run = new BlackjackApp();
		run.launch();
	}

	private void launch() throws InterruptedException {
		BlackjackGameRules bj = new BlackjackGameRules();
		bj.newGame();
	}
	
	}