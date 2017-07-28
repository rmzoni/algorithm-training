package ai.linkedlists

class ReverseGroupOfKElements {

  class ListNode[T](x: T) {
    var value: T = x
    var next: Option[ListNode[T]] = None
  }

  def reverse(l: Option[ListNode[Int]], k: Int): Option[ListNode[Int]] = {

    var prevLast: Option[ListNode[Int]] = None
    var firstLast = prevLast
    var curLast = prevLast
    var prev = prevLast
    var cur = l

    var curLastNext = prevLast

    var i = 0

    while (cur.nonEmpty) {
      if (i % k == 0) {
        prevLast = curLast
        curLast = cur
      }

      var tmp = cur.get.next
      var tmpCur = cur
      cur.get.next = prev
      prev = cur
      cur = tmp

      if (i % k == 0) {
        curLastNext = tmpCur.get.next
        tmpCur.get.next = None
      }

      if (i % k == k - 1) {
        if (firstLast.isEmpty) {
          firstLast = tmpCur
        }
        if (prevLast.nonEmpty) {
          prevLast.get.next = tmpCur
        }
      }

      i += 1
    }
    prevLast.foreach { n => n.next = prev }
    //println("prev last", prevLast, prevLast.map(_.value).getOrElse(-1))

    if (i % k > 1) {
      cur = prev
      prev = None
      (1 to i % k).foreach { _ =>
        //println(cur, cur.map(_.value).getOrElse(-1))
        if (cur.nonEmpty) {
          var tmp = cur.get.next
          cur.get.next = prev
          prev = cur
          cur = tmp
        }
      }
      //println("prev", prev, prev.map(_.value).getOrElse(-1))
      prevLast.foreach(_.next = prev)
    }

    firstLast
  }

}