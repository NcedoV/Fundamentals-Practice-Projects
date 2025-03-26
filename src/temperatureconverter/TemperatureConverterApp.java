package temperatureconverter;

import java.util.Scanner;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        int inputTemp = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("TEMPERATURE CONVERTER");
        System.out.println("---------------------");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Fahrenheit to Kelvin");
        System.out.println("5. Kelvin to Celsius");
        System.out.println("4. Kelvin to Fahrenheit");
        System.out.println("6. Celsius to Kelvin");
        System.out.println("7. Exit");

        System.out.print("\nSelect a conversion type(1/2.../7): ");
        byte tempUnitSelected = scanner.nextByte();
        char degSign = (int)176;

        switch (tempUnitSelected) {
            case 1:
                System.out.print("\nPlease input temperature to convert to " + degSign + "C:  ");
                inputTemp = scanner.nextInt();

                int tempInCelsius = (inputTemp - 32)  * 5 / 9;
                System.out.println(degSign+tempInCelsius);
                break;
            case 2:
                System.out.print("\nPlease input temperature to convert to " + degSign + "F:  ");
                inputTemp = scanner.nextInt();

                float tempInFahrenheit = (float)inputTemp * (5 / 9) + 32;
                System.out.println(degSign+tempInFahrenheit);
                break;
            case 3:
                System.out.print("\nPlease input temperature to convert to " + degSign + "K:  ");
                inputTemp = scanner.nextInt();

                double tempInKelvin = (float) (((inputTemp - 32) * (5 / 9)) + 273.15);
                System.out.println(degSign+tempInKelvin);
                break;
            case 4:
                System.out.print("\nPlease input temperature to convert to " + degSign + "C:  ");
                inputTemp = scanner.nextInt();
                break;
            case 5:
                System.out.print("\nPlease input temperature to convert to " + degSign + "F:  ");
                inputTemp = scanner.nextInt();
                break;
            case 6:
                System.out.print("\nPlease input temperature to convert to " + degSign + "K:  ");
                inputTemp = scanner.nextInt();
                break;
            default:
                    System.out.println("Ok, see again next time... GBye!");
        }
    }
}