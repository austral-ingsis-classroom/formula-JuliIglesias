package edu.austral.ingsis.math;

import edu.austral.ingsis.math.functions.Simple;
import edu.austral.ingsis.math.operations.Addition;
import edu.austral.ingsis.math.registers.RegisterVariable;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListVariablesTest {

  MathEngine mathEngine = new MathEngine();
  Map<String, Double> variables = new LinkedHashMap<>();
  /** Case 1 + 6 */
  @Test
  public void shouldListVariablesFunction1() {
    Map<String, Double> variables = new LinkedHashMap<>();
    variables.put("a", 1.0);
    variables.put("b", 6.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    Simple function = new Simple(1,6, new Addition());
    double rst = mathEngine.completeFunction(registerVariable,function);

    final List<String> result = Collections.emptyList();

    assertThat(result, empty());
  }

  /** Case 12 / div */
  @Test
  public void shouldListVariablesFunction2() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("div"));
  }

  /** Case (9 / x) * y */
  @Test
  public void shouldListVariablesFunction3() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("x", "y"));
  }

  /** Case (27 / a) ^ b */
  @Test
  public void shouldListVariablesFunction4() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("a", "b"));
  }

  /** Case z ^ (1/2) */
  @Test
  public void shouldListVariablesFunction5() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("z"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction6() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case |value| - 8 */
  @Test
  public void shouldListVariablesFunction7() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("value"));
  }

  /** Case (5 - i) * 8 */
  @Test
  public void shouldListVariablesFunction8() {
    final List<String> result = Collections.emptyList();

    assertThat(result, containsInAnyOrder("i"));
  }
}
