package jfk;

import com.sun.xml.internal.fastinfoset.util.StringArray;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetCommand {
    private InputRead inputReader;
    private String variable;
    private Object variableValue;
    private ValueCalculator valueCalculator = new ValueCalculator();
    private boolean errorOcurred = false;

    public SetCommand(InputRead inputReader) {
        this.inputReader = inputReader;

    }

    public HashMap<String, Object> setVariable(HashMap<String, Object> variables) {
        String temp = "";
        if (inputReader.isVariable()) {
            variable = inputReader.readVariable();
            if (variables.size() != 0) {
                temp = replaceVariable(inputReader.readValue(), variables);
                if (temp != "error") {
                    variableValue = valueCalculator.calculate(temp);
                } else {
                    return variables;
                }
            } else {
                variableValue = valueCalculator.calculate(inputReader.readValue());
            }

            variables.put(variable, variableValue);
            System.out.println("#" + variable + "=" + variableValue);
            return variables;
        } else {
            System.out.println("Not valid variable");
        }
        return variables;
    }

    private String replaceVariable(String variableValue, HashMap<String, Object> variables) {
        String pattern = "[a-zA-Z]+[0-9]*";
        Pattern regex = Pattern.compile(pattern);

        Matcher matcher = regex.matcher(variableValue);

        while (matcher.find()) {
            if (!variables.containsKey(matcher.group())) {
                System.out.println("ERROR no variable");
                return "error";
            }

            int variable = (int) variables.get(matcher.group());
            String a1 = matcher.group();
            String a2 = String.valueOf((variable));
            String replacedValue;
            replacedValue = variableValue.replace(a1, a2);
            variableValue = replacedValue;

        }
        return variableValue;

    }

}


