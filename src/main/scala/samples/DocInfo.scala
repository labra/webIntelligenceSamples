package samples

/**
 * Created with IntelliJ IDEA.
 * User: labra
 * Date: 1/09/12
 * Time: 8:16
 * Contains information of a document that is stored in the index
 */
class DocInfo extends Ordered[DocInfo] {

  private var title : String = ""

  def this(doc: Doc) {
    this()
    this.title = doc.getTitle
  }

  override def toString = title

  def getTitle = title

  def compare(that: DocInfo) =
    this.getTitle.compare (that.getTitle)

}
