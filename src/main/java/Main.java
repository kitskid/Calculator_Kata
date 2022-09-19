import java.util.Scanner;

public class Main {

    public static String calc(String input) {
        String result;
        Calculator calculator = new Calculator(input);
        try {
            if (!calculator.validationString()) {
                throw new Exception("не верный формат выражения, проверьте ввод согласно описанию");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (calculator.isArabFirstNumber()) {
            System.out.println("вызываем на помощь калькулятор арабских чисел");
            result = "" + calculator.arabCalculator();
            return result;
        }
        if (calculator.isRimFirstNumber()) {
            System.out.println("вызываем на помощь калькулятор римских чисел");
            try {
                result = "" + calculator.rimCalculator();
                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return  null;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        String result = calc(inputString);
        if (result != null) {
            System.out.println("Результат: " + result);
        } else {
            throw new RuntimeException("Ошибка выполнения программы");
        }

    }
}