import java.util.ArrayList;

/*
 * https://projecteuler.net/archives
 * Problems that were presented on project Euler
 */
/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1
 * to 10 without any remainder.
 * 
 * What is the smallest positive number that is evenly divisible by all of the
 * numbers from 1 to 20?
 * 
 * @author crosby
 * 
 */
public class Problem005 {
	public static void main(String[] args) {
		/*
		 */
		int upTo = 20;
		/*
		 */
		ArrayList<Integer> primesList = getListOfPrimes(upTo);
		
		int multiple = getMultipleOfList(primesList);
		boolean flag = true;
		for(int i=1;;i++){
			for(int j=1;j<=upTo && flag;j++){
				if(multiple*i % j != 0){
					flag = false;
				}
			}
			if(flag){
				System.out.println(multiple*i);
				System.exit(0);
			}
			flag = true;
		}
	}

	public static int getMultipleOfList(ArrayList<Integer> list){
		int mult=1;
		for(Integer x:list){
			mult= x * mult;
		}
		return mult;
	}
	public static boolean checkIfPrime(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static ArrayList<Integer> getListOfPrimes(int numberToGoUpTo){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=3;i<numberToGoUpTo;i++){
			if(checkIfPrime(i)){
				list.add(0, i);
			}
		}
		return list;
	}
}
