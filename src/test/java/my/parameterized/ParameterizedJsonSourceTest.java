package my.parameterized;

import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ParameterizedJsonSourceTest {

  @ParameterizedTest
  @JsonSource(value = "{key:'pre-vtp.audi.com', server: 'https://pre-vtp.audi.com'}", type = Config.class)
  void jsonSourceTest(Config config) {
    System.out.println(config);
    assertAll(
        () -> assertEquals("pre-vtp.audi.com", config.key),
        () -> assertEquals("https://pre-vtp.audi.com", config.server));
  }

  static class Config {
	  
	String key;
	String server;
//	String context;
//	String version;
//	String boerse;
//	String authuser;
//	String authpassword;
//	String timeout;
//	String expectedlanguage;
//	String xpattern;
//	String logging;

    @Override
    public String toString() {
      return  "Config{" + "key='" + key + '\'' +", server='" + server + '\'' + '}';
    }
  }
}
