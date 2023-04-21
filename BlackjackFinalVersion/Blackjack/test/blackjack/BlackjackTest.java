package blackjack;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author Ethan
 */
public class BlackjackTest {
    
    public BlackjackTest() {
    }
    
    public static void setUpClass() {
    }
    
    public static void tearDownClass() {
    }

    public void setUp() {
    }
    
    public void tearDown() {
    }

    /**
     * Good test of getBet method, of class Blackjack.
     */
    @Test
    public void testGetBetGood() {
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        
        int playerChips = 50;
        int bet = Blackjack.getBet(scanner, playerChips);
        
        assertEquals(10, bet); // minimum bet is 10
    }
    /**
     * Bad test of getBet method, of class Blackjack.
     */
    @Test(expected = NoSuchElementException.class)
    public void testGetBetBad() {
        String input = "5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        
        int playerChips = 50;
        int bet = Blackjack.getBet(scanner, playerChips);
        
        assertEquals(10, bet); // minimum bet is 10

    }
    /**
     * Boundary test of getBet method, of class Blackjack.
     */
    @Test(expected = NoSuchElementException.class)
    public void testGetBetBoundary() {
        String input = "";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        
        int playerChips = 50;
        int bet = Blackjack.getBet(scanner, playerChips);
        
        assertEquals(10, bet); // minimum bet is 10

    }
    
    @Test
    public void testPlayerTurnGood() {
        Scanner scanner = new Scanner("stand");
        Player player = new Player("Ethan");
        Deck deck = new Deck();
        deck.shuffle();
        Dealer dealer = new Dealer("Ethan", deck);
        Hand hand = new Hand();
        player.addCardToHand(new Card(Rank.ACE, Suit.SPADES));
        player.addCardToHand(new Card(Rank.KING, Suit.HEARTS));
        Blackjack.playerTurn(scanner, player, dealer, deck);
        assertEquals(2, player.handSize());
        assertTrue(player.getTotalHandValue() <= 21);
    }
    @Test
    public void testPlayerTurnBad() {
        Scanner scanner = new Scanner("stick\nhit\nstand\n");
        Player player = new Player("Ethan");
        Deck deck = new Deck();
        deck.shuffle();
        Dealer dealer = new Dealer("Ethan", deck);
        player.addCardToHand(new Card(Rank.JACK, Suit.CLUBS));
        player.addCardToHand(new Card(Rank.QUEEN, Suit.SPADES));
        Blackjack.playerTurn(scanner, player, dealer, deck);
        assertEquals(2, player.handSize());
        assertTrue(player.getTotalHandValue() >= 20);
    }
    @Test(expected = NoSuchElementException.class)
    public void testPlayerTurnBoundary() {
        Scanner scanner = new Scanner("");
        Player player = new Player("Ethan");
        Deck deck = new Deck();
        deck.shuffle();
        Dealer dealer = new Dealer("Ethan", deck);
        player.addCardToHand(new Card(Rank.JACK, Suit.CLUBS));
        player.addCardToHand(new Card(Rank.QUEEN, Suit.SPADES));
        Blackjack.playerTurn(scanner, player, dealer, deck);
        assertEquals(2, player.handSize());
        assertTrue(player.getTotalHandValue() >= 20);
    }
}

