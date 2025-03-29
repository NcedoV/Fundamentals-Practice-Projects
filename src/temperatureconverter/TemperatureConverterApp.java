package temperatureconverter;

import java.util.Scanner;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        double selectedTemperatureUnitCombination;
        byte userInputSelection = 0;
        char degSign = (int) 176;
        String terminateApplication = "Y";

        Scanner scanner = new Scanner(System.in);

        System.out.println("TEMPERATURE CONVERTER");
        System.out.println("---------------------");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Fahrenheit to Kelvin");
        System.out.println("4. Kelvin to Celsius");
        System.out.println("5. Kelvin to Fahrenheit");
        System.out.println("6. Celsius to Kelvin");
        System.out.println("7. Exit");

        while (true) { // The condition to be passed here should be (terminateApplication == "Y")
            userInputSelection = validateUserInput(scanner, userInputSelection);

            selectedTemperatureUnitCombination = Math.ceil(userInputSelection);

            selectConversionAndCalculateOutputTemperature((int) selectedTemperatureUnitCombination, degSign, scanner);

            System.out.print("Would you like to perfrom another conversion? (Y/N): ");
            terminateApplication = scanner.nextLine();

            if (terminateApplication == "Y")
                break;
            else
                terminateApplication = "N";
        }
    }

    private static byte validateUserInput(Scanner scanner, byte userInputSelection) {
        String inputSelection;
        do {
            System.out.print("\nSelect a conversion type(1/2.../7): ");
            inputSelection = scanner.nextLine();

            String numberRegex = "^[-+]?(\\d+(\\.\\d*)?|\\.\\d+)$";

            userInputSelection = inputIsANumber(inputSelection, numberRegex, userInputSelection);

            if (inputIsAValidMenuSelection(userInputSelection)) break;

        } while (true); //Replaced the following expression with the boolean "true". Not sure why and how it works. Do some research to explain: (userInputSelection < 1 || userInputSelection > 7)
        return userInputSelection;
    }

    private static void selectConversionAndCalculateOutputTemperature(int selectedTemperatureUnitCombination, char degSign, Scanner scanner) {
        float inputTemp;
        switch (selectedTemperatureUnitCombination) {
            case 1:
                System.out.print("\nPlease input temperature to convert to " + degSign + "C:  ");
                inputTemp = scanner.nextFloat();

                double tempFahrenheitToCelsius = (inputTemp - 32) * (double) 5 / (double) 9;
                System.out.println(String.format("%.2f", tempFahrenheitToCelsius) + (degSign + "C"));
                break;
            case 2:
                System.out.print("\nPlease input temperature to convert to " + degSign + "F:  ");
                inputTemp = scanner.nextFloat();

                double tempCelsiusToFahrenheit = inputTemp * (double) 9 / (double) 5 + 32;
                System.out.println(String.format("%.2f", tempCelsiusToFahrenheit) + (degSign + "F"));
                break;
            case 3:
                System.out.print("\nPlease input temperature to convert to " + degSign + "K:  ");
                inputTemp = scanner.nextFloat();

                double tempFahrenheitToKelvin = (inputTemp - 32) * (double) 5 / (double) 9 + 273.15D;
                System.out.println(String.format("%.2f", tempFahrenheitToKelvin) + (degSign + "K"));
                break;
            case 4:
                System.out.print("\nPlease input temperature to convert to " + degSign + "C:  ");
                inputTemp = scanner.nextFloat();

                float tempKelvinToCelsius = inputTemp - 273.15F;
                System.out.println(String.format("%.2f", tempKelvinToCelsius) + (degSign + "C"));
                break;
            case 5:
                System.out.print("\nPlease input temperature to convert to " + degSign + "F: ");
                inputTemp = scanner.nextFloat();

                float tempKelvinToFahrenheit = (inputTemp - 273.15F) * (float) 9 / (float) 5 + 32;
                System.out.println(String.format("%.2f", tempKelvinToFahrenheit) + (degSign + "F"));
                break;
            case 6:
                System.out.print("\nPlease input temperature to convert to " + degSign + "K: ");
                inputTemp = scanner.nextFloat();

                float tempCelsiusToKelvin = inputTemp + 273.15F;
                System.out.println(String.format("%.2f", tempCelsiusToKelvin) + (degSign + "K"));
                break;
            default:
                System.out.println("Ok, see again next time... GBye!");
        }
    }

    private static boolean inputIsAValidMenuSelection(byte userInputSelection) {
        if (userInputSelection >= 1 && userInputSelection <= 7)
            return true;
        else
            System.out.println("Error: Please input a number between 1 and 7.");
        return false;
    }

    private static byte inputIsANumber(String inputSelection, String numberRegex, byte userInputSelection) {
        if (inputSelection.matches(numberRegex)) {
            userInputSelection = Byte.parseByte(inputSelection);
        } else
            System.out.println("Error: Please enter a numeric value.");
        return userInputSelection;
    }
}