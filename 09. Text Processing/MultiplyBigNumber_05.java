package textProcessing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumber_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstInput = scanner.nextLine(); //"923847238931983192462832102"
        String secondInput = scanner.nextLine(); //"4"

        BigInteger firstNumber = new BigInteger(firstInput); //923847238931983192462832102
        BigInteger secondNumber = new BigInteger(secondInput);// 4

        System.out.println(firstNumber.multiply(secondNumber));
    }
}
