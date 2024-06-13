package edu.austral.ingsis.math.operations;

import java.util.List;

public class Module implements Operation{
  String operationTypes = "|";

  @Override
  public Double doOperation(List<Double> numbers) {
    return Math.abs(numbers.getFirst());
  }

  @Override
  public String getType() {
    return operationTypes;
  }
}
