package my.dynamic;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

@DisplayName("TestInfo DynamicModuleAccessible")
public class DynamicModuleAccessible {

	@TestFactory
	@DisplayName("for dynamic tests")
	List<DynamicTest> createDynamicTests() {
		return Arrays.asList(DynamicTest.dynamicTest("This test is dynamically generated", () -> assertTrue(true)),

				DynamicTest.dynamicTest("Here's another instance of a dynamically generated test",
						() -> assertTrue(true)));
	}

	@TestFactory
	@DisplayName("for dynamic test containers")
	Stream<DynamicContainer> createDynamicTestContainers() {
		return Stream
				.of(DynamicContainer.dynamicContainer("This dynamically generated container",
						Collections.singletonList(DynamicTest.dynamicTest(
								"contains a single dynamically generated test in a dynamic Container",
								() -> assertTrue(true)))));
	}

}
