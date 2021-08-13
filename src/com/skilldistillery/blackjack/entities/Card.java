package com.skilldistillery.blackjack.entities;

import java.util.Objects;

public class Card {
	private Rank rank;
	private Suit suit;

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	Card(Suit suit, Rank rank) {
		this.rank = rank;
		this.suit = suit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return rank == other.rank && suit == other.suit;
	}

	int getValue() {
		return this.rank.getValue();
	}
}
