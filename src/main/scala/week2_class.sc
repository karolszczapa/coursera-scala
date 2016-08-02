val a = new Rational(1, 2)
val b = new Rational(1, 3)
a.add(b)
a.sub(b)

val x = new Rational(1,3)
val y = new Rational(5,7)
val z = new Rational(3,2)
x.sub(y).sub(z)
y.add(y)

class Rational(n :Int, d: Int){
  private val g = gcd(n, d)
  private val numer = n
  private val denom = d

  def this(x: Int) = this(x, 1)

  require (d > 0, " denominator must be positive")

  def less(that: Rational) = this.numer * that.denom < that.numer * this.denom

  def max(that:Rational) = if(this.less(that)) that else this

  def add(that : Rational):Rational = {
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )
  }
  def neg: Rational = new Rational(-numer, denom)

  def sub(that: Rational): Rational ={
    add(that.neg)
  }

  override def toString = numer/g+ "/"+denom/g

  private def gcd(a : Int, b : Int): Int = if(b==0)a else gcd(b, a % b)
}