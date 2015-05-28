package com.ehsunbehravesh.trumps.cards;

import com.ehsunbehravesh.cardgames.cards.Numbers;
import com.ehsunbehravesh.cardgames.cards.Suits;

/**
 *
 * @author Ehsun Behravesh
 */
public class Card extends com.ehsunbehravesh.cardgames.cards.Card implements Comparable<Card> {

  /**
   * The value of the card. e.g TWO number has the least value and ACE has the
   * most value
   */
  protected final Integer value;

  /**
   * Constructor which takes the suit, number and the value
   *
   * @param suit
   * @param number
   * @param value
   */
  public Card(Suits suit, Numbers number, int value) {
    super(suit, number);
    this.value = value;
  }

  /**
   * Constructor which takes the suit and the number. The value will be determined by number.
   * @param suit
   * @param number 
   */
  public Card(Suits suit, Numbers number) {
    super(suit, number);
    this.value = valueOf(number);
  }
  
  /**
   * Simple getter
   *
   * @return value
   */
  public int getValue() {
    return value;
  }

  /**
   * Compare the {@code TrumpCard} object with another {@code TrumpCard} object
   *
   * @param card
   * @return the value {@code 0} if {@code value == card.value}; a value less
   * than {@code 0} if {@code value < card.value}; and a value greater than
   * {@code 0} if {@code value > card.value}
   */
  @Override
  public int compareTo(Card card) {
    return value.compareTo(card.value);
  }

  @Override
  public String toString() {
    return "suit: ".concat(String.valueOf(suit)).concat("(" + Suits.characterOf(suit) + ")").concat(" number: ").concat(String.valueOf(number)).concat(" value: ").concat(String.valueOf(value));
  }

  public static int valueOf(Numbers number) {
    switch (number) {
      case TWO:
        return 2;
      case THREE:
        return 3;
      case FOUR:
        return 4;
      case FIVE:
        return 5;
      case SIX:
        return 6;
      case SEVEN:
        return 7;
      case EIGHT:
        return 8;
      case NINE:
        return 9;
      case TEN:
        return 10;
      case JACK:
        return 11;
      case QUEEN:
        return 12;
      case KING:
        return 13;
      case ACE:
        return 14;
    }
    
    return 0;
  }
}
