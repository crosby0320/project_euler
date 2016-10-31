import java.util.*;
/**
 * the class will create groupings of a set were all the elements in the set
 * are accounted for in every set. we use the power sets of the sets and get 
 * the power sets of those sets till we get to the last iteration then just 
 * print the last elements.
 * 
 * for use age all you have to do is select a number of kids and candy bars
 * and the class will give you a set of solutions for different ways that you 
 * can split up the candy bars between the kids making sure you have no candy 
 * bars remaining
 * 
 * 
 * ex: 2 candy  and 2 kids
 * one kid can have all the candy and the other kid can have all the candy 
 * thats 2 different solutions then we can split the candys thats 2 more 
 * solutions this is what that looks like 
 * 
 * solution    kid 1      kid 2
 *    0          []     [A, B]
 *    1         [B]        [A]
 *    2         [A]        [B]
 *    3      [A, B]         []
 * 
 * @author crosby
 *
 */
public class ComboClass {
	public static int candy = 10, kids = 5, counter = 0;
	public static char[] letters = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
			'I', 'J', 'K', 'L', 'M', 'N' };

	public static void main(String[] args) {
		ArrayList<Character> list = new ArrayList<Character>();
		for (int i = 0; i < kids; i++) {
			list.add(letters[i]);
		}

		String l = "";

		List<List<Character>> ps = powerset(list);
		Iteration(list, l, 0);
	}
	/**
	 * recursive function that gets the List of characters and make a power set
	 * of the characters and add the sets to a string getting the power sets of 
	 * its sets incrementing the iteration could every time it gets into the 
	 * next loop until it gets down to the last iteration were it just prints
	 * the rest of the Characters  
	 * @param listGoingIn
	 * @param pastCalculations
	 * @param iteration
	 */
	public static void Iteration(ArrayList<Character> listGoingIn, 
			String pastCalculations, int iteration) {
		//if at the last 2 iterations just print out the rest else keep going
		if (iteration >= candy - 2) {
			List<List<Character>> ps = powerset(listGoingIn);

			for (List<Character> x : ps) {
				ArrayList<Character> list = new ArrayList<Character>(listGoingIn);
				list.removeAll(x);
				String n = new Formatter().format("%4d %s %10s %10s",
						counter++, pastCalculations, x, list).toString();
				System.out.println(n);
			}
		} else {
			List<List<Character>> ps = powerset(listGoingIn);

			for (List<Character> x : ps) {
				ArrayList<Character> list = new ArrayList<Character>(listGoingIn);
				list.removeAll(x);
				String n = new Formatter().format(
						"%s  %10s  ", pastCalculations, x)
						.toString();
				Iteration(list, n, iteration + 1);
			}
		}
	}
	/**
	 * power set function takes in an Collection and makes a power set from 
	 * it
	 * @param list to be made into a power set
	 * @return the power set
	 */
	public static <T> List<List<T>> powerset(Collection<T> list) {
		List<List<T>> ps = new ArrayList<List<T>>();
		ps.add(new ArrayList<T>()); // add the empty set

		// for every item in the original list
		for (T item : list) {
			List<List<T>> newPs = new ArrayList<List<T>>();

			for (List<T> subset : ps) {
				// copy all of the current powerset's subsets
				newPs.add(subset);

				// plus the subsets appended with the current item
				List<T> newSubset = new ArrayList<T>(subset);
				newSubset.add(item);
				newPs.add(newSubset);
			}

			// powerset is now powerset of list.subList(0, list.indexOf(item)+1)
			ps = newPs;
		}
		return ps;
	}
}
