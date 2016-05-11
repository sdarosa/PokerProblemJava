package eulerproblems.euler54;

import java.util.Arrays;

import eulerproblems.helper.InsertionSort;

public class WinnerDeterminator {
	private Card[] cardsPlayer1, cardsPlayer2;	
	private int winner;
	private Card highestCardPlayer1, highestCardPlayer2;
	
	public WinnerDeterminator() {}
	public WinnerDeterminator(Card[] cards) {
		this.cardsPlayer1 = Arrays.copyOfRange(cards, 0, cards.length / 2);
		this.cardsPlayer2 = Arrays.copyOfRange(cards, cards.length / 2, cards.length);		
	}
	
	public Card[] getCardsPlayer1() {
		return cardsPlayer1;
	}
	public Card[] getCardsPlayer2() {
		return cardsPlayer2;
	}	
	
	public void printCard(Card[] card) {		
		for(Card ca : card) {
			System.out.println(ca.getValue() + " " + ca.getSuit());
		}
	}
	
	//determines the hand result 
	public int levelDeterminator(Card[] cards) {
		Rules r = new Rules(cards);
		int level = -1;
		
		if(r.areAllConsecutive() && r.lowestCard().getValue() == 10) {
			level = 9;	//Royal Flush
		} else if (r.areAllConsecutive() && r.areAllSameSuit()) {
			level = 8;	//Straight Flush
		} else if(r.cardsSameValue()[0] == 1) {
			level = 7;	//Four of a Kind
		} else if(r.cardsSameValue()[1] == 1 && r.cardsSameValue()[2] == 1) {
			level = 6;	//Full House
		} else if(r.areAllSameSuit() && level == -1) {
			level = 5;  //Flush
		} else if(r.areAllConsecutive() && level == -1) {
			level = 4; //Straight
		} else if(r.cardsSameValue()[1] == 1 && r.cardsSameValue()[2] == 0) {
			level = 3;	//Three of a Kind
		} else if(r.cardsSameValue()[2] == 2) {
			level = 2; 	//Two Pairs
		} else if(r.cardsSameValue()[2] == 1) {
			level = 1;	//One Pair
		} else {
			level = 0;	//High Card
		}		
		return level;
	}
	
	//determines the winner
	public int determineWinner() {
		Rules r1 = new Rules(cardsPlayer1);
		Rules r2 = new Rules(cardsPlayer2);
		int levelPlayer1 = levelDeterminator(cardsPlayer1);
		int levelPlayer2 = levelDeterminator(cardsPlayer2);
		highestCardPlayer1 = r1.highestValueCard();
		highestCardPlayer2 = r2.highestValueCard();
		
		int hsvc1 = r1.highestValueSameValueCards();
		int hsvc2 = r2.highestValueSameValueCards();
		
		if(levelPlayer1 > levelPlayer2) {
			winner = 1;
		} else if(levelPlayer1 < levelPlayer2) {
			winner = 2;
		} else {
			//compare the highest value card between the players
			if(levelPlayer1 == 0 || levelPlayer1 == 4 || levelPlayer1 == 5 || levelPlayer1 == 8) {
				if(highestCardPlayer1.getValue() > highestCardPlayer2.getValue()) {
					winner = 1; 
				} else {
					winner = 2;
				}
			} else if(levelPlayer1 == 1 || levelPlayer1 == 2 || levelPlayer1 == 3 || levelPlayer1 == 6 || levelPlayer1 == 7) {	//compare the highest value between the pairs
				if(hsvc1 > hsvc2) {
					winner = 1;
				} else if(hsvc1 < hsvc2) {
					winner = 2;
				} else {
					if(highestCardPlayer1.getValue() > highestCardPlayer2.getValue()) {
						winner = 1; 
					} else {
						winner = 2;
					}					
				}
			} else {
				System.out.println("this should never run at " + this.getClass());
			}
		}
		return winner;		
	}
	
	
	
	

}
