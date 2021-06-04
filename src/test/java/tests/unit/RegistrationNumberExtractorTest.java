package tests.unit;

import org.junit.Test;

import java.util.ArrayList;
import utility.*;
import static org.junit.Assert.*;


public class RegistrationNumberExtractorTest {

    @Test
    public void testExtractRegistrationNumbers(){
        ArrayList<String> extractedRegistrationNumbers = new ArrayList<>();
        extractedRegistrationNumbers = RegistrationNumberExtractor.extractRegistrationNumbers();
        int numberOfItems = extractedRegistrationNumbers.size();
        assertTrue(numberOfItems>0);
    }

    @Test
    public void testExtractOutput(){
        ArrayList<Car> cars = new ArrayList<>();
        cars = RegistrationNumberExtractor.extractOutput();
        int numberOFItems = cars.size();
        assertTrue(numberOFItems>0);
    }
}
