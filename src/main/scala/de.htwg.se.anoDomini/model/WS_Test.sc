//import de.htwg.se.anoDomini.model._
import scala.Predef.StringFormat
import scala.collection.immutable.Stack
import java.util.Scanner;
/*
    Frage an Marco:
    - Wenn wir bei card4 den Wert Year von
    100 auf 4 wechseln meldet das System einen NosuchFile Fehler

 */
case class Card(year:Int)
val card1 = new Card(1)
val card2 = new Card(2)
val card3 = new Card(3)
val card4 = Card(4)
val card5 = Card(5)
val card6 = Card(6)
val card7 = Card(7)
val card8 = Card(8)
val card9 = Card(9)


val fullDeck = Stack(card1, card2, card3, card4, card5, card6, card7, card8, card9) //als instanz



/*case class Deck(deck:Set[Card]){
  def pull: (Card, Deck) =  (deck.head, Deck(deck.tail))
  def push(card: Card):Deck = Deck(deck + card)
}*/
case class Table(table:List[Card]) {
  def getCard(position:Int, card:Card) :Table = Table(table.take(position) ++ List(card) ++ table.drop(position))
  val sliding = table.sliding(2)
 /* def map(f:Card => Card) = sliding.map(card => f(card))//def check(f:Card => Card) = table.sliding(2).next.check(card => f(card))  //for(List(cardA,cardB) <- table.sliding(2) => cardA.year < cardB.year)
  */
 def check() :Boolean = {
   var boolList = List[Boolean]()
   for (List(cardA,cardB) <- table.sliding(2)) {boolList = boolList ++ List(cardA.year < cardB.year)}
   if(boolList.contains(false)) false else true
 }
}
/*
    aus unserer Liste an Karten koennten wir eine Liste an boolwerten erstellen und dann mit contains(false) ueberpruefen
    das geht nicht mit map! (vielleicht mit tricksen)
 */
println("Wilkommen zu AnoDomini!")
var table1 = new Table(List(card4, card7))
var int = 0
table1.table.foreach{c:Card => print("Pos:" + int + " " + c.year + " "); int = int + 1}
val newCard = card5;
println("Your Card: " + newCard)
println("Insert at? ")
val s = new Scanner(System.in)
s.nextInt()
val a = 1
table1 = table1.getCard(a, newCard)
table1.table.foreach{c:Card => print("Pos:" + int + " " + c.year + " "); int = int + 1}
var boolList = List[Boolean]()
if(table1.check() == true) print("Gewonnen! ") else print("Verloren. ")
//table1.table.foreach(c => check(c, tr.head))
//tr = tr -- tr.head
//table1.sliding.next.head.year < table1.sliding.next.head.year

/*case class Player(hand:Set[Card]) {

  def draw(number:Int, pullDeck:Deck): (Player, Deck) = (Player(hand + pullDeck.pull._1), pullDeck.pull._2);
    /*for (i <- 0 until number) {
      tmphand ++ Set(pullDeck.pull) */
  def discard(position:Int, card: Card, table:Table) : Unit = {
    table.getCard(position, card)
    this.hand - card
  }

   def cardCheck(pushDeck:Deck, table:Table): Unit = {
      for(List(left,right) <- table.sliding(2) if (left.year > right.year)){
        table.removeCards(pushDeck)
        draw(3, pushDeck)
        table.setTable(pushDeck)
       pushDeck.pull
     }
  }
}*/

//Game starts, Table is set
/*System.out.print("Willkommen zu AnoDomini\n")
var (card, deck) = Deck(fullDeck).pull
var table = Table(List(card))
table
deck

//Player draws his Hand
val (player1, newdeck) = Player(Set()).draw(1,deck)
//player1.draw(3, deck)
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