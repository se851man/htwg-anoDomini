package de.htwg.se.anoDomini.model

import org.scalatest.{Matchers, WordSpec}

class CardSpec extends WordSpec with Matchers {
  "A Card" should {
    "have a value Year" in {
      val card = Card(1999).year should be(1999)
    }
  }
}
