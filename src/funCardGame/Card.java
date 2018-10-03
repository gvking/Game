package funCardGame;

public class Card {
	private String suit;
	private int value;
	//classic object oriented program with getters and setters
	public Card(int cardIdentifier) {
		if(cardIdentifier < 13) {
			this.setSuit("Hearts");
			this.setValue(cardIdentifier+1);
		}
		else if(cardIdentifier < 26) {
			this.setSuit("Diamonds");
			this.setValue(cardIdentifier-12);
		}
		else if(cardIdentifier < 39) {
			this.setSuit("Clubs");
			this.setValue(cardIdentifier-27);
		}
		else if(cardIdentifier < 52) {
			this.setSuit("Spades");
			this.setValue(cardIdentifier-38);
		}
		// identifies the type of card it is, starting with Hearts and ending with Spades.
		//did this because easier to do one loop of 52 than two for loops when creating a deck in the Deck class
	}
	
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	} 
	

}

