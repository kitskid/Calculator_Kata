
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private String inputString;
    private String[] rimNumber = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
    private String[] arabNumber = {"1","2","3","4","5","6","7","8","9","10"};
    private String[] operations = {"+","-","*","/"};

    private boolean isArabFirstNumber = false;
    private boolean isArabSecondNumber = false;
    private boolean isRimFirstNumber = false;
    private boolean isRimSecondNumber = false;
    private boolean isOperation = false;
    private String[] partOfInputString;
    private int firstNumber;
    private int secondNumber;
    private String operationCurrent;

    public Calculator(String inputString) {
        this.inputString = inputString;
        this.partOfInputString = this.inputString.split("\\s");
    }

    public boolean isArabFirstNumber() {
        return isArabFirstNumber;
    }

    public boolean isRimFirstNumber() {
        return isRimFirstNumber;
    }
    public int arabCalculator(){

        switch (operationCurrent){
            case "+":
                return firstNumber+secondNumber;
            case "-":
                return firstNumber-secondNumber;
            case "*":
                return firstNumber*secondNumber;
            case "/":
                return firstNumber%secondNumber;
            default:
                return 404;
        }
    }
    public String rimCalculator() throws Exception {
        int result = arabCalculator();
        String resultString = "";
        if(result <=0 ) {
            throw new Exception("римское число не может быть отрицательным или 0");
        }
        int a = result/10;
        int b = result%10;
        if (a >= 1 && a <=3) {
            for(int i = 1; i<=a; i++) {
                resultString = resultString + "X"; 
            }
            
        } else if (a == 4) {
            resultString = "XL";
        } else if (a >= 5 && a <=  8) {
            resultString = "L";
            for (int i = 1; i<=a-5; i++) {
                resultString = resultString + "X";
            }
        } else if (a == 9) {
            resultString = "XC";
        } else if (a == 10){
            resultString = "C";
        }

        if (b == 0) {
            return resultString;
        } else {
            for (int i = 0; i < rimNumber.length; i++) {
                if((i+1) == b){
                    resultString = resultString + rimNumber[i];
                }
            }
        }


        return resultString;
    }
    public boolean validationString() throws Exception {


        if (!(partOfInputString.length == 3) || partOfInputString[1].equals("")) {
            throw new Exception("Ошибка ввода");
        }
        List<String> operationList = new ArrayList(Arrays.asList(operations));
        if(!operationList.contains(partOfInputString[1])){
            throw new Exception("введенная арифметическая операция не является допустимой");
        }
        isOperation = true;
        for(String operation: operationList) {
            if (operation.equals(partOfInputString[1])){
                operationCurrent = operation;
            }
        }
        if (operationCurrent == null) {
            throw new Exception();
        }

        List<String> rimNumberList = new ArrayList(Arrays.asList(rimNumber));
        if(rimNumberList.contains(partOfInputString[0])){
            if(rimNumberList.contains(partOfInputString[2])){
                isRimFirstNumber = true;
                isRimSecondNumber = true;
                for(String str1: rimNumberList) {
                    if(str1.equals(partOfInputString[0])) {
                        firstNumber = rimNumberList.indexOf(str1) + 1;
                    }
                }
                for(String str2: rimNumberList) {
                    if(str2.equals(partOfInputString[2])) {
                        secondNumber = rimNumberList.indexOf(str2) + 1;
                    }
                }
                return true;
            } else {
                throw new Exception("не верный формат выражения, второе число не является римским");
            }
        } else {
            List<String> arabNumberList = new ArrayList(Arrays.asList(arabNumber));
            if(arabNumberList.contains(partOfInputString[0])){
                if(arabNumberList.contains(partOfInputString[2])){
                    isArabFirstNumber = true;
                    isArabSecondNumber = true;
                    try {
                        firstNumber = Integer.parseInt(partOfInputString[0]);
                        secondNumber = Integer.parseInt(partOfInputString[2]);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return true;
                } else {
                    throw new Exception("не верный формат выражения, второе число не является арабским");
                }
            }
        }



        return false;
    }
}
