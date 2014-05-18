/**
 * Ishag Alexanian       CS203        
 * project BlackJack
 * The Card class which has the number of the card between 1 and 13
 * and suit and the value between 0 and 51
 */

package blackjack;

public class Card
{
	private int number;
	private int suit;
    private int value;
	
    public Card(){}
    
	// Takes value from 0-51
	public Card(int value)
	{
		this.number = (value % 13) + 1;
		this.suit = value / 13;
		this.value = value;
	}

	public int getNumber()
	{
		return number;
	}

	public int getSuit()
	{
		return suit;
	}

	public int getVal(){
		return this.value;
	}
	
	public int getValue()
	{
		if (number == 1)
			return 1;

		else if (number > 10)
			return 10;

		else
			return number;
	}

	public String toString()
	{
		String card;

		switch (number)
		{
			case 1:
				card = "Ace";
			break;

			case 11:
				card = "Jack";
			break;

			case 12:
				card = "Queen";
			break;

			case 13:
				card = "King";
			break;

			default:
				card = number + "";
			break;
		}

		card += " of ";

		switch (suit)
		{
			case 0:
				card += "Diamonds";
			break;

			case 1:
				card += "Hearts";
			break;

			case 2:
				card += "Clubs";
			break;

			case 3:
				card += "Spades";
			break;
		}

		return card;
	}
}