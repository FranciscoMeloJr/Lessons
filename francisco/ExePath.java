package tp6305.francisco;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Class for Execution Path
public class ExePath {
	static boolean[] arrayRes = new boolean[] { true, false };
	static Operators[] arrayOpt = new Operators[] { Operators.less, Operators.greater, Operators.equal };
	static Variables[] arrayVariables = new Variables[] { Variables.Vars1, Variables.Vars2, Variables.Vars3,
			Variables.zero, Variables.first, Variables.second, Variables.third, Variables.Vartrian, Variables.Vars1s2,
			Variables.Vars2s3, Variables.Vars1s3 };

	
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

	int id;
	List<Condition> branches;

	ExePath(int i) {
		if (i == 1) {
			branches = Condition.createBranchesList(array1);
		}
		if (i == 2) {
			branches = Condition.createBranchesList(array2);
		}
		if (i == 3) {
			branches = Condition.createBranchesList(array3);
		}
		if (i == 4) {
			branches = Condition.createBranchesList(array4);
		}
		if (i == 5) {
			branches = Condition.createBranchesList(array5);
		}
		if (i == 6) {
			branches = Condition.createBranchesList(array6);
		}
		if (i == 7) {
			branches = Condition.createBranchesList(array7);
		}
		if (i == 8) {
			branches = Condition.createBranchesList(array8);
		}
		if (i == 9) {
			branches = Condition.createBranchesList(array9);
		}
		if (i == 10) {
			branches = Condition.createBranchesList(array10);
		}
		if (i == 11) {
			branches = Condition.createBranchesList(array11);
		}
		if (i == 12) {
			branches = Condition.createBranchesList(array12);
		}
		if (i == 13) {
			branches = Condition.createBranchesList(array13);
		}
		if (i == 14) {
			branches = Condition.createBranchesList(array14);
		}
		id = i;
	}
	
	static ArrayList<ExePath> createExePaths(){
		ArrayList<ExePath> paths = new ArrayList<ExePath>();
		for (int i = 1; i < 15; i++) {
			ExePath e = new ExePath(i);
			paths.add(e);
		}
		return paths;
	}
	
	ExePath(int i, List<Condition> br) {
		branches = new ArrayList<Condition>();
		branches = br;
		id = i;
	}
	
	ExePath(List<Condition> br) {
		branches = new ArrayList<Condition>();
		branches = br;
		Random rand = new Random();
		id = rand.nextInt(1000)+1;
	}
	
	List<Condition> getBranches() {
		return branches;
	}
	
	Condition getBrancheId(int index) {
		return branches.get(index);
	}
	
	float[] runPath(float[] testData, int triang, FitnessFunction fit) {
		int tri = triang;
		for(Condition each: getBranches() ){
			testData = each.calculateTestDataByCondition(testData, tri, fit);
		}
		return testData;
		
	}
	
}
