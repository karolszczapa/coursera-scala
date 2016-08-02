abstract class IntSet{
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

class Empty extends IntSet {
  override def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)

  override def contains(x: Int): Boolean = false

  override def union(other: IntSet): IntSet = other

  override def toString = "."
}

class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends IntSet{
  override def contains(x: Int): Boolean =
    if(x < elem) left.contains(x)
    else if (x > elem) right contains x
    else true

  override def incl(x: Int): IntSet =
    if(x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this

  override def union(other: IntSet): IntSet = {
    right union left union other incl elem
  }

  override def toString = "{" + left + elem + right + "}"

  def this(elem: Int)= this(elem, new Empty(), new Empty())
}

val set1 = new NonEmpty(1)
val set2 = new NonEmpty(2)
val set3 = new NonEmpty(3)
val set4 = set1 union set2 union set3
set4 union new NonEmpty(4) union new NonEmpty(5)
