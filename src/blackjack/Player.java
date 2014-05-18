/**
 * Ishag Alexanian       CS203        
 * project BlackJack
 * The Player class is a class that holds the hand of the player
 */


package blackjack;

import java.util.*;

public class Player
{
	private List<Card> hand;
	private int score;

	public Player()
	{
		score =0; 
		hand = new ArrayList<Card>();
	}

	public int getScore()
	{
		int numAces = 0;
		int sum = 0;

		for (Card c : hand)
		{
			sum += c.getValue();

			if (c.getValue() == 1)
				++numAces;
		}

		while (numAces > 0 && sum + 10 <= 21)
		{
			sum += 10;
			--numAces;
		}

		this.score = sum;
		return score;
	}
	
	public void setScore(int score){
		this.score = score;
	}

	public void addCard(Card c)
	{
		hand.add(c);
	}

	public void reset()
	{
		hand.clear();
	}
}