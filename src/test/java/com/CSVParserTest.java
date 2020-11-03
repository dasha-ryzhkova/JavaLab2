package com;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CSVParserTest {

    @Test
    public void testReadCSVFile() {
        Scanner scanner = new Scanner (System.in);

        String path = new String("C:\\Users\\VivoBook\\Desktop\\lab2.csv");
        File f = new File(path);
        if (f.exists())
        {
            char del = ',';
            char newdel = '+';
            String newpath = new String("C:\\Users\\VivoBook\\Desktop\\result.txt");   //scanner.next().CharAt();
            CSVParser parser = new CSVParser(path, newpath, del, '"', newdel);
            parser.readCSVFile();
            assertEquals("q2!cvb", parser.linesArr.get(0).get(2));
        }
        scanner.close();
    }

    @Test
    public void testParseCSV() {
        ArrayList<ArrayList<String>> linesArr = new ArrayList<>();
        ArrayList<String> wordsOfLine = new ArrayList<>();
        CSVParser pars = new CSVParser(',' , '"');
        pars.outputFile = "result1.txt";
        ArrayList<String>lines = new ArrayList<>();
        lines.add("abc,1234,q2!cvb");
        pars.parseCSV(lines);
        assertEquals("abc", pars.linesArr.get(0).get(0));
    }

    @Test(expected = NullPointerException.class)
    public void testExtractWordFromLineNull() {
        CSVParser pars = new CSVParser(',' , '"');
        pars.wordsOfLine = null;
        assertEquals("\"\" \"\",\"\"Australia\"\"\"", pars.extractWordFromLine("\"12,\"\"AU\"\",\"\" \"\",\"\"Australia\"\"\""));
    }

    @Test
    public void testExtractWordFromLine() {
        CSVParser pars = new CSVParser(',' , '"');
        pars.wordsOfLine = new ArrayList<>();
        assertEquals("\"\" \"\",\"\"Australia\"\"\"", pars.extractWordFromLine("\"12,\"\"AU\"\",\"\" \"\",\"\"Australia\"\"\""));


//        assertEquals("1234,q!bv5", pars.extractWordFromLine("abc,1234,q!bv5"));
//        assertEquals("q!bv5", pars.extractWordFromLine("1234,q!bv5"));
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteQuotesOfLineNull(){
        CSVParser pars = new CSVParser(',' , '"');
        String str = null;
        assertEquals("\"Australia\"\"", pars.deleteQuotesOfLine(str));
    }

    @Test
    public void testDeleteQuotesOfLine() {
        CSVParser pars = new CSVParser(',' , '"');
        assertEquals("\"Australia\"\"", pars.deleteQuotesOfLine("\"\"Australia\"\"\""));
    }

    @Test(expected = NullPointerException.class)
    public void testDeleteDoubleQuotesInWordNull() {
        CSVParser pars = new CSVParser(',' , '"');
        String str = null;
        assertEquals("Aus\"\"tralia", pars.deleteDoubleQuotesInWord(str));
    }

    @Test
    public void testDeleteDoubleQuotesInWord() {
        CSVParser pars = new CSVParser(',' , '"');
        assertEquals("Aus\"\"tralia", pars.deleteDoubleQuotesInWord("Aus\"\"\"\"tralia"));
    }
}