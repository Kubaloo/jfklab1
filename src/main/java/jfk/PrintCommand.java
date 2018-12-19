package jfk;


import java.util.HashMap;


public class PrintCommand {
    private InputRead inputReader;

    private ValueCalculator valueCalculator = new ValueCalculator();
    private Object variableValue;
    private String insert;
    private String variable;


    public PrintCommand(InputRead inputReader, String insert) {
        this.inputReader = inputReader;
        this.insert = insert;
    }

    public void printVariable(HashMap<String, Object> variablesMap) {

        if (inputReader.isVariableToPrint()) {
            variable = valueCalculator.replaceVariable(inputReader.readValue(), variablesMap, false);
            if (variable != "calculateError") {
                variableValue = valueCalculator.calculate(variable);
                System.out.println(variableValue);
            }

        } else {
            System.out.println(inputReader.readNumberToPrint());
        }
    }

}

