package interview;

import java.util.HashMap;

public class ImageStore{
	private iImageIndexUtility _idxU;
	//the format of String id of ImageContainer is fileId_fileHashing
	private HashMap<String, byte[]> _imageContainer=new HashMap<String,byte[]>();
    public ImageStore(iImageIndexUtility idx) {
    	_idxU=idx;
	// TODO Auto-generated constructor stub
    }
  /**
   * Inserts an image in the store
   *
   * @param id -- The identifier of the image
   * @param content -- The content of the image
   */
  public void storeImage (String id, byte[] image) {
	  //if the file already exist with the same key in the store, it will not be stored.
	  if((!_imageContainer.containsKey(id))&&(!_imageContainer.containsValue(image)))
	  {
		  _imageContainer.put(id, image);
	  }
	  else if((!_imageContainer.containsKey(id))&&(_imageContainer.containsValue(image))){
		
	  }
	  else if(_imageContainer.containsKey(id)&&(!_imageContainer.containsValue(image)))
	  {
		  _imageContainer.remove(id);
		  _imageContainer.put(id, image);
	  }
  }

  public iImageIndexUtility get_idxU() {
	return _idxU;
}
public void set_idxU(iImageIndexUtility _idxU) {
	this._idxU = _idxU;
}
/**
   * Retrieves an image from the store
   *
   * @param id -- The identifier of the image to be retrieved
   * @return the image content
   */
  public byte[] fetchImage(String id) {
    return _imageContainer.get(id);
  }

  /**
   * The size of the store
   *
   * @return the actual store size
   */
  public int size() {
	  
    return _imageContainer.size();
  }
}
