package oops.deckOfCards;

public class Card {
    private Suit suit;
    private Rank rank;

    // Constructor to initialize the suit and rank of the card
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // Getter for the suit
    public Suit getSuit() {
        return suit;
    }

    // Getter for the rank
    public Rank getRank() {
        return rank;
    }

    // Method to display the card as a string (e.g., "Ace of Spades")
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
