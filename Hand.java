/*
 * a class of hand can be used as dealer'hand or player's hand
 * the hand can ask for cards, show the cards, and give it back of cards
 * also hand can show hand card's value
 */
import java.util.*;
public class Hand {
	private ArrayList<Card> handCard;
	public Hand() {
		this.handCard= new ArrayList<Card>();
	}
	/**
	 * the method is to add one more card to hand
	 * @param Card, is one specific card
	 * the method is add one card in hand of list
	 */
	public void addCard(Card cards) {
		if(cards !=null) getHandCard().add(cards);
	}
	/**
	 * 
	 * @param j is integer, which represents card's face value
	 * @return string to show specific card
	 */
	public String showCard(int j) {
		Card newCard = (Card)getHandCard().get(j); 
		return newCard.toString();

	}
	public void clearCard() {
		getHandCard().clear();
	}
	
	public ArrayList<Card> getHandCard() {
		return handCard;
	}

	public int handValue() {
		int val = 0;
		boolean ace = false;
		for(int i = 0; i < this.handCard.size(); i++) {
			int cardVal = this.handCard.get(i).getValue();
			if(cardVal > 10) {
				cardVal = 10;
			}
			if(cardVal == 1) {
				ace = true;
			}
			val = val + cardVal;
		}
		if(ace == true && val + 10 <=21)
			val = val + 10;
		
		return val;
		
	}
	
		
	}
	
	

