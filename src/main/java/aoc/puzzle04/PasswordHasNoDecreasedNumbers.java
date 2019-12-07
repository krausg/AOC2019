package aoc.puzzle04;

import java.util.function.Predicate;

public class PasswordHasNoDecreasedNumbers implements Predicate<String> {

	@Override
	public boolean test(String password) {
		byte[] bytes = password.getBytes();
		for (int i = 1; i < bytes.length; i++) {
			if (bytes[i - 1] > bytes[i]) {
				return false;
			}
		}
		return true;
	}

}
