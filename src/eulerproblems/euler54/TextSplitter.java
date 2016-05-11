/*
 * splitText() takes the line of texts and splits it into an array 
 * where each location is a card.
 */

package eulerproblems.euler54;

public class TextSplitter {
	private String line;
	
	public TextSplitter() {}
	public TextSplitter(String line) {
		this.line = line;
	}

	public String getLine() {
		return line;
	}
	public void setLine(String line) {
		this.line = line;
	}
	
	public String[] getPlayArray() {
		String[] text = line.split(" ");
		//readArray(text);		 
		return text;
	}
	
	public void readArray(String[] cards) {
		for(int i=0; i<cards.length; i++) {
			System.out.println(cards[i]);
		}
	}
	

}
