package by.jmp.module09.task5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 2/15/2016.
 */
public class Runner {

    public static List<String> lineList;

    public static void main(String arg[]) {

        System.out.println("PID:" + ManagementFactory.getRuntimeMXBean().getName());

        lineList = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("src\\main\\resources\\TaskData.txt"));


            String line = null;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }

                for(int i = 0; i < line.length(); i+=3) {
                    char[] subLine = new char[3];
                    line.getChars(i, i+3, subLine, 0);
                    lineList.add(new String(subLine));
                }
                Thread.sleep(5);
                System.out.println("Line list size: " + lineList.size());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
