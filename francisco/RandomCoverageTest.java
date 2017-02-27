package tp6305.francisco;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tp6305.CoverageTest;

public class RandomCoverageTest extends CoverageTest {

	// List used to save the String:
	private List<String> branches = new ArrayList<String>();
	static Random rand = new Random();

	/**
	 * Do the random execution calling the builder:
	 * 
	 * @param builder
	 *            The string builder used for traces
	 * @param testData
	 *            Maximum value. Must be greater than min.
	 */
	protected void generateTestData(StringBuilder builder, float[] testData) {
		randomData(builder, testData);
	}

	/**
	 * Call the random generation for each testData:
	 * 
	 * @param builder
	 *            The string builder used for traces
	 * @param testData
	 *            Maximum value. Must be greater than min.
	 */
	protected void randomData(StringBuilder builder, float[] testData) {

		// Max and min parameters - hard coded:
		int max = 6;
		int min = 1;

		// For each element in testData:
		for (int i = 0; i < testData.length; i++) {

			// Call the random function:
			testData[i] = randInt(min, max);
			// then put them in the StringBuilder as:
			builder.append(testData[i]).append(", ");
		}

	}

	/**
	 * Returns a pseudo-random number between min and max, inclusive. Each
	 * random variable is initialized separately
	 * 
	 * @param min
	 *            Minimum value
	 * @param max
	 *            Maximum value. Must be greater than min.
	 * @return Integer between min and max, inclusive. reference
	 *         http://stackoverflow.com/questions/363681/generating-random-
	 *         integers-in-a-specific-range/363692#363692
	 */
	public static int randInt(int min, int max) {

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt(max) - min; // rand.nextInt((max - min) + 1) + min;

		//This seems to be the most important parameter since the generation relies on the distribution
		return randomNum;
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

				//easiest way to delete part of a string:
				data = data.replace("<trace>", "");
				data = data.replace("</trace>", "");

				if (!branches.contains(data)) {
					branches.add(data);
					System.out.println(data);
				}
			}
		}

		//used for logging:
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
	 * Write the branches to a file
	 * 
	 * @param fileName
	 *            String - name of the file to be written
	 * @param branches
	 *            List of string to write
	 */
	protected void writeBranches(String fileName, List<String> branches) {

		try {
			PrintWriter writer = new PrintWriter(fileName+".txt", "UTF-8");

			for (String each : branches) {
				writer.println(branches + "\n");
			}

			writer.close();
		} catch (IOException e) {
		}

	}

}
