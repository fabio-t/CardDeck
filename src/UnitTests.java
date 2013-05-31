import static org.junit.Assert.*;


public class UnitTests
{
	@org.junit.Test
	public void deckTest()
	{
		Deck deck = new Deck();
		
		assertNull("drawing a negative number of cards must return null", deck.draw(-1));
		assertNull("drawing 0 cards must return null", deck.draw(0));
		assertNull("drawing a too big number of cards must return null", deck.draw(500));
		
		assertSame("drawing 5 cards from the deck must return a list with 5 elements", 5, deck.draw(5).size());
		
		deck = new Deck();
		Deck deck2 = new Deck();
				
		assertEquals("the first card of two different, unshuffled decks must be the same", deck.draw(1).get(0), deck2.draw(1).get(0));
		assertTrue("cards drawn in sorted order from an unshuffled deck must be the same as if drawn in non-sorted order", deck.draw(5).equals(deck2.drawSorted(5)));
		
		deck2.shuffle();
		
		assertTrue("if a a deck is shuffled, it must have a different order of cards than an unshuffled deck", !deck.draw(5).equals(deck2.draw(5)));
	}
	
	@org.junit.Test
	public void cardTest()
	{
		Card highestCard = new Card(Card.Suit.SPADES, Card.FaceValue.ACE);
		Card highCard = new Card(Card.Suit.SPADES, Card.FaceValue.JACK);
		Card lowestCard = new Card(Card.Suit.CLUBS, Card.FaceValue.TWO);
		Card lowCard = new Card(Card.Suit.CLUBS, Card.FaceValue.FOUR);
		
		assertTrue("the highest card must return a positive number when calling 'compareTo' with the others", 
					highestCard.compareTo(highCard) > 0 && highestCard.compareTo(lowCard) > 0 &&
					highestCard.compareTo(lowestCard) > 0);
		
		assertTrue("the lowest card must return a negative number when calling 'compareTo' with the others",
					lowestCard.compareTo(highCard) < 0 && lowestCard.compareTo(lowCard) < 0 &&
					lowestCard.compareTo(highestCard) < 0);
		
		Card highCard2 = new Card(Card.Suit.HEARTS, Card.FaceValue.ACE);
		Card lowCard2 = new Card(Card.Suit.DIAMONDS, Card.FaceValue.TWO);
		
		assertTrue("if the suit is different, it rules the order even with the same face value", highCard.compareTo(highCard2) > 0 && lowCard.compareTo(lowCard2) < 0);
	}
}
