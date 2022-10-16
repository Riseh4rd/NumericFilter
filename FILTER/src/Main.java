import java.util.*;
public class Main {
    public static final String RESET = "\033[0m";  // Text Reset
    // Regular Colors
    public static final String RED = "\033[0;31m";  // RED
    public static final String GREEN = "\033[0;32m";  // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";// RED
    public static final String B_BOLD_BRIGHT = "\033[1;97m";

    public static void main(String[] args) throws InterruptedException {
        int min=1;
        int max;
        System.out.println(B_BOLD_BRIGHT+"Please, Enter"+RED_BOLD_BRIGHT+ " maximum "+B_BOLD_BRIGHT+ "value:"+RESET);
        Scanner in = new Scanner(System.in);
        max = in.nextInt();
        int count = max - min+1;

//-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8
        ArrayList<Integer> arrayList = new ArrayList<>(count);
        Random random = new Random();

        while (arrayList.size() < count) {
            int i = random.nextInt(count) + 1;
            if (!arrayList.contains(i)) {
                arrayList.add(i);
            }
        }
        int[] randomArray = arrayList.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(randomArray));
//-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8-8
        System.out.print(B_BOLD_BRIGHT+"Save History?"+GREEN_BOLD_BRIGHT+"Y"+B_BOLD_BRIGHT+"/"+RED_BOLD_BRIGHT+"N"+RESET);
        boolean SaveHistory;
        int SaveHistoryTimer =1;
        Scanner inputstartYN = new Scanner(System.in);
        if (Objects.equals(inputstartYN.nextLine(), "Y")){ System.out.print(GREEN_BOLD_BRIGHT+"YES --- Saving history");SaveHistory=true;}
        else {System.out.print(RED_BOLD_BRIGHT+"NO --- Not Saving history");SaveHistory=false;SaveHistoryTimer = 2;}
        String start = inputstartYN.nextLine();
        int Slenght =start.length();
        String space =("\b");
        System.out.println(start+space.repeat(Slenght)+B_BOLD_BRIGHT+"starting...");
        int Counter = 0;
        int[] WorkArr = randomArray;

        do {
            System.out.print(RED+ WorkArr[Counter]+BLACK_BOLD+ "\t|\t"+RESET);
            Counter++;
        } while (Counter != count); Counter =0;


        System.out.println(" ");
//-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
        int ActiveCount = 0;
        int ActiveUnit;
        int ActiveMinimal = min;
        int FoundCaunt = 0;
//STARTING!!!
        while (true){
            ActiveUnit = WorkArr[ActiveCount];
            ActiveCount++;
        if (ActiveUnit == ActiveMinimal ){WorkArr[ActiveCount-1] = WorkArr[FoundCaunt]; WorkArr[FoundCaunt] = ActiveUnit;ActiveMinimal++;FoundCaunt++;ActiveCount = FoundCaunt;}
        if(ActiveCount == WorkArr.length){break;}



            Thread.sleep(500/SaveHistoryTimer);

            if(!SaveHistory){System.out.print(("\b").repeat(5*WorkArr.length));}
            else {System.out.println("");}

            int minCaunt = 0;
            do {
                if(WorkArr[Counter] == ActiveUnit){System.out.print(RED_BOLD_BRIGHT+WorkArr[Counter]+BLACK_BOLD+ "\t|\t"+RESET);}
                else if(WorkArr[Counter] == ActiveMinimal){System.out.print(GREEN_BOLD_BRIGHT+WorkArr[Counter]+BLACK_BOLD+ "\t|\t"+RESET);}
                else if(WorkArr[Counter] == WorkArr[FoundCaunt]){System.out.print(YELLOW+WorkArr[Counter]+BLACK_BOLD+ "\t|\t"+RESET);}
                else if((WorkArr[Counter] == WorkArr[minCaunt])&(WorkArr[Counter] < ActiveMinimal  )){System.out.print(GREEN+WorkArr[Counter]+BLACK_BOLD+ "\t|\t"+RESET);minCaunt++;}
                else {System.out.print(WorkArr[Counter]+BLACK_BOLD+ "\t|\t"+RESET);}
                Counter++;
            } while (Counter != count); Counter =0;

        }
        System.out.println("");
        do {
            System.out.print(GREEN_BOLD_BRIGHT+WorkArr[Counter]+BLACK_BOLD+ "\t|\t"+GREEN_BOLD_BRIGHT);
            Counter++;
        } while (Counter != count); Counter =0;
    }
}