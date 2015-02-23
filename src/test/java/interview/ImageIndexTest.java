package interview;

import java.util.HashMap;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImageIndexTest {
	double[] testArrayDouble={0.1,0.2,0.3};
	String index=MD5Utility.getMD5Double(testArrayDouble);
	String id="id1";
	ImageIndex idx=(ImageIndex)ImageIndex.getInstance(id,index);
	@Test
	public void testCreatIndex()
	{
		
		
		assertTrue(idx instanceof ImageIndex);
		assertEquals("id1", idx.getFileID());
		assertEquals("8e006c78708cf4ed38f209a5cf26b4e9",idx.getMD5Hashing());
			
	}
	@Test
	public void testParseHashingFromUID()
	{
		assertEquals("8e006c78708cf4ed38f209a5cf26b4e9", idx.getHashingFromUID(idx.getUniqueID()));
	}
	@Test
	public void testIndexLookup()
	{
		HashMap<String, double[]> imageStore=new HashMap<String, double[]>();
		imageStore.put(idx.getUniqueID(), testArrayDouble);
		assertEquals(testArrayDouble,imageStore.get(idx.getUniqueID()));
	}

}
