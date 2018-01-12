package my.parameterized;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("TestInfo ParameterizedModuleAccessible")
public class ParameterizedSimple {

	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void withValueSource(String candidate) {
		assertTrue(isPalindrome(candidate));
	}

	@ParameterizedTest(name = "run #{index} with [{arguments}]")
	@ValueSource(ints = { 1, 2, 3 })
	void withValueSource(int value) {
		assertNotNull(value);
	}
	
	@ParameterizedTest(name = "lottery #{index} is {arguments}")
	@ValueSource(longs = { 4, 22, 5, 18, 1, 7 })
	void withValueSource(long number) { 
		assertNotNull(number);
	}
	
	@ParameterizedTest
	@ValueSource(doubles = { 4.1, 22.5, 18.1 })
	void withValueSource(double number) { 
		assertNotNull(number);
	}

	private static boolean isPalindrome(String input) {
		input = input.replaceAll("\\w", "");
		StringBuffer buffer = new StringBuffer(input);
		buffer.reverse();
		return buffer.toString().equals(input);
	}

}
