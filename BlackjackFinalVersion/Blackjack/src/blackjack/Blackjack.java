/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

import java.util.Scanner;

public class Blackjack {
    private static final int INITIAL_CHIPS = 100;
    private static final int MIN_BET = 10;

    public static void main(String[] args) {
        Deck deck = new Deck();
        Dealer dealer = new Dealer("Dealer", deck);
        Player player = new Player("Player");

        Scanner scanner = new Scanner(System.in);

        int playerChips = INITIAL_CHIPS;

        while (true) {
            System.out.println("You have " + playerChips + " chips.");

            // Reset the player's hand and the deck
            player.clearHand();
            dealer.clearHand();
            deck = new Deck();
            deck.shuffle();
            dealer.shuffleDeck();

            // Place the bet
            int bet = getBet(scanner, playerChips);
            playerChips -= bet;

            // Deal the cards
            dealer.dealCards(player);
            dealer.dealCards(dealer);

            // Print the initial hands
            System.out.println("Dealer's Hand: " + dealer.getHand());
            System.out.println("Dealer's Hand score: " + dealer.getTotalHandValue());
            System.out.println("Player's Hand: " + player.getHand());
            System.out.println("Player's Hand score: " + player.getTotalHandValue());
            // Player's turn
            playerTurn(scanner, player, dealer, deck);

            // Dealer's turn
            dealerTurn(dealer, deck);

            // Determine the winner
            int playerTotal = player.getTotalHandValue();
            int dealerTotal = dealer.getTotalHandValue();

            if (player.isBusted()) {
                System.out.println("You busted! Dealer wins.");
            } else if (dealer.isBusted()) {
                System.out.println("Dealer busted! You win.");
                playerChips += 2 * bet;
            } else if (playerTotal > dealerTotal) {
                System.out.println("You win!");
                playerChips += 2 * bet;
            } else if (playerTotal == dealerTotal) {
                System.out.println("Push.");
                playerChips += bet;
            } else {
                System.out.println("Dealer wins!");
            }

            // Ask the player if they want to play again
            if (playerChips < MIN_BET) {
                System.out.println("You don't have enough chips to play again.");
                break;
            }
            System.out.println("Do you want to play again? (y/n)");
            String input = scanner.next();
            if (input.equalsIgnoreCase("n")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static int getBet(Scanner scanner, int playerChips) {
        while (true) {
            System.out.println("Enter your bet (minimum bet is " + MIN_BET + "):");
            int bet = scanner.nextInt();
            if (bet < MIN_BET) {
                System.out.println("Your bet is too low.");
            } else if (bet > playerChips) {
                System.out.println("You don't have enough chips to make that bet.");
            } else {
                return bet;
            }
        }
    }

    public static void playerTurn(Scanner scanner, Player player, Dealer dealer, Deck deck) {
        while (true) {
            System.out.println("Do you want to hit or stand?");
            String input = scanner.next();
            if (input.equalsIgnoreCase("hit")) {
                player.addCardToHand(deck.drawCard());
                System.out.println("Player's Hand: " + player.getHand());
                System.out.println("Player's Hand score: " + player.getTotalHandValue());
                if (player.isBusted()) {
                    System.out.println("You busted!");
                    break;
                }
            } else {
                break;
            }
        }
    }

    private static void dealerTurn(Dealer dealer, Deck deck) {
        while (dealer.getTotalHandValue() < 17) {
            dealer.addCardToHand(deck.drawCard());
        }
        System.out.println("Dealer's Hand: " + dealer.getHand());
        System.out.println("Dealer's Hand score: " + dealer.getTotalHandValue());
    }
}
