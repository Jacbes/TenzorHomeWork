
public class MainCardEnum {

    public static void main(String[] args) {
        CardTypeBEnum card = new CardTypeBEnum(0, "Clubs");
        CardTypeBEnum card1 = new CardTypeBEnum(2, "foo");
        CardTypeBEnum card2 = new CardTypeBEnum(2, "Clubs");

        System.out.println("Card: " + card);
        System.out.println("Card1: " + card1);
        System.out.println("Card2: " + card2);

        System.out.println("Card in standard deck? " + card.checkCardBelongsOfStandardDeck());
        System.out.println("Card1 in standard deck? " + card1.checkCardBelongsOfStandardDeck());
        System.out.println("Card2 in standard deck? " + card2.checkCardBelongsOfStandardDeck());

        CardTypeBEnum card3 = new CardTypeBEnum(2, "Clubs");
        System.out.println("Card3: " + card3);
        System.out.println("Card3 stronger than Card2? " + card3.checkStrongerThan(card2));

        System.out.println("Card compare Card1: " + card.compareTo(card1));
        System.out.println("Card2 compare Card3: " + CardTypeBEnum.compareCards(card2, card3));
    }

}
