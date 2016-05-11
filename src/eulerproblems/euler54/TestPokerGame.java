package eulerproblems.euler54;

import java.net.URL;
import java.util.List;

import eulerproblems.helper.MyFileReader;

public class TestPokerGame {

	public static void main(String[] args) {
		int player1Wins = 0;
		int player2Wins = 0;
		//get the file
		MyFileReader fr = new MyFileReader();
		URL url = TestPokerGame.class.getResource("p054_poker.txt");		
		fr.setFilePath(url.getPath());
		//make a list of each play
		List<String> myList = fr.readFileByLine();		
		//split each line into arrays
//		TextSplitter ts = new TextSplitter(myList.get(0));
//		ts.getPlayArray();
		
		for(int i=0; i<myList.size(); i++) {
			TextSplitter ts = new TextSplitter(myList.get(i));
			String[] playString = ts.getPlayArray();
			Card[] playCards = new Card[playString.length];
			//get the 10 cards 
			for(int x=0; x<playCards.length; x++) {
				playCards[x] = new Card(playString[x]);
			}
			WinnerDeterminator wd = new WinnerDeterminator(playCards);
			if(wd.determineWinner() == 1) {
				player1Wins += 1;
			} else if(wd.determineWinner() == 2) {
				player2Wins += 1;
			} else {
				System.out.println("error, this should never run");
			}
		}
		
		System.out.println("Player 1 wins: " + player1Wins);
		System.out.println("player 2 wins: " + player2Wins);
	}

}
