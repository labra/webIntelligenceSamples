package samples

import collection.immutable.TreeSet


/**
 * Created with IntelliJ IDEA.
 * User: labra
 * Date: 1/09/12
 * Time: 8:03
 * To change this template use File | Settings | File Templates.
 */
class Result {
      private var results : TreeSet[DocInfo] = new TreeSet[DocInfo]

      def mix (docInfo : DocInfo) {
        results += docInfo
      }

    def contains(docInfo : DocInfo) =
      results contains docInfo

     override def toString =
       results.toList.mkString(", ")
}
