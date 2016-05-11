package eulerproblems.euler54;

import java.util.Arrays;

import eulerproblems.helper.InsertionSort;

public class Rules {
	
	private Card[] cards;
	private int[] values;
	private String[] suits;
	
	public Rules(Card[] cards) {
		this.cards = cards;
		this.values = new int[cards.length];
		this.suits = new String[cards.length];
		setValuesAndSuits();
	}
	
	private void setValuesAndSuits() {
		for(int i=0; i<cards.length; i++) {
			values[i] = cards[i].getValue();
			suits[i] = cards[i].getSuit();
		}
	}
	
	//returns the lowest valued card
	public Card lowestCard() {
		Card c = cards[0];
		for(int i=1; i< cards.length; i++) {
			if(cards[i].getValue() < c.getValue()) c = cards[i];
		}		
		return c;
	}
	
	//determines if a number of cards are consecutive
	public boolean areAllConsecutive() {			
		int[] v = values;
		InsertionSort is = new InsertionSort(v);
		is.sort();
		for(int i=1; i<v.length; i++) {
			if(v[i] != (v[i-1] + 1)) {
				return false;
			}			
		}		
		return true;		
	}
	
	//returns the card with the highest value
	public Card highestValueCard() {
		Card highestCard = cards[0];
		for(int i=1; i<cards.length; i++) {
			if(cards[i].getValue() > highestCard.getValue()) {
				highestCard = cards[i];
			}
		}		
		return highestCard;
	}
	
	//determines if all cards have the same suit
	public boolean areAllSameSuit() {
		for(int i=1; i<suits.length; i++) {
			if(!suits[i].equals(suits[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	//returns either: 41, 31, 32, 22, 21, 0  (4 same, 3 same, 3 same & 1 pair, 2 pairs, 1 pair, none)
	public int[] cardsSameValue() {		
		int[] cardValue = new int[13];
		int[] type = {0,0,0,0};		
		
		//set cardValue values to zero
		for(int i : cardValue) i=0;		
		for(int v : values) {
			cardValue[v - 2] += 1;
		}
		//determine which ones are the same
		for(int i : cardValue) {
			if(i == 0) continue;
			if(i == 4) {
				type[0] += 1; 
			} else if(i == 3) {
				type[1] += 1;
			} else if(i == 2) {
				type[2] += 1;
			}
		}
		return type;
	}	
	
	public int highestValueSameValueCards() {		
		int[] cardValue = new int[13];		
		int[] typeValue = {0,0,0,0};
		int highest = -1;
		
		//set cardValue values to zero
		for(int i : cardValue) i=0;		
		for(int v : values) {
			cardValue[v - 2] += 1;
		}
		//determine which ones are the same
		for(int i=0; i<cardValue.length; i++) {
			if(cardValue[i] == 0) continue;
			if(cardValue[i] == 4) {
				typeValue[0] = i + 2;	//4 of the same value
			} else if(cardValue[i] == 3) {
				typeValue[1] = i + 2;	//3 of the same value
			} else if(cardValue[i] == 2) {
				if(typeValue[2] == 0) typeValue[2] = i + 2;	//2 of the same value
				else typeValue[3] = i + 2; 	//another pair
			}
		}
		//System.out.println("Result of typeValue");
		for(int i : typeValue) {
			//System.out.print(i + " ");
			if(highest < i) highest = i;
		}
		return highest;
	}
	
	
	
}
