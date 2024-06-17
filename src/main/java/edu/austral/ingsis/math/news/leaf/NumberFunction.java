package edu.austral.ingsis.math.news.leaf;

import edu.austral.ingsis.math.news.Function;
import java.util.ArrayList;
import java.util.List;

public class NumberFunction implements Function {
  private final double value;

  public NumberFunction(double value) {
    this.value = value;
  }

  @Override
  public double evaluate() {
    return value;
  }

  @Override
  public double evaluate(int val) {
    return value;
  }

  @Override
  public List<String> getVariables() {
    return new ArrayList<>();
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }
}
