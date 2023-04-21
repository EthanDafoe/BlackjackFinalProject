package blackjack;
import java.util.ArrayList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getTotalValue() {
        int totalValue = 0;
        int numAces = 0;

        for (Card card : cards) {
            if (card.getValue() == 1) {
                numAces++;
            }
            totalValue += card.getValue();
        }

        while (numAces > 0 && totalValue <= 11) {
            totalValue += 10;
            numAces--;
        }

        return totalValue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString());
            sb.append(", ");
        }
        if (!cards.isEmpty()) {
            sb.delete(sb.length() - 2, sb.length());
        }
        return sb.toString();
    }

    public boolean isBusted() {
        return getTotalValue() > 21;
    }

    public boolean isBlackjack() {
        return getTotalValue() == 21 && cards.size() == 2;
    }
    public List getCards(){
        return cards;
    }
}

