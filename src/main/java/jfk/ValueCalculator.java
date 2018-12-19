package jfk;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValueCalculator {

    private ScriptEngineManager mgr = new ScriptEngineManager();
    private ScriptEngine engine = mgr.getEngineByName("JavaScript");

    public ValueCalculator() {

    }

    public Object calculate(String value) {

        try {
            return engine.eval(value);

        } catch (ScriptException e) {

            return "calculateError";

        }
    }

    public String replaceVariable(String variableValue, HashMap<String, Object> variables, boolean isSetCommand) {

        String pattern = "[a-zA-Z]+[0-9]*";
        Pattern regex = Pattern.compile(pattern);

        Matcher matcher = regex.matcher(variableValue);

        while (matcher.find()) {
            if (!variables.containsKey(matcher.group())) {
                if (isSetCommand) {
                    System.out.println("ERROR no variable");
                } else {
                    System.out.println("???");
                }
                return "noVariableError";
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
