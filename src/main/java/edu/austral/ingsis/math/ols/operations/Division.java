package edu.austral.ingsis.math.ols.operations;

import java.util.List;

public class Division implements Operation{
  String operationTypes = "/";


  @Override
  public Double doOperation(List<Double> numbers) {
    double rst = Math.pow(numbers.getFirst(),2);
    for (double number : numbers) {
      rst /= number;
    }
    return rst;
  }

  @Override
  public String getType() {
    return operationTypes;
  }
}
