package eulerproblems.euler54;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestRules {
	
	Card[] cards, cards2, cards3, cards4;
	String[] cardsDealt, cd2, cd3, cd4;
	Rules r, r2, r3, r4;	

	@Before
	public void setUp() throws Exception {
		cardsDealt = new String[]{"AD","JD","QD","TD","KD"};
		cd2 = new String[]{"3H","3D","6S","6C","6H"};	
		cd3 = new String[]{"4H","4D","4C","8D","8C"};
		cd4 = new String[]{"5D","7H","2S","KC","AD"};
		
		cards = new Card[5];
		cards2 = new Card[5];
		cards3 = new Card[5];
		cards4 = new Card[5];
		
		for(int i=0; i<cards.length; i++) {
			cards[i] = new Card(cardsDealt[i]);
			cards2[i] = new Card(cd2[i]);
			cards3[i] = new Card(cd3[i]);
			cards4[i] = new Card(cd4[i]);
		}
		r = new Rules(cards);
		r2 = new Rules(cards2);
		r3 = new Rules(cards3);
		r4 = new Rules(cards4);
	}

	@Test
	public void testAreAllConsecutive() {
		assertTrue(r.areAllConsecutive());		
	}
	
	@Test
	public void testHighestValueCard() {
		assertTrue(r.highestValueCard().getValue() == 14 && r.highestValueCard().getSuit() == "Diamonds");
	}
	
	@Test
	public void testSameSuit() {
		assertTrue(r.areAllSameSuit());
	}
	
	@Test
	public void testNumCardsSameValue() {
		int[] value = {0,1,1,0};
		int[] value2 = {0,0,0,0};
		assertTrue(Arrays.equals(r2.cardsSameValue(), value));
		assertTrue(Arrays.equals(r.cardsSameValue(), value2));
	}
	
	@Test 
	public void testLowestCard() {
		Card c = r2.lowestCard();
		System.out.println(c.getValue() + " " + c.getSuit());
		assertTrue(c.getValue() == 3);
	}
	
	@Test
	public void testHighestValueSameValueCards() {
		assertEquals(r2.highestValueSameValueCards(), 6);
		assertEquals(r3.highestValueSameValueCards(), 8);
		assertEquals(r4.highestValueSameValueCards(), 0);
	}

}
