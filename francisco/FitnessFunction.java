package tp6305.francisco;

import java.util.Random;

public class FitnessFunction {

	int maxK = 10;
	Random rand = new Random();

	public int evaluateCondition(Operators op, boolean result, int a, int b) {
		int F = 0;
		int K = rand.nextInt(maxK) + 1;

		if (op == Operators.equal)
			F = functionEqual(a, b, result, K);

		if (op == Operators.less)
			F = functionLess(a, b, result, K);

		if (op == Operators.equal)
			F = functionGreater(a, b, result, K);

		return F;
	}

	int functionEqual(int a, int b, boolean result, int K) {
		int F;
		if (result) {
			if (a == b) {
				F = 0;
			} else {
				F = Math.abs(b - a);
			}
		} else {
			if (a == b) {
				F = K;
			} else {
				F = 0;
			}
		}
		return F;

	}

	int functionLess(int a, int b, boolean result, int K) {
		int F;
		if (result) {
			if (a < b) {
				F = 0;
			} else {
				F = (a - b) + K;
			}
		} else {
			if (a < b) {
				F = (b - a);
			} else {
				F = 0;
			}
		}
		return F;

	}

	int functionGreater(int a, int b, boolean result, int K) {
		int F;
		if (result) {
			if (a > b) {
				F = 0;
			} else {
				F = (b - a) + K;
			}
		} else {
			if (a > b) {
				F = (a - b);
			} else {
				F = 0;
			}
		}
		return F;

	}
}