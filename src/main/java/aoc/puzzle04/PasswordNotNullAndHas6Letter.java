package aoc.puzzle04;

import java.util.function.Predicate;

public class PasswordNotNullAndHas6Letter implements Predicate<String> {

	@Override
	public boolean test(String password) {
		return password != null && password.length() == 6;
	}

}
