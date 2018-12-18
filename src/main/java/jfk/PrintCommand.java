package jfk;

import java.util.HashMap;

public class PrintCommand {
    private InputRead inputReader;
    private String variable;
    private ValueCalculator valueCalculator = new ValueCalculator();
    private Object variableValue;


    public PrintCommand(InputRead inputReader) {
        this.inputReader = inputReader;
    }

    public void printVariable(HashMap<String, Object> variablesMap) {
        if (inputReader.isVariable()) {
            variable = inputReader.readVariable();
            if (variablesMap != null) {
                System.out.println(variablesMap.get(variable));
                variableValue = valueCalculator.calculate(inputReader.readValue());
            }
        }
    }
}
