import java.util.*;

public class Deck {

    private static final List<CardTypeB> listCardsTypeB = new ArrayList<>();

    private Deck(boolean includeJokers) {
        String[] suits = new String[]{"Clubs", "Diamonds", "Spades", "Hearts"};
        for (String suit : suits) {
            for (int rank = 2; rank < 15; rank++) {
                listCardsTypeB.add(new CardTypeB(rank, suit));
            }
        }

        if (includeJokers) {
            listCardsTypeB.add(new CardTypeB(1, "Joker"));
            listCardsTypeB.add(new CardTypeB(2, "Joker"));
        }
    }

    public static Deck createDeckWithJokers() {
        return new Deck(true);
    }


    public static Deck createDeckWithoutJokers() {
        return new Deck(false);
    }

    public static CardTypeB getRandomCard(Deck inDeck) {
        Collections.shuffle(inDeck.getListCardsTypeB());
        return inDeck.getListCardsTypeB().get(0);
    }

    public void shuffleDeck() {
        Collections.shuffle(listCardsTypeB);
    }

    public void sortDeck() {
        Collections.sort(listCardsTypeB);
    }

    public List<CardTypeB> getListCardsTypeB() {
        return listCardsTypeB;
    }

    public CardTypeB popCard() {
        if (listCardsTypeB.isEmpty()) {
            return null;
        }

        CardTypeB card = listCardsTypeB.get(0);
        listCardsTypeB.remove(0);

        return card;
    }

    public void returnCard(CardTypeB inCard) {
        if (!listCardsTypeB.contains(inCard)) {
            listCardsTypeB.add(inCard);
        }
    }

    public boolean isEmpty() {
        return listCardsTypeB.isEmpty();
    }

    public String toString() {
        String result = "";
        for (CardTypeB card : listCardsTypeB) {
            result = result.concat(card.toString() + "\n");
        }

        return result;
    }

}
