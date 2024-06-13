package edu.austral.ingsis.math;

import edu.austral.ingsis.math.news.Function;
import edu.austral.ingsis.math.news.Operations.BinaryOperationFunction;
import edu.austral.ingsis.math.news.Operations.UnaryOperationFunction;
import edu.austral.ingsis.math.news.leaf.NumberFunction;
import edu.austral.ingsis.math.news.leaf.VariableFunction;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.List;


public class ListVariablesTest {

  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Function function = new BinaryOperationFunction(
        new NumberFunction(1),
        new NumberFunction(6),
        "+"
    );

    List<String> result = function.getVariables();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    Function function = new BinaryOperationFunction(
        new NumberFunction(12),
        new VariableFunction("div"),
        "/"
    );

    List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("div"));

  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    Function function = new BinaryOperationFunction(new BinaryOperationFunction(
        new NumberFunction(9),
        new VariableFunction("x"),
        "/"
    ), new VariableFunction("y"), "*");

    List<String> result = function.getVariables();


    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    Function function = new BinaryOperationFunction(new BinaryOperationFunction(
        new NumberFunction(27),
        new VariableFunction("a"),
        "/"
    ), new VariableFunction("b"), "pow");

    List<String> result = function.getVariables();


    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    Function function = new UnaryOperationFunction(
        new VariableFunction("z"),
        "sqrt"
    );

    List<String> result = function.getVariables();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    Function function = new BinaryOperationFunction(new UnaryOperationFunction(
        new VariableFunction("value"),
        "mod"
    ), new NumberFunction(8), "-");

    List<String> result = function.getVariables();


    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    Function function = new BinaryOperationFunction(new UnaryOperationFunction(
        new VariableFunction("value"),
        "mod"
    ), new NumberFunction(8), "-");

    List<String> result = function.getVariables();


    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    Function function = new BinaryOperationFunction(new BinaryOperationFunction(
        new NumberFunction(5),
        new VariableFunction("i"),
        "-"
    ), new NumberFunction(8), "*");

    List<String> result = function.getVariables();


    assertThat(result, containsInAnyOrder("i"));
  }
}
