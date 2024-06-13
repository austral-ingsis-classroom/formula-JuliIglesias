package edu.austral.ingsis.math.news.Operations;

import edu.austral.ingsis.math.news.Function;

import java.util.ArrayList;
import java.util.List;

public class UnaryOperationFunction implements Function {
  private Function function;
  private String operation;

  public UnaryOperationFunction(Function function, String operation) {
    this.function = function;
    this.operation = operation;
  }

  @Override
  public double evaluate() {
    double value = function.evaluate();
    switch (operation) {
      case "pow":
        return Math.pow(value, 2);
      case "sqrt":
        return Math.sqrt(value);
      case "mod":
        return Math.abs(value);
      default:
        throw new UnsupportedOperationException("Operación no soportada");
    }
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>(function.getVariables());
    return variables;
  }

  @Override
  public String toString() {
    return String.format("%s %s %s", function.toString(), operation);
  }
}
