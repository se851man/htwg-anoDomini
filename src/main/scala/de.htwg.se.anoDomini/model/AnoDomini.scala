package de.htwg.se.anoDomini.model

import de.htwg.se.anoDomini.model.Card

import scala.collection.immutable.Stack
import java.util.Scanner;

object AnoDomini {
  def main(args: Array[String]): Unit = {
    println("Willkommen zu ANO DOMINI!")

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

    case class Table(table:List[Card]) {
      def getCard(position: Int, card: Card): Table = Table(table.take(position) ++ List(card) ++ table.drop(position))

      val sliding = table.sliding(2)

      /* def map(f:Card => Card) = sliding.map(card => f(card))//def check(f:Card => Card) = table.sliding(2).next.check(card => f(card))  //for(List(cardA,cardB) <- table.sliding(2) => cardA.year < cardB.year)
       */
      def check(): Boolean = {
        var boolList = List[Boolean]()
        for (List(cardA, cardB) <- table.sliding(2)) {
          boolList = boolList ++ List(cardA.year < cardB.year)
        }
        if (boolList.contains(false)) false else true
      }
    }

    var table1 = new Table(List(card4, card7))
    var int = 0
    table1.table.foreach{c:Card => print("Pos:" + int + " " + c.year + " "); int = int + 1}
    val newCard = card5;
    println("Your Card: " + newCard)
    println("Insert at? ")
    val s = new Scanner(System.in)
    val a = s.nextInt()
    table1 = table1.getCard(a, newCard)
    table1.table.foreach{c:Card => println("Pos:" + int + " " + c.year + " "); int = int + 1}
    var boolList = List[Boolean]()
    if(table1.check() == true) print("Gewonnen! ") else print("Verloren. ")

  }
}

case class Card(year:Int)