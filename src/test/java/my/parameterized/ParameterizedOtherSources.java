package my.parameterized;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("TestInfo ParameterizedOtherSources")
public class ParameterizedOtherSources {

	@ParameterizedTest
	@EnumSource(value = TimeUnit.class, names = { "NANOSECONDS", "MICROSECONDS" })
	void withSomeEnumValues(TimeUnit unit) {
		// executed once for TimeUnit.NANOSECONDS
		// and once for TimeUnit.MICROSECONDS
	}

	@ParameterizedTest
	@CsvSource({ "Hello, 5", "JUnit 5, 7", "'Hello, JUnit 5!', 15" })
	void withCsvSource(String word, int length) {
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = { "example.csv" })
	void withCsvSourceFile(String word, int length) { }
	
	
	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithSimpleMethodSource(String argument) {
	    assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
	    return Stream.of("foo", "bar");
	}
	
	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
	    assertEquals(3, str.length());
	    assertTrue(num >=1 && num <=2);
	    assertEquals(2, list.size());
	}

	static Stream<Arguments> stringIntAndListProvider() {
	    return Stream.of(
	        Arguments.of("foo", 1, Arrays.asList("a", "b")),
	        Arguments.of("bar", 2, Arrays.asList("x", "y"))
	    );
	}
	
}
