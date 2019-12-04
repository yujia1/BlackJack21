import java.util.Random;
import java.util.Scanner;

public class BlackJack21 {
	Hand dealer;
	Hand player1;
	Deck deck;
	private Random ran;
	public void run () {
		
		dealer = new Hand();
		player1 = new Hand();
		deck = new Deck();
		int money;
		int bet;
		boolean resume = true;
		ran = new Random();
		Scanner keyboard = new Scanner(System.in);
		//in beginning of game, ask player to input money
		System.out.println("Welcome to blackjack21!");
		System.out.println("How much you buy in chips: ");
		money = keyboard.nextInt();
		while(money <= 0) {
			System.out.println("Error! The money has to be a positive number.");
			System.out.println("How much you buy in chips: ");
			money = keyboard.nextInt();	
		}
		
		
		// loop to run game again
		while(true) {
			
			/*
			 * // ask users to input bet
			 * input can only between 0- money player inputed early
			 */
			System.out.println("How much bet you put this round: ");
			bet = keyboard.nextInt();
			while(bet <= 0 || bet > money) {
				System.out.println("The bet has to be between 0 and " + money + ".");
				System.out.println("How much bet you put this round: ");
				bet = keyboard.nextInt();
			}
			System.out.println();
			// shuffle card
			deck.shuffle(); 
			
			/**
			 * deal two cards to player and dealer
			 * show one of dealer's cards
			 */
			player1.addCard(deck.dealtCard());
			player1.addCard(deck.dealtCard());
			System.out.println("You get two cards");
			System.out.println();
			dealer.addCard(deck.dealtCard());
			dealer.addCard(deck.dealtCard());
			System.out.println("Dealer is dealt two cards.");
			System.out.println();
			
			// check black jack 21
			if(player1.handValue() ==21 ) {
					System.out.println("you get black jack.");
					// player blackjack
					System.out.println();
			}
			if(dealer.handValue() == 21) {
					System.out.println("Dealer gets black jack.");
					// dealer black jack
					System.out.println();
					
			}
			
			// show one of dealer's cards
			System.out.println();
			System.out.println("One of Dealer's cards is: ");
			System.out.println(dealer.showCard(ran.nextInt(dealer.getHandCard().size())));
			System.out.println();
			// check out player's card and show it
			System.out.println("Your cards are: ");
			System.out.println(player1.showCard(0));
			System.out.println(player1.showCard(1));
			System.out.println();
			/*
			 *  this loop is to keep ask user hit or stand until player inputs either h or s
			 *  under condition that player hit, system will give one more cards to player.
			 *  but if the value of cards of player is over 21, system end loop, and player loses.
			 *  under condition that player stand, it ends with asking player's action.
			 */
			/**
			 * none of them gets black jack,
			 * ask user to hit or stand cards, and check out if handvalue is over 21
			 */
			while(true) {
				
				System.out.println("Do you want to hit or stand? [h/s]");
				String action = keyboard.next();
				while(!action.equals("h") && !action.equals("s")) {
				System.out.println("The input has to be 'h' or 's'.");
				System.out.println("Do you want to hit or stand? [h/s]");
				action = keyboard.next();}
				
				if(action.equals("h")) {
					System.out.println("You get one more card.");
					player1.addCard(deck.dealtCard());
					System.out.println("Your cards are:");
					for(int i = 0; i < player1.getHandCard().size();i++) {
						System.out.println(player1.showCard(i));
					}
					System.out.println();
					if(player1.handValue() >21) {
						System.out.println("You are over 21.");
						System.out.println();
						resume = false;
						break;
					}	
				}else {
					resume = true;
					break;
				}
			}
			/*
			 * if neither dealer or player are blackjack21,check out if dealer's hand value is less 16
			 *  add one more card to dealer if dealer is less than 16.
			 */
			if(resume) {
				while(dealer.handValue() < 16) {
					
					dealer.addCard(deck.dealtCard());; // get one more card
					System.out.println("Dealer asks one more card.");
					System.out.println();
					if(dealer.handValue() > 21) {
						System.out.println("Dealer is over 21, and you win!");
						break;
					}
				}	
			}
			
			/**
			 * this method is to compare player's card value to dealer's card value
			 * arguments are integers, which represent player's and dealer's cards values so far.
			 *  output will be boolean, if it return true, player is closer to 21 and win. otherwise, dealer wins.
			 */
			boolean result = deck.showDown(player1.handValue(), dealer.handValue());
			 if(result) {
					System.out.println("You win!");
					System.out.println("The dealer's cards are:");
					for(int j = 0; j < dealer.getHandCard().size();j++) {
						System.out.println(dealer.showCard(j));
					}
					money = money + bet;
					System.out.println("You win $"+ bet + " and you have $" + money + " so far.");
			}else  {
					System.out.println("You lose!");
					System.out.println();
					System.out.println("The dealer's cards are:");
					for(int j = 0; j < dealer.getHandCard().size();j++) {
						System.out.println(dealer.showCard(j));
					}
					money = money -bet;
					System.out.println();
					System.out.println("You lose $" + bet + " and you have $" + money + " so far.");
			}
				System.out.println();
			/*
			 * keep asking player if he/she want to play the game again
			 */
			System.out.println("Do you wan to play again[y/n]: ");
			String answer = keyboard.next();
			while(!answer.equals("y") && !answer.equals("n")) {
				System.out.println("The input has to be 'y' or 'n'.");
				System.out.println("Do you wan to play again[y/n]: ");
				answer = keyboard.next();
			}
			
				if(answer.equals("y")) {
					 System.out.println("Let's play again."); 
					 System.out.println("Currently, you have $"+ money + " chips.");
					 player1.clearCard();//clear player card  
					 dealer.clearCard(); //clear dealer card 
					 deck.shuffle();//  shuffle deck
					 System.out.println();
					 if(money ==0) {
						 System.out.println("You don't have money.");
						 break;
					 }
				 }else if(answer.equals("n")){
					 System.out.println("Currently, you have $"+ money + " chips.");
					 keyboard.close();
					 break;
				}
		}	
	}
	public static void main(String[]args) {
		/**
		 * the main function is to create a object "game" of BlackJack
		 * and use method to run the program
		 */
		BlackJack21 game=new BlackJack21();
		game.run();

	}

}
