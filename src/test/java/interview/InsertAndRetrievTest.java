package interview;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

//In this test, we try to verify different image with different name can be store
//If the name is in the store and we can replace it with a different image.
//I had put a MD5 utility and we can get the hash of file using this.
//In next version maybe we only need to store the MD5 hasing's byte in the store and have a connection store with name/id and its location
//I am willing to provide a version with this, but I only provide the byte array of MD5 hashing in the last test case to make the implementation more consisant
//Once we need to use to fetch from two different store , we need a method with synchronized notion

public class InsertAndRetrievTest {

	@Test
	public void insertTest()
	{
		ImageStore is=new ImageStore(new ImageUtility());
		//get the test case from the requirement
		byte[] imageA={0,1,0};
		byte[] imageB={0,0,1};
		is.storeImage("Hotel_A", imageA);
		is.storeImage("Hotel a", imageA);
		is.storeImage("Hotel_B", imageB);
		assertTrue(is.size()==2);
		System.out.println("The size of ImageStore in this test is "+is.size());
		assertTrue(is.fetchImage("Hotel_A").equals(imageA));
		System.out.println("The position 1 of Hotel_A image is "+is.fetchImage("Hotel_A")[1]);// verify from the same position in two images 
		assertTrue(is.fetchImage("Hotel_B").equals(imageB));
		System.out.println(is.fetchImage("Hotel_B")[1]);
	}
	@Test
	public void insertTestForRequirementTwo()
	{
		ImageStore is=new ImageStore(new ImageUtility());
		//get the test case from the requirement 2
		byte[] imageA={0,1,0};
		byte[] imageB={0,0,1};
		is.storeImage("Hotel_A", imageA);
		is.storeImage("Hotel a", imageA);
		is.storeImage("Hotel_A", imageB);
		is.storeImage("Hotel a", imageB);
		assertTrue(is.size()==1);
		System.out.println("The size of ImageStore in this test 2 is "+is.size());
		assertTrue(is.fetchImage("Hotel_A").equals(imageB)); //only ImageA can be store with name Hotel_A
		System.out.println(is.fetchImage("Hotel_A")[1]);
		try {
			assertTrue(is.fetchImage("Hotel a").equals(imageB));// ImageB had been used to replace ImageA and it makes the Hotel a can be store as ImageB is exist
		} catch (Exception e) {
			assertTrue(e instanceof NullPointerException);
		}
	}
	//addtional with MD5
	@Test
	public void insertTestWithMD5()
	{
		ImageStore is=new ImageStore(new ImageUtility());
		//get the test case from the requirement
		String filePathOfImageA=getClass().getResource("/imageA.jpg").getPath();
		byte[] imageA;
		try {
			imageA = MD5Utility.getFileMD5String(new File(filePathOfImageA)).getBytes();
			byte[] imageB={0,0,1};
			is.storeImage("Hotel_A", imageA);
			is.storeImage("Hotel a", imageA);
			is.storeImage("Hotel_B", imageB);
			assertTrue(is.size()==2);
			System.out.println("The size of ImageStore in this test with MD5 is "+is.size());
			assertTrue(is.fetchImage("Hotel_A").equals(imageA));
			System.out.println("The position 1 of Hotel_A image is "+is.fetchImage("Hotel_A")[1]);// verify from the same position in two images 
			assertTrue(is.fetchImage("Hotel_B").equals(imageB));
			System.out.println(is.fetchImage("Hotel_B")[1]);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}
