package com.ehsunbehravesh.trumps.cards;

import com.ehsunbehravesh.cardgames.cards.Suits;
import com.ehsunbehravesh.trumps.exceptions.TrickNotAllCardsAreSetException;
import com.ehsunbehravesh.trumps.exceptions.TrickSetCardException;

/**
 * Trumps trick
 *
 * @author Ehsun Behravesh
 */
public class Trick {

    /**
     * First player card in the trick
     */
    protected Card card1;

    /**
     * Second player card in the trick
     */
    protected Card card2;

    /**
     * Third player card in the trick
     */
    protected Card card3;

    /**
     * Fourth player card in the trick
     */
    protected Card card4;

    /**
     * The suit which is the trump in the trick
     */
    protected final Suits trumpSuit;

    /**
     * Constructor which takes the trump suit
     *
     * @param trumpSuit
     */
    public Trick(Suits trumpSuit) {
        this.trumpSuit = trumpSuit;
    }

    /**
     * To find out of all cards are none trump in the trick
     *
     * @return {@code true} if none of the cards in the trick are the trump, and
     * {@code false} if at least one of the cards is the trump
     */
    private boolean noneIsTrump() {
        boolean result = true;

        try {
            if (card1.getSuit() == trumpSuit) {
                result = false;
            }

            if (card2.getSuit() == trumpSuit) {
                result = false;
            }

            if (card3.getSuit() == trumpSuit) {
                result = false;
            }

            if (card4.getSuit() == trumpSuit) {
                result = false;
            }
        } catch (NullPointerException ex) {
            throw new TrickNotAllCardsAreSetException("Not all cards in the trick are set. Can not determine if all are non-trump suits");
        }

        return result;
    }

    /**
     * To get the winner card of the Trick
     *
     * @return winner card out of the four cards
     */
    public Card winner() {
        try {
            Card winner = card1;

            /**
             * if the trick is a trump trick (all cards are trump) or none of
             * the cards are trump the winner is the higher value
             */
            if (card1.getSuit() == trumpSuit) {
                if (winner.compareTo(card2) < 0 && card2.getSuit() == trumpSuit) {
                    winner = card2;
                }

                if (winner.compareTo(card3) < 0 && card3.getSuit() == trumpSuit) {
                    winner = card3;
                }

                if (winner.compareTo(card4) < 0 && card4.getSuit() == trumpSuit) {
                    winner = card4;
                }
            } else if (noneIsTrump()) {
                if (winner.compareTo(card2) < 0 && winner.getSuit() == card2.getSuit()) {
                    winner = card2;
                }

                if (winner.compareTo(card3) < 0 && winner.getSuit() == card3.getSuit()) {
                    winner = card3;
                }

                if (winner.compareTo(card4) < 0 && winner.getSuit() == card4.getSuit()) {
                    winner = card4;
                }
            } else {
                /**
                 * if some of cards are trump but not the first card
                 */
                if (card2.getSuit() == trumpSuit) {
                  winner = card2;
                } else if (winner.compareTo(card2) < 0) {
                  winner = card2;
                }
                
                if (winner.getSuit() == trumpSuit) {
                  if (card3.getSuit() == trumpSuit && winner.compareTo(card3) < 0) {
                    winner = card3;
                  } 
                } else if (card3.getSuit() == trumpSuit) {
                  winner = card3;
                } else if (winner.compareTo(card3) < 0) {
                  winner = card3;
                }
                
                if (winner.getSuit() == trumpSuit) {
                  if (card4.getSuit() == trumpSuit && winner.compareTo(card4) < 0) {
                    winner = card4;
                  } 
                } else if (card4.getSuit() == trumpSuit) {
                  winner = card4;
                } else if (winner.compareTo(card4) < 0) {
                  winner = card4;
                }
            }

            return winner;
        } catch (NullPointerException ex) {
            throw new TrickNotAllCardsAreSetException("Winner can not be determined until all players cards are set.");
        }
    }

    /**
     * Simple getter
     *
     * @return card1
     */
    public Card getCard1() {
        return card1;
    }

    /**
     * Simple setter
     *
     * @param card1
     */
    public void setCard1(Card card1) {
        if (this.card1 != null) {
            throw new TrickSetCardException("The first card is already set and can not be set again in the trick.");
        }

        this.card1 = card1;
    }

    /**
     * Simple getter
     *
     * @return card2
     */
    public Card getCard2() {
        return card2;
    }

    /**
     * Simple setter
     *
     * @param card2
     */
    public void setCard2(Card card2) {
        if (this.card2 != null) {
            throw new TrickSetCardException("The second card is already set and can not be set again in the trick.");
        }

        this.card2 = card2;
    }

    /**
     * Simple getter
     *
     * @return card3
     */
    public Card getCard3() {
        return card3;
    }

    /**
     * Simple setter
     *
     * @param card3
     */
    public void setCard3(Card card3) {
        if (this.card3 != null) {
            throw new TrickSetCardException("The third card is already set and can not be set again in the trick.");
        }

        this.card3 = card3;
    }

    /**
     * Simple getter
     *
     * @return
     */
    public Card getCard4() {
        return card4;
    }

    /**
     * Simple setter
     *
     * @param card4
     */
    public void setCard4(Card card4) {
        if (this.card4 != null) {
            throw new TrickSetCardException("The fourth card is already set and can not be set again in the trick.");
        }

        this.card4 = card4;
    }

  public Suits getTrumpSuit() {
    return trumpSuit;
  }
    
    
}
