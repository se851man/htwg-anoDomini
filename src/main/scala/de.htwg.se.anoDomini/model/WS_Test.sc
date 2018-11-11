import de.htwg.se.anoDomini.model.{Player, _}

/*
    Frage an Marco:
    - Wenn wir bei card4 den Wert Year von
    100 auf 4 wechseln meldet das System einen NosuchFile Fehler

 */

//case class Card(year:Int)

val card1 = new Card(1)
card1.year
val card2 = new Card(2)
val card3 = new Card(3)
val card4 = Card(100)
val card5 = Card(5)
val card6 = Card(6)
val card7 = Card(7)
val card8 = Card(8)
val card9 = Card(9)

def checkYear(a:Card, b:Card) = a.year <= b.year

checkYear(card1, card1)
checkYear(card1, card2)
checkYear(card2, card1)

object FullDeck{
  val cards = Set(card1, card2, card3, card4, card5, card6, card7, card8, card9)
}

case class Deck(deck:Set[Card] = FullDeck.cards){
  def pull: Card =  {
    val card = deck.head
    deck - card
    card
    //remove(card)
    //return card
  }
  def remove(card:Card): Deck = {deck - card}
  def push(table : Table) = deck ++ Set(table)
}

case class Table(table:List[Card]) {
  def setTable(deck:Deck)={
    deck.pull

  }
  def getCard(position:Int, card:Card) = table.take(position) ++ List(card) ++ table.drop(position)
  def sliding(i:Int)= table.sliding(i)
}

case class Player(hand:Set[Card]) {

  def draw(number:Int, pullDeck:Deck): Unit= {
    for (i <- 0 until number) {
      hand ++ Set(pullDeck.pull)
    }
  }
  def discard(position:Int, card: Card, table:Table) : Unit = {
    table.getCard(position, card)
    this.hand - card
  }

   def cardCheck(pushDeck:Deck, table:Table): Unit = {
      for(List(left,right) <- table.sliding(2) if (left.year > right.year)){
        pushDeck.push(table)
        draw(3, pushDeck)
        table.setTable(pushDeck)
       pushDeck.pull
     }
  }
}
var deck = Deck()

var table = Table(List(deck.pull))
deck
deck = deck.remove(deck.pull)

var player1 = Player(Set())
player1.draw(3, deck)
player1

/*
def add(card:Card): Set() =
  {

    deck = deck :+ card
  }
add(card4)
deck
def remove(): Card ={
  val removedCard = deck.head
  deck = deck.filter(_ != removedCard)
  return removedCard
}
remove()
deck*/