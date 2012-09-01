package samples

/**
 * Created with IntelliJ IDEA.
 * User: labra
 * Date: 31/08/12
 * Time: 17:45
 * To change this template use File | Settings | File Templates.
 */
class DB {
  private var docs : List[Doc] = List.empty

  def add (doc : Doc) {
      docs = doc :: docs
  }

  def createIndex : Index = {
    val index = new Index
    for (doc <- docs ) index.add(doc)
    return index
  }

  def show() = {
    for { d <- docs } {
      println(d)
    }
  }
}
