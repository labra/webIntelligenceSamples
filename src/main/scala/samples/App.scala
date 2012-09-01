package samples

/**
 * Small example
 * @author labra
 */
object App {

  def main(args : Array[String]) {
    val a = new Doc("a.com","the quick brown fox jumps over tha lazy dog")
    val b = new Doc("b.com","a bird in hand is worth two in a bush")
    val c = new Doc("c.com","the lazy bird misses the worm")
    val db = new DB
    db.add(a)
    db.add(b)
    db.add(c)
    db.show
    println("---------------------")
    val index = db.createIndex
    index.show
    search(index,"fox")

    search(index,"bird")

    search(index,"the bird")
  }

  def search(index : Index, term: String) {
    println("Search: " + term + ". Results: " + index.search(term).toString)
  }

}
