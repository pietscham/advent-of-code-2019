import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day2 {

    public static void main(String[] args) throws Exception {
        File f = new File("./day2_input.txt");
        Scanner scanner = new Scanner(f);
        String[] line = scanner.next().split(",");
        scanner.close();
        int[] program = new int[line.length];
        int[] input = new int[line.length];
        for(int i = 0; i < line.length; i++) {
            input[i] = Integer.parseInt(line[i].trim());
            program[i] = Integer.parseInt(line[i].trim());
        }

        for(int i = 0; i < Integer.MAX_VALUE; i++) {
            for(int j = 0; j < Integer.MAX_VALUE; j++) {
                input[1] = i;
                input[2] = j;
                int res = calculateProgram(input);
                if(res == 19690720) {
                    System.out.println(i + " " + j);
                    System.exit(1);
                }
                if(res < 0 || res > 19690720) {
                    break;
                }

                for(int ii = 0; ii < input.length; ii++) {
                    input[ii] = program[ii];
                }
            }
        }
    }

    public static int calculateProgram(int[] input) {
        int len = input.length;
        for(int i = 0; i < len; i+=4) {
            int op = input[i];
            int indexA = input[i+1];
            int indexB = input[i+2];
            int pos = input[i+3];
            if(indexA >= len || indexB >= len || pos >= len) return -1;
            if(op == 1) {
                input[pos] = input[indexA] + input[indexB];
            }
            else if(op == 2) {
                input[pos] = input[indexA] * input[indexB];
            }
            else break;
        }
        return input[0];
    }
}
