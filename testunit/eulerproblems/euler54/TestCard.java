package eulerproblems.euler54;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TestCard {	
	
	protected String card1;
	protected String card2;
	protected Card myCard;
	protected String[] cardsDealt;
	
	@Before
	public void setUp() {	
		card1 = "2D";
		card2 = "TS";
		myCard = new Card(card2);	
		cardsDealt = new String[]{"8C","TS","KC","9H","4S","7D","2S","5D","3S","AC"};	
	}

	@Test
	public void testOneCard() {
//		System.out.println(myCard.getSuit());
//		System.out.println(myCard.getValue());
		assertTrue(myCard.getSuit() == "Spades");
		assertTrue(myCard.getValue() == 10);
	}
	
	@Test
	public void testManyCards() {
		Card[] manyCards = new Card[cardsDealt.length];
		for(int i=0; i<cardsDealt.length; i++) {					
			manyCards[i] = new Card(cardsDealt[i]);
			System.out.println(manyCards[i].getValue() + " " + manyCards[i].getSuit());
		}		
		assertTrue(manyCards[3].getValue() == 9);
		assertTrue(manyCards[3].getSuit() == "Hearts");
	}

}
