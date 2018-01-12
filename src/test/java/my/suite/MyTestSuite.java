package my.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("test.assumtion")
public class MyTestSuite {

	/*
	 * currently not working within eclipse !!!
	 */
	
	/*
	 * -	Bug in Eclipse bei Ausführen von TestSuites! -	Lösung März 2018
     * https://stackoverflow.com/questions/46717693/eclipse-no-tests-found-using-junit-5-caused-by-noclassdeffounderror/46723851
	 */

}
