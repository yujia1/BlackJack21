# BlackJack21
Comp 170 Project Proposal.

Project Title: Blackjack 21
My App Definition:
Blackjack 21 is a poker game that has a dealer and a player. First, two cards are dealt to player and dealer. If the value of dealer' cards is 21, which is called Blackjack, and then the dealer wins. Otherwise, if the user has 21, then the user wins. In the middle of game, if dealer’s cards are not higher than 16, he/she has got one more card, and show one of his/her cards. The player can choose to hit or stand after he receive two initial cards.

The interesting part of game is players can choose to hit or stand, depending on what one of card dealer shows is.

Team or Individual:
Individual 

Design:
Initially, in main function, system will ask users to input the money and the bet, and then object deck deals two cards to players and dealers, respectively. Secondly, if dealer’s cards are not as high as 16, dealer has to add one more card, and then shows one of cards he/she has. Meanwhile, players decide to hit one more card or stand to stop calling cards and show all his/her cards. In the end, the winner is one who has cards value closed to 21, but not over 21. In the end, System asks players if they want to play again. In order to keep playing next round, system clear players and dealer’s cards and shuffle the cards.

Object:
1.	Card:  Card is designed to represent 52 cards that have different face value with different suits. 
Card attributes are suits and value (face value/ ranks) and other unchangeable variables. The object Cards can show its ranks and suits, and get suit and value, respectively. 

2.	Deck: Deck is designed to pack 52 cards and other functions, which is an ArrayList. 
Deck attributes are an ArrayList including 52 cards and how many cards are used. deck can shuffle cards, deal cards, get cards, and show who win.

3.	Hand:  Hand is designed to represent players or dealers. 
Hand attributes are cards in one’s hand, which is an ArrayList. Hand can add more cards, show cards, give back cards, and sum up cards in hand.
 

Main function: blackjack method run, which is method of class BlackJack.

Frist of all, key components are main function and other classes to support main function.
The inputs include user’s money bet, and actions (hit or stand), and outputs will be winner and money gain or loss.

Schedule:
Make a 4 weeks plan to do the work. List key activities for each week:
Week 1 (Monday start date) main function and method
Week 2 (Monday start date) Card object
Week 3 (Monday start date) Deck object
Week 4 (Monday start date) Hand object

Testing
Frist of all, in order to test my apps, I will conduct different instructions to test whether or not it is error. In addition, I will show my java files to my friends and ask them to play this game and give me feedback.

Bugs:
1. The class Cards return an ArrayList.
2. The class Deck exceed index of ArrayList.
3. The main function cannot show player’s card.
4. the main function cannot go through the loop of whole game.
