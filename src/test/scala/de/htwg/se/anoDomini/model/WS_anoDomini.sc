
//import de.htwg.se.anoDomini.model.Card
/*
  this is just as little test worksheet to try out scala stuff.
  It has nothing to do with the game
 */
1+2
1<2
1>2
//i:Int = 0
var a = 1 + 2 //erkennt a automatisch als int.
a = a + 1 // var laesst sich aendern
val b = "hi" //erkennt b als String.
//b = "hallo" val laesst sich nicht aendern
//var c:Int //Typdefinition
//c = 3

def +++(x:Int): Int = x + 3
/*ist als methodenname erlaubt
  (aber + alleine zu ueberschreiben geht irgendwie nicht,
   obwohl es sollte
 */
val d = 4 + +++(a)
a.toString //automatischer wechsel zu string.

class Zahl(zahl:Double)
val zahl1 = new Zahl(3.5) //classes mit new initialisieren

case class Wert(wert:Double)
val zahl2 = Wert(2.7) //case class brauch kein new beim initialisieren

/*
  Notiz: die Privatsphaere der Klassen laesst sich haargenau einstellen, probiers mal
  Nomenklatur: private[erlaubteKlasse/package] classenname
  default ist public, es gibt auch kein exter begriff dafuer

  Imports sind ueberall erlaubt
  man kann klassen umbenennen
  import de.htwg.{ComplicatedClassName => Complex}
 */

def test1 : Unit = {System.out.println("test1 wurde aufgerufn")} //normale deklaration fuer void klasse
def test2 {System.out.println("test2 wurde aufgerufen")} //alternative deklaration fuer void klasse

test1
test2

/* User Object instead of Static

      Type Option: is used if a return type can have something or nothing

      search(something) match {
        case Some(s) => println("found "+s)
        case None => println("found nothing")
 */


val setA = Set(1, 2, 3, 4)
val setB = Set(4, 5, 6, 7)

setA contains 4 //true
setA contains 6 //false

setB ++ setA contains(6) //true
setA -- setB contains(4) //false

setA & setB contains 4 //true
setA & setB contains 2 //false

setA | setB contains 4 //true
setA | setB contains 2 //true

setA diff setB contains 0 //false
setA diff setB contains 2 //true
setA diff setB contains 4 //false

var p = Set[Int]()
p = p + 9
