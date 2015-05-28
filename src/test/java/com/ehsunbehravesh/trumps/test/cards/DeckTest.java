/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ehsunbehravesh.trumps.test.cards;

import com.ehsunbehravesh.cardgames.cards.Numbers;
import com.ehsunbehravesh.cardgames.cards.Suits;
import com.ehsunbehravesh.trumps.cards.Card;
import com.ehsunbehravesh.trumps.cards.Deck;
import com.ehsunbehravesh.trumps.exceptions.DeckIsEmptyException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DeckTest {

  private Deck deck;

  public DeckTest() {
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
  public void testCreation() {
    deck = new Deck(false);
    
    /*
    Iterator<Card> iterator = deck.getCards().iterator();
    
    while (iterator.hasNext()) {
      Card c = iterator.next();
      System.out.println(c);
      System.out.println("------");
    }
            */
    
    assertEquals("Size of deck is wrong!", Deck.STANDARD_SIZE, deck.count());
    try {
      Card card = deck.get(true);
      System.out.println(card);
      assertTrue(card.getSuit() == Suits.CLUB && card.getNumber() == Numbers.TWO);
      card = deck.get(true);
      System.out.println(card);
      assertTrue(card.getSuit() == Suits.CLUB && card.getNumber() == Numbers.THREE);
      
      assertEquals("Size of deck is wrong!", Deck.STANDARD_SIZE - 2, deck.count());
    } catch (DeckIsEmptyException ex) {
      fail("Deck is empty!!!");
    }
  }
}
