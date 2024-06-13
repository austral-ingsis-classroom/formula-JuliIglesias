package edu.austral.ingsis.math;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import edu.austral.ingsis.math.news.Function;
import edu.austral.ingsis.math.news.Operations.BinaryOperationFunction;
import edu.austral.ingsis.math.news.Operations.UnaryOperationFunction;
import edu.austral.ingsis.math.news.leaf.NumberFunction;
import edu.austral.ingsis.math.news.leaf.VariableFunction;
import org.junit.jupiter.api.Test;

public class ResolutionWithVariablesTest {

  /** Case 1 + x where x = 3 */
  @Test
  public void shouldResolveFunction1() {
    Function function =
        new BinaryOperationFunction(new NumberFunction(1), new VariableFunction("x"), "+");
    double result = function.evaluate(3);

    assertThat(result, equalTo(4d));
  }

  /** Case 12 / div where div = 4 */
  @Test
  public void shouldResolveFunction2() {
    Function function =
        new BinaryOperationFunction(new NumberFunction(12), new VariableFunction("div"), "/");
    double result = function.evaluate(4);

    assertThat(result, equalTo(3d));
  }

  /** Case (9 / x) * y where x = 3 and y = 4 */
  @Test
  public void shouldResolveFunction3() {
    Function nine = new NumberFunction(9);
    Function x = new VariableFunction("x");
    Function y = new VariableFunction("y");

    Function division = new BinaryOperationFunction(nine, x, "/");
    double div = division.evaluate(3);
    Function exponentiation = new BinaryOperationFunction(new NumberFunction(div), y, "*");
    double result = exponentiation.evaluate(4); // Pass a = 9 and b = 3 as arguments

    assertThat(result, equalTo(12d));
  }

  /** Case (27 / a) ^ b where a = 9 and b = 3 */
  @Test
  public void shouldResolveFunction4() {
    Function twentySeven = new NumberFunction(27);
    Function a = new VariableFunction("a");
    Function b = new VariableFunction("b");

    Function division = new BinaryOperationFunction(twentySeven, a, "/");
    double div = division.evaluate(9);
    Function exponentiation = new BinaryOperationFunction(new NumberFunction(div), b, "pow");
    double result = exponentiation.evaluate(3); // Pass a = 9 and b = 3 as arguments

    assertThat(result, equalTo(27d));
  }

  /** Case z ^ (1/2) where z = 36 */
  @Test
  public void shouldResolveFunction5() {
    Function function = new UnaryOperationFunction(new VariableFunction("z"), "sqrt");
    double result = function.evaluate(36);

    assertThat(result, equalTo(6d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction6() {
    Function function =
        new BinaryOperationFunction(new VariableFunction("value"), new NumberFunction(8), "-");
    double result = function.evaluate(8);

    assertThat(result, equalTo(0d));
  }

  /** Case |value| - 8 where value = 8 */
  @Test
  public void shouldResolveFunction7() {
    Function value = new VariableFunction("value");
    Function absoluteValue = new UnaryOperationFunction(value, "mod");
    Function eight = new NumberFunction(8);
    Function subtraction = new BinaryOperationFunction(absoluteValue, eight, "-");

    Double result = subtraction.evaluate(8);

    assertThat(result, equalTo(0d));
  }

  /** Case (5 - i) * 8 where i = 2 */
  @Test
  public void shouldResolveFunction8() {
    Function function =
        new BinaryOperationFunction(new NumberFunction(5), new VariableFunction("i"), "-");
    double re = function.evaluate(2);
    Function function1 =
        new BinaryOperationFunction(new NumberFunction(re), new NumberFunction(8), "*");
    double result = function1.evaluate();

    assertThat(result, equalTo(24d));
  }
}
