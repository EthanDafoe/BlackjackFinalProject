package blackjack;
public class Dealer extends Player {
    private Deck deck;

    public Dealer(String name, Deck deck) {
        super(name);
        this.deck = deck;
    }

    public void shuffleDeck() {
        deck.shuffle();
    }

    public void dealCards(Player player) {
        player.addCardToHand(deck.drawCard());
        player.addCardToHand(deck.drawCard());
    }

    public void dealAdditionalCards(Player player) {
        while (player.getTotalHandValue() < 17) {
            player.addCardToHand(deck.drawCard());
        }
    }
}

   
