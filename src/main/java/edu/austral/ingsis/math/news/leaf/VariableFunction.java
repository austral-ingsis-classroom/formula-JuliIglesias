package edu.austral.ingsis.math.news.leaf;

import edu.austral.ingsis.math.news.Function;
import java.util.Collections;
import java.util.List;

public class VariableFunction implements Function {
  private String name;

  public VariableFunction(String name) {
    this.name = name;
  }

  @Override
  public double evaluate() {
    return 0;
  }

  @Override
  public double evaluate(int value) {
    return value;
  }

  public double evaluate(double value) {
    return value;
  }

  @Override
  public List<String> getVariables() {
    return Collections.singletonList(name);
  }

  @Override
  public String toString() {
    return name;
  }
}
