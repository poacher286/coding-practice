package oops.deckOfCards;

import java.util.*;

public class Deck {
    private List<Card> cards;
    private Random random;

    // Constructor to initialize a new deck of 52 cards
    public Deck() {
        cards = new ArrayList<>();
        random = new Random();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Method to shuffle the deck of cards
    public void shuffle() {
        Collections.shuffle(cards, random);
    }

    // Method to draw a card from the deck
    public Card draw() {
        if (cards.isEmpty()) {
            System.out.println("No cards left in the deck.");
            return null;
        }
        return cards.remove(cards.size() - 1); // Draws the last card in the list
    }

    // Method to check if the deck is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Method to get the number of cards remaining in the deck
    public int size() {
        return cards.size();
    }

    // Method to display the remaining cards in the deck
    public void displayDeck() {
        cards.forEach(System.out::println);
    }
}
