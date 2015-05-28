package com.ehsunbehravesh.cardgames.cards;

/**
 *
 * @author Ehsun Behravesh
 */
public enum Suits {

  /**
   * Hearts suit ASCII code 03 HTML entity &hearts;
   */
  HEART,
  /**
   * Diamonds suit ASCII code 04 HTML entity &diams;
   */
  DIAMOND,
  /**
   * Clubs suit ASCII code 05 HTML entity &clubs;
   */
  CLUB,
  /**
   * Spades suit ASCII code 06 HTML entity &spades;
   */
  SPADE;

  public static String characterOf(Suits suit) {
    switch (suit) {
      case SPADE:
        return "♠";
      case CLUB:
        return "♣";
      case HEART:
        return "♥";
      case DIAMOND:
        return "♦";
      default:
        return "";
    }

  }

}
