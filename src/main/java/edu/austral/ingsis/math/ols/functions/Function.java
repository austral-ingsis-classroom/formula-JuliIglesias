package edu.austral.ingsis.math.ols.functions;

import java.util.Map;
import java.util.Set;

public interface Function {
  double evaluate(Map<String, Double> variables);
  String getType();
  String getFunction();
}
