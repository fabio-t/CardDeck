/**
 * Class implementing a Card, with a suit and a face value. It implements {@link Comparable},
 * and its natural order is by suit first, than by value.
 * 
 * @author		Fabio Ticconi
 */
public class Card implements Comparable<Card>
{
	public enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES}
	public enum FaceValue {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}
	
	private final Suit suit;
	private final FaceValue faceValue;
	
	public Card(Suit suit, FaceValue faceValue)
	{
		this.suit = suit;
		this.faceValue = faceValue;
	}
	
	public Suit getSuit()
	{
		return suit;
	}
	
	public FaceValue getFaceValue()
	{
		return faceValue;
	}

	@Override
	public int compareTo(Card card)
	{
		int compareValue = this.suit.compareTo(card.suit);
		
		if (compareValue < 0 || compareValue > 0)
			return compareValue;
		else
		{
			return this.faceValue.compareTo(card.faceValue);
		}
	}
}
