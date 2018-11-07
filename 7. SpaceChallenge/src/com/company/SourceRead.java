package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SourceRead {

    public static int phase = 1;


    public static File SetSourceFilePathPhase() {

        File file;
        switch (phase){
            case 1: file = new File("/Users/Yaro/repository/Java/Java SI Assignments/7. SpaceChallenge/src/Phase-1.txt");
                phase ++;
                return file;
            default: file = new File ("/Users/Yaro/repository/Java/Java SI Assignments/7. SpaceChallenge/src/Phase-2.txt");
                return file;
        }
    }



    public static ArrayList<Item> ReadFile(File file) throws FileNotFoundException {
        ArrayList<Item> itemsListFromFile = new ArrayList<>();    //define an array, will store objects item
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {                           // get the name and weight of the item
            String line = scanner.nextLine();
            String[] arrayWordsInLine = line.split("=");
            Item item = new Item(arrayWordsInLine[0], Integer.parseInt(arrayWordsInLine[1]));
            itemsListFromFile.add(item);                          // add name and weight to the object.name and object.weight
        }
        return itemsListFromFile;
    }
}
