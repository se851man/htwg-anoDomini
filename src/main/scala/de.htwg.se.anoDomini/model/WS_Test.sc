//import de.htwg.se.anoDomini.model.Card

case class Card(year:Int)

val card1 = new Card(1)
card1.year
val card2 = new Card(2)
val card3 = new Card(3)
val card4 = new Card(100)

def checkYear(a:Card, b:Card) = a.year <= b.year

checkYear(card1, card1)
checkYear(card1, card2)
checkYear(card2, card1)

var deck = List[Card](card1, card2, card3)

def add(card:Card): Unit =
{
  deck = deck :+ card
}

add(card4)
deck
def remove(): Unit ={
  val removedCard = deck.head
  deck = deck.filter(_ != removedCard)
  return removedCard
}
remove()
deck