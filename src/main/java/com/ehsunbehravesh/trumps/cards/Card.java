package com.ehsunbehravesh.trumps.cards;

import com.ehsunbehravesh.cardgames.cards.Numbers;
import com.ehsunbehravesh.cardgames.cards.Suits;

/**
 *
 * @author Ehsun Behravesh
 */
public class Card extends com.ehsunbehravesh.cardgames.cards.Card implements Comparable<Card>{

    /**
     * The value of the card. e.g TWO number has the least value and ACE has the most value
     */
    protected final Integer value;

    /**
     * Constructor which takes the suit, number and the value
     * @param suit
     * @param number
     * @param value 
     */
    public Card(Suits suit, Numbers number, int value) {
        super(suit, number);
        this.value = value;
    }

    /**
     * Simple getter
     * @return value
     */
    public int getValue() {
        return value;
    }        

    /**
     * Compare the {@code TrumpCard} object with another {@code TrumpCard} object
     * @param card
     * @return the value {@code 0} if {@code value == card.value};
     *         a value less than {@code 0} if {@code value < card.value}; and
     *         a value greater than {@code 0} if {@code value > card.value}
     */
    @Override
    public int compareTo(Card card) {
        return value.compareTo(card.value);
    }
}
