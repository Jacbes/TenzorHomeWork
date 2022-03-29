fun main(args: Array<String>) {
    val card = CardOnKotlin(0, "Clubs")
    val card1 = CardOnKotlin(2, "foo")
    val card2 = CardOnKotlin(2, "Clubs")

    println("Card: $card")
    println("Card1: $card1")
    println("Card2: $card2")

    println("Card in standard deck? ${card.checkCardBelongsOfStandardDeck()}")
    println("Card1 in standard deck? ${card1.checkCardBelongsOfStandardDeck()}")
    println("Card2 in standard deck? ${card2.checkCardBelongsOfStandardDeck()}")

    val card3 = CardOnKotlin(2, "Clubs")
    println("Card3: $card3")
    println("Card3 stronger than Card2? ${card3.checkStrongerThan(card2)}")

    println("Card compare Card1 ${card.compareTo(card1)}")
    println("Card2 compare Card3 ${card.compareCards(card2, card3)}")
}
