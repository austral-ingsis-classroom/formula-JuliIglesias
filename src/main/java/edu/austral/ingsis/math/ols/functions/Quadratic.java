package edu.austral.ingsis.math.ols.functions;

import edu.austral.ingsis.math.ols.operations.Addition;
import edu.austral.ingsis.math.ols.operations.Multiplication;
import edu.austral.ingsis.math.ols.operations.Operation;
import edu.austral.ingsis.math.ols.operations.PowerOf;
import edu.austral.ingsis.math.ols.registers.RegisterOperation;

import java.util.*;

public class Quadratic implements Function{
  private final RegisterOperation register = new RegisterOperation();
  private final double a;
  private final double b;
  private final double c;

  public Quadratic(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
    setOperations();
  }

  public void setOperations(){
    Stack<Operation> operations = new Stack<>();
    operations.push(new Addition());
    operations.push(new Multiplication());
    operations.push(new PowerOf());
    register.setFuncsOp("Quadratic",operations);
  }

  @Override
  public double evaluate(Map<String, Double> variables) {
    double x = variables.get("x");

    double x2 = op2(x, 2.0, register.getOperation());

    Operation multi = register.getOperation();
    double ax2 = op2(x2, a, multi);
    double bx = op2(x, b, multi);

    return op3(ax2, bx, register.getOperation());
  }

  private Double op3(double ax2, double bx, Operation operation) {
    List<Double> list = new ArrayList<>();
    list.add(ax2);
    list.add(bx);
    list.add(c);
    return operation.doOperation(list);
  }

  private double op2(double x, double e, Operation operations) {
    List<Double> list = new ArrayList<>();
    list.add(x);
    list.add(e);
    return operations.doOperation(list);
  }

  public Set<String> getVariables() {
    return Set.of("x");
  }

  public String getType(){
    return "Quadratic";
  }

  public String getFunction(){
    return a + "*x*x + " +b+ "*x + " +c;
  }
}
