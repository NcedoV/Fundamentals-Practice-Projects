package temperatureconverter;

import java.util.Scanner;

public class TemperatureConverterApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("TEMPERATURE CONVERTER");
        System.out.println("---------------------");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.println("3. Fahrenheit to Kelvin");
        System.out.println("4. Kelvin to Fahrenheit");
        System.out.println("5. Celsius to Kelvin");
        System.out.println("6. Kelvin to Celsius");
        System.out.println("7. Exit");

        System.out.print("\nMake your selection:");
        byte tempUnitSelection = scanner.nextByte();




    }
}