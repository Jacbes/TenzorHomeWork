public class CardTypeBEnum {

    private enum Suit {
        Clubs,
        Diamonds,
        Spades,
        Hearts
    }

    private enum Rank {
        Two(2),
        Three(3),
        Four(4),
        Five(5),
        Six(6),
        Seven(7),
        Eight(8),
        Nine(9),
        Ten(10),
        Jack(11),
        Queen(12),
        King(13),
        Ace(14),
        Joker(15);

        private final int rankValue;

        Rank(int rv) {
            rankValue = rv;
        }

        public int getRankValue() {
            return rankValue;
        }
    }

    private final Rank rank;
    private final Suit suit;

    public CardTypeBEnum(int inRank, String inSuit) {
        this.suit = checkSuit(inSuit);
        this.rank = checkRank(inRank);
    }

    private Rank checkRank(int inRank) {
        if (inRank < 2 || inRank > 15) {
            return null;
        }

        return Rank.values()[inRank - 2];
    }

    private Suit checkSuit(String inSuit) {
        Suit checkedSuit = null;
        try {
            checkedSuit = Suit.valueOf(inSuit);
        } catch (IllegalArgumentException e) {
            System.out.println("Suit \"" + inSuit + "\" not allowed");
        }

        return checkedSuit;
    }

    public Rank getCardRank() {
        return rank;
    }

    public Suit getCardSuit() {
        return suit;
    }

    public String toString() {
        return "Rank = " + rank + ", "
                + "Suit = " + suit;
    }

    public boolean equals(CardTypeBEnum inCard) {
        if (this == inCard) {
            return true;
        }

        return this.rank == inCard.rank
                && this.suit == inCard.suit;
    }

    public int hashCode() {
        if (this.rank == null || this.suit == null) {
            return 0;
        }

        return 17 * rank.getRankValue() + suit.ordinal();
    }

    public boolean checkCardBelongsOfStandardDeck() {
        if (this.suit == null || this.rank == null) {
            return false;
        }

        return this.rank.getRankValue() > 1;
    }

    public boolean checkStrongerThan(CardTypeBEnum inCard) {
        if (this.suit == inCard.suit) {
            return ((this.rank != null) ? this.rank.getRankValue() : -1)
                    > ((inCard.rank != null) ? inCard.rank.getRankValue() : -1);
        }

        return false;
    }

    public int compareCards(CardTypeBEnum inCard) {
        if (this.equals(inCard)) {
            return 0;
        }

        if (checkStrongerThan(inCard)) {
            return 1;
        } else {
            if (this.suit == inCard.suit) {
                return ((this.rank != null) ? this.rank.getRankValue() : -1)
                        - ((inCard.rank != null) ? inCard.rank.getRankValue() : -1);
            } else {
                return ((this.suit != null) ? this.suit.ordinal() : -1)
                        - ((inCard.suit != null) ? inCard.suit.ordinal() : -1);
            }
        }
    }

    public static int compareCards(CardTypeBEnum cardOne, CardTypeBEnum cardTwo) {
        return cardOne.compareCards(cardTwo);
    }

    public int compareTo(CardTypeBEnum inCard) {
        return compareCards(inCard);
    }

}
