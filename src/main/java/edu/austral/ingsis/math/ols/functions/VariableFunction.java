package edu.austral.ingsis.math.ols.functions;

import edu.austral.ingsis.math.ols.operations.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VariableFunction implements Function{
  private final double a;
  private final Operation operation;
  private final String b;

  public VariableFunction(double a, String b, Operation operation) {
    this.a = a;
    this.b = b;
    this.operation = operation;
  }


  @Override
  public double evaluate(Map<String, Double> variables) {
    double var = variables.get(b);
    List<Double> num = new ArrayList<>();
    num.add(a);
    num.add(var);
    return operation.doOperation(num);

  }

  @Override
  public String getType() {
    return "Variable Function";
  }

  @Override
  public String getFunction() {
    return a +" "+ operation.getType() + " " + b;
  }
}
