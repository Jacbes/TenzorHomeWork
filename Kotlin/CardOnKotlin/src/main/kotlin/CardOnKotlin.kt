class CardOnKotlin(inRank: Int, inSuit: String) {

    enum class Suit {
        Clubs,
        Diamonds,
        Spades,
        Hearts
    }

    enum class Rank(private val rv: Int) {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(11),
        QUEEN(12),
        KING(13),
        ACE(14),
        JOKER(15);

        fun getRankValue(): Int {
            return rv
        }
    }

    private val rank = checkRank(inRank)
    private val suit = checkSuit(inSuit)

    private fun checkRank(inRank: Int): Rank? {
        return if (inRank < 2 || inRank > 15) {
            null
        } else {
            Rank.values()[inRank - 2]
        }
    }

    private fun checkSuit(inSuit: String): Suit? {
        var checkedSuit: Suit? = null
        try {
            checkedSuit = Suit.valueOf(inSuit)
        } catch (e: IllegalArgumentException) {
            println("Suit $inSuit not allowed")
        }

        return checkedSuit
    }

    override fun toString(): String {
        return "Rank = $rank, Suit = $suit"
    }

    override fun equals(other: Any?): Boolean {
        return if (this === other) {
            true
        } else {
            other as CardOnKotlin

            this.rank == other.rank && this.suit == other.suit
        }
    }

    override fun hashCode(): Int {
        return 17 * (rank?.getRankValue() ?: 0) + (suit?.ordinal ?: 0)
    }

    fun checkCardBelongsOfStandardDeck(): Boolean {
        return if (this.suit == null) {
            false
        } else {
            (this.rank?.getRankValue() ?: 0) > 1
        }
    }

    fun checkStrongerThan(inCard: CardOnKotlin): Boolean {
        return if (this.suit == inCard.suit) {
            (this.rank?.getRankValue() ?: -1) > (inCard.rank?.getRankValue() ?: -1)
        } else {
            false
        }
    }

    private fun compareCards(inCard: CardOnKotlin): Int {
        return if (this == inCard) {
            0
        } else if (checkStrongerThan(inCard)) {
            1
        } else {
            return if (this.suit == inCard.suit) {
                (this.rank?.getRankValue() ?: -1) - (inCard.rank?.getRankValue() ?: -1)
            } else {
                (this.suit?.ordinal ?: -1) - (inCard.suit?.ordinal ?: -1)
            }
        }
    }

    fun compareCards(cardOne: CardOnKotlin, cardTwo: CardOnKotlin): Int {
        return cardOne.compareCards(cardTwo)
    }

    fun compareTo(inCard: CardOnKotlin): Int {
        return compareCards(inCard)
    }

}
