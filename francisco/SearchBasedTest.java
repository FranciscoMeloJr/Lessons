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