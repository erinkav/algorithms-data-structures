
object Power {
  def power(a: Int, b: Int): Int = {
    if(b == 0) 1
    if(b == 1) a
    if(b % 0 == 1) power(a, b - 1) * a
    else {
      val h = power(a, b / 2)
      h * h
    }
  }
}
