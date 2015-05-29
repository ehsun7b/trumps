package com.ehsunbehravesh.cardgames.cards;

/**
 *
 * @author Ehsun Behravesh
 */
public class Card {

    /**
     * Suit of the card (heart/diamond/spade/club)
     */
    protected final Suits suit;
    
    /**
     * Value of the card (2, 3 ..., Jack, Queen, King, Ace)
     */
    protected final Numbers number;

    /**
     * Constructor which takes the card suit and number
     * @param suit
     * @param number 
     */
    public Card(Suits suit, Numbers number) {
        this.suit = suit;
        this.number = number;
    }    
    
    /**
     * simple getter
     * @return suit
     */
    public Suits getSuit() {
        return suit;
    }

    /**
     * Simple getter
     * @return number
     */
    public Numbers getNumber() {
        return number;
    }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof Card) {
      Card c = (Card) obj;
      return suit == c.getSuit() && number == c.getNumber();
    }
    
    return false;
  }

  @Override
  public int hashCode() {
    return number.hashCode() + suit.hashCode();
  }
    
    
}
