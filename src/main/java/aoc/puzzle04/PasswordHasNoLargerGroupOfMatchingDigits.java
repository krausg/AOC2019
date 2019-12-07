package aoc.puzzle04;

import static java.lang.Character.getNumericValue;

import java.util.function.Predicate;

public class PasswordHasNoLargerGroupOfMatchingDigits implements Predicate<String> {

	@Override
	public boolean test(String password) {
		int[] numCount = new int[10];
		char[] pwdChars = password.toCharArray();
		for (char pwdChar : pwdChars) {
			numCount[getNumericValue(pwdChar)] += 1;
		}

		for (int i = 9; i > 0; i--) {
			if (numCount[i] == 2) {
				return true;
			}
		}
		return false;
	}
}
