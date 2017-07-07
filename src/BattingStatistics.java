import java.util.Scanner;

/**
 * Created by Nathan Saleniuc on 7/5/2017.
 */
public class BattingStatistics {
    public static void main(String[] args) {
        String cont = "y";
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Batting Average Calculator!");

        //2. Ask for the number of at bats
        while (cont.equalsIgnoreCase("y")) {
            System.out.println("Enter number of times at bat:");
            int timesAtBat = scan.nextInt();

            int[] battingResults = new int[timesAtBat];

            //3. Display at-bat result possibilities
            System.out.println("0= out, 1= single, 2= double, 3= triple, 4= home run");

            //4. Input at-bat results into array
            fillArray(scan, battingResults);
            
//        5. Calculate batting average
            getBattingAvg(timesAtBat, battingResults);

            //6. Calculate slugging percentage

            getSluggingPct(timesAtBat, battingResults);
            System.out.println();

            scan.nextLine();
            System.out.println("Another Batter?");
            cont = scan.nextLine();
            while (!cont.equalsIgnoreCase("y")) {
                if ((!(cont.equalsIgnoreCase("y"))) && !(cont.equalsIgnoreCase("n"))) {
                    System.out.println("Invalid entry, please type y/n");
                    cont = scan.nextLine();
                }
            }
        }
        System.out.println("Goodbye");

    }

    public static void fillArray(Scanner scan, int[] battingResults) {
        for (int i = 0; i < battingResults.length; i++) {
            System.out.print("Please enter result for at-bat " + i + " : ");
            int userNum = scan.nextInt();
            battingResults[i] = userNum;
            while (!(userNum >= 0 && userNum <= 4)) {
                if (userNum < 0 || userNum > 4) {
                    System.out.println("Invalid entry, try a number 0-4");
                    userNum = scan.nextInt();
                    continue;
                }
            }
        }
    }

    public static void getBattingAvg(int timesAtBat, int[] battingResults) {
        double sum = 0;
        for (int result : battingResults) {
            if (result > 0) {
                sum += 1;
            }
        }
        double battingAvg = sum / timesAtBat;
        System.out.printf("Batting Average: %.3f", battingAvg);
    }

    public static void getSluggingPct(int timesAtBat, int[] battingResults) {
        double total = 0;
        for (int result : battingResults) {
            total += result;
        }

        double sluggingPct = total / timesAtBat;
        System.out.println();
        System.out.printf("Slugging Percentage: %.3f", sluggingPct);
        System.out.println();
    }
}
