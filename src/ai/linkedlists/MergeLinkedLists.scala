package ai.linkedlists

class MergeLinkedLists {

  class ListNode[T](x: T) {
    var value: T = x
    var next: Option[ListNode[T]] = None
  }

  def merge(l1: Option[ListNode[Int]], l2: Option[ListNode[Int]]): Option[ListNode[Int]] = {

    (l1, l2) match {

      case (None, None)    => None
      case (Some(_), None) => l1
      case (None, Some(_)) => l2
      case (Some(x), Some(y)) if y.value < x.value => {
        y.next = merge(Some(x), y.next)
        Some(y)
      }
      case (Some(x), Some(y)) if y.value >= x.value => {
        x.next = merge(x.next, Some(y))
        Some(x)
      }

    }

  }

}