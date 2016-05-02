import org.scalatest._

class Hello2Spec extends FlatSpec with Matchers {
  "Hello" should "have tests" in {
    true should === (true)
  }

  "Hello2" should "have tests" in {
    true should === (true)
  }
}
