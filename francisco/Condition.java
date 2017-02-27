package tp6305.francisco;

public class Condition {

	static boolean[] arrayRes = new boolean[]{true, false};
	static Operators[] arrayOpt = new Operators[]{Operators.less, Operators.greater, Operators.equal};
	static Variables[] arrayVariables = new Variables[]{Variables.Vars1, Variables.Vars2, Variables.Vars3,Variables.zero, Variables.first, Variables.second, Variables.third, Variables.Vartrian, Variables.Vars1s2, Variables.Vars2s3, Variables.Vars1s3};
	
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
	
	public static Condition createCondition(int v1, int op, int v2, int res){
		return new Condition(arrayVariables[v1], arrayOpt[op], arrayVariables[v2], arrayRes[res]);
	}
}
