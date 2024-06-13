package edu.austral.ingsis.math;

import edu.austral.ingsis.math.functions.Simple;
import edu.austral.ingsis.math.functions.UnitaryFunction;
import edu.austral.ingsis.math.operations.*;
import edu.austral.ingsis.math.operations.Module;
import edu.austral.ingsis.math.registers.RegisterVariable;
import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ResolutionTest {

  MathEngine mathEngine = new MathEngine();
  Map<String, Double> variables = new LinkedHashMap<>();

  /** Case 1 + 6 */
  @Test
  public void shouldResolveSimpleFunction1() {
    variables.put("a", 1.0);
    variables.put("b", 6.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    Simple function = new Simple(1,6, new Addition());
    double rst = mathEngine.completeFunction(registerVariable,function);

    assertThat(rst, equalTo(7.0));
  }

  /** Case 12 / 2 */
  @Test
  public void shouldResolveSimpleFunction2() {
    variables.put("a", 12.0);
    variables.put("b", 2.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    Simple function = new Simple(12,2, new Division());
    double rst = mathEngine.completeFunction(registerVariable,function);

    assertThat(rst, equalTo(6.0));
  }

  /** Case (9 / 2) * 3 = 13.5*/
  @Test
  public void shouldResolveSimpleFunction3() {
    variables.put("a", 9.0);
    variables.put("b", 2.0);
    variables.put("c", 3.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    Simple function = new Simple(9,2, new Division());
    double rst1 = mathEngine.completeFunction(registerVariable,function);
    Simple function2 = new Simple(rst1, 3, new Multiplication());
    double rst2 = mathEngine.completeFunction(registerVariable,function2);

    assertThat(rst2, equalTo(13.5));
  }

  /** Case (27 / 6) ^ 2 */
  @Test
  public void shouldResolveSimpleFunction4() {
    variables.put("a", 27.0);
    variables.put("b", 6.0);
    variables.put("c", 2.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    Simple function = new Simple(27,6, new Division());
    double rst1 = mathEngine.completeFunction(registerVariable,function);
    Simple function2 = new Simple(rst1, 2, new PowerOf());
    double rst2 = mathEngine.completeFunction(registerVariable,function2);

    assertThat(rst2, equalTo(20.25));
  }

  /** Case 36 ^ (1/2) */
  @Test
  public void shouldResolveSimpleFunction5() {
    variables.put("a", 36.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    UnitaryFunction function = new UnitaryFunction(36,new Square());
    double rst = mathEngine.completeFunction(registerVariable,function);

    assertThat(rst, equalTo(6.0));
  }

  /** Case |136| */
  @Test
  public void shouldResolveSimpleFunction6() {
    variables.put("a", 136.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    UnitaryFunction function = new UnitaryFunction(136,new Module());
    double rst = mathEngine.completeFunction(registerVariable,function);

    assertThat(rst, equalTo(136.0));
  }

  /** Case |-136| */
  @Test
  public void shouldResolveSimpleFunction7() {
    variables.put("a", -136.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    UnitaryFunction function = new UnitaryFunction(-136,new Module());
    double rst = mathEngine.completeFunction(registerVariable,function);

    assertThat(rst, equalTo(136.0));
  }

  /** Case (5 - 5) * 8 */
  @Test
  public void shouldResolveSimpleFunction8() {
    variables.put("a", 5.0);
    variables.put("b", 5.0);
    variables.put("c", 8.0);
    RegisterVariable registerVariable = new RegisterVariable(variables);
    Simple function = new Simple(5,5, new Subtraction());
    double rst1 = mathEngine.completeFunction(registerVariable,function);
    Simple function2 = new Simple(rst1, 8, new Multiplication());
    double rst2 = mathEngine.completeFunction(registerVariable,function2);

    assertThat(rst2, equalTo(0.0));
  }
}
