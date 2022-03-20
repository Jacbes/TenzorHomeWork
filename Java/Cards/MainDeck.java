
public class MainDeck {

    public static void main(String[] args) {
        Deck deck = Deck.createDeckWithJokers();

        CardTypeB cardPop = deck.popCard();
        System.out.println("Pop: " + cardPop.toString());
        CardTypeB cardPop2 = deck.popCard();
        System.out.println("Pop: " + cardPop2.toString());
        CardTypeB cardPop3 = deck.popCard();
        System.out.println("Pop: " + cardPop3.toString());

        deck.returnCard(cardPop);
        System.out.println("Return card: " + cardPop);
        deck.returnCard(cardPop2);
        System.out.println("Return card: " + cardPop2);
        deck.returnCard(cardPop2);
        System.out.println("Return card: " + cardPop2);
        System.out.println(deck.toString());

        System.out.println("Shuffle deck");
        deck.shuffleDeck();
        System.out.println(deck.toString());
        System.out.println("Sort deck");
        deck.sortDeck();
        System.out.println(deck.toString());

        System.out.println("Pop while is empty");
        while (!deck.isEmpty()) {
            deck.popCard();
        }
        System.out.println(deck.toString());
    }

}
