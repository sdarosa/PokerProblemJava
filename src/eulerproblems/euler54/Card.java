package eulerproblems.euler54;

public class Card {		
	
	private String name;
	private String suit;
	private int value;
	
	public Card() {
		if(name != null) {
			determineValue();
			determineSuit();
		}
	}
	public Card(String name) {
		this.name = name;	
		determineValue();
		determineSuit();
	}
	
	public int getValue() {
		return value;
	}
	public String getSuit() {
		return suit;
	}
	
	//returns the value of the card dealt;
	//T = 10, J = 11, Q = 12, K = 13, A = 14
	public void determineValue() {		
		char c = name.charAt(0);
		char[] values = {'T', 'J', 'Q', 'K', 'A'};
		//if its a number
		if(c >= '0' && c <= '9') {
			value = Character.getNumericValue(c);
		} else {
			for(int i=0; i< values.length; i++) {
				if(c == values[i]) {
					value = 10 + i;
					break;
				}
			}
		}		
	}
	//returns the suit type of the card dealt
	public void determineSuit() {
		char c = name.charAt(1);
		char[] suits = {'D', 'H', 'S', 'C'};
		String[] suitNames = {"Diamonds", "Hearts", "Spades", "Clover"};
		for(int i=0; i<suits.length; i++) {
			if(c == suits[i]) {
				suit = suitNames[i];
				break;
			}
		}
	}
	
}
