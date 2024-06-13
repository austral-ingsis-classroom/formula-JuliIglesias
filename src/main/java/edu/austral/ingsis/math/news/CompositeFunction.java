package edu.austral.ingsis.math.news;

import java.util.ArrayList;
import java.util.List;

public class CompositeFunction implements Function {
  private List<Function> functions;

  public CompositeFunction() {
    this.functions = new ArrayList<>();
  }

  public void addFunction(Function function) {
    this.functions.add(function);
  }

  @Override
  public double evaluate() {
    double result = 0;
    for (Function function : functions) {
      result += function.evaluate();
    }
    return result;
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>();
    for (Function function : functions) {
      variables.addAll(function.getVariables());
    }
    return variables;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Function function : functions) {
      sb.append(function.toString()).append(" ");
    }
    return sb.toString().trim();
  }
}