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
    private ArrayList<String> listOfLines = new ArrayList<>();

    public static void main(String[] args) {

        HashMap<String, Object> variablesMap = new HashMap<>();

//        try {
//
//            for(String line: readFile("C:\\Users\\Kuba\\Downloads\\jfk\\out\\artifacts\\jfk_jar\\file.txt")){
//                fileOutput(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        while (true) {
            String command;
            String insert;
            Scanner scanner = new Scanner(System.in);

            insert = scanner.nextLine();

            InputRead inputReader = new InputRead(insert);

            command = inputReader.readCommand();
            if (command != null) {
                if (command.startsWith("s") || command.startsWith("S")) {
                    SetCommand setCommand = new SetCommand(inputReader);
                    variablesMap = setCommand.setVariable(variablesMap);
                } else {
                    PrintCommand printCommand = new PrintCommand(inputReader, insert);
                    printCommand.printVariable(variablesMap);
                }
            }
        }

    }

//    public static ArrayList<String> readFile(String filePath) throws IOException {
//        FileReader fileReader = new FileReader(filePath);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        ArrayList<String> listOfLines = new ArrayList<>();
//        String textLine = bufferedReader.readLine();
//        do {
//            listOfLines.add(textLine);
//            textLine = bufferedReader.readLine();
//        } while (textLine != null);
//
//        bufferedReader.close();
//        return listOfLines;
//    }
//
//    public static void fileOutput(String nextLine) {
//
//        HashMap<String, Object> variablesMapFile = new HashMap<>();
//        String input = nextLine;
//
//        InputRead inputReader = new InputRead(input);
//        input = inputReader.readCommand();
//        if (input != null) {
//            if (input.startsWith("s") || input.startsWith("S")) {
//                SetCommand setCommand = new SetCommand(inputReader);
//                variablesMapFile = setCommand.setVariable(variablesMapFile);
//                if (variablesMapFile == null) {
//
//                }
//
//
//            } else {
//                PrintCommand printCommand = new PrintCommand(inputReader, nextLine);
//                printCommand.printVariable(variablesMapFile);
//
//            }
//        }
//    }
//
//}

}

