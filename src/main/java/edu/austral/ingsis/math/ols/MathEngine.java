package edu.austral.ingsis.math.ols;

import edu.austral.ingsis.math.ols.functions.Function;
import edu.austral.ingsis.math.ols.registers.RegisterVariable;


public class MathEngine {

  public Double completeFunction(RegisterVariable variable, Function function){
    return function.evaluate(variable.variables());
  }

  public String printFunction(Function function) {
    return function.getFunction();
  }
}