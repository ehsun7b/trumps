/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehsunbehravesh.trumps.test.cards;

import com.ehsunbehravesh.trumps.Direction;
import com.ehsunbehravesh.trumps.Hand;
import com.ehsunbehravesh.trumps.Players;
import com.ehsunbehravesh.trumps.cards.Card;
import com.ehsunbehravesh.trumps.exceptions.DeckIsEmptyException;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ehsun Behravesh <post@ehsunbehravesh.com>
 */
public class HandTest {

  public HandTest() {
  }

  @BeforeClass
  public static void setUpClass() {
  }

  @AfterClass
  public static void tearDownClass() {
  }

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
  }

  @Test
  public void test1() throws DeckIsEmptyException {
    Hand hand1 = new Hand(Players.NORTH, Direction.CLOCKWISE);
    
    assertTrue(hand1.getTrumpCaller() == Players.NORTH);
    
    List<Card> deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.EAST);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.SOUTH);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.WEST);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.NORTH);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.EAST);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.SOUTH);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.WEST);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.NORTH);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.EAST);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.SOUTH);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.WEST);
    System.out.println("");
    printCards(deal);
    
    deal = hand1.deal();
    assertTrue(hand1.getCurrentPlayer() == Players.NORTH);
    System.out.println("");
    printCards(deal);
    
    List<Card> northHand = hand1.getPlayerHand(Players.NORTH);
    List<Card> southHand = hand1.getPlayerHand(Players.SOUTH);
    List<Card> eastHand = hand1.getPlayerHand(Players.EAST);
    List<Card> westHand = hand1.getPlayerHand(Players.WEST);
  }

  
  private static void printCards(List<Card> cards) {
    Iterator<Card> iterator = cards.iterator();
    
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }
  }
}
