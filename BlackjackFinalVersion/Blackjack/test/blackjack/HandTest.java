/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package blackjack;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ethan
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
    public void testIsBustedGood() {
        Hand hand = new Hand();
        hand.addCard(new Card(Rank.JACK, Suit.CLUBS));
        hand.addCard(new Card(Rank.QUEEN, Suit.CLUBS));
        hand.addCard(new Card(Rank.KING, Suit.CLUBS));
        assertTrue(hand.isBusted());
    }
    @Test
    public void testIsBustedBad() {
        Hand hand = new Hand();
        hand.addCard(new Card(Rank.JACK, Suit.CLUBS));
        hand.addCard(new Card(Rank.QUEEN, Suit.CLUBS));
        assertFalse(hand.isBusted());
    }
    @Test
    public void testIsBustedBoundary() {
        Hand hand = new Hand();
        assertFalse(hand.isBusted());
    }
    
}
