package samples

/**
 * Created with IntelliJ IDEA.
 * User: labra
 * Date: 31/08/12
 * Time: 23:43
 * To change this template use File | Settings | File Templates.
 */
class Doc (title: String, contents: String) {

  def getTitle : String = title

  def getWords : List[String] = {
    contents.split(" ").toList
  }

  override def toString : String = title + ": " + contents
}
