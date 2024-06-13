package edu.austral.ingsis.math.ols.functions;

import edu.austral.ingsis.math.ols.operations.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Simple implements Function{
  private final double a;
  private final double b;
  private final Operation operation;

  public Simple(double a, double b, Operation operation1) {
    this.a = a;
    this.b = b;
    this.operation = operation1;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    List<Double> num = new ArrayList<>();
    num.add(a);
    num.add(b);
    return operation.doOperation(num);
  }

  @Override
  public String getType() {
    return "Simple Function";
  }

  @Override
  public String getFunction() {
    return a +" "+ operation.getType() + " " + b;
  }
}
