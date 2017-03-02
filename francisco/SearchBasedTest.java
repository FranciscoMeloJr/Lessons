package tp6305.francisco;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tp6305.CoverageTest;

/**
 * This class does the Search Based Test:
 *
 */
public class SearchBasedTest extends CoverageTest {

	// Variables to make the tests easy:
	static boolean[] arrayRes = new boolean[] { true, false };
	static Operators[] arrayOpt = new Operators[] { Operators.less, Operators.greater, Operators.equal };
	static Variables[] arrayVariables = new Variables[] { Variables.Vars1, Variables.Vars2, Variables.Vars3,
			Variables.zero, Variables.first, Variables.second, Variables.third, Variables.Vartrian, Variables.Vars1s2,
			Variables.Vars2s3, Variables.Vars1s3 };

	// Fitness function:
	private FitnessFunction fit = new FitnessFunction();
	public List<List<Condition>> ExePathcurrent = new ArrayList<List<Condition>>();
	
	public ArrayList<ExePath> paths = new ArrayList<ExePath>();
	private int iterationExePath = 0;

	// To accumulate the branches:
	private List<String> branches = new ArrayList<String>();

	/**
	 * This function generates the test data:
	 * 
	 * @param builder
	 * 
	 * @param testData
	 *
	 */
	protected void generateTestData(StringBuilder builder, float[] testData) {
		
		Random rand = new Random();
		int maxRand = 1000;
		int triang = 0;
		
		testData[0] = rand.nextInt(maxRand)+1;
		testData[1] = rand.nextInt(maxRand)+1;
		testData[2] = rand.nextInt(maxRand)+1;

		paths.clear();
		startBranches();
		ExePath exe = paths.get(iterationExePath);
		
		//For each condition in the current Path:
		testData = exe.runPath(testData, triang, fit);
		//testData = runPath(exe, testData, triang);
		
		for (int i = 0; i < testData.length; i++) {
			builder.append(testData[i]).append(", ");
		}
		iterationExePath++;
		if (iterationExePath == 14)
			iterationExePath = 0;

	}
	private float[] runPath(ExePath exe, float[] testData, int triang) {
		int tri = triang;
		for(Condition each: exe.getBranches() ){
			testData = calculateTestDataByCondition(each, testData, tri);
		}
		return testData;
		
	}
	/**
	 * Returns the new testData 
	 * 
	 * @param condition
	 * 
	 * @param testData
	 * 
	 * @param triang
	 * 
	 * @return new TestData
	 */
	float[] calculateTestDataByCondition(Condition condition, float[] testData, int triang) {
		int Total = 0;
		//Condition condition = currentPath.get(i);
		int a = 0;
		int b = 0;
		a = calculateA(condition, testData);
		b = calculateB(condition, testData);

		if (fit.evaluateCondition(condition.op, condition.result, a, b) != 0) {
			Total = fit.evaluateCondition(condition.op, condition.result, a, b);
			testData = updateTestData(testData, condition, Total);
			testData = updateTestData2(testData, condition, Total);
		}
		triang = triangFunction(condition, triang);
		
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
	private int triangFunction(Condition condition, int triang) {

		int x = 0;
		for (int i = 1; i < 4; i++) {
			if (i == 1)
				x = 1;
			if (i == 2)
				x = 2;
			if (i == 3)
				x = 2;
			if (condition.op == arrayOpt[2] && condition.left == arrayVariables[0]
					&& condition.right == arrayVariables[x] && condition.result == arrayRes[0]) {
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
	private float[] updateTestData2(float[] testData, Condition condition, int Total) {

		int j = 0;
		for (int i = 7; i < 10; i++) {
			if (i == 7)
				j = 2;
			if (i == 8)
				j = 0;
			if (i == 9)
				j = 1;

			if (condition.left == arrayVariables[i]) {
				if ((condition.op == arrayOpt[1] && condition.result == arrayRes[0])
						|| (condition.op == arrayOpt[1] && condition.result == arrayRes[1])) {
					testData[j] += Total;
				}
				if ((condition.op == arrayOpt[1] && condition.result == arrayRes[0])
						|| (condition.op == arrayOpt[1] && condition.result == arrayRes[1])) {
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
	private float[] updateTestData(float[] testData, Condition condition, int Total) {

		int max = 4;
		for (int i = 0; i < max; i++) {
			if (condition.left == arrayVariables[i] && condition.right == arrayVariables[3]) {
				testData[i] -= Total;
			}
		}

		for (int i = 0; i < 3; i++) {
			if (condition.left == arrayVariables[0] && condition.right == arrayVariables[i]) {
				if (testData[0] < testData[i]) {
					testData[0] += Total;
				} else {
					testData[i] += Total;
				}
			}
		}

		int x = 1;
		int y = 1;

		if (condition.left == arrayVariables[x] && condition.right == arrayVariables[y]) {
			if (testData[x] < testData[y]) {
				testData[x] += Total;
			} else {
				testData[y] += Total;
			}
		}
		return testData;
	}
	/**
	 * calculateB
	 * 
	 * @param testData
	 * 
	 * @param condition
	 * 
	 * @return returns b
	 */
	private int calculateB(Condition condition, float[] testData) {
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
	private int calculateA(Condition condition, float[] testData) {
		int triang = 0;
		int a = 0;
		int max = 7;
		int[] arrayResult = new int[] { (int) testData[0], (int) testData[1], (int) testData[2], (int) triang,
				(int) (testData[0] + testData[1]), (int) (testData[1] + testData[2]),
				(int) (testData[0] + testData[2]) };
		Variables[] array = new Variables[] { Variables.Vars1, Variables.Vars2, Variables.Vars3, Variables.third,
				Variables.Vartrian, Variables.Vars1s2, Variables.Vars2s3, Variables.Vars1s3 };
		for (int i = 0; i < max; i++) {
			if (condition.left == array[i]) {
				a = arrayResult[i];
			}
		}
		return a;
	}

	/**
	 * Returns a branch coverage
	 * 
	 * @param instrumentingOutputs
	 * 
	 * @param testData
	 * 
	 * @return double - calculated coverage
	 */
	protected double computeBranchCoverage(List<String> instrumentingOutputs, String testData) {

		// new coverage calculation:
		double coverage;

		for (String data : instrumentingOutputs) {

			if (data.contains("<trace>")) {

				// easiest way to delete part of a string:
				data = data.replace("<trace>", "");
				data = data.replace("</trace>", "");

				if (!branches.contains(data)) {
					branches.add(data);
					System.out.println(data);
				}
			}
		}

		// used for logging:
		coverage = branches.size();
		if (coverage > branches.size())
			System.out.println(coverage);

		writeBranches("branches", branches);
		// Return the relative coverage:
		return coverage / TOTAL_BRANCH_NUM;
	}

	@Override
	protected double computeRACC(List<String> outputs, String testData) {
		return 0;
	}

	/**
	 * Function to start the branches:
	 * 
	 */

	public void startBranches() {

		paths = ExePath.createExePaths();
	}

	// Function to create the Paths
	private List<Condition> createPath(int i) {
		List<Condition> branches = null;

		branches = Condition.createPath(i);

		return branches;
	}

	/**
	 * Function to create branch list from an array:
	 * 
	 * @param array
	 *            Array with the conditions
	 */
	private List<Condition> createBranchesList(int array[][]) {
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

	/**
	 * Write the branches to a file
	 * 
	 * @param fileName
	 *            String - name of the file to be written
	 * @param branches
	 *            List of string to write
	 */
	protected void writeBranches(String fileName, List<String> branches) {

		try {
			PrintWriter writer = new PrintWriter(fileName + ".txt", "UTF-8");

			for (String each : branches) {
				writer.println(branches + "\n");
			}

			writer.close();
		} catch (IOException e) {
		}

	}

}