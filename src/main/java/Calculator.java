import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        while (true) {
            int[] moneys = moneyInputer();
            int sumResult = moneyAccumulator(moneys);
            showMeTheMoney(sumResult);
        }
    }

    static int[] moneyInputer() {
        Scanner sc = new Scanner(System.in);
        int[] moneys = new int[5];
        int _10000원 = 0;
        int _5000원 = 0;
        int _1000원 = 0;
        int _500원 = 0;
        int _100원 = 0;

        System.out.print("\n"
                + "**** 금고안에 있는 잔액을 입력하세요 ****\n"
                + "<금액수는 숫자(정수형)으로 입력하세요>\n"
                + "<50000원 지폐는 10000원으로 계산하세요>\n"
                + "ex) 50000원 1장 = 10000원 5장\n"
                + "\n");

        try {
            System.out.print("10000원 수 입력 >_");
            _10000원 = sc.nextInt();
            System.out.printf("10000원 지폐가 %d(장) 있습니다.\n", _10000원);

            System.out.print("5000원 수 입력 >_");
            _5000원 = sc.nextInt();
            System.out.printf("5000원 지폐가 %d(장) 있습니다.\n", _5000원);

            System.out.print("1000원 수 입력 >_");
            _1000원 = sc.nextInt();
            System.out.printf("1000원 지폐가 %d(장) 있습니다.\n", _1000원);

            System.out.print("500원 수 입력 >_");
            _500원 = sc.nextInt();
            System.out.printf("500원 동전이 %d(개) 있습니다.\n", _500원);

            System.out.print("100원 수 입력 >_");
            _100원 = sc.nextInt();
            System.out.printf("100원 동전이 %d(개) 있습니다.\n", _100원);
        } catch (InputMismatchException err) {
            System.out.print("\n"
                    + "# 주의!\n"
                    + "잔액 입력 칸에 숫자(정수형)가 아닌 값이 들어갔습니다."
                    + "\n"
            );
        }

        moneys[0] = _10000원 * 10000;
        moneys[1] = _5000원 * 5000;
        moneys[2] = _1000원 * 1000;
        moneys[3] = _500원 * 500;
        moneys[4] = _100원 * 100;

        return moneys;
    }

    static int moneyAccumulator(int[] moneys) {
        int sum = 0;
        return Arrays.stream(moneys).map((idx) -> idx + sum).sum();
    }

    static void showMeTheMoney(int sumResult) {
        LocalDateTime now = LocalDateTime.now();
        String formatNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));

        System.out.printf("계산된 총 금액은 %d원 입니다.\n", sumResult);
        System.out.println(formatNow + "에 사용하였습니다.");
    }
}

