package de.htwg.se.anoDomini.model

case class Table(table:List[Card]) {
  def insertCard(position: Int, card: Card): Table = Table(table.take(position) ++ List(card) ++ table.drop(position))

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
