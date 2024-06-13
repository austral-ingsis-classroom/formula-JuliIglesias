package edu.austral.ingsis.math.registers;

import edu.austral.ingsis.math.operations.Operation;


import java.util.Map;
import java.util.Stack;

public class RegisterOperation {
  private Map<String,Stack<Operation>> funcsOp;

  private final Stack<Operation> operations = new Stack<>();

  public void setOperations(Operation operation) {
    operations.push(operation);
  }

  public Operation getOperation(){
    return operations.pop();
  }

  public void setFuncsOp(String name, Stack<Operation> operations){
    funcsOp.put(name, operations);
  }
}
