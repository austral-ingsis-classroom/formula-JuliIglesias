package edu.austral.ingsis.math.functions;

import edu.austral.ingsis.math.operations.Operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnitaryFunction implements Function{
  private final Operation operation;
  private final double b;

  public UnitaryFunction(double b,Operation operation) {
    this.operation = operation;
    this.b = b;
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    List<Double> num = new ArrayList<>();
    num.add(b);
    return operation.doOperation(num);
  }

  @Override
  public String getType() {
    return "Unitary Function";
  }

  @Override
  public String getFunction() {
    return operation.getType() + " " + b;
  }
}
