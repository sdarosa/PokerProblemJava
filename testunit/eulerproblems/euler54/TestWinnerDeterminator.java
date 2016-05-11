package eulerproblems.euler54;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestWinnerDeterminator {
	
	WinnerDeterminator wd, wd2;
	Card[] cards;
	String[] play;
	Card[] player1, player2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12;
	Card c8C = new Card("8C");
	Card cTS = new Card("TS");
	Card cKC = new Card("KC");
	Card c9H = new Card("9H");
	Card c4S = new Card("4S");
	Card c7D = new Card("7D");
	Card c2S = new Card("2S");
	Card c5D = new Card("5D");
	Card c3S = new Card("3S");
	Card cAC = new Card("AC");
	Card[] game1;
	
	
	@Before
	public void setUp() {		
		play = new String[]{"8C","TS","KC","9H","4S","7D","2S","5D","3S","AC"};
		cards = new Card[play.length];
		for(int i=0; i<play.length; i++) {
			cards[i] = new Card(play[i]);
		}
		wd = new WinnerDeterminator(cards);
		player1 = wd.getCardsPlayer1();
		player2 = wd.getCardsPlayer2();
		p3 = new Card[]{new Card("TD"), new Card("JH"), new Card("QS"), new Card("KH"), new Card("AH")};
		p4 = new Card[]{new Card("TH"), new Card("JH"), new Card("QH"), new Card("KH"), new Card("9H")};
		p5 = new Card[]{new Card("3D"), new Card("3H"), new Card("3S"), new Card("3C"), new Card("9H")};
		p6 = new Card[]{new Card("3D"), new Card("3H"), new Card("3S"), new Card("2C"), new Card("2H")};
		p7 = new Card[]{new Card("4D"), new Card("7D"), new Card("8D"), new Card("9D"), new Card("TD")};
		p8 = new Card[]{new Card("7A"), new Card("3H"), new Card("4H"), new Card("6C"), new Card("5H")};
		p9 = new Card[]{new Card("JH"), new Card("JD"), new Card("2D"), new Card("JS"), new Card("AS")};
		p10 = new Card[]{new Card("JH"), new Card("JD"), new Card("2D"), new Card("2S"), new Card("AS")};
		p11 = new Card[]{new Card("JH"), new Card("JD"), new Card("5D"), new Card("7C"), new Card("AS")};
		p12 = new Card[]{new Card("JH"), new Card("5D"), new Card("2H"), new Card("7C"), new Card("AC")};
		
		game1 = new Card[]{c8C, cTS, cKC, c9H, c4S, c7D, c2S, c5D, c3S, cAC};
		wd2 = new WinnerDeterminator(game1);
	}

	@Test
	public void testSplitArrays() {		
		assertTrue(player1[0] == cards[0]);
		assertTrue(player1[4] == cards[4]);
		assertTrue(player2[0] == cards[5]);
		assertTrue(player2[4] == cards[9]);
	}
	
	@Test 
	public void testLevelDeterminator() {		
		assertEquals(wd.levelDeterminator(p3), 9);	//ROYAL FLUSH
		assertEquals(wd.levelDeterminator(p4), 8); //straight flush
		assertEquals(wd.levelDeterminator(p5), 7); //four of a kind
		assertEquals(wd.levelDeterminator(p6), 6); //full house
		assertEquals(wd.levelDeterminator(p7), 5); //flush
		assertEquals(wd.levelDeterminator(p8), 4); //straight
		assertEquals(wd.levelDeterminator(p9), 3); //three of a kind		
		assertEquals(wd.levelDeterminator(p10), 2); //Two pairs
		assertEquals(wd.levelDeterminator(p11), 1); //one pair
		assertEquals(wd.levelDeterminator(p12), 0); //high card
	}
	
	@Test
	public void testDetermineWinner() {
		assertTrue(wd2.determineWinner() == 2);
	}
	
	
}
