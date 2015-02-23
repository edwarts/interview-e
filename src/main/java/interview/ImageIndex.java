package interview;

public class ImageIndex{
	String MD5Hashing="";
	String fileID="";
	public String getMD5Hashing() {
		return MD5Hashing;
	}
	public void setMD5Hashing(String mD5Hashing) {
		MD5Hashing = mD5Hashing;
	}
	public String getFileID() {
		return fileID;
	}
	public void setFileID(String fileID) {
		this.fileID = fileID;
	}
	public ImageIndex(String fileID,String mD5Hashing) {
		MD5Hashing = mD5Hashing;
		this.fileID = fileID;
	}


}
