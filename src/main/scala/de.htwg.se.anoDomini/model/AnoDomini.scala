package de.htwg.se.anoDomini.model

import scala.util.control.Breaks._
import de.htwg.se.anoDomini.model.Card

import scala.collection.immutable.Stack
import java.util.Scanner

import scala.collection.mutable.ListBuffer;

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
    val fullDeck = Array(card1, card2, card3, card4, card5, card6, card7, card8, card9) //als instanz
    var maindeck = ListBuffer[Card]()
    for(i <- 0 to 8) maindeck = maindeck ++ List(fullDeck(i))

    def draw:Card = {
      var r = new scala.util.Random
      val card = maindeck(r.nextInt(maindeck.size - 1))
      maindeck -= card
      card
    }
    def check(table:Table):Boolean={
      var boolList = List[Boolean]()
      if(table.check() == true){
        print("Gewonnen! ")
        return true
      }
      print("Verloren. ")
      return false
    }
    //var deck = List[Card] ()

    //deck = deck ++ List(card)
    var table1 = new Table(List(draw))

    var int = 0
    table1.table.foreach{c:Card => println("Pos:" + int + "\n" + c.year + " "); int = int + 1}

    var player = ListBuffer[Card] ()
  //create Player, give them three cards
    for(i <- 0 until 3){
      player = player ++ List(draw)
    }

    while (player.length != 0) {
      //show the playercards
      println("Your Cards: ")
      for (i <- 0 until player.length) {
        println(player(i).year)
      }

      //determin the card to be laied down
      val scanner = new Scanner(System.in)
      var b = 0
      if(player.length != 1){
        println("Wich Card do you want to use?")
        b = scanner.nextInt()
      }

      //determin, where the card should be put
      println("Your Card: " + player(b).year + ". Insert at? ")
      val a = scanner.nextInt()
      table1 = table1.insertCard(a, player(b))
      player -= player(b)

      //print out the new table
      int = 0;
      table1.table.foreach { c: Card => println("Pos:" + int + " " + c.year + " "); int = int + 1 }
      if (player.length != 0) {
        println("Do you want to check the cards position (y/n)")
        if(scanner.next().equals("y")){
          if(!check(table1)) player = player ++ List(draw)
          for(i <- 0 until table1.table.length) {
            maindeck += table1.table(i)
          }
          maindeck.foreach(cardTest => println (cardTest.year))
          table1 = new Table(List(draw))
          println("New table has been created.")
          int = 0;
          table1.table.foreach { c: Card => println("Pos:" + int + " " + c.year + " "); int = int + 1 }
        }
      } else check(table1)

    }
  }
}


case class Card(year:Int)