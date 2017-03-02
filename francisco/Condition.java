package tp6305.francisco;

import java.util.ArrayList;
import java.util.List;

public class Condition {

	static boolean[] arrayRes = new boolean[] { true, false };
	static Operators[] arrayOpt = new Operators[] { Operators.less, Operators.greater, Operators.equal };
	static Variables[] arrayVariables = new Variables[] { Variables.Vars1, Variables.Vars2, Variables.Vars3,
			Variables.zero, Variables.first, Variables.second, Variables.third, Variables.Vartrian, Variables.Vars1s2,
			Variables.Vars2s3, Variables.Vars1s3 };

	public Variables left;
	public Operators op;
	public Variables right;
	public boolean result;

	public Condition(Variables v1, Operators operator, Variables v2, boolean result) {
		this.left = v1;
		this.op = operator;
		this.right = v2;
		this.result = result;
	}

	/**
	 * This function creates a Condition from an array
	 * 
	 * @param array
	 *            information that is in the arrays above
	 */
	public static Condition createCondition(int v1, int op, int v2, int res) {
		return new Condition(arrayVariables[v1], arrayOpt[op], arrayVariables[v2], arrayRes[res]);
	}

	/**
	 * This function creates a Condition from an array
	 * 
	 * @param array
	 *            information that is in the arrays above
	 */
	public static Condition createCondition(int[] array) {
		return new Condition(arrayVariables[array[0]], arrayOpt[array[1]], arrayVariables[array[2]],
				arrayRes[array[3]]);
	}

	// All the conditions are described below -although not enhanced, this is
	// much easy to understand:

	static int cond1[] = new int[] { 0, 0, 3, 0 };
	static int cond2[] = new int[] { 0, 0, 3, 1 };
	static int cond3[] = new int[] { 1, 0, 3, 0 };
	static int cond4[] = new int[] { 1, 0, 3, 1 };
	static int cond5[] = new int[] { 2, 0, 3, 1 };
	static int cond6[] = new int[] { 0, 2, 1, 1 };
	static int cond7[] = new int[] { 1, 2, 2, 1 };
	static int cond8[] = new int[] { 0, 2, 2, 0 };
	static int cond9[] = new int[] { 7, 2, 3, 1 };
	static int cond10[] = new int[] { 7, 1, 6, 1 };
	static int cond11[] = new int[] { 7, 2, 4, 1 };
	static int cond12[] = new int[] { 7, 2, 5, 1 };
	static int cond13[] = new int[] { 7, 2, 6, 0 };
	static int cond14[] = new int[] { 10, 1, 1, 0 };
	static int cond15[] = new int[] { 10, 1, 1, 1 };
	static int cond16[] = new int[] { 2, 0, 3, 0 };
	static int cond17[] = new int[] { 7, 2, 5, 0 };
	static int cond18[] = new int[] { 9, 1, 0, 1 };
	static int cond19[] = new int[] { 0, 2, 2, 1 };
	static int cond20[] = new int[] { 8, 0, 2, 0 };
	static int cond21[] = new int[] { 7, 2, 5, 0 };
	static int cond22[] = new int[] { 9, 1, 0, 0 };
	static int cond23[] = new int[] { 7, 2, 6, 1 };
	static int cond24[] = new int[] { 7, 2, 4, 0 };
	static int cond25[] = new int[] { 8, 1, 2, 1 };
	static int cond26[] = new int[] { 1, 0, 2, 1 };
	static int cond27[] = new int[] { 2, 0, 2, 1 };
	static int cond28[] = new int[] { 9, 0, 0, 1 };
	static int cond30[] = new int[] { 8, 1, 2, 0 };
	static int cond31[] = new int[] { 1, 2, 2, 0 };
	static int cond32[] = new int[] { 0, 2, 1, 0 };
	static int cond33[] = new int[] { 10, 0, 1, 1 };
	static int cond34[] = new int[] { 7, 1, 3, 1 };
	static int cond35[] = new int[] { 7, 1, 6, 0 };
	static int cond36[] = new int[] { 7, 2, 2, 0 };
	static int cond37[] = new int[] { 7, 2, 3, 0 };
	static int cond38[] = new int[] { 8, 0, 2, 1 };
	static int cond39[] = new int[] { 10, 0, 1, 0 };
	static int cond40[] = new int[] { 8, 0, 0, 0 };
	static int cond41[] = new int[] { 0, 0, 2, 1 };

	// the arrays below describe each one of the paths:
	static int array14[][] = new int[][] { cond1, cond4, cond5, cond7, cond8, cond9, cond11, cond12, cond13, cond15 };

	static int array13[][] = new int[][] { cond2, cond4, cond5, cond6, cond7, cond8, cond9, cond10, cond11, cond12,
			cond13, cond14 };

	static int array12[][] = new int[][] { cond2, cond4, cond5, cond6, cond19, cond31, cond9, cond10, cond11, cond21,
			cond18, cond23 };

	static int array11[][] = new int[][] { cond2, cond4, cond5, cond6, cond19, cond31, cond9, cond10, cond11, cond21,
			cond22 };

	static int array10[][] = new int[][] { cond2, cond4, cond5, cond7, cond19, cond32, cond9, cond10, cond24, cond25,
			cond12, cond23 };
	static int array9[][] = new int[][] { cond2, cond4, cond5, cond7, cond19, cond32, cond23, cond10, cond24, cond30 };
	static int array8[][] = new int[][] { cond2, cond4, cond5, cond32, cond31, cond8, cond34, cond35 };
	static int array7[][] = new int[][] { cond41, cond26, cond27, cond6, cond7, cond19, cond36, cond8, cond28, cond33 };
	static int array6[][] = new int[][] { cond2, cond4, cond5, cond6, cond7, cond19, cond37, cond8, cond28, cond39 };
	static int array5[][] = new int[][] { cond2, cond4, cond5, cond6, cond7, cond19, cond37, cond8, cond40 };
	static int array4[][] = new int[][] { cond2, cond4, cond5, cond6, cond7, cond19, cond37, cond20 };
	static int array3[][] = new int[][] { cond2, cond4, cond16 };
	static int array2[][] = new int[][] { cond2, cond3 };
	static int array1[][] = new int[][] { cond1 };

	/**
	 * This function creates all the paths:
	 * 
	 * @param int
	 *            The path to be created
	 */
	static protected List<Condition> createPath(int i) {
		List<Condition> branches = new ArrayList<Condition>();
		ExePath ex;

		ex = new ExePath(i);
		branches = ex.getBranches();

		return branches;
	}

	/**
	 * Function to create branch list from an array:
	 * 
	 * @param array
	 *            Array with the conditions
	 */
	static List<Condition> createBranchesList(int array[][]) {
		ArrayList<int[]> list = new ArrayList<int[]>();

		for (int each1[] : array) {
			list.add(each1);
		}

		List<Condition> branches = new ArrayList<Condition>();
		for (int[] each2 : list) {
			branches.add(Condition.createCondition(each2));
		}

		return branches;
	}

}
