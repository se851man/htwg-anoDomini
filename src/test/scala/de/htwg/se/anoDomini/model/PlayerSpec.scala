package de.htwg.se.anoDomini.model

import org.scalatest.{Matchers, WordSpec}

/* The Player has a Name.
  There can be several Players in one Game.
  Each Player has their own Name and their own Set of Cards.
  A Player can draw Cards from the Deck.
  A Player can place Cards on the Table.
  A Player has won if he has no more Cards left
 */

class PlayerSpec extends WordSpec with Matchers {
  "A Player" when { "new" should {
    val player1 = Player("Name")
    "have a name" in {
      player1.playerName should be("Name")
    }
    "have a nice String representation" in {
      player1.toString should be("Name")
    }
  }}
}
