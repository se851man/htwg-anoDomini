package de.htwg.se.anoDomini.model

import org.scalatest.{Matchers, WordSpec}

class CardSpec extends WordSpec with Matchers {
  "A Card" should {
    "have a value Year >= 0" in {
      val card = Card(10)
      card.year should be (10)
    }
  }
}
