package blackjack;
import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
        this.name = name;
        hand = new Hand();
    }

    public void addCardToHand(Card card) {
        hand.addCard(card);
    }

    public void clearHand() {
        hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public int getTotalHandValue() {
        return hand.getTotalValue();
    }

    public boolean isBusted() {
        return hand.isBusted();
    }

    public boolean isBlackjack() {
        return hand.isBlackjack();
    }

    public String getHand() {
        return hand.toString();
    }
        
    public int handSize(){
        return hand.getCards().size();
    }
}
