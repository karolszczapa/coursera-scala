def pascal(c: Int, r: Int): Int = {
  if (r == 0 || c == 0 || c == r) 1
  else pascal(c - 1, r - 1) + pascal(c, r - 1)
}

def balance(chars: List[Char]): Boolean = {
  def loop(openCount: Int, chars: List[Char]): Boolean =
    if (chars.isEmpty) return openCount == 0
    else if (chars.head == '(') loop(openCount + 1, chars.tail)
    else if (chars.head == ')')
      if (openCount == 0) false
      else loop(openCount - 1, chars.tail)
    else loop(openCount, chars.tail)

  loop(0, chars)
}

balance("(if (zero? x) max (/ 1 x))".toList)
balance("I told him (that it’s not (yet) done). (But he wasn’t listening)".toList)
balance(":-)".toList)
balance("())()".toList)


def countChange(money: Int, coins: List[Int]): Int = {
  if (coins.isEmpty && money == 0) 1
  else if (money < 0 || coins.isEmpty) 0
  else countChange(money - coins.head, coins) + countChange(money, coins.tail)
}
(1 to 2).toList
countChange(4, (1 to 2).toList)