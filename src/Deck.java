import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * Class implementing a simple deck of cards. A deck is made of
 * {@link Card} objects, each having a unique combination of Suit and FaceValue.
 * 
 * @author		Fabio Ticconi
 */
public class Deck
{
	protected LinkedList<Card> deckCards;
	
	public Deck()
	{
		deckCards = new LinkedList<Card>();
		
		for (Card.Suit suit : Card.Suit.values())
		{
			for (Card.FaceValue faceValue : Card.FaceValue.values())
			{
				deckCards.add(new Card(suit, faceValue));
			}
		}
	}
	
	/**
	 * Shuffles the deck
	 */
	public void shuffle()
	{
		Collections.shuffle(deckCards);
	}
	
	/** Draw a number of cards from the deck. The end result is that the cards returned are removed from the deck.
	 * 
	 * @param howMany the number of cards to be returned
	 * @return a {@link List} containing cards in the same order they were drawn
	 */
	public List<Card> draw(int howMany)
	{
		if (howMany < 1 || howMany > deckCards.size())
			return null;
		
		List<Card> drawnCards = new LinkedList<Card>();
		
		for (int i = 0; i < howMany; i++)
			drawnCards.add(deckCards.removeFirst());
		
		return drawnCards;
	}
	
	/**
	 * Draw a number of cards from the deck in sorted order. The end result is that the cards returned are removed from the deck.
	 * 
	 * @param howMany the number of cards to be returned
	 * @return a {@link List} containing cards ordered by suit and face value
	 */
	public List<Card> drawSorted(int howMany)
	{		
		List<Card> drawnCards = draw(howMany);
		
		if (drawnCards == null)
			return null;
		
		Collections.sort(drawnCards);
		
		return drawnCards;
	}
}
