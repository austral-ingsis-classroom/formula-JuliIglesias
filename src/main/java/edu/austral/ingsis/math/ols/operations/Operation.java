package edu.austral.ingsis.math.ols.operations;

import java.util.List;

public interface Operation {

  Double doOperation(List<Double> numbers);

  String getType();
}
