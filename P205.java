import java.util.Random;
/**
 * Peter has nine four-sided (pyramidal) dice, each with faces numbered 1, 2, 3, 4.
 * Colin has six six-sided (cubic) dice, each with faces numbered 1, 2, 3, 4, 5, 6.
 * 
 * Peter and Colin roll their dice and compare totals: the highest total wins. 
 * The result is a draw if the totals are equal.
 * 
 * What is the probability that Pyramidal Pete beats Cubic Colin? Give your 
 * answer rounded to seven decimal places in the form 0.abcdefg
 * @author Antonio
 */

public class P205 {
    public static void main(String[] args) {
        Random rand = new Random();
        int numberoftimes = 2;
        int pl1WinsCount = 0,
                numberOfDicePl1=9,numberofDicePl2=6,
                numberOfFacesPl1=4,numberFacePl2=6;
        for(int totalNumberOfPlays=0;totalNumberOfPlays<numberoftimes;totalNumberOfPlays++){
            int pl1points=0,pl2points=0;
            for(int i=0;i<numberOfDicePl1;i++){
                pl1points += rand.nextInt() * numberOfFacesPl1 +1;
            }
            for(int i=0;i<numberofDicePl2;i++){
                pl2points+=rand.nextInt() * numberFacePl2+1;
            }
            if(pl1points > pl2points)
                pl1WinsCount++;
        }
        double percent = ((double)pl1WinsCount)/((double)numberoftimes);
        System.out.printf("f.7% of the time, 4 side will win",round(percent));
    }
    /**
     * just rounds to the 7th decimal
     * @param number the number you want to round to the 7th decimal
     * @return number rounded to the 7th decimal
     */
    public static double round(double number){
        number+=0.00000005;
        number/=10000000;
        number = ((int)number) *10000000;
        return number;
    }
}