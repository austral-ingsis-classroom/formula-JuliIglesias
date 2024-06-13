package edu.austral.ingsis.math.ols.operations;

import java.util.List;

public class Square implements Operation{
  String operationTypes = "^(1/2)";

  @Override
  public Double doOperation(List<Double> numbers) {
    return Math.sqrt(numbers.getFirst());
  }

  @Override
  public String getType() {
    return operationTypes;
  }
}
