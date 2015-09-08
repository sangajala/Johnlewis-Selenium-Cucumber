package Utils;

import org.apache.log4j.Logger;
import org.junit.Assert;

/**
 * Created by sriramangajala on 29/07/2014.
 */
public class VerifyUtils {

    static Logger LOGGER = Logger.getLogger(VerifyUtils.class);
    public static void contains(String expected, String actual) {
        boolean result=false;
        LOGGER.info("Verifying the expected data :"+expected+" to be visbile in actual value :"+actual);
        if(actual.replaceAll("\\s+","").contains(expected.replaceAll("\\s+","")))
        {
            return;
        }
        else if(actual.replaceAll("\\s+","").equals(expected.replaceAll("\\s+","")))
        {
            return;
        }
        else if(expected.replaceAll("\\s+","").contains(actual.replaceAll("\\s+","")))
        {
            return;
        }
     //   else
        Assert.fail(expected.replaceAll("\\s+","")+" is not containing actual value "+actual.replaceAll("\\s+",""));
    }

    public static void True(boolean condition) {
        LOGGER.info("Verifying the value to be True"+condition);
        Assert.assertTrue("The condition is false but expecting true - ",condition);
    }

    public static void False(boolean condition) {
        LOGGER.info("Verifying the value to be false"+condition);
        Assert.assertFalse("The condition is false but expecting false",condition);
    }
    
    public static void equals(String expected, String actual) {
        LOGGER.info("Verifying the expected data :"+expected+" to be visbile in actual value :"+actual);
        Assert.assertEquals("the expected value is "+expected+"but actual is" + actual, expected.replaceAll("\\s+",""), actual.replaceAll("\\s+",""));
    }

    public static void equals(String message,String expected, String actual) {
        LOGGER.info("Verifying the expected data :"+expected+" to be visbile in actual value :"+actual);
        Assert.assertEquals(message, expected.replaceAll("\\s+",""), actual.replaceAll("\\s+",""));
    }

    public static void fail(String message) {
        Assert.fail(message);
    }

    public static void equals(boolean exp, boolean act) {
          Assert.assertEquals("Checked the condition to be equal",exp,act);
    }

    public static void equals(int expected, int actual) {
        LOGGER.info("Verifying the expected data :"+expected+" to be visbile in actual value :"+actual);
        Assert.assertEquals("the expected value is "+expected+" but actual is " + actual + " ",expected,actual);
    }

    public static void True(String message,boolean condition)
    {
        LOGGER.info(message);
        Assert.assertTrue(message,condition);
    }

    public static void ContainsTrue(String message, String haystack, String needle) {
        LOGGER.info(message + ": Checking that "+haystack+" contains "+needle);
        Assert.assertTrue(message + ": Checking that "+haystack+" contains "+needle,haystack.contains(needle));
    }

    public static void Info(String message) {
        LOGGER.info(message);
    }
}
