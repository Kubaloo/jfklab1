package jfk;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.io.EOFException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetCommand {
    private InputRead inputReader;
    private String variable;
    private Object variableValue;
    private ValueCalculator valueCalculator = new ValueCalculator();


    public SetCommand(InputRead inputReader) {
        this.inputReader = inputReader;

    }

    public HashMap<String, Object> setVariable(HashMap<String, Object> variables) {

        if (inputReader.isVariable()) {
            variable = inputReader.readVariable();
            if (variables.size() != 0) {
                variableValue = valueCalculator.replaceVariable(inputReader.readValue(), variables, true);
                if (variableValue != "noVariableError") {
                    variableValue = valueCalculator.calculate((String) variableValue);
                } else {
                    return variables;
                }
            } else {
                variableValue = valueCalculator.replaceVariable(inputReader.readValue(), variables, true);
                variableValue = valueCalculator.calculate(inputReader.readValue());
            }
            if (variableValue != "calculateError") {
                variables.put(variable, variableValue);
                System.out.println("#" + variable + "=" + variableValue);
                return variables;
            } else {
                System.out.println("calculation error");
                return variables;
            }
        } else {
            System.out.println("Not valid variable");
        }
        return variables;
    }


}


