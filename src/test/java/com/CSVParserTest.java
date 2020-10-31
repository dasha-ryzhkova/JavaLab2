package com;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.*;

public class CSVParserTest {

//    @Test
//    public void testReadCSVFile() {
//        //parser.readCSVFile();
//    }
//
//    @Test
//    public void testParseCSV() {
//
//    }

    @Test
    public void testExtractWordFromLine() {
        CSVParser pars = new CSVParser(',' , '"');
        pars.wordsOfLine = new ArrayList<>();
        assertEquals("\"\" \"\",\"\"Australia\"\"\"", pars.extractWordFromLine("\"12,\"\"AU\"\",\"\" \"\",\"\"Australia\"\"\""));
    }

    @Test
    public void testDeleteQuotesOfLine() {
        CSVParser pars = new CSVParser(',' , '"');
        assertEquals("\"Australia\"\"", pars.deleteQuotesOfLine("\"\"Australia\"\"\""));
    }

    @Test
    public void testDeleteDoubleQuotesInWord() {
        CSVParser pars = new CSVParser(',' , '"');
        assertEquals("Aus\"\"tralia", pars.deleteDoubleQuotesInWord("Aus\"\"\"\"tralia"));
    }
}