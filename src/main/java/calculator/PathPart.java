package calculator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class PathPart {
    String path = System.getProperty("user.home");
    String desktopPath = path + "\\Desktop\\log";

    void createLogDirectory() {
        try {
            Files.createDirectory(Path.of(desktopPath));
        } catch (FileAlreadyExistsException ignored) {
        } catch (NoSuchFileException e) {
            System.out.println("디렉터리 경로가 존재하지 않습니다.");
        } catch (IOException e) {
            System.out.println("뜻밖의 에러가 발생하였습니다. 관리자에게 문의하세요.");
        }
    }

    void createLogFile(String[] stringResults, int[] moneys) {
        String totalAmount = stringResults[0];
        String whenUse = stringResults[1];

        int fiftyThousandCount = moneys[0] / 50000;
        int tenThousandCount = moneys[1] / 10000;
        int fiveThousandCount = moneys[2] / 5000;
        int oneThousandCount = moneys[3] / 1000;
        int fiveHundredCount = moneys[4] / 500;
        int oneHundredCount = moneys[5] / 100;

        String year = whenUse.substring(0, 4);
        String month = whenUse.substring(6, 8);
        String day = whenUse.substring(10, 12);
        String hour = whenUse.substring(14, 16);
        String minute = whenUse.substring(18, 20);
        String second = whenUse.substring(22, 24);

        try {
            String timeFormat = year + "년-" + month + "월-" + day + "일-" + hour + "시-" + minute + "분-" + second + "초 실행 기록";
            File file = new File(desktopPath + "\\" + timeFormat + ".txt");
            boolean result = file.createNewFile();

            if (result) {
                FileWriter fw = new FileWriter(file);
                BufferedWriter writer = new BufferedWriter(fw);

                String log = String.format(
                        "50000 x %d = %d\n"
                                + "10000 x %d = %d\n"
                                + "5000 x %d = %d\n"
                                + "1000 x %d = %d\n"
                                + "500 x %d = %d\n"
                                + "100 x %d = %d\n"
                                + "%s",
                        fiftyThousandCount, moneys[0],
                        tenThousandCount, moneys[1],
                        fiveThousandCount, moneys[2],
                        oneThousandCount, moneys[3],
                        fiveHundredCount, moneys[4],
                        oneHundredCount, moneys[5],
                        totalAmount
                );

                writer.write(log);
                writer.close();
            } else {
                throw new Exception();
            }


        } catch (IOException e) {
            System.out.println("뜻밖의 에러가 발생하였습니다. 관리자에게 문의하세요.");
        } catch (Exception e) {
            System.out.println("Program Error");
        }


    }
}
