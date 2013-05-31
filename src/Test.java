import static org.junit.Assert.*;


public class Test
{
	@org.junit.Test
	public void test()
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
}
