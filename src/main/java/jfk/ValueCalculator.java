package jfk;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ValueCalculator {

    private ScriptEngineManager mgr = new ScriptEngineManager();
    private ScriptEngine engine = mgr.getEngineByName("JavaScript");

    public ValueCalculator() {

    }

    public Object calculate(String value) {

        try {
            return engine.eval(value);

        } catch (ScriptException e) {
            e.printStackTrace();
            return null;

        }
    }
}
