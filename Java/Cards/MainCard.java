
public class MainCard {

    public static void main(String[] args) {
        CardTypeC cardTypeC_new = new CardTypeC(3, "Diamonds");
        System.out.println(cardTypeC_new.getCardRank() + " " + cardTypeC_new.getCardSuit());

        CardTypeC cardTypeC = new CardTypeC("Diamonds");
        CardTypeC cardTypeC1 = new CardTypeC("Clubs");
        CardTypeC cardTypeC2 = new CardTypeC("Diamonds");
        CardTypeC cardTypeC3 = new CardTypeC("Joker");
        CardTypeC cardTypeC4 = new CardTypeC("Joker");
        CardTypeC cardTypeC5 = new CardTypeC("Joker");
        CardTypeC cardTypeC6 = new CardTypeC(10, "Diamonds");
        CardTypeC cardTypeC7 = new CardTypeC(10, "foo");
        CardTypeC cardTypeC8 = new CardTypeC(16, "Diamonds");

        System.out.println(cardTypeC.getCardRank() + " " + cardTypeC.getCardSuit());
        System.out.println(cardTypeC1.getCardRank() + " " + cardTypeC1.getCardSuit());
        System.out.println(cardTypeC2.getCardRank() + " " + cardTypeC2.getCardSuit());
        System.out.println(cardTypeC3.getCardRank() + " " + cardTypeC3.getCardSuit());
        System.out.println(cardTypeC4.getCardRank() + " " + cardTypeC4.getCardSuit());
        System.out.println(cardTypeC5.getCardRank() + " " + cardTypeC5.getCardSuit());
        System.out.println(cardTypeC6.getCardRank() + " " + cardTypeC6.getCardSuit());
        System.out.println(cardTypeC7.getCardRank() + " " + cardTypeC7.getCardSuit());
        System.out.println(cardTypeC8.getCardRank() + " " + cardTypeC8.getCardSuit());

        CardTypeB cardTypeB = new CardTypeB(14, "Diamonds");
        CardTypeB cardTypeB1 = new CardTypeB(10, "Spades");
        CardTypeB cardTypeB2 = new CardTypeB(10, "Diamonds");
        System.out.println(cardTypeB.toString());
        System.out.println(cardTypeB.checkStrongerThan(cardTypeB1));
        System.out.println(cardTypeB.checkCardBelongsOfStandartDeck());
        System.out.println(cardTypeB1.equals(cardTypeB2));

        System.out.println(cardTypeB.compareCards(cardTypeB1));
        System.out.println(cardTypeB.compareCards(cardTypeB));
        System.out.println(cardTypeB.compareCards(cardTypeB2));

        System.out.println(CardTypeB.compareCards(cardTypeB, cardTypeB2));
    }

}
