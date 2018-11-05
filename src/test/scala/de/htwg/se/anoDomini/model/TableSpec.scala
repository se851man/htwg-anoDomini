package de.htwg.se.anoDomini.model

import org.scalatest.{Matchers, WordSpec}

/* The Table is a sorted Collection of Cards.
  A Player can add cards to the Table.
  The added Card can be placed between any other Cards, but outside of this the order of the Cars cannot be changed.
  The table can check the order of the card and tell if the order is correct.
  The order is correct, if the "left" Card has a lower value than the "right" Card.
 */
class TableSpec extends WordSpec with Matchers {
  "A Table" when { "new" should {
    val table = Table()
  }}
}
