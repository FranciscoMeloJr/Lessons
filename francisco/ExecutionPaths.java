package tp6305.francisco;

import java.util.ArrayList;
import java.util.List;

//Make sure that your executions paths well represent the logic of the class triangle.java and could work
//with other fitness ffirstctions.
	
public class ExecutionPaths {
	List<List<Condition>> ExePath = new ArrayList<List<Condition>>();
	
	public void ExecutionPaths() {
		List<Condition> branches = new ArrayList<Condition>();

		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, true));
		// Chemin d'exécution 1
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, true));
		// Chemin d'exécution 2
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, true));
		// Chemin d'exécution 3
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, false));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, true));
		// Ligne 50
		branches.add(new Condition(Variables.Vars1s2, Operators.less, Variables.Vars3, true));
		// Chemin d'exécution 4
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, false));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, true));
		// Ligne 50
		branches.add(new Condition(Variables.Vars1s2, Operators.less, Variables.Vars3, false));
		// Ligne 50
		branches.add(new Condition(Variables.Vars2s3, Operators.less, Variables.Vars1, true));
		// Chemin d'exécution 5
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, false));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, true));
		// Ligne 50
		branches.add(new Condition(Variables.Vars1s2, Operators.less, Variables.Vars3, false));
		// Ligne 50
		branches.add(new Condition(Variables.Vars2s3, Operators.less, Variables.Vars1, false));
		// Ligne 50
		branches.add(new Condition(Variables.Vars1s3, Operators.less, Variables.Vars2, true));
		// Chemin d'exécution 6
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, false));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, true));
		// Ligne 50
		branches.add(new Condition(Variables.Vars1s2, Operators.less, Variables.Vars3, false));
		// Ligne 50
		branches.add(new Condition(Variables.Vars2s3, Operators.less, Variables.Vars1, false));
		// Ligne 50
		branches.add(new Condition(Variables.Vars1s3, Operators.less, Variables.Vars2, false));
		// Chemin d'exéuction 7
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, true));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, true));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, true));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, false));
		// Ligne 56
		branches.add(new Condition(Variables.Vartrian, Operators.greater, Variables.third, true));
		// Chemin d'exécution 8
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, true));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, false));
		// Ligne 56
		branches.add(new Condition(Variables.Vartrian, Operators.greater, Variables.third, false));
		// Ligne 59
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.first, true));
		// Ligne 59
		branches.add(new Condition(Variables.Vars1s2, Operators.greater, Variables.Vars3, true));
		// Chemin d'exécution 9
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, true));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, false));
		// Ligne 56
		branches.add(new Condition(Variables.Vartrian, Operators.greater, Variables.third, false));
		// Ligne 59
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.first, true));
		// Ligne 59
		branches.add(new Condition(Variables.Vars1s2, Operators.greater, Variables.Vars3, false));
		// Ligne 62
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.second, false));
		// Ligne 65
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.third, false));
		// Chemin d'exécution 10
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, true));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, false));
		// Ligne 56
		branches.add(new Condition(Variables.Vartrian, Operators.greater, Variables.third, false));
		// Ligne 59
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.first, false));
		// Ligne 62
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.second, true));
		// Ligne 62
		branches.add(new Condition(Variables.Vars2s3, Operators.greater, Variables.Vars1, true));
		// Chemin d'exécution 11
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, true));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, false));
		// Ligne 56
		branches.add(new Condition(Variables.Vartrian, Operators.greater, Variables.third, false));
		// Ligne 59
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.first, false));
		// Ligne 62
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.second, true));
		// Ligne 62
		branches.add(new Condition(Variables.Vars2s3, Operators.greater, Variables.Vars1, false));
		// Ligne 65
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.third, false));
		// Chemin d'exécution 12
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, true));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, false));
		// Ligne 56
		branches.add(new Condition(Variables.Vartrian, Operators.greater, Variables.third, false));
		// Ligne 59
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.first, false));
		// Ligne 62
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.second, false));
		// Ligne 65
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.third, true));
		// Ligne 65
		branches.add(new Condition(Variables.Vars1s3, Operators.greater, Variables.Vars2, true));
		// Chemin d'exécution 13
		ExePath.add(branches);

		branches = new ArrayList<Condition>();
		// Line
		branches.add(new Condition(Variables.Vars1, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars2, Operators.less, Variables.zero, false));
		branches.add(new Condition(Variables.Vars3, Operators.less, Variables.zero, false));
		// Ligne 40
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars2, false));
		// Ligne 43
		branches.add(new Condition(Variables.Vars2, Operators.equal, Variables.Vars3, false));
		// Ligne 46
		branches.add(new Condition(Variables.Vars1, Operators.equal, Variables.Vars3, true));
		// Ligne 49
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.zero, false));
		// Ligne 56
		branches.add(new Condition(Variables.Vartrian, Operators.greater, Variables.third, false));
		// Ligne 59
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.first, false));
		// Ligne 62
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.second, false));
		// Ligne 65
		branches.add(new Condition(Variables.Vartrian, Operators.equal, Variables.third, true));
		// Ligne 65
		branches.add(new Condition(Variables.Vars1s3, Operators.greater, Variables.Vars2, false));
		// Chemin d'exécution 14
		ExePath.add(branches);
	}

	
	public void clear() {
		if(ExePath.size() > 0)
			ExePath.clear();
		
	}


	public List<Condition> get(int iterationExePath) {
		return ExePath.get(iterationExePath);
	}
	
}
