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
	
	//Variables to make the tests easy:
	static boolean[] arrayRes = new boolean[]{true, false};
	static Operators[] arrayOpt = new Operators[]{Operators.less, Operators.greater, Operators.equal};
	static Variables[] arrayVariables = new Variables[]{Variables.Vars1, Variables.Vars2, Variables.Vars3,Variables.zero, Variables.first, Variables.second, Variables.third, Variables.Vartrian, Variables.Vars1s2, Variables.Vars2s3, Variables.Vars1s3};
	
	//Fitness function:
	private FitnessFunction fit = new FitnessFunction();
	public List<List<Condition>> ExePath = new ArrayList<List<Condition>>();
	private int iterationExePath = 0;
	
	//To accumulate the branches:
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
			
			if (fit.evaluateCondition(condition.op,condition.result,a,b) != 0) {
				Total = fit.evaluateCondition(condition.op,condition.result,a,b);
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
					}
					else {
						testData[1] += Total;
					}
				}
				if (condition.left == arrayVariables[0] && condition.right == arrayVariables[2]) {
					if (testData[0] < testData[2]) {
						testData[0] += Total;
					}
					else {
						testData[2] += Total;
					}
				}
				if (condition.left == arrayVariables[1] && condition.right == arrayVariables[2]) {
					if (testData[1] < testData[2]) {
						testData[1] += Total;
					}
					else {
						testData[2] += Total;
					}
				}
				
				if (condition.left == arrayVariables[7]) {
					if ((condition.op == arrayOpt[1] && condition.result== arrayRes[0])|| (condition.op == arrayOpt[1] && condition.result==arrayRes[1] )) {
						testData[2] += Total;
					}
					if ((condition.op == arrayOpt[1] && condition.result== arrayRes[0] )|| (condition.op == arrayOpt[1] && condition.result==arrayRes[1])) {
						testData[2] -= Total;
					}
				}
				if (condition.left == arrayVariables[8]) {
					if ((condition.op == arrayOpt[1] && condition.result==arrayRes[0] )|| (condition.op == arrayOpt[1] && condition.result==arrayRes[1])) {
						testData[0] += Total;
					}
					if ((condition.op == arrayOpt[1] && condition.result==arrayRes[0] )|| (condition.op == arrayOpt[1] && condition.result==arrayRes[1])) {
						testData[0] -= Total;
					}
				}
				if (condition.left == arrayVariables[9]) {
					if ((condition.op ==arrayOpt[1] && condition.result==arrayRes[0] )|| (condition.op == arrayOpt[1] && condition.result==arrayRes[1])) {
						testData[1] += Total;
					}
					if ((condition.op == arrayOpt[1] && condition.result==arrayRes[0] )|| (condition.op == arrayOpt[1] && condition.result==arrayRes[1])) {
						testData[1] -= Total;
					}
				}
			}
			if (condition.op==arrayOpt[2] && condition.left==arrayVariables[0] && condition.right==arrayVariables[1] && condition.result == arrayRes[0] ) {
				triang = triang+1;
			}
			if (condition.op==arrayOpt[2] && condition.left==arrayVariables[0]&& condition.right==arrayVariables[2] && condition.result == arrayRes[0] ) {
				triang = triang+2;
			}
			if (condition.op==arrayOpt[2] && condition.left==arrayVariables[0] && condition.right==arrayVariables[2] && condition.result == arrayRes[0] ) {
				triang = triang+3;
			}
		}
		for(int i = 0 ; i< testData.length; i++) {
			builder.append(testData[i]).append(", ");
		}
		iterationExePath += 1;
		if (iterationExePath == 14) {
			iterationExePath = 0;
		}
		
	}
	
	private int calculateB(Condition condition, float[] testData) {
		int b = 0;
		if (condition.right == arrayVariables[0]) {
			b = (int) testData[0];
		}
		if (condition.right == arrayVariables[1]) {
			b = (int) testData[1];
		}
		if (condition.right == arrayVariables[2]) {
			b = (int) testData[2];
		}
		if (condition.right == arrayVariables[3]) {
			b = 0;
		}
		if (condition.right == arrayVariables[4]) {
			b = 1;
		}
		if (condition.right == arrayVariables[5]) {
			b = 2;
		}
		if (condition.right == arrayVariables[6]) {
			b = 3;
		}
		return b;
	}
	
	private int calculateA(Condition condition, float[] testData) {
		int triang = 0;
		int a = 0;
		if (condition.left == arrayVariables[0]) {
			a = (int) testData[0];
		}
		if (condition.left == arrayVariables[1]) {
			a = (int) testData[1];
		}
		if (condition.left == arrayVariables[2]) {
			a = (int) testData[2];
		}
		if (condition.left == arrayVariables[6]) {
			a = (int) triang;
		}
		if (condition.left == arrayVariables[7]) {
			a = (int) (testData[0] + testData[1]);
		}
		if (condition.left == arrayVariables[8]) {
			a = (int) (testData[1] + testData[2]);
		}
		if (condition.left == arrayVariables[9]) {
			a = (int) (testData[0] + testData[2]);
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
	 * Function to start the branches:
	 * 
	 */
	
	public void startBranches() {
		//boolean[] arrayRes = new boolean[]{true, false};
		//Operators[] arrayOpt = new Operators[]{Operators.less, Operators.greater, Operators.equal};
		//Variables[] arrayVariables = new Variables[]{Variables.Vars1, Variables.Vars2, Variables.Vars3,Variables.first, Variables.second, Variables.third, Variables.Vartrian, Variables.Vars1s2, Variables.Vars2s3, Variables.Vars1s3} ;

		// Path 1
		ExePath.add(createPath1());
		//Path 2
		ExePath.add(createPath2());
		//Path 3
		ExePath.add(createPath3());
		//Path 4
		ExePath.add(createPath4());
		//Path 5
		ExePath.add(createPath5());
		//Path 6
		ExePath.add(createPath6());
		//Path 7
		ExePath.add(createPath7());
		//Path 8
		ExePath.add(createPath8());
		//Path 9
		ExePath.add(createPath9());
		//Path 10
		ExePath.add(createPath10());
		//Path 11
		ExePath.add(createPath11());
		//Path 12
		ExePath.add(createPath12());
		//Path 13
		ExePath.add(createPath13());
		//Path 14
		ExePath.add(createPath14());
		
	}
	// Path 14
	private List<Condition> createPath14() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0,0,3,1));
		branches.add(Condition.createCondition(1,0,3,1));
		branches.add(Condition.createCondition(2,0,3,1));
		branches.add(Condition.createCondition(0,2,1,1));
		branches.add(Condition.createCondition(1,2,2,1));
		branches.add(Condition.createCondition(0,2,2,0));
		branches.add(Condition.createCondition(7,2,3,1));
		branches.add(Condition.createCondition(7,1,6,1));
		branches.add(Condition.createCondition(7,2,4,1));
		branches.add(Condition.createCondition(7,2,5,1));
		branches.add(Condition.createCondition(7,2,6,0));
		branches.add(Condition.createCondition(10,1,1,1));
		return branches;
	}
	// Path 13
	private List<Condition> createPath13() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0,0,3,1));
		branches.add(Condition.createCondition(1,0,3,1));
		branches.add(Condition.createCondition(2,0,3,1));
		branches.add(Condition.createCondition(0,2,1,1));
		branches.add(Condition.createCondition(1,2,2,1));
		branches.add(Condition.createCondition(0,2,2,0));
		branches.add(Condition.createCondition(7,2,3,1));
		branches.add(Condition.createCondition(7,1,6,1));
		branches.add(Condition.createCondition(7,2,4,1));
		branches.add(Condition.createCondition(7,2,5,1));
		branches.add(Condition.createCondition(7,2,6,0));
		branches.add(Condition.createCondition(10,1,1,0));
		return branches;
	}
	// Path 12
	private List<Condition> createPath12() {
		List<Condition> branches = new ArrayList<Condition>();;
		branches.add(Condition.createCondition(0,0,3,1));
		branches.add(Condition.createCondition(1,0,3,1));
		branches.add(Condition.createCondition(2,0,3,1));
		branches.add(Condition.createCondition(0,2,1,1));
		branches.add(Condition.createCondition(0,2,2,1));
		branches.add(Condition.createCondition(1,2,2,0));
		branches.add(Condition.createCondition(7,2,3,1));
		branches.add(Condition.createCondition(7,1,6,1));
		branches.add(Condition.createCondition(7,2,4,1));
		branches.add(Condition.createCondition(7,2,5,0));
		branches.add(Condition.createCondition(9,1,0,1));
		branches.add(Condition.createCondition(7,2,6,1));
		return branches;
	}
	// Path 10
	private List<Condition> createPath11() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0,0,3,1));
		branches.add(Condition.createCondition(1,0,3,1));
		branches.add(Condition.createCondition(2,0,3,1));
		branches.add(Condition.createCondition(0,2,1,1));
		branches.add(Condition.createCondition(0,2,2,1));
		branches.add(Condition.createCondition(1,2,2,0));
		branches.add(Condition.createCondition(7,2,3,1));
		branches.add(Condition.createCondition(7,1,6,1));
		branches.add(Condition.createCondition(7,2,4,1));
		branches.add(Condition.createCondition(7,2,5,0));
		branches.add(Condition.createCondition(9,1,0,0));
		return branches;
	}
	// Path 10
	private List<Condition> createPath10() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0,0,3,1));
		branches.add(Condition.createCondition(1,0,3,1));
		branches.add(Condition.createCondition(2,0,3,1));
		branches.add(Condition.createCondition(1,2,2,1));
		branches.add(Condition.createCondition(0,2,2,1));
		branches.add(Condition.createCondition(0,2,1,0));
		branches.add(Condition.createCondition(7,2,3,1));
		branches.add(Condition.createCondition(7,1,6,1));
		branches.add(Condition.createCondition(7,2,4,0));
		branches.add(Condition.createCondition(8,1,2,1));
		branches.add(Condition.createCondition(7,2,5,1));
		branches.add(Condition.createCondition(7,2,6,1));
		return branches;
	}
	// Path 9
	private List<Condition> createPath9() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0,0,3,1));
		branches.add(Condition.createCondition(1,0,3,1));
		branches.add(Condition.createCondition(2,0,3,1));
		branches.add(Condition.createCondition(1,2,2,1));
		branches.add(Condition.createCondition(0,2,2,1));
		branches.add(Condition.createCondition(0,2,1,0));
		branches.add(Condition.createCondition(7,2,6,1));
		branches.add(Condition.createCondition(7,1,6,1));
		branches.add(Condition.createCondition(7,2,4,0));
		branches.add(Condition.createCondition(8,1,2,0));
		return branches;
	}
	// Path 8
	private List<Condition> createPath8() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0,0,3,1));
		branches.add(Condition.createCondition(1,0,3,1));
		branches.add(Condition.createCondition(2,0,3,1));
		branches.add(Condition.createCondition(0,2,1,0));
		branches.add(Condition.createCondition(1,2,2,0));
		branches.add(Condition.createCondition(0,2,2,0));
		branches.add(Condition.createCondition(7,1, 3,1));
		branches.add(Condition.createCondition(7,1,6,0));
		return branches;
	}
	// Path 7
	private List<Condition> createPath7() {
		List<Condition> branches = new ArrayList<Condition>();
		
		branches.add(Condition.createCondition(0, 0, 2,1));
		branches.add(Condition.createCondition(1, 0, 2,1));
		branches.add(Condition.createCondition(2, 0, 2,1));
		branches.add(Condition.createCondition(0, 2, 1,1));
		branches.add(Condition.createCondition(1, 2, 2,1));
		branches.add(Condition.createCondition(0, 2, 2,1));
		branches.add(Condition.createCondition(7, 2, 2,0));
		branches.add(Condition.createCondition(8, 0,2,1));
		branches.add(Condition.createCondition(9, 0,0,1));
		branches.add(Condition.createCondition(10, 0,1,1));
		return branches;
	}
	// Path 6
	private List<Condition> createPath6() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0, 0, 3, 1));
		branches.add(Condition.createCondition(1, 0, 3, 1));
		branches.add(Condition.createCondition(2, 0, 3, 1));
		branches.add(Condition.createCondition(0, 2, 1, 1));
		branches.add(Condition.createCondition(1, 2, 2, 1));
		branches.add(Condition.createCondition(0, 2, 2, 1));
		branches.add(Condition.createCondition(7, 2, 3, 0));
		branches.add(Condition.createCondition(8, 0, 2, 1));
		branches.add(Condition.createCondition(9, 0, 0, 1));
		branches.add(Condition.createCondition(10, 0, 1, 0));
		return branches;
	}
	// Path 5
	private List<Condition> createPath5() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0, 0, 3, 1));
		branches.add(Condition.createCondition(1, 0, 3, 1));
		branches.add(Condition.createCondition(2, 0, 3, 1));
		branches.add(Condition.createCondition(0, 2, 1, 1));
		branches.add(Condition.createCondition(1, 2, 2, 1));
		branches.add(Condition.createCondition(0, 2, 2, 1));
		branches.add(Condition.createCondition(7, 2, 3, 0));
		branches.add(Condition.createCondition(8, 0, 2, 1));
		branches.add(Condition.createCondition(8, 0, 0, 0));
		return branches;
	}
	// Path 4
	private List<Condition> createPath4() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0, 0, 3, 1));
		branches.add(Condition.createCondition(1, 0, 3, 1));
		branches.add(Condition.createCondition(2, 0, 3, 1));
		branches.add(Condition.createCondition(0, 2, 1, 1));
		branches.add(Condition.createCondition(1, 2, 2, 1));
		branches.add(Condition.createCondition(0, 2, 2, 1));
		branches.add(Condition.createCondition(7, 2, 3, 0));
		branches.add(Condition.createCondition(8, 0, 2, 0));

		return branches;
	}
	//Path 3
	private List<Condition> createPath3() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0, 0, 3, 1));
		branches.add(Condition.createCondition(1, 0, 3, 1));
		branches.add(Condition.createCondition(2, 0, 3, 0));
		return branches;
	}
	// Path 2
	private List<Condition> createPath2() {
		List<Condition> branches = new ArrayList<Condition>();
		branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0, 0, 3, 1));
		branches.add(Condition.createCondition(1, 0, 3, 0));
		
		return branches;
	}
	// Path 1
	private List<Condition> createPath1() {
		List<Condition> branches = new ArrayList<Condition>();
		branches.add(Condition.createCondition(0, 0, 3, 0));
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
			PrintWriter writer = new PrintWriter(fileName+".txt", "UTF-8");

			for (String each : branches) {
				writer.println(branches + "\n");
			}

			writer.close();
		} catch (IOException e) {
		}

	}
	
	
}