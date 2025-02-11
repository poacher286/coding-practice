package oops.deckOfCards;

public class Main {
    public static void main(String[] args) {
        // Create a new deck of cards
        Deck deck = new Deck();
        
        // Display the deck before shuffling
        System.out.println("Deck before shuffling:");
        deck.displayDeck();
        
        // Shuffle the deck
        deck.shuffle();
        
        // Display the deck after shuffling
        System.out.println("\nDeck after shuffling:");
        deck.displayDeck();
        
        // Draw a few cards from the deck
        System.out.println("\nDrawing cards:");
        for (int i = 0; i < 5; i++) {
            Card card = deck.draw();
            System.out.println("Drew: " + card);
        }
        
        // Check the remaining size of the deck
        System.out.println("\nCards remaining in the deck: " + deck.size());
    }
}
