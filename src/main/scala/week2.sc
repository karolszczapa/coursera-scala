def sum(f: Int => Int) (a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if (a > b) acc
    else loop(a + 1, acc + f(a))
  }
  loop(a, 0)
}

sum(x => x)(1, 3)

def product(f: Int => Int )(a: Int, b: Int): Int ={
  if(a > b) 1
  else f(a)*product(f)(a + 1,b)
}

def fact(n: Int): Int = product(x => x)(1, n)

fact(5)

def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int ={
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))
}

def newProduct(f: Int => Int)(a: Int, b : Int): Int = {
  mapReduce(f, (x, y) => x * y, 1)(a,b)
}

def newSum(f: Int => Int)(a: Int, b: Int): Int = {
  mapReduce(f, (x, y) => x +y, 0)(a, b)
}

newProduct(x=> x)(1, 5)

val tolerance = 0.0001

def abs(d: Double) = if(d < 0) -d else d

def isCloseEnough(x: Double, y: Double) =
  abs((x - y) / x) / x < tolerance
def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
    val next = f(guess)
    if (isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

def averageDamp(f: Double => Double)(x: Double) = (x + f(x)) / 2

def oldSqrt(x: Double) = fixedPoint(y => (y + x / y) / 2)(1.0)
def sqrt(x: Double) = fixedPoint(averageDamp(y => x/y))(1.0)
oldSqrt(2)
sqrt(2)


