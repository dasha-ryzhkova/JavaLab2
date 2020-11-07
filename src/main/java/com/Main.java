package com;

import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException
    {
        Scanner scanner = new Scanner (System.in);

        System.out.println("Enter file path:");
        String path = new String("C:\\Users\\VivoBook\\Desktop\\lab2.csv");
        File f = new File(path);
        if (f.exists())
        {
            System.out.println("Enter delimiter:");
            char del = ',';

            System.out.println("Enter new delimiter:");
            char newdel = '+';

            System.out.println("Enter path for new file:");
            String newpath = new String("C:\\Users\\VivoBook\\Desktop\\result.txt");   //scanner.next().CharAt();


            CSVParser parser = new CSVParser(newpath, del, '"', newdel);
            parser.readCSVFile(path);

        }
        else
            System.out.println("File does not exist.\n");

        scanner.close();
    }
}
