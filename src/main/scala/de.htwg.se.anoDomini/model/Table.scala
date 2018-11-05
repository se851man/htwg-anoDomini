package de.htwg.se.anoDomini.model

case class Table(table:List[Card]) {
  def draw(drawnCard: Deck): Unit ={
    table :+ drawnCard.remove()
  }


}
