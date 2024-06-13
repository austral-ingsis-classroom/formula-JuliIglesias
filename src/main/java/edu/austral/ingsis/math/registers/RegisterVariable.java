package edu.austral.ingsis.math.registers;

import java.util.Map;

public record RegisterVariable(Map<String, Double> variables) {

  public void addVariable(String var, Double val) {
    variables.put(var, val);
  }

  public Double getVariableValue(String name) {
    return variables.get(name);
  }
}
