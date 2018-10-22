import de.htwg.se.anoDomini.model.Card

1+2
1<2

val card1 = new Card(1)
card1.year
val card2 = new Card(2)
val card3 = new Card(3)

def checkYear(a:Card, b:Card) = a.year <= b.year

checkYear(card1, card1)
checkYear(card1, card2)
checkYear(card2, card1)

val table = List[Card](card1, card2, card3)



