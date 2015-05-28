package com.ehsunbehravesh.trumps.cards;

import com.ehsunbehravesh.cardgames.cards.Numbers;
import com.ehsunbehravesh.cardgames.cards.Suits;
import com.ehsunbehravesh.trumps.exceptions.DeckIsEmptyException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 *
 * @author Ehsun Behravesh
 */
public class Deck {

  /**
   * initial size of cards set
   */
  public static final int STANDARD_SIZE = 52;

  /**
   * The set containing cards
   */
  protected final List<Card> cards;

  /**
   * Constructor which fills the cards set and may shuffle the set
   *
   * @param shuffle if true shuffles the deck
   */
  public Deck(boolean shuffle) {
    cards = new ArrayList<>(STANDARD_SIZE);

    Suits suit = Suits.CLUB;

    cards.add(new Card(suit, Numbers.TWO, 2));
    cards.add(new Card(suit, Numbers.THREE, 3));
    cards.add(new Card(suit, Numbers.FOUR, 4));
    cards.add(new Card(suit, Numbers.FIVE, 5));
    cards.add(new Card(suit, Numbers.SIX, 6));
    cards.add(new Card(suit, Numbers.SEVEN, 7));
    cards.add(new Card(suit, Numbers.EIGHT, 8));
    cards.add(new Card(suit, Numbers.NINE, 9));
    cards.add(new Card(suit, Numbers.TEN, 10));
    cards.add(new Card(suit, Numbers.JACK, 11));
    cards.add(new Card(suit, Numbers.QUEEN, 12));
    cards.add(new Card(suit, Numbers.KING, 13));
    cards.add(new Card(suit, Numbers.ACE, 14));

    suit = Suits.DIAMOND;

    cards.add(new Card(suit, Numbers.TWO, 2));
    cards.add(new Card(suit, Numbers.THREE, 3));
    cards.add(new Card(suit, Numbers.FOUR, 4));
    cards.add(new Card(suit, Numbers.FIVE, 5));
    cards.add(new Card(suit, Numbers.SIX, 6));
    cards.add(new Card(suit, Numbers.SEVEN, 7));
    cards.add(new Card(suit, Numbers.EIGHT, 8));
    cards.add(new Card(suit, Numbers.NINE, 9));
    cards.add(new Card(suit, Numbers.TEN, 10));
    cards.add(new Card(suit, Numbers.JACK, 11));
    cards.add(new Card(suit, Numbers.QUEEN, 12));
    cards.add(new Card(suit, Numbers.KING, 13));
    cards.add(new Card(suit, Numbers.ACE, 14));

    suit = Suits.HEART;

    cards.add(new Card(suit, Numbers.TWO, 2));
    cards.add(new Card(suit, Numbers.THREE, 3));
    cards.add(new Card(suit, Numbers.FOUR, 4));
    cards.add(new Card(suit, Numbers.FIVE, 5));
    cards.add(new Card(suit, Numbers.SIX, 6));
    cards.add(new Card(suit, Numbers.SEVEN, 7));
    cards.add(new Card(suit, Numbers.EIGHT, 8));
    cards.add(new Card(suit, Numbers.NINE, 9));
    cards.add(new Card(suit, Numbers.TEN, 10));
    cards.add(new Card(suit, Numbers.JACK, 11));
    cards.add(new Card(suit, Numbers.QUEEN, 12));
    cards.add(new Card(suit, Numbers.KING, 13));
    cards.add(new Card(suit, Numbers.ACE, 14));

    suit = Suits.SPADE;

    cards.add(new Card(suit, Numbers.TWO, 2));
    cards.add(new Card(suit, Numbers.THREE, 3));
    cards.add(new Card(suit, Numbers.FOUR, 4));
    cards.add(new Card(suit, Numbers.FIVE, 5));
    cards.add(new Card(suit, Numbers.SIX, 6));
    cards.add(new Card(suit, Numbers.SEVEN, 7));
    cards.add(new Card(suit, Numbers.EIGHT, 8));
    cards.add(new Card(suit, Numbers.NINE, 9));
    cards.add(new Card(suit, Numbers.TEN, 10));
    cards.add(new Card(suit, Numbers.JACK, 11));
    cards.add(new Card(suit, Numbers.QUEEN, 12));
    cards.add(new Card(suit, Numbers.KING, 13));
    cards.add(new Card(suit, Numbers.ACE, 14));

    if (shuffle) {
      shuffle();
    }
  }

  private void shuffle() {
    Collections.shuffle(cards);
  }

  public int count() {
    return cards.size();
  }

  public Card get(boolean remove) throws DeckIsEmptyException {
    try {
      Iterator<Card> iterator = cards.iterator();
      Card result = iterator.next();

      if (remove) {
        iterator.remove();
      }
      
      return result;
    } catch (NoSuchElementException ex) {
      throw new DeckIsEmptyException("Deck count: " + count());
    }
  }

  public List<Card> getCards() {
    return cards;
  }
  
  
}
