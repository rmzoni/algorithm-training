package ai.linkedlists

class RearrangeLastElements {

  class ListNode[T](x: T) {
    var value: T = x
    var next: Option[ListNode[T]] = None
  }

  def rearrange(l: Option[ListNode[Int]], n: Int): Option[ListNode[Int]] = {
    if (n == 0) {
      return l
    }

    var count = 0
    var prev: Option[ListNode[Int]] = None
    var cur = l
    while (cur.nonEmpty) {
      prev = cur
      cur = cur.get.next
      count += 1
    }
    var origLast = prev

    if (count < 2 || n == count) {
      return l
    }

    var newLast = l
    (1 until (count - n)).foreach { _ => // 1, 2, 3, n = 1 = 0
      newLast = newLast.get.next
    }

    var first = newLast.get.next
    newLast.get.next = None
    origLast.get.next = l

    first

  }

}