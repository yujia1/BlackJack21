/*
 * a class of Card consist of attributes Rank and Suit, which represents different cards
 * Card's value is defined by its face value
 * Card's suit is defined by its suits type.
 */

public class Card {
	
	public final static int ACE = 1, JACK = 11, QUEEN = 12, KING =13; 
	public final static int SPADES = 0, HEART = 1, DIAMONDS = 2, CLUBS =3;
	private final int suit;
	private final int value;
	
	public Card(int initialSuit, int initialValue) { // Card constructor
		this.suit = initialSuit;
		this.value = initialValue;
	}
	
	public int getValue() {
		return value;
	}
	/**
	 * it represents different card's face value pointing to cards face
	 * @return cards face
	 */
	public String getValueToString() {
		switch(value) {
		case 1: return "Ace";
		case 2:   return "2";
        case 3:   return "3";
        case 4:   return "4";
        case 5:   return "5";
        case 6:   return "6";
        case 7:   return "7";
        case 8:   return "8";
        case 9:   return "9";
        case 10:  return "10";
        case 11:  return "Jack";
        case 12:  return "Queen";
        case 13:  return "King";
        default:  return "error";
		}
	}
	
	public int getSuit() {
		return suit;
	}
	
	public String getSuitToString() {
		switch(suit) {
		case 0: return "SPADES";
		case 1: return "HEART" ;
		case 2: return "DIAMONDS";
		case 3: return "CLUBS";
		default: return "error";
		}
	}
	public String toString() {
		return getValueToString() + " of " + getSuitToString();
	}

	
	
	
	
}
	
