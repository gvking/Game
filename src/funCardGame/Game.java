 package funCardGame;

public class Game {

	public static void main(String[] args) {
		System.out.println("Welcome to Left or Right, a game where we explore how lucky you are in your choices." );;
		System.out.println("The game ends when you reach a Face Card (Jack, Queen, King, but not Ace because Ace does not have a Face!)");
		System.out.println("If you choose Left, you will proceed to the left. If Right, your card choice will go to the right!");
		System.out.println("The purpose of this game is to maximize your points without hitting a face card!");
		//Instructions
		Deck deck = new Deck();
		deck.deal();
	}

}
