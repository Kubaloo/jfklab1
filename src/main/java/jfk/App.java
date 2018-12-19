package jfk;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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

    public static ArrayList<String> listOfLines = new ArrayList<String>();
    public static HashMap<String, Object> variablesMap = new HashMap<>();
    public static void main(String[] args) {

        try {
            readFile("C:\\Users\\Kuba\\Downloads\\jfk\\out\\artifacts\\jfk_jar\\file.txt");
            for(String line: listOfLines){

                CommandReader(line);
            }
        } catch (IOException e) {

            e.printStackTrace();
        }


        while (true) {

            String insert;
            Scanner scanner = new Scanner(System.in);
            insert = scanner.nextLine();
           CommandReader(insert);
      }
    }

    public static ArrayList<String> readFile(String filePath) throws IOException {
        FileReader fileReader = new FileReader(filePath);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String textLine = bufferedReader.readLine();
        do {
            listOfLines.add(textLine);
            textLine = bufferedReader.readLine();
        } while (textLine != null);

        bufferedReader.close();
        return listOfLines;
    }


    public static void CommandReader(String input){
        String insert=input;
        InputRead inputReader = new InputRead(input);
        input = inputReader.readCommand();

            if (input.startsWith("s") || input.startsWith("S")) {
                SetCommand setCommand = new SetCommand(inputReader);
                variablesMap = setCommand.setVariable(variablesMap);
            } else {
                PrintCommand printCommand = new PrintCommand(inputReader, insert);
                printCommand.printVariable(variablesMap);
            }

    }
}


