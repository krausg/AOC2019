package aoc.puzzle04;

import java.util.function.Predicate;

public class PasswordHasOnlyNumbers implements Predicate<String> {

	@Override
	public boolean test(String password) {
		return password.matches("^[0-9]+$");
	}

}
