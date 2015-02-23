package interview;

public class ImageUtility implements iImageIndexUtility{

	public String getHashingFromUID(String uid)
	{
		return uid.substring(uid.indexOf('_')+1, uid.length());
	}
	public String getUniqueID(String fID, String fHashing) {
		return fID+"_"+fHashing;
	}

}
