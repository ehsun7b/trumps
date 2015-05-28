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
import com.ehsunbehravesh.trumps.cards.Trick;
import com.ehsunbehravesh.trumps.exceptions.DeckIsEmptyException;
import java.util.Random;
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
public class TrickTest {

  public TrickTest() {
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
  public void test1() {
    Trick trick = new Trick(Suits.HEART);

    trick.setCard1(new Card(Suits.CLUB, Numbers.TWO));
    trick.setCard2(new Card(Suits.CLUB, Numbers.THREE));
    trick.setCard3(new Card(Suits.CLUB, Numbers.TEN));
    trick.setCard4(new Card(Suits.CLUB, Numbers.FOUR));

    Card winner = trick.winner();
    System.out.print("Winner: ");
    System.out.println(winner);

    assertTrue(winner.getNumber() == Numbers.TEN);
  }

  @Test
  public void test2() {
    Trick trick = new Trick(Suits.HEART);

    trick.setCard1(new Card(Suits.CLUB, Numbers.TWO));
    trick.setCard2(new Card(Suits.HEART, Numbers.THREE));
    trick.setCard3(new Card(Suits.CLUB, Numbers.TEN));
    trick.setCard4(new Card(Suits.CLUB, Numbers.FOUR));

    Card winner = trick.winner();
    System.out.print("Winner: ");
    System.out.println(winner);

    assertTrue(winner.getNumber() == Numbers.THREE);
  }

  @Test
  public void test3() {
    Trick trick = new Trick(Suits.HEART);

    trick.setCard1(new Card(Suits.HEART, Numbers.JACK));
    trick.setCard2(new Card(Suits.HEART, Numbers.THREE));
    trick.setCard3(new Card(Suits.CLUB, Numbers.TEN));
    trick.setCard4(new Card(Suits.CLUB, Numbers.FOUR));

    Card winner = trick.winner();
    System.out.print("Winner: ");
    System.out.println(winner);

    assertTrue(winner.getNumber() == Numbers.JACK);
  }

  @Test
  public void test4() {
    Trick trick = new Trick(Suits.HEART);

    trick.setCard1(new Card(Suits.SPADE, Numbers.THREE));
    trick.setCard2(new Card(Suits.DIAMOND, Numbers.QUEEN));
    trick.setCard3(new Card(Suits.CLUB, Numbers.THREE));
    trick.setCard4(new Card(Suits.CLUB, Numbers.KING));

    Card winner = trick.winner();
    System.out.print("Winner: ");
    System.out.println(winner);

    assertTrue(winner.getNumber() == Numbers.THREE && winner.getSuit() == Suits.SPADE);
  }

  @Test
  public void test5() throws DeckIsEmptyException {
    Deck deck = new Deck(true);

    System.out.println("");
    System.out.println("");
    
    for (int i = 0; i < 13; i++) {
      Trick t = new Trick(randomSuit());

      System.out.println("Trump: " + t.getTrumpSuit());
      
      Card c = deck.get(true);
      System.out.println("card1: " + c);
      t.setCard1(c);
      
      c = deck.get(true);
      System.out.println("card2: " + c);
      t.setCard2(c);
      
      c = deck.get(true);
      System.out.println("card3: " + c);
      t.setCard3(c);
      
      c = deck.get(true);
      System.out.println("card4: " + c);
      t.setCard4(c);
      
      System.out.println("Winner: " + t.winner());
      
      System.out.println("------------------");
    }
  }

  private Suits randomSuit() {
    Random r = new Random();
    
    int v = r.nextInt(4);
    //System.out.println(v);

    switch (v) {
      case 0:
        return Suits.CLUB;
      case 1:
        return Suits.SPADE;
      case 2:
        return Suits.HEART;
      case 3:
        return Suits.DIAMOND;
    }
    
    return Suits.SPADE;
  }

}
