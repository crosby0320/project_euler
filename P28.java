/**
 * Project Euler problem # 28
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 * 
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 * 
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * 
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * 
 * Answer: in this case i saw that the top right were all squares of the number 
 * of items in the rows to i just used that to my advantage and subtracted the 
 * number of numbers +1 from the square and so on and so one so that i would 
 * not have generate the matrix
 * 
 * @author Antonio
 */ 
public class P28 {
    public static void main(String[] args) {
        int numberoflines = 1001;
        int total = 1; // counting the first one
        
        //numbers on the top right are in this order
        for(int i=3;i<=numberoflines;i+=2){
            int topright = (int) Math.pow(i, 2);
            //this is the number at the top left of that
            int topleft = topright-i+1;
            int bottomleft = topleft-i+1;
            int bottomright = bottomleft-i+1;
            
            total += topleft + topright + bottomleft +bottomright;
            //System.out.printf("For pass %d we get %d %d %d %d = %d\n"
            //        ,i,topright,topleft,bottomleft,bottomright,total);
            // for debugging
        }
        System.out.println("The total is "+total);
    }
}
