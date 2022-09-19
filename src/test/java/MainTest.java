import java.util.ArrayList;
import java.util.List;

//вспомогательный тест
public class MainTest {

    static String[] rimNumber = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

    static String[] operations = {"+","*"};

    public static void main(String[] args) {
        List<String> testStrings = new ArrayList<>();
        for (String operation : operations) {
            for (String s : rimNumber) {
                for (String value : rimNumber) {
                    testStrings.add(s + " " + operation + " " + value);

                }
            }
        }
        for (String s:testStrings) {
            String result = Main.calc(s);
            if (result != null) {
                System.out.println(s);
                System.out.println("Результат: " + result);
            } else {
                throw new RuntimeException("Ошибка выполнения программы");
            }
        }

    }

}
