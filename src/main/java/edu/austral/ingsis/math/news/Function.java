package edu.austral.ingsis.math.news;

import java.util.List;

public interface Function {
  double evaluate();

  double evaluate(int value);

  List<String> getVariables();

  String toString();
}
