package com.skilldistillery.blackjack.entities;

public enum Suit {
	HEARTS("Hearts \u2665"), SPADES("Spades \u2660"), CLUBS("Clubs \u2663"), DIAMONDS("Diamond \u2666");

	private String name;

	Suit(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return this.name;
	}
}