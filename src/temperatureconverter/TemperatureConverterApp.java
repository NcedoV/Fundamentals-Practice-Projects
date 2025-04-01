package temperatureconverter;

import java.util.Scanner;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        byte validateUserInputMenuSelection = 0;
        char degSign = (int) 176; //Temperature degree sign converted into a usable string from ASCII code.

        Scanner scanner = new Scanner(System.in);

        convertTemperature(validateUserInputMenuSelection, scanner, degSign);
    }

    private static void convertTemperature(double validateUserInputMenuSelection, Scanner scanner, char degSign) {
        double selectedTemperatureUnitCombination;
        String runProgramme;

        do {
            System.out.println("\n\nTEMPERATURE CONVERTER");
            System.out.println("---------------------");
            System.out.println("1. Fahrenheit to Celsius");
            System.out.println("2. Celsius to Fahrenheit");
            System.out.println("3. Fahrenheit to Kelvin");
            System.out.println("4. Kelvin to Celsius");
            System.out.println("5. Kelvin to Fahrenheit");
            System.out.println("6. Celsius to Kelvin");
            System.out.println("7. Exit");

            validateUserInputMenuSelection = validateUserInput(scanner, validateUserInputMenuSelection);

            selectedTemperatureUnitCombination = Math.ceil(validateUserInputMenuSelection);

            selectConversionTypeAndCalculateOutputTemperature((int) selectedTemperatureUnitCombination, degSign, scanner);

            runProgramme = reRunProgramme(scanner);
        } while (runProgramme.equals("Y"));

    }

    private static String reRunProgramme(Scanner scanner) {
        String terminateApplication;

        System.out.print("\nWould you like to perform another conversion? (Y/N): ");
        terminateApplication = scanner.next();

        String continueApplication = terminateApplication.toUpperCase();

        if (continueApplication.equals("N")) {
            System.out.println("\nAll good, see again another time... GBye!");
        }

        return continueApplication;
    }

    private static double validateUserInput(Scanner scanner, double userInputSelection) {
        String inputSelection;

        do {
            System.out.print("\nSelect a conversion type(1/2.../7): ");
            scanner = new Scanner(System.in);
            inputSelection = scanner.nextLine();

            String numberRegex = "^[-+]?(\\d+(\\.\\d*)?|\\.\\d+)$";

            userInputSelection = inputIsANumber(inputSelection, numberRegex, userInputSelection);

        } while (!inputIsAValidMenuSelection(userInputSelection));
        return userInputSelection;
    }

    private static void selectConversionTypeAndCalculateOutputTemperature(int selectedTemperatureUnitCombination, char degSign, Scanner scanner) {
        float inputTemp;
        switch (selectedTemperatureUnitCombination) {
            case 1:
                System.out.print("\nEnter temperature in Fahrenheit to convert to " + degSign + "C:  ");
                inputTemp = scanner.nextFloat();

                double tempFahrenheitToCelsius = (inputTemp - 32) * (double) 5 / (double) 9;
                System.out.println(String.format(inputTemp + (degSign + "F") + " is equal to %.2f", tempFahrenheitToCelsius) + (degSign + "C"));
                break;
            case 2:
                System.out.print("\nEnter temperature in Celsius to convert to " + degSign + "F:  ");
                inputTemp = scanner.nextFloat();

                double tempCelsiusToFahrenheit = inputTemp * (double) 9 / (double) 5 + 32;
                System.out.println(String.format(inputTemp + (degSign + "C") + " is equal to %.2f", tempCelsiusToFahrenheit) + (degSign + "F"));
                break;
            case 3:
                System.out.print("\nEnter temperature in Fahrenheit to convert to " + degSign + "K:  ");
                inputTemp = scanner.nextFloat();

                double tempFahrenheitToKelvin = (inputTemp - 32) * (double) 5 / (double) 9 + 273.15D;
                System.out.println(String.format(inputTemp + (degSign + "F") + " is equal to %.2f", tempFahrenheitToKelvin) + (degSign + "K"));
                break;
            case 4:
                System.out.print("\nEnter temperature in Kelvin to convert to " + degSign + "C:  ");
                inputTemp = scanner.nextFloat();

                float tempKelvinToCelsius = inputTemp - 273.15F;
                System.out.println(String.format(inputTemp + (degSign + "K") + " is equal to %.2f", tempKelvinToCelsius) + (degSign + "C"));
                break;
            case 5:
                System.out.print("\nEnter temperature in Kelvin to convert to " + degSign + "F: ");
                inputTemp = scanner.nextFloat();

                float tempKelvinToFahrenheit = (inputTemp - 273.15F) * (float) 9 / (float) 5 + 32;
                System.out.println(String.format(inputTemp + (degSign + "K") + " is equal to %.2f", tempKelvinToFahrenheit) + (degSign + "F"));
                break;
            case 6:
                System.out.print("\nEnter temperature in Celsius to convert to " + degSign + "K: ");
                inputTemp = scanner.nextFloat();

                float tempCelsiusToKelvin = inputTemp + 273.15F;
                System.out.println(String.format(inputTemp + (degSign + "K") + " is equal to %.2f", tempCelsiusToKelvin) + (degSign + "K"));
                break;
            default:
                System.out.println("Ok, see again next time... GBye!");
                break;
        }
    }

    private static boolean inputIsAValidMenuSelection(double userInputSelection) {
        if (userInputSelection >= 1 && userInputSelection <= 7)
            return true;
        else
            System.out.println("Error: Please input a number between 1 and 7.");
        return false;
    }

    private static double inputIsANumber(String inputSelection, String numberRegex, double userInputSelection) {

        if (inputSelection.matches(numberRegex)) {
            userInputSelection = Double.parseDouble(inputSelection);
        }
        else {
            System.out.println("Error: Please enter a numeric value.");
        }

        return userInputSelection;
    }
}