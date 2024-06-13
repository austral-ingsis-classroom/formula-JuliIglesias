package edu.austral.ingsis.math.operations;

import java.util.List;

public class Subtraction implements Operation{
  String operationTypes = "-";


  @Override
  public Double doOperation(List<Double> numbers) {
    double rst = numbers.getFirst()*2;
    for (double number : numbers) {
      rst -= number;
    }
    return rst;
  }

  @Override
  public String getType() {
    return operationTypes;
  }
}
