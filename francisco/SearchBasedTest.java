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
	public List<List<Condition>> ExePath = new ArrayList<List<Condition>>();
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
		testData[0] = rand.nextInt(maxRand) + 1;
		testData[1] = rand.nextInt(maxRand) + 1;
		testData[2] = rand.nextInt(maxRand) + 1;

		int triang = 0;
		ExePath.clear();
		startBranches();
		List<Condition> currentPath = ExePath.get(iterationExePath);
		for (int i = 0; i < currentPath.size(); i++) {
			int Total = 0;
			Condition condition = currentPath.get(i);
			int a = 0;
			int b = 0;
			a = calculateA(condition, testData);

			b = calculateB(condition, testData);

			if (fit.evaluateCondition(condition.op, condition.result, a, b) != 0) {
				Total = fit.evaluateCondition(condition.op, condition.result, a, b);
				if (condition.left == arrayVariables[0] && condition.right == arrayVariables[3]) {
					testData[0] -= Total;
				}
				if (condition.left == arrayVariables[1] && condition.right == arrayVariables[3]) {
					testData[1] -= Total;
				}
				if (condition.left == arrayVariables[2] && condition.right == arrayVariables[3]) {
					testData[2] -= Total;
				}
				if (condition.left == arrayVariables[0] && condition.right == arrayVariables[1]) {
					if (testData[0] < testData[1]) {
						testData[0] += Total;
					} else {
						testData[1] += Total;
					}
				}
				if (condition.left == arrayVariables[0] && condition.right == arrayVariables[2]) {
					if (testData[0] < testData[2]) {
						testData[0] += Total;
					} else {
						testData[2] += Total;
					}
				}
				if (condition.left == arrayVariables[1] && condition.right == arrayVariables[2]) {
					if (testData[1] < testData[2]) {
						testData[1] += Total;
					} else {
						testData[2] += Total;
					}
				}

				if (condition.left == arrayVariables[7]) {
					if ((condition.op == arrayOpt[1] && condition.result == arrayRes[0])
							|| (condition.op == arrayOpt[1] && condition.result == arrayRes[1])) {
						testData[2] += Total;
					}
					if ((condition.op == arrayOpt[1] && condition.result == arrayRes[0])
							|| (condition.op == arrayOpt[1] && condition.result == arrayRes[1])) {
						testData[2] -= Total;
					}
				}
				if (condition.left == arrayVariables[8]) {
					if ((condition.op == arrayOpt[1] && condition.result == arrayRes[0])
							|| (condition.op == arrayOpt[1] && condition.result == arrayRes[1])) {
						testData[0] += Total;
					}
					if ((condition.op == arrayOpt[1] && condition.result == arrayRes[0])
							|| (condition.op == arrayOpt[1] && condition.result == arrayRes[1])) {
						testData[0] -= Total;
					}
				}
				if (condition.left == arrayVariables[9]) {
					if ((condition.op == arrayOpt[1] && condition.result == arrayRes[0])
							|| (condition.op == arrayOpt[1] && condition.result == arrayRes[1])) {
						testData[1] += Total;
					}
					if ((condition.op == arrayOpt[1] && condition.result == arrayRes[0])
							|| (condition.op == arrayOpt[1] && condition.result == arrayRes[1])) {
						testData[1] -= Total;
					}
				}
			}
			if (condition.op == arrayOpt[2] && condition.left == arrayVariables[0]
					&& condition.right == arrayVariables[1] && condition.result == arrayRes[0]) {
				triang = triang + 1;
			}
			if (condition.op == arrayOpt[2] && condition.left == arrayVariables[0]
					&& condition.right == arrayVariables[2] && condition.result == arrayRes[0]) {
				triang = triang + 2;
			}
			if (condition.op == arrayOpt[2] && condition.left == arrayVariables[0]
					&& condition.right == arrayVariables[2] && condition.result == arrayRes[0]) {
				triang = triang + 3;
			}
		}
		for (int i = 0; i < testData.length; i++) {
			builder.append(testData[i]).append(", ");
		}
		iterationExePath += 1;
		if (iterationExePath == 14) {
			iterationExePath = 0;
		}

	}

	private int calculateB(Condition condition, float[] testData) {
		int b = 0;
		int[] arrayResult = new int[]{(int) testData[0],(int) testData[1], (int) testData[2],0,1,2,3};
		
		for(int i = 0; i< 7; i++){
			if (condition.left == arrayVariables[i]) {
				b = arrayResult[i];
			}
		}
		return b;
	}

	private int calculateA(Condition condition, float[] testData) {
		int triang = 0;
		int a = 0;
		int[] arrayResult = new int[]{(int) testData[0],(int) testData[1], (int) testData[2],(int)triang,(int) (testData[0] + testData[1]),(int) (testData[1] + testData[2]),(int) (testData[0] + testData[2])};
		Variables[] array = new Variables[] { Variables.Vars1, Variables.Vars2, Variables.Vars3,
				Variables.third, Variables.Vartrian, Variables.Vars1s2,
				Variables.Vars2s3, Variables.Vars1s3 };
		
		for(int i = 0; i< array.length; i++){
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

		// Path 1 to 14:
		for(int i = 1; i< 15; i++){
			ExePath.add(createPath(i));
		}

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