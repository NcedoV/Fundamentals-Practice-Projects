package temperatureconverter;

import java.util.Scanner;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        int inputTemp;

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

        System.out.print("\nSelect a conversion type(1/2.../7): ");
        byte temperatureUnitCombination = scanner.nextByte();
        char degSign = (int)176;

        switch (temperatureUnitCombination) {
            case 1:
                System.out.print("\nPlease input temperature to convert to " + degSign + "C:  ");
                inputTemp = scanner.nextInt();

                double tempFahrenheitToCelsius = (inputTemp - 32)  * (double)5 / (double)9;
                System.out.println(String.format("%.2f",tempFahrenheitToCelsius) + (degSign + "C"));
                break;
            case 2:
                System.out.print("\nPlease input temperature to convert to " + degSign + "F:  ");
                inputTemp = scanner.nextInt();

                double tempCelsiusToFahrenheit = inputTemp * (double)9 / (double)5 + 32;
                System.out.println(String.format("%.2f",tempCelsiusToFahrenheit) + (degSign + "F"));
                break;
            case 3:
                System.out.print("\nPlease input temperature to convert to " + degSign + "K:  ");
                inputTemp = scanner.nextInt();

                double tempFahrenheitToKelvin = (inputTemp - 32) * (double)5 / (double)9 + 273.15D;
                System.out.println(String.format("%.2f",tempFahrenheitToKelvin) + (degSign + "K"));
                break;
            case 4:
                System.out.print("\nPlease input temperature to convert to " + degSign + "C:  ");
                inputTemp = scanner.nextInt();

                float tempKelvinToCelsius = inputTemp - 273.15F;
                System.out.println(String.format("%.2f",tempKelvinToCelsius) + (degSign + "C"));
                break;
            case 5:
                System.out.print("\nPlease input temperature to convert to " + degSign + "F: ");
                inputTemp = scanner.nextInt();

                float tempKelvinToFahrenheit = (inputTemp - 273.15F) * (float)9 / (float)5 + 32;
                System.out.println(String.format("%.2f",tempKelvinToFahrenheit) + (degSign + "F"));
                break;
            case 6:
                System.out.print("\nPlease input temperature to convert to " + degSign + "K: ");
                inputTemp = scanner.nextInt();

                float tempCelsiusToKelvin = inputTemp + 273.15F;
                System.out.println(String.format("%.2f",tempCelsiusToKelvin) + (degSign + "K"));
                break;
            default:
                    System.out.println("Ok, see again next time... GBye!");
        }
    }
}