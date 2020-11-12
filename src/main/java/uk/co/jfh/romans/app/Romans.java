package uk.co.jfh.romans.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;

public class Romans {

    private static InputStream inputStream = System.in;
    private static OutputStream outputStream = System.out;

    private static final Map<Integer, String> UNITS = Map.of(1, "I", 2, "II", 3, "III", 4, "IV", 5, "V", 6, "VI", 7,
            "VII", 8, "VIII", 9, "IX");

    private static final Map<Integer, String> TENS = Map.of(10, "X", 20, "XX", 30, "XXX", 40, "XL", 50, "L", 60, "LX",
            70, "LXX", 80, "LXXX", 90, "XC");

    private static final Map<Integer, String> HUNDREDS = Map.of(100, "C", 200, "CC", 300, "CCC", 400, "CD", 500, "D",
            600, "DC", 700, "DCC", 800, "DCCC", 900, "CM");

    private static final Map<Integer, String> THOUSANDS = Map.of(1000, "M", 2000, "MM", 3000, "MMM");

    public static void main(String[] args) {
        String convertedValue;
        String input = getUserInput();
        if (validateInput(input)) {
            convertedValue = convertInput(input);
        } else {
            convertedValue = "Invalid input";
        }
        outputConvertedValue(convertedValue);
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
            result.append(THOUSANDS.get(thousands));
        }
        if (hundreds > 0) {
            result.append(HUNDREDS.get(hundreds));
        }
        if (tens > 0) {
            result.append(TENS.get(tens));
        }
        if (units > 0) {
            result.append(UNITS.get(units));
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
