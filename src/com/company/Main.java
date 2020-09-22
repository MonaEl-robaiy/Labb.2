package com.company;
import java.io.File;
import java.util.Scanner;
public class Main {
    public static boolean hasFoundWord = false;

    public static void main(String[] args) {
        File startingFolder = new File("/Users/monael-robaiy/Desktop/Labb2/testdata");
        Scanner sc = new Scanner(System.in);
        System.out.println("sök efter ett ord");
        String word = sc.next();
        printInfo(startingFolder, word);
    }

    public static void readFile(File file, String wordFile) {
        try {
            Scanner sc = new Scanner(file);
            String word;
            while (sc.hasNext()) {
                if (wordFile.equals(sc.next())) {
                    System.out.println(file.getAbsolutePath());
                    hasFoundWord = true;
                }
            }
            sc.close();
        } catch (Exception e) {
        }
    }

    public static void printInfo(File file, String word) {
        if (!file.canRead()) {
            System.out.println("System error");
            return;
        }

        if (file.isFile()) {
            readFile(file, word);
        } else if (file.isDirectory()) {
            try {
                File[] folderContents = file.listFiles();
                for (File f : folderContents) {
                    printInfo(f, word);
                }
            } catch (Exception e) {
                System.out.println("Ooops");
            }

        }

    }
}
