import java.util.Arrays;

public class CardTypeB implements Comparable<CardTypeB> {

	private static final String[] ALLOWED_SUITS = new String[]{"Clubs", "Diamonds", "Spades", "Hearts", "Joker"};
	private static final String[] SUITS_AFTER_TEN = new String[]{"Jack", "Queen", "King", "Ace"};

	private int rank;
	private String suit;

	public CardTypeB(int rank, String inSuit) {
		this.rank = rank;
		this.suit = checkSuit(inSuit);
	}

	private String checkSuit(String inSuit) {
		String checkedSuit = Arrays.stream(ALLOWED_SUITS)
				.filter(allowedSuit -> allowedSuit.equals(inSuit))
				.findFirst()
				.orElse(null);
		if (checkedSuit == null) {
			System.out.println("Suit \"" + inSuit + "\" not allowed");
		}

		return checkedSuit;
	}

	public int getCardRank() {
		return rank;
	}

	public String getCardSuit() {
		return suit;
	}

	public String toString() {
		return "Rank = " + ((rank <= 10) ? rank : SUITS_AFTER_TEN[rank % 10 - 1]) + ", " +
				"Suit = " + suit;
	}

	public boolean equals(CardTypeB inCard) {
		if (this == inCard) {
			return true;
		}

		return this.rank == inCard.rank
				&& this.suit.equals(inCard.suit);
	}

	public int hashCode() {
		return 17 * rank + suit.hashCode();
	}

	public boolean checkCardBelongsOfStandartDeck() {
		if (this.suit == null) {
			return false;
		}

		if (this.suit.equals("Joker")) {
			return this.rank > 0 && this.rank < 3;
		} else {
			return this.rank > 1 && this.rank < 15;
		}
	}

	public boolean checkStrongerThan(CardTypeB inCard) {
		if (this.suit.equals(inCard.suit)) {
			return this.rank > inCard.rank;
		}

		return false;
	}

	public int compareCards(CardTypeB inCard) {
		int suitToIndexOfThisCard = Arrays.asList(ALLOWED_SUITS).indexOf(this.suit);
		int suitToIndexOfInCard = Arrays.asList(ALLOWED_SUITS).indexOf(inCard.suit);

		if (this.equals(inCard)) {
			return 0;
		}

		if (checkStrongerThan(inCard)) {
			return 1;
		} else {
			if (this.suit.equals(inCard.suit)) {
				return -1;
			} else {
				return (suitToIndexOfThisCard > suitToIndexOfInCard) ? 1 : -1;
			}
		}
	}

	public static int compareCards(CardTypeB cardOne, CardTypeB cardTwo) {
		return cardOne.compareCards(cardTwo);
	}

	public int compareTo(CardTypeB inCardTypeB) {
		return compareCards(inCardTypeB);
	}

}
