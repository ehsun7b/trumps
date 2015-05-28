package com.ehsunbehravesh.trumps;

import com.ehsunbehravesh.cardgames.cards.Suits;
import com.ehsunbehravesh.trumps.cards.Card;
import com.ehsunbehravesh.trumps.cards.Deck;
import com.ehsunbehravesh.trumps.exceptions.DeckIsEmptyException;
import com.ehsunbehravesh.trumps.exceptions.DirectionException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Ehsun Behravesh <post@ehsunbehravesh.com>
 */
public class Hand {
  
  /**
   * The current number that dealer has given cards to the players
   */
  protected int dealingTime;
  
  protected Suits trumpSuit;
  
  protected Direction direction;
  
  protected Players trumpCaller;
  
  protected Map<Players, List<Card>> hands;
  
  protected Players currentPlayer;
  
  protected Deck deck;

  public Hand(Players trumpCaller, Direction direction) {
    this.trumpCaller = trumpCaller;
    this.direction = direction;
    this.dealingTime = 0;
    this.currentPlayer = trumpCaller;
    this.deck = new Deck(true);
    this.hands = new HashMap<>();
  }
  
  public List<Card> deal() throws DeckIsEmptyException {
    List<Card> result = new ArrayList<>();
    int cardsToDeal = 4;
    
    if (dealingTime < 4) {
      cardsToDeal = 5;
      hands.put(currentPlayer, new ArrayList<>());
    }
    
    for (int i = 0; i < cardsToDeal; i++) {
      result.add(deck.get(true));
    }
    
    hands.get(currentPlayer).addAll(result);
    
    currentPlayer = nextPlayer(currentPlayer);
    dealingTime++;
    
    return result;
  }
  
  private Players nextPlayer(Players player) {
    if (direction == Direction.CLOCKWISE) {
      switch (player) {
        case NORTH:
          return Players.EAST;
        case EAST:
          return Players.SOUTH;
        case SOUTH:
          return Players.WEST;
        case WEST:  
          return Players.NORTH;
      }
    } else if (direction == Direction.COUNTER_CLOCKWISE) {
      switch (player) {
        case NORTH:
          return Players.WEST;
        case EAST:
          return Players.NORTH;
        case SOUTH:
          return Players.EAST;
        case WEST:  
          return Players.SOUTH;
      }
    }
    
    throw new DirectionException();
  }

  public Suits getTrumpSuit() {
    return trumpSuit;
  }

  public Direction getDirection() {
    return direction;
  }

  public Players getTrumpCaller() {
    return trumpCaller;
  }

  public Players getCurrentPlayer() {
    return currentPlayer;
  }

  public void setTrumpSuit(Suits trumpSuit) {
    this.trumpSuit = trumpSuit;
  }
  
  public List<Card> getPlayerHand(Players player) {
    return hands.get(player);
  }
}
