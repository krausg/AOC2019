package aoc.puzzle04;

import java.io.IOException;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class MainPuzzleB {

	private static final Predicate<String> CRITERIAS = new PasswordNotNullAndHas6Letter()
			.and(new PasswordHasOnlyNumbers()).and(new PasswordHasNoLargerGroupOfMatchingDigits())
			.and(new PasswordHasNoDecreasedNumbers());
	private final static int startRange = 178416;
	private final static int endRange = 676461;

	public long start(int passwordStart, int passwordEnd) throws IOException {
		return IntStream.rangeClosed(passwordStart, passwordEnd).mapToObj(x -> x + "")
				.filter(this::isPasswordInCriteria).count();
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new MainPuzzleB().start(startRange, endRange));
	}

	public boolean isPasswordInCriteria(String password) {
		return CRITERIAS.test(password);
	}

}
