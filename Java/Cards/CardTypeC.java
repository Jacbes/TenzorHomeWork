import java.util.Arrays;

public class CardTypeC {

    private static final String[] ALLOWED_SUITS = new String[]{"Diamonds", "Clubs", "Hearts", "Spades", "Joker"};
    private static final int[] suitRanks = new int[]{2, 2, 2, 2, 1};
    private static final int maxRankOfStandartSuit = 15;
    private static final int minRankOfStandartSuit = 2;
    private static final int maxRankOfJoker = 3;
    private static final int minRankOfJoker = 1;

    private int rank;
    private String suit;

    public CardTypeC(int inRank, String inSuit) {
        this.suit = (checkInSuit(inSuit)) ? inSuit : null;
        this.rank = (checkInRank(inRank, this.suit)) ? inRank : 0;
    }

    public CardTypeC(String inSuit) {
        this.suit = (checkInSuit(inSuit)) ? inSuit : null;
        this.rank = incrementRankBySuit(this.suit);
    }

    private boolean checkInSuit(String inSuit) {
        String checkedSuit = Arrays.stream(ALLOWED_SUITS)
                .filter(allowedSuit -> allowedSuit.equals(inSuit))
                .findFirst()
                .orElse(null);
        if (checkedSuit == null) {
            System.out.println("Suit \"" + inSuit + "\" not allowed");
            return false;
        } else {
            return true;
        }
    }

    private boolean checkInRank(int inRank, String inSuit) {
        if (inSuit == null) {
            return false;
        }

        if (inSuit.equals("Joker")) {
            return minRankOfJoker <= inRank
                    && maxRankOfJoker > inRank;
        } else {
            return minRankOfStandartSuit <= inRank
                    && maxRankOfStandartSuit > inRank;
        }
    }

    private int incrementRankBySuit(String inSuit) {
        if (inSuit == null) {
            return 0;
        }

        int indexOfInSuit = Arrays.asList(ALLOWED_SUITS).indexOf(inSuit);
        if (ALLOWED_SUITS[indexOfInSuit].equals("Joker")) {
            return (suitRanks[indexOfInSuit] < maxRankOfJoker) ? suitRanks[indexOfInSuit]++ : 0;
        } else {
            return (suitRanks[indexOfInSuit] < maxRankOfStandartSuit) ? suitRanks[indexOfInSuit]++ : 0;
        }
    }

    public int getCardRank() {
        return rank;
    }

    public String getCardSuit() {
        return suit;
    }

}
