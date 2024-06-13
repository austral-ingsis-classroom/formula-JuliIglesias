package edu.austral.ingsis.math.news.Operations;

import edu.austral.ingsis.math.news.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryOperationFunction implements Function {
  private Function left;
  private Function right;
  private String operation;

  public BinaryOperationFunction(Function left, Function right, String operation) {
    this.left = left;
    this.right = right;
    this.operation = operation;
  }

  @Override
  public double evaluate() {
    double leftValue = left.evaluate();
    double rightValue = right.evaluate();
    switch (operation) {
      case "+":
        return leftValue + rightValue;
      case "-":
        return leftValue - rightValue;
      case "*":
        return leftValue * rightValue;
      case "/":
        return leftValue / rightValue;
      case "pow":
        return Math.pow(leftValue, rightValue);
      default:
        throw new UnsupportedOperationException("Operación no soportada");
    }
  }

  public double evaluate(int value) {
    // Aquí reemplazas la variable con el valor pasado como parámetro
    double leftValue = left.evaluate(value);
    double rightValue = right.evaluate(value);
    switch (operation) {
      case "+":
        return leftValue + rightValue;
      case "-":
        return leftValue - rightValue;
      case "*":
        return leftValue * rightValue;
      case "/":
        return leftValue / rightValue;
      case "pow":
        return Math.pow(leftValue, rightValue);
      default:
        throw new UnsupportedOperationException("Operation not supported");
    }
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>();
    variables.addAll(left.getVariables());
    variables.addAll(right.getVariables());
    return variables;
  }

  @Override
  public String toString() {
    if (Objects.equals(operation, "pow")) {
      return String.format("%s %s %s", left.toString(), "^", right.toString());
    } else if (Objects.equals(operation, "/")) {
      return String.format("(%s %s %s)", left.toString(), operation, right.toString());
    } else if (Objects.equals(operation, "-")) {
      return String.format("(%s %s %s)", left.toString(), operation, right.toString());
    }
    return String.format("%s %s %s", left.toString(), operation, right.toString());
  }
}
