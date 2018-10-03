package funCardGame;

import java.util.Queue;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class Deck {
	private Queue<Card> queue = new LinkedList<>();
	private int score;
	
	public Deck() {
		this.createDeck();
		this.shuffle();
		this.deal();
	}
	
	public void shuffle() {
		Collections.shuffle((List<?>) queue);	
		//shuffles the queue using a Collections method, but typecasted it to type List so that Collections accepts it
		
	}
	
	public void deal() {
		
			
		Scanner scan = new Scanner(System.in);
		try{
			//catch if the deck ran out of cards
		System.out.println("Your first card is "+ queue.element().getSuit() + " " + queue.element().getValue());
		this.setScore(queue.element().getValue());
		if(queue.element().getValue() > 10) {
			//make sure first card is acceptable
			System.out.println("You already lost!! Better luck next time!");
			System.exit(0);
		}		
		System.out.println("Your score so far is " + this.getScore());
		int roundCounter = 0;
		//roundCounter is used because a pyramid is basically exponential, so we need it to make sure that our pyramid progresses properly
		while(true) {
		System.out.println("So what is your choice? Left, Right, or Exit");
		String input = scan.next();
		roundCounter++;
		if(input.equals("Left")) {
			for(int i =0; i < Math.pow(2, roundCounter)-1; i++) {
			queue.remove();
			//for loop used to make the card game operate in a pyramid
			}
			if(queue.element().getValue() > 10) {
				System.out.println("Your card was "+ queue.element().getSuit() + " " + queue.element().getValue());
				System.out.println("You lost! " + "Your final score was "+ this.getScore());
				System.exit(0);
				//Exit if face card
			}
			System.out.println("Your card is "+ queue.element().getSuit() + " " + queue.element().getValue());
			this.setScore(this.getScore()+queue.element().getValue());
			//added score
			System.out.println("Your score so far is " + this.getScore());
			
		}
		
		else if(input.equals("Right")) {
			for(int i =0; i < Math.pow(2, roundCounter); i++) {
				queue.remove();
				//for loop for moving Right to move in a pyramid
				}
			if(queue.element().getValue() > 10) {
				System.out.println("Your card was "+ queue.element().getSuit() + " " + queue.element().getValue());
				System.out.println("You lost! " + "Your final score was "+ this.getScore());
				System.exit(0);
				
			}
			System.out.println("Your card is "+ queue.element().getSuit() + " " + queue.element().getValue());
			this.setScore(this.getScore()+queue.element().getValue());
			System.out.println("Your score so far is " + this.getScore());
			
			
		}
		
		else if(input.equals("Exit")){
			
			System.exit(0);
			break;
		}
		
		else {
			System.out.println("Please enter Left, Right, or Exit");
		}
			
		
		}
		}
		catch(Exception NoSuchElementException) {
			System.out.println("No more cards! Your score is " + score);
			System.out.println("Congrats! Play again next time! Make sure to touch your toes ten times between games so that you stay healthy!");
			System.exit(0);
			//addressing exception, and a little note to stay healthy between games.
		}
		
	}
	//getters and setters
	public int getScore() {
		return score;
	}
		
	public void setScore(int score) {
		this.score = score;
	}

	public Queue<Card> returnQueue(){
		return queue;
	}
	
	private void createDeck() {
		for(int i =0; i < 52; i++) {
			queue.add(new Card(i));
		}
	}
	
	
	

}
