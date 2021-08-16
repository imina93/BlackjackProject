package com.skilldistillery.blackjack.entities;

public class Player {
Hand playerHand;
private String name; // get rid of wallet

public Player (Hand hand) {
	this.playerHand = hand;
}

public Player() { // need a no arg constructor
	super();
	}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Hand getPlayerHand() {
	return playerHand;
}

public void setPlayerHand(Hand playerHand) {
	this.playerHand = playerHand;
}



}