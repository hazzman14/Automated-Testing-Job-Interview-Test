package utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationNumberExtractor {

    private static Logger log = LogManager.getLogger(RegistrationNumberExtractor.class);


    public static ArrayList<String> extractRegistrationNumbers() {
        //this is the format of a number plate, allows for a space or no space
        Pattern pattern = Pattern.compile("[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}");
        ArrayList<String> extractedRegistrationNumbers = new ArrayList<>();
        //try to take in the file and find this pattern on each line, putting into array list
        try {
            File inputFile = new File("car_input.txt");
            Scanner myScanner = new Scanner(inputFile);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                Matcher matcher = pattern.matcher(data);
                while (matcher.find()) {
                    log.info("found: " + matcher.group());
                    extractedRegistrationNumbers.add(matcher.group());
                    System.out.println("printing: " + matcher.group());
                }
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            log.error("File not found");
            e.printStackTrace();
        }
        return extractedRegistrationNumbers;
    }

    public static ArrayList<Car> extractOutput() {
        ArrayList<Car> cars = new ArrayList<>();
        String[] stringarray = null;
        //try to take the file and break each line by comma, make sure first section is a reg number and
        // then make it a car object and add to ArrayList of cars
        try {
            File inputFile = new File("car_output.txt");
            Scanner myScanner = new Scanner(inputFile);
            while (myScanner.hasNextLine()) {
                String data = myScanner.nextLine();
                stringarray = data.split(",");
                if(stringarray[0].matches("[A-Z]{2}[0-9]{2}\\s?[A-Z]{3}")){
                    int year = Integer.parseInt(stringarray[4]);
                    Car car = new Car(stringarray[0],stringarray[1],stringarray[2],stringarray[3],year);
                    cars.add(car);
                }
            }
            myScanner.close();
        } catch (FileNotFoundException e) {
            log.error("File not found");
            e.printStackTrace();
        }
        return cars;
    }
}
