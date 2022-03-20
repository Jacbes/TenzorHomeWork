import java.util.Arrays;

public class CardTypeB {

	private static final String[] ALLOWED_SUITS = new String[]{"Diamonds", "Clubs", "Hearts", "Spades"};

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

}
