import de.htwg.se.anoDomini.model.Card

import scala.collection.immutable.Stack
import scala.collection.mutable.ListBuffer
//import de.htwg.se.anoDomini.model.{Player, _}

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

val fullDeck = Array(card1, card2, card3, card4, card5, card6, card7, card8, card9) //als instanz
var maindeck = ListBuffer[Card]()
for(i <- 0 to 8) maindeck = maindeck ++ List(fullDeck(i))

def draw:Card = {
  var r = new scala.util.Random
  val card = maindeck(r.nextInt(maindeck.size - 1))
  maindeck -= card
  card
}

var player = ListBuffer[Card] ()

for(i <- 0 until 3){
  player = player ++ List(draw)
}
player.length

player -= player(0)

player.length