package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationNumberExtractor {

    private static Logger log = LogManager.getLogger(RegistrationNumberExtractor.class);


    public static ArrayList<String> extractRegistrationNumbers(){
        //this is the format of a number plate, allows for a space or no space
        Pattern pattern = Pattern.compile("[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}");
        ArrayList<String> extractedRegistrationNumbers = new ArrayList<String>();
        //try to take in the file and find this pattern on each line, putting into array list
        try {
            File inputFile = new File("car_input.txt");
            Scanner myScanner = new Scanner(inputFile);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                Matcher matcher = pattern.matcher(data);
                while(matcher.find()){
                    log.info("found: " + matcher.group());
                    extractedRegistrationNumbers.add(matcher.group());
                }
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            log.error("File not found");
            e.printStackTrace();
        }
        return extractedRegistrationNumbers;
    }
}
