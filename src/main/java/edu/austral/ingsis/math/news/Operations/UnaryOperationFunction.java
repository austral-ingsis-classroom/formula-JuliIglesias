package edu.austral.ingsis.math.news.Operations;

import edu.austral.ingsis.math.news.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
      case "sqrt":
        return Math.sqrt(value);
      case "mod":
        return Math.abs(value);
      default:
        throw new UnsupportedOperationException("Operación no soportada");
    }
  }

  public double evaluate(int value) {
    // Aquí reemplazas la variable con el valor pasado como parámetro
    double funcValue = function.evaluate(value);
    switch (operation) {
      case "mod":
        return Math.abs(funcValue);
      case "sqrt":
        return Math.sqrt(funcValue); // Asumiendo que pow es siempre squared
      default:
        throw new UnsupportedOperationException("Operation not supported");
    }
  }

  @Override
  public List<String> getVariables() {
    List<String> variables = new ArrayList<>(function.getVariables());
    return variables;
  }

  @Override
  public String toString() {
    String op;
    if ((Objects.equals(operation, "sqrt"))) {
      op = "^(1/2)";
      return String.format("(%s) %s", function.toString(), op);
    } else {
      op = "|";
      return op + function.toString() + op;
    }
  }
}
