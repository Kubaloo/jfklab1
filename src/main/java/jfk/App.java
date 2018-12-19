package jfk;

import jdk.internal.util.xml.impl.Input;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {

        HashMap<String, Object> variablesMap = new HashMap<>();

        while (true) {
            String input = "";

            String insert;
            Scanner scanner = new Scanner(System.in);

            insert = scanner.nextLine();

            InputRead inputReader = new InputRead(insert);

            input = inputReader.readCommand();

            if (input.startsWith("s") || input.startsWith("S")) {
                SetCommand setCommand = new SetCommand(inputReader);
                variablesMap = setCommand.setVariable(variablesMap);
                if (variablesMap == null) {
                    System.out.println("blad zmienna nie istnieje");
                }
                System.out.println(variablesMap);


            } else {
                PrintCommand printCommand = new PrintCommand(inputReader);
                printCommand.printVariable(variablesMap);

            }
        }

    }


}
