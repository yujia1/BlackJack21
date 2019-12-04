/*
 * a class Deck collects 52 cards randomly, which can be dealt to players and dealers
 * and deck will shuffle cards so that cards are dealt randomly
 * deck also can compare two players' cards
 */
import java.util.Collections;
import java.util.ArrayList;
public class Deck {
	ArrayList<Card> deckCard;
	private int cardused = 52;
	
	public Deck() {
		this.deckCard = new ArrayList<Card>();
		for(int i = 0; i < 4; i++) {
			for(int j =1; j <=13; j++) {
				Card cards = new Card(i,j);
				deckCard.add(cards);
			}
		}
	}
	// deal card to hand, and count how many cards left
	public Card dealtCard() {
		cardused--;
		return this.deckCard.get(cardused);
		
	}
	
	// shuffle the pack of cards
	public void shuffle() {
		Collections.shuffle(deckCard);
	}
	// compare two hand value
	public boolean showDown(int a, int b) {
		if( b > 21) {
			return true; // dealer over 21
		}
		if((a <21) && (a > b)) {
			return true; // play is closer to 21
		}
		if((a == 21) && (b != 21)) {
			return true; // play is blackjack, dealer is not
		}
		if(a > 21) {
			return false; // player is over 21
		}
		if((b < 21) && (b >a)) {
			return false; // dealer is closer to 21
		}
		if(b == 21) {
			return false; // dealer is blackjack 21
		}else {
			return true;
		}
	
	}
	
}
