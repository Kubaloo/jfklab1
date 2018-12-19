package jfk;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputRead {

    private final String statement;
    private String readed;
    private String pattern;

    InputRead(String statement) {
        this.statement = statement;
    }

    String readCommand() {
        pattern = "(set|Set|SET|print|Print|PRINT)\\s";
        read(pattern, "action");
        return readed;
    }

    String readVariable() {

        pattern = "[a-zA-Z0-9]+,";
        read(pattern, "variable");
        String var = readed;

        return var.substring(0, var.length() - 1);
    }

    String readNumberToPrint() {
        pattern = "[0-9]+";
        read(pattern);
        return readed;
    }
    boolean isVariableToPrint(){
            pattern = "[a-zA-Z]+";
            read(pattern);
            return readed != null;
    }
    boolean isVariable() {
        pattern = "[a-zA-Z]+,";
        read(pattern);
        return readed != null;
    }

    String readValue() {

        pattern = "[0-9a-zA-Z\\+\\-\\*\\(\\)]+$";
        read(pattern, "mathematical operation");

        return readed;

    }

    private void read(String pattern, String partOfStatement) {

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(statement);
        try {
            readed = null;
            matcher.find();
            readed = matcher.group();

        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ERROR (Incorrect " + partOfStatement + ")");
        }

    }

    private void read(String pattern) {

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(statement);
        try {
            readed = null;
            matcher.find();
            readed = matcher.group();
        } catch (Exception ignored) {
        }

    }

}
