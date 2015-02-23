package interview;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class MD5UtiliyTest {

	@Test
	public void testDoubleArrayToString()//just play around with it
	{
		double[] testArrayDouble={0.1,0.2,0.3};
		assertEquals(MD5Utility.getMD5Double(testArrayDouble),"8e006c78708cf4ed38f209a5cf26b4e9");
	}
	@Test
	public void testMD5HashingForFile()
	{
		String filePathOfImageA=getClass().getResource("/imageA.jpg").getPath();
		try {
			String hashing=MD5Utility.getFileMD5String(new File(filePathOfImageA));
			assertTrue(hashing=="38dc200d4c1ad6858adfc1689161a804");
			System.out.println("FileHashing is "+hashing);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
