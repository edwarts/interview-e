package interview;

import static org.junit.Assert.*;

import org.junit.Test;

public class MD5UtiliyTest {

	@Test
	public void testDoubleArrayToString()
	{
		double[] testArrayDouble={0.1,0.2,0.3};
		assertEquals(MD5Utility.getMD5Double(testArrayDouble),"8e006c78708cf4ed38f209a5cf26b4e9");
	}

}
