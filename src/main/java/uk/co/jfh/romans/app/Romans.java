package uk.co.jfh.romans.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import uk.co.jfh.romans.conf.Mappings;

public class Romans {

    private static InputStream inputStream = System.in;
    private static OutputStream outputStream = System.out;

    public static void main(String[] args) {
        String response;
        String input = getUserInput();
        if (validateInput(input)) {
            response = convertInput(input);
        } else {
            response = "Invalid input";
        }
        outputConvertedValue(response);
    }

    public static void outputConvertedValue(String convertedValue) {
        try (BufferedWriter consoleWriter = new BufferedWriter(new OutputStreamWriter(outputStream))) {
            consoleWriter.write(convertedValue);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String convertInput(String input) {
        Integer value = Integer.parseInt(input);
        Integer thousands = (value / 1000) * 1000;
        Integer hundreds = (value - thousands) / 100 * 100;
        Integer tens = (value - thousands - hundreds) / 10 * 10;
        Integer units = (value - thousands - hundreds - tens);
        StringBuilder result = new StringBuilder();
        if (thousands > 0) {
            result.append(Mappings.THOUSANDS.get(thousands));
        }
        if (hundreds > 0) {
            result.append(Mappings.HUNDREDS.get(hundreds));
        }
        if (tens > 0) {
            result.append(Mappings.TENS.get(tens));
        }
        if (units > 0) {
            result.append(Mappings.UNITS.get(units));
        }
        return result.toString();
    }

    public static Boolean validateInput(String input) {
        int integer;
        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        if (integer < 1 || integer > 3999) {
            return false;
        }
        return true;
    }

    public static String getUserInput() {
        String input = null;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(inputStream))) {
            input = consoleReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public static InputStream getInputStream() {
        return inputStream;
    }

    public static void setInputStream(InputStream inputStream) {
        Romans.inputStream = inputStream;
    }

    public static OutputStream getOutputStream() {
        return outputStream;
    }

    public static void setOutputStream(OutputStream outputStream) {
        Romans.outputStream = outputStream;
    }

}
