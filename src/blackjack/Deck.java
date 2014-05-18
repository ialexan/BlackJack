/**
 * Ishag Alexanian       CS203        
 * project BlackJack
 * The Deck class has a 52 cards  which is a stack of cards
 */


package blackjack;

import java.util.*;

public class Deck
{
	private Stack<Card> deck;

	public Deck()
	{
		deck = new Stack<Card>();

		reset();
	}

	public Card getCard()
	{
		return deck.pop();
	}

	public void reset()
	{
		deck.clear();

		for (int i = 0; i < 52; ++i)
			deck.push(new Card(i));

		Collections.shuffle(deck);
	}
}