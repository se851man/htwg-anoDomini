package de.htwg.se.anoDomini.model

import de.htwg.se.anoDomini.model._

/* Deck contains all Cards that are playable in Game.
  Cards can be drawn from the Deck (From Player or at the Beginning from Table)
  When a card is drawn, it will belong to the Entity that drawed it.
  When a Card is drawn from Deck, it cannot be drawn anymore until it is layed back.
 */



case class Deck(deck:List[Card]) {

  def remove(): Card ={
    val removedCard = deck.head
    deck.filter(_ != removedCard)
    return removedCard
  }
  /*def add(card:Card): Card =
  {
    deck :+ card
  }*/

}
