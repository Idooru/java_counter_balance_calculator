package calculator;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculatingPart {
    int[] moneyInput() {
        Scanner sc = new Scanner(System.in);
        int[] moneys = new int[6];
        int fiftyThousandWon;
        int tenThousandWon;
        int fiveThousandWon;
        int oneThousandWon;
        int fiveHundredWon;
        int oneHundredWon;

        System.out.print("\n"
                + "**** 금고안에 있는 잔액을 입력하세요 ****\n"
                + "<금액수는 숫자(정수형)으로 입력하세요>\n"
                + "\n");

        try {
            System.out.print("50000원 수 입력 >_");
            fiftyThousandWon = sc.nextInt() * 50000;

            System.out.print("10000원 수 입력 >_");
            tenThousandWon = sc.nextInt() * 10000;

            System.out.print("5000원 수 입력 >_");
            fiveThousandWon = sc.nextInt() * 5000;

            System.out.print("1000원 수 입력 >_");
            oneThousandWon = sc.nextInt() * 1000;

            System.out.print("500원 수 입력 >_");
            fiveHundredWon = sc.nextInt() * 500;

            System.out.print("100원 수 입력 >_");
            oneHundredWon = sc.nextInt() * 100;

            System.out.println();

            moneys[0] = fiftyThousandWon;
            moneys[1] = tenThousandWon;
            moneys[2] = fiveThousandWon;
            moneys[3] = oneThousandWon;
            moneys[4] = fiveHundredWon;
            moneys[5] = oneHundredWon;

        } catch (InputMismatchException err) {
            System.out.print("\n"
                    + "# 주의!\n"
                    + "잔액 입력 칸에 숫자(정수형)가 아닌 값이 들어갔습니다."
                    + "\n"
            );
        }


        return moneys;
    }

    int moneyAccumulator(int[] moneys) {
        int sum = 0;
        return Arrays.stream(moneys).map((idx) -> idx + sum).sum();
    }

    String[] showMeTheMoney(int sumResult) {
        LocalDateTime now = LocalDateTime.now();
        String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
        String totalAmount = String.format("계산된 총 금액은 %d원 입니다.", sumResult);
        String whenUse = String.format(formatNow + "에 사용하였습니다.");

        System.out.println(totalAmount);
        System.out.println(whenUse);

        return new String[]{totalAmount, whenUse};
    }
}
