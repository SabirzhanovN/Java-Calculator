import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Converter converter = new Converter();

        System.out.println("Введите 2 числа(арабских/римских) и операцию(+-/*): ");
        String input = scan.nextLine();

        // find operation
        char operation = '0';
        for (int i = 0; i < input.length(); i++){
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*' || input.charAt(i) == '/'){
                operation = input.charAt(i);
                break;
            }
        }

        // find 2 operands
        String num1="", num2="";
        try {
            String[] operands = input.split("[-+*/]");
            if (operands.length != 2) throw new Exception("Введите только 2 числа!");
            if (operands[1].equals("0") && operation == '/') throw new Exception("Нельзя делить на 0!");

            num1 = operands[0];
            num2 = operands[1];
        } catch (ArrayIndexOutOfBoundsException ex){
            System.out.println(ex + "\nНеизвестная операция!");
            System.exit(1);
        } catch (Exception ex) {
            System.out.println(ex);
            System.exit(1);
        }

        if (!converter.isRoman(num1) && !converter.isRoman(num2)){
            try {
                int number1 = Integer.parseInt(num1);
                int number2 = Integer.parseInt(num2);

                if (number1 > 10 || number2 > 10) throw new Exception("Числа не должны превышать 10!");

                switch (operation) {
                    case '+' -> System.out.println(number1 + number2);
                    case '-' -> System.out.println(number1 - number2);
                    case '*' -> System.out.println(number1 * number2);
                    case '/' -> System.out.println(number1 / number2);
                }

            } catch (NumberFormatException ex){
                System.out.println(ex + "\nВведите арабские или римские числа!");
            } catch (Exception ex){
                System.out.println(ex);
            }
        } else {

            int number1 = converter.romanToInt(num1);
            int number2 = converter.romanToInt(num2);

            int result = 0;

            switch (operation) {
                case '+' -> result = number1 + number2;
                case '-' -> result = number1 - number2;
                case '*' -> result = number1 * number2;
                case '/' -> result = number1 / number2;
            }

            if (result < 0){
                System.out.println("Рузультат не может быть меньше 0!");
                System.exit(1);
            } else {
                System.out.println(converter.intToRoman(result));
            }
        }
    }
}