import java.io.*;

public class Day1 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        File f = new File("./input.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        long gallons = 0;
        String s;
        while((s = br.readLine()) != null) {
            long curr = Long.parseLong(s);
            gallons += calculateFuel(curr);
        }
        System.out.print(gallons);
    }

    public static long calculateFuel(long gallons) {
        if(gallons <= 0) return 0;
        else {
            long current = gallons/3 - 2;
            return Math.max(0,current) + calculateFuel(current);
        }
    }
}
