//import de.htwg.se.anoDomini.model.{Player, _}

/*
    Frage an Marco:
    - Wenn wir bei card4 den Wert Year von
    100 auf 4 wechseln meldet das System einen NosuchFile Fehler

 */

case class Card(year:Int)

val card1 = new Card(1)
card1.year
val card2 = new Card(2)
val card3 = new Card(3)
val card4 = Card(4)
val card5 = Card(5)
val card6 = Card(6)
val card7 = Card(7)
val card8 = Card(8)
val card9 = Card(9)

def checkYear(a:Card, b:Card) = a.year <= b.year

checkYear(card1, card1)
checkYear(card1, card2)
checkYear(card2, card1)

val fullDeck = Set(card1, card2, card3, card4, card5, card6, card7, card8, card9)

case class Table(table:List[Card]) {
  def getCard(position:Int, card:Card) :Table = Table(table.take(position) ++ List(card) ++ table.drop(position))
  val sliding = table.sliding(2)
  def map(f:Card => Card) = sliding.map(card => f(card))//def check(f:Card => Card) = table.sliding(2).next.check(card => f(card))  //for(List(cardA,cardB) <- table.sliding(2) => cardA.year < cardB.year)
}
/*
    aus unserer Liste an Karten koennten wir eine Liste an boolwerten erstellen und dann mit contains(false) ueberpruefen
    das geht nicht mit map! (vielleicht mit tricksen)
 */
var table1 = new Table(List(card4, card3))
table1 = table1.getCard(1, card5)
table1.sliding.next.head.year < table1.sliding.next.head.year

/*case class Deck(deck:Set[Card] = FullDeck.cards){
  def pull: Card =  {
    val card = deck.head
    deck - card
    card
    //remove(card)
    //return card
  }
  def remove(card:Card): Deck = {deck - card}
  def push(table : Table) = deck ++ Set(table)
}*/
/*
    puts two Cards on the table and gives you one free card
    then allows to insert the free card in any Postion
 */
/*case class Player(hand:Set[Card]) {

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
}*/

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