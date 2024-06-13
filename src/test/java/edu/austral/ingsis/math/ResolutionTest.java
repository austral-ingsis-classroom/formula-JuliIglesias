package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.news.Function;
import edu.austral.ingsis.math.news.Operations.BinaryOperationFunction;
import edu.austral.ingsis.math.news.Operations.UnaryOperationFunction;
import edu.austral.ingsis.math.news.leaf.NumberFunction;
import org.junit.jupiter.api.Test;

public class ResolutionTest {

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    Function function =
        new BinaryOperationFunction(new NumberFunction(1), new NumberFunction(6), "+");
    assertThat(function.evaluate(), equalTo(7.0));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    Function function =
        new BinaryOperationFunction(new NumberFunction(12), new NumberFunction(2), "/");
    assertThat(function.evaluate(), equalTo(6.0));
  }

  /** Case (9 / 2) * 3 = 13.5 */
  @Test
  public void shouldResolveSimpleFunction3() {
    Function function =
        new BinaryOperationFunction(
            new BinaryOperationFunction(new NumberFunction(9), new NumberFunction(2), "/"),
            new NumberFunction(3),
            "*");

    assertThat(function.evaluate(), equalTo(13.5));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    Function function =
        new BinaryOperationFunction(
            new BinaryOperationFunction(new NumberFunction(27), new NumberFunction(6), "/"),
            new NumberFunction(2),
            "pow");

    assertThat(function.evaluate(), equalTo(20.25));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    Function function = new UnaryOperationFunction(new NumberFunction(36), "sqrt");

    assertThat(function.evaluate(), equalTo(6.0));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    Function function = new UnaryOperationFunction(new NumberFunction(136), "mod");

    assertThat(function.evaluate(), equalTo(136.0));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    Function function = new UnaryOperationFunction(new NumberFunction(-136), "mod");

    assertThat(function.evaluate(), equalTo(136.0));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    Function function =
        new BinaryOperationFunction(
            new BinaryOperationFunction(new NumberFunction(5), new NumberFunction(5), "-"),
            new NumberFunction(8),
            "*");

    assertThat(function.evaluate(), equalTo(0.0));
  }
}
