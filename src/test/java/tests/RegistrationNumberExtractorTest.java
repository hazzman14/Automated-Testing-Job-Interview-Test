package tests;

import org.junit.Test;
import utility.RegistrationNumberExtractor;

import java.util.ArrayList;

import static org.junit.Assert.*;


public class RegistrationNumberExtractorTest {

    @Test
    public void testExtractRegistrationNumbers(){
        ArrayList<String> extractedRegistrationNumbers = new ArrayList<>();
        extractedRegistrationNumbers = RegistrationNumberExtractor.extractRegistrationNumbers();
        int numberOfItems = extractedRegistrationNumbers.size();
        assertTrue(numberOfItems>0);
    }
}
