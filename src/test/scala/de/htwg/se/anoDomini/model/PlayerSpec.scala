package de.htwg.se.anoDomini.model

import org.scalatest.{Matchers, WordSpec}

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
