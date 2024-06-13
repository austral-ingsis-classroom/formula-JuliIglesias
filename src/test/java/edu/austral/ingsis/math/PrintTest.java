package edu.austral.ingsis.math;

import edu.austral.ingsis.math.news.Function;
import edu.austral.ingsis.math.news.Operations.BinaryOperationFunction;
import edu.austral.ingsis.math.news.Operations.UnaryOperationFunction;
import edu.austral.ingsis.math.news.leaf.NumberFunction;
import edu.austral.ingsis.math.news.leaf.VariableFunction;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {

  /** Case 1 + 6 */
  @Test
  public void shouldPrintFunction1() {
    String result =  (new BinaryOperationFunction(
        new NumberFunction(1),
        new NumberFunction(6), "+")).toString();

    assertThat(result, equalTo("1.0 + 6.0"));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldPrintFunction2() {
    String result =  (new BinaryOperationFunction(
        new NumberFunction(12),
        new NumberFunction(2), "/")).toString();

    assertThat(result, equalTo("(12.0 / 2.0)"));
  }

  /** Case (9 / 2) * 3 */
  @Test
  public void shouldPrintFunction3() {
    Function nine = new NumberFunction(9);
    Function two = new NumberFunction(2);
    Function division = new BinaryOperationFunction(nine, two, "/");
    Function mult = new BinaryOperationFunction(division, new NumberFunction(3), "*");
    String result = mult.toString();

    assertThat(result, equalTo("(9.0 / 2.0) * 3.0"));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldPrintFunction4() {
    Function twentySeven = new NumberFunction(27);
    Function six = new NumberFunction(6);
    Function division = new BinaryOperationFunction(twentySeven, six, "/");
    Function exponentiation = new BinaryOperationFunction(division, new NumberFunction(2),"pow");
    String result = exponentiation.toString();

    assertThat(result, equalTo("(27.0 / 6.0) ^ 2.0"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction6() {
    Function mod = new UnaryOperationFunction(new VariableFunction("value"), "mod");
    Function sub = new BinaryOperationFunction(mod,new NumberFunction(8) , "-");
    String result = sub.toString();

    assertThat(result, equalTo("(|value| - 8.0)"));

  }

  /** Case |value| - 8 */
  @Test
  public void shouldPrintFunction7() {
    Function mod = new UnaryOperationFunction(new VariableFunction("value"), "mod");
    Function sub = new BinaryOperationFunction(mod,new NumberFunction(8) , "-");
    String result = sub.toString();

    assertThat(result, equalTo("(|value| - 8.0)"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldPrintFunction8() {
    String result =  (new BinaryOperationFunction(
        new BinaryOperationFunction(new NumberFunction(5), new VariableFunction("i"), "-"),
        new NumberFunction(8), "*")).toString();

    assertThat(result, equalTo("(5.0 - i) * 8.0"));
  }
}
