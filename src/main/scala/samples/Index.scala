package samples

import collection.mutable.HashMap

/**
 * Created with IntelliJ IDEA.
 * User: labra
 * Date: 1/09/12
 * Time: 0:12
 * To change this template use File | Settings | File Templates.
 */
class Index {
  private val table : HashMap[String,List[DocInfo]] = new HashMap()

  def add(doc : Doc) {
    for (word <- doc.getWords) {
      val docInfo = new DocInfo(doc)
      if (table contains word) {
        table(word) = docInfo :: table(word)
      }
      else
        table += (word -> List(docInfo))
    }
  }

  def search (query : String) : Result = {
    val words = splitQuery(query)
    val result : Result = new Result
    for (word <- words) {
      if (table contains word)
        for (docInfo <-table(word) )
          result.mix(docInfo)
    }
    return result
  }

  def splitQuery(query : String) : List[String] =
    query.split(" ").toList


  def show {
    for (key <- table.keys) {
      print(key + " -> " );
      for (doc <- table(key)) {
        print(doc + " ")
      }
      println
    }
  }
}
