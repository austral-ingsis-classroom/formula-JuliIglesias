package edu.austral.ingsis.math.operations;

import java.util.List;

public class PowerOf implements Operation {
  String operationTypes = "^2";

  @Override
  public Double doOperation(List<Double> numbers) {
    return Math.pow(numbers.getFirst(), numbers.getLast());
  }

  @Override
  public String getType() {
    return operationTypes;
  }
}
