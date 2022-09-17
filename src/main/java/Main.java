import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        Calculator calculator = new Calculator(inputString);
        try {
            if (!calculator.validationString()) {
                throw new Exception("не верный формат выражения, проверьте ввод согласно описанию");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (calculator.isArabFirstNumber()) {
            System.out.println("вызываем на помощь калькулятор арабских чисел");
            System.out.println("Результат: " + calculator.arabCalculator());
        }
        if (calculator.isRimFirstNumber()) {
            System.out.println("вызываем на помощь калькулятор римских чисел");
            try {
                System.out.println("Результат: " + calculator.rimCalculator());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}