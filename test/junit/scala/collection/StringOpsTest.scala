package scala.collection

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(classOf[JUnit4])
class StringOpsTest {
  // Test for scala/bug#10951
  @Test def mkstring(): Unit = {
    assert("".mkString("") == "")
    assert("".mkString(",") == "")
    assert("a".mkString(",") == "a")
    assert("ab".mkString(",") == "a,b")
    assert("ab".mkString("foo", ",", "bar") == "fooa,bbar")
  }

  @Test def addString(): Unit = {
    assert("".addString(new StringBuilder).toString == "")
    assert("a".addString(new StringBuilder, ",").toString == "a")
    assert("".addString(new StringBuilder, "foo", ",", "bar").toString == "foobar")
  }
}
