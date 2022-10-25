import java.io.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Main {


    private final ArrayList<String> word = new ArrayList<>();
    int count = 0;

    private boolean readdic() {
        try {
            Scanner fScanner = new Scanner(new FileInputStream("words.txt"));
            while (fScanner.hasNext())
                word.add(fScanner.nextLine());
            fScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("단어 파일이 없습니다.");
            return false;
        }
        System.out.println("단어 파일 : word.txt.를 읽었습니다.");
        return true;
    }

    private void search() {


        Scanner sc = new Scanner(System.in);
        boolean match = false;

        while (true) {
            long beforeTime=0;
            long afterTime=0;
            long secDiffTime=0;


            System.out.print("단어>>");
            String input = sc.nextLine();
            beforeTime = System.currentTimeMillis();

            if (input.equals("그만")) {
                break;
            }

            for (String word : word) {
                if (word.length() <input.length())
                    continue;

                String cut = word.substring(0, input.length());

                if (cut.equals(input)) {
                    System.out.println(word);
                    count++;
                    match = true;
                }
            }
            System.out.println("검색된 단어의 개수 : "+count);

            if (!match) {
                System.out.println("없는 단어입니다.");
            }
            afterTime = System.currentTimeMillis();
            secDiffTime = (afterTime-beforeTime);
            System.out.println("runnig time : "+secDiffTime+"ms");

        }//while


    }

    public void run () {

        boolean readresult = readdic();
        if (readresult) {
            search();
            System.out.println("사전을 종료합니다.");
        }

    }
    public static void main (String[]args){

        Main m = new Main();
        m.run();

    }
}