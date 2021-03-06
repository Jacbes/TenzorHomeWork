import java.util.Arrays;

public class CardTypeC {

    private static final String[] ALLOWED_SUITS = new String[]{"Diamonds", "Clubs", "Hearts", "Spades", "Joker"};
    private static final int[] suitRanks = new int[]{1, 1, 1, 1, 0};
    private static final int maxRankOfStandardSuit = 14;
    private static final int minRankOfStandardSuit = 2;
    private static final int maxRankOfJoker = 2;
    private static final int minRankOfJoker = 1;

    private final int rank;
    private final String suit;

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

        int indexOfInSuit = getIndexOfSuit(inSuit);
        if (inSuit.equals("Joker")) {
            if (minRankOfJoker <= inRank
                    && maxRankOfJoker >= inRank) {
                suitRanks[indexOfInSuit] = inRank;
                return true;
            } else {
                return false;
            }
        } else {
            if (minRankOfStandardSuit <= inRank
                    && maxRankOfStandardSuit >= inRank) {
                suitRanks[indexOfInSuit] = inRank;
                return true;
            } else {
                return false;
            }
        }
    }

    private int incrementRankBySuit(String inSuit) {
        if (inSuit == null) {
            return 0;
        }

        int indexOfInSuit = getIndexOfSuit(inSuit);
        if (ALLOWED_SUITS[indexOfInSuit].equals("Joker")) {
            return (suitRanks[indexOfInSuit] < maxRankOfJoker) ? ++suitRanks[indexOfInSuit] : 0;
        } else {
            return (suitRanks[indexOfInSuit] < maxRankOfStandardSuit) ? ++suitRanks[indexOfInSuit] : 0;
        }
    }

    private int getIndexOfSuit(String inSuit) {
        return Arrays.asList(ALLOWED_SUITS).indexOf(inSuit);
    }

    public int getCardRank() {
        return rank;
    }

    public String getCardSuit() {
        return suit;
    }

}
