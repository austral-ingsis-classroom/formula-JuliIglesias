package edu.austral.ingsis.math;

import edu.austral.ingsis.math.functions.Function;
import edu.austral.ingsis.math.registers.RegisterVariable;


public class MathEngine {

  public Double completeFunction(RegisterVariable variable, Function function){
    return function.evaluate(variable.variables());
  }

  public String printFunction(Function function) {
    return function.getFunction();
  }
}