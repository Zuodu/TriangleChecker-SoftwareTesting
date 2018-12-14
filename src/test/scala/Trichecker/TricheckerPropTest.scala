package Trichecker

import org.scalacheck.Prop.BooleanOperators
import org.scalacheck.{Properties, _}

object TricheckerPropTest extends Properties("Triangle") {
  val a = Gen.choose(1, 5000)
  val s : Gen[Seq[Int]] = Gen.pick(3, 1 to 5000)

  val propEquilateral: Prop = Prop.forAll(a) { n =>
    Trichecker.Check(n, n, n) == Result.EQUILATERAL
  }
  val propIsoceles: Prop = Prop.forAll(s) { n =>
    val sort = n.sorted
    val a = sort.head
    val b = sort.apply(2)
    (a * 2 >= b) ==> (Trichecker.Check(a, a, b) == Result.ISOCELES)
  }

  val propScalene: Prop = Prop.forAll(s) { n =>
    val sort = n.sorted
    val a = sort.head
    val b = sort.apply(1)
    val c = sort.apply(2)
    (a + b >= c) ==> (Trichecker.Check(a, b, c) == Result.SCALENE)
  }

  val propNoTriangle: Prop = Prop.forAll(s) { n =>
    val sort = n.sorted
    val a = sort.head
    val b = sort.apply(1)
    val c = sort.apply(2)
    (a + b < c) ==> (Trichecker.Check(a, b, c) == Result.NO_TRIANGLE)
  }

  //test checking
  propEquilateral.check
  propIsoceles.check
  propScalene.check
  propNoTriangle.check
}
