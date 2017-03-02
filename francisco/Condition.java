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

	float[] calculateTestDataByCondition( float[] testData, int triang, FitnessFunction fit) {
		int Total = 0;
		//Condition condition = currentPath.get(i);
		int a = 0;
		int b = 0;
		a = calculateA(testData);
		b = calculateB(testData);

		if (fit.evaluateCondition(this.op, this.result, a, b) != 0) {
			Total = fit.evaluateCondition(this.op, this.result, a, b);
			testData = updateTestData(testData, Total);
			testData = updateTestData2(testData, Total);
		}
		triang = triangFunction(triang);
		
		return testData;
		
	}
	/**
	 * Returns triangFunction
	 * 
	 * @param condition
	 * 
	 * @param triang
	 * 
	 * @return int triang
	 */
	private int triangFunction(int triang) {

		int x = 0;
		for (int i = 1; i < 4; i++) {
			if (i == 1)
				x = 1;
			if (i == 2)
				x = 2;
			if (i == 3)
				x = 2;
			if (this.op == arrayOpt[2] && this.left == arrayVariables[0]
					&& this.right == arrayVariables[x] && this.result == arrayRes[0]) {
				triang = triang + i;
			}
		}
		return triang;
	}
	/**
	 * updateTestData2
	 * 
	 * @param condition
	 * 
	 * @param testData
	 * 
	 * @param Total
	 * 
	 * @return testData
	 */
	private float[] updateTestData2(float[] testData, int Total) {

		int j = 0;
		for (int i = 7; i < 10; i++) {
			if (i == 7)
				j = 2;
			if (i == 8)
				j = 0;
			if (i == 9)
				j = 1;

			if (this.left == arrayVariables[i]) {
				if ((this.op == arrayOpt[1] && this.result == arrayRes[0])
						|| (this.op == arrayOpt[1] && this.result == arrayRes[1])) {
					testData[j] += Total;
				}
				if ((this.op == arrayOpt[1] && this.result == arrayRes[0])
						|| (this.op == arrayOpt[1] && this.result == arrayRes[1])) {
					testData[j] -= Total;
				}
			}
		}
		return testData;
	}
	/**
	 * updateTestData
	 * 
	 * @param testData
	 * 
	 * @param condition
	 * 
	 * @param Total
	 * 
	 * @return new float testData
	 */
	private float[] updateTestData(float[] testData, int Total) {

		int max = 4;
		for (int i = 0; i < max; i++) {
			if (this.left == arrayVariables[i] && this.right == arrayVariables[3]) {
				testData[i] -= Total;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (this.left == arrayVariables[0] && this.right == arrayVariables[i]) {
				if (testData[0] < testData[i]) {
					testData[0] += Total;
				} else {
					testData[i] += Total;
				}
			}
		}

		int x = 1;
		int y = 1;

		if (this.left == arrayVariables[x] && this.right == arrayVariables[y]) {
			if (testData[x] < testData[y]) {
				testData[x] += Total;
			} else {
				testData[y] += Total;
			}
		}
		return testData;
	}	/**
	 * calculateB
	 * 
	 * @param testData
	 * 
	 * @param condition
	 * 
	 * @return returns b
	 */
	private int calculateB(float[] testData) {
		int b = 0;
		int[] arrayResult = new int[] { (int) testData[0], (int) testData[1], (int) testData[2], 0, 1, 2, 3 };
		int max = 7;
		for (int i = 0; i < max; i++) {
			b = arrayResult[i];
		}

		return b;
	}
	/**
	 * calculateB
	 * 
	 * @param testData
	 * 
	 * @param condition
	 * 
	 * @return returns a
	 */
	private int calculateA( float[] testData) {
		int triang = 0;
		int a = 0;
		int max = 7;
		int[] arrayResult = new int[] { (int) testData[0], (int) testData[1], (int) testData[2], (int) triang,
				(int) (testData[0] + testData[1]), (int) (testData[1] + testData[2]),
				(int) (testData[0] + testData[2]) };
		Variables[] array = new Variables[] { Variables.Vars1, Variables.Vars2, Variables.Vars3, Variables.third,
				Variables.Vartrian, Variables.Vars1s2, Variables.Vars2s3, Variables.Vars1s3 };
		for (int i = 0; i < max; i++) {
			if (this.left == array[i]) {
				a = arrayResult[i];
			}
		}
		return a;
	}
}
