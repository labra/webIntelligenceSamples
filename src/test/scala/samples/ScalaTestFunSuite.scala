package samples

import _root_.org.junit.runner.RunWith
import _root_.org.scalatest.junit.JUnitRunner
import _root_.org.scalatest.FunSuite
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.ShouldMatchers

@RunWith(classOf[JUnitRunner])
class ScalaTestFunSuite extends FunSuite with ShouldMatchers
                                         with BeforeAndAfterAll {

  var db : DB = new DB
  var index : Index = new Index
  var aInfo, bInfo, cInfo : DocInfo = new DocInfo

  override def beforeAll(configMap: Map[String, Any]) {
    val a = new Doc("a.com","the quick brown fox jumps over tha lazy dog")
    val b = new Doc("b.com","a bird in hand is worth two in a bush")
    val c = new Doc("c.com","the lazy bird misses the worm")
    db = new DB
    db.add(a)
    db.add(b)
    db.add(c)
    index = db.createIndex
    aInfo = new DocInfo(a)
    bInfo = new DocInfo(b)
    cInfo = new DocInfo(c)
  }

  /*test("searching fox") {
    index.search("fox") should (contains aInfo)
  } */

  test("searching bird") {
    assert(index.search("bird") contains bInfo)
  }

  test("searching the bird") {
    assert(index.search("the bird") contains aInfo)
  }

  /* test("searching kiko") {
    index.search("kiko") should not (contains aInfo)
  }  */
}
