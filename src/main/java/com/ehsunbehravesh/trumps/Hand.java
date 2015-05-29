package com.ehsunbehravesh.trumps;

import com.ehsunbehravesh.cardgames.cards.Suits;
import com.ehsunbehravesh.trumps.cards.Card;
import com.ehsunbehravesh.trumps.cards.Deck;
import com.ehsunbehravesh.trumps.cards.Trick;
import com.ehsunbehravesh.trumps.exceptions.CardHasNoOwnerException;
import com.ehsunbehravesh.trumps.exceptions.DeckIsEmptyException;
import com.ehsunbehravesh.trumps.exceptions.DirectionException;
import com.ehsunbehravesh.trumps.exceptions.PlayerDoesNotOwnCardException;
import com.ehsunbehravesh.trumps.exceptions.TrickIsFullException;
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

  /**
   * The suit which is trump suit by trump caller
   */
  protected Suits trumpSuit;

  /**
   * The direction the players turn: clockwise or counter clockwise
   */
  protected Direction direction;

  /**
   * The player who is trump caller and will decide which suit is the trump suit
   * of the hand
   */
  protected Players trumpCaller;

  /**
   * The cards which is in hands of the players (52 / 4 = 13)
   */
  protected Map<Players, List<Card>> hands;

  /**
   * The current player which is going to play or which is going to receive the
   * next deal from the dealer
   */
  protected Players currentPlayer;

  /**
   * Deck of cards
   */
  protected Deck deck;
  
  /**
   * All complete tricks
   */
  protected List<Trick> tricks;
  
  /**
   * Current playing trick
   */
  protected Trick currentTrick;
  
  /**
   * Constructor which takes the trump caller player and the game direction
   *
   * @param trumpCaller
   * @param direction
   */
  public Hand(Players trumpCaller, Direction direction) {
    this.trumpCaller = trumpCaller;
    this.direction = direction;
    this.dealingTime = 0;
    this.currentPlayer = trumpCaller;
    this.deck = new Deck(true);
    this.hands = new HashMap<>();
    this.tricks = new ArrayList<>();
  }

  /**
   * Calling this method make the dealer gives the next dealing shot to the
   * current player. The current player will get updated based on the game
   * direction. (clockwise/counter clockwise)
   *
   * @return the current deal (list of cards) which has been added to the
   * current player hand
   * @throws DeckIsEmptyException
   */
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

  public boolean play(Card card) throws PlayerDoesNotOwnCardException, TrickIsFullException, CardHasNoOwnerException {    
    boolean result = false;
    List<Card> currentPlayerHand = hands.get(currentPlayer);
    
    if (!currentPlayerHand.contains(card)) {
      throw new PlayerDoesNotOwnCardException("The player ".concat(String.valueOf(currentPlayer)).concat(" does not own the card ").concat(String.valueOf(card)));
    }
    
    if (currentTrick == null) {
      currentTrick = new Trick(trumpSuit);
    }
    
    currentTrick.addCard(card);
    
    if (currentTrick.isFull()) {
      Card winner = currentTrick.winner();
      
      if (winner != card) {
        currentPlayer = ownerOf(card);        
      }
      
      result = true;
    } else {
      currentPlayer = nextPlayer(currentPlayer);
    }
    
    return result;
  }

  /**
   * Will determine next player based on the passing player and the hand
   * direction
   *
   * @param player
   * @return player
   */
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

  /**
   * Simple getter
   *
   * @return trumpSuit
   */
  public Suits getTrumpSuit() {
    return trumpSuit;
  }

  /**
   * Simple getter
   *
   * @return direction
   */
  public Direction getDirection() {
    return direction;
  }

  /**
   * Simple getter
   *
   * @return trumpCaller
   */
  public Players getTrumpCaller() {
    return trumpCaller;
  }

  /**
   * Simple getter
   *
   * @return currentPlayer
   */
  public Players getCurrentPlayer() {
    return currentPlayer;
  }

  /**
   * Simple setter
   *
   * @param trumpSuit
   */
  public void setTrumpSuit(Suits trumpSuit) {
    this.trumpSuit = trumpSuit;
  }

  /**
   * To get the specified player hand
   *
   * @param player
   * @return player hand
   */
  public List<Card> getPlayerHand(Players player) {
    return hands.get(player);
  }

  private Players ownerOf(Card card) throws CardHasNoOwnerException {
    Players player = Players.EAST;
    List<Card> hand = hands.get(player);
    if (hand.contains(card)) {
      return player;
    }
    
    player = Players.NORTH;
    hand = hands.get(player);
    if (hand.contains(card)) {
      return player;
    }
    
    player = Players.SOUTH;
    hand = hands.get(player);
    if (hand.contains(card)) {
      return player;
    }
    
    player = Players.WEST;
    hand = hands.get(player);
    if (hand.contains(card)) {
      return player;
    }
    
    throw new CardHasNoOwnerException("Can not find the owner of the card ".concat(String.valueOf(card)));
  }
}
