package jp.co.est_inc.android.shiritori;

public class ImageInfo {
	private int resId;
	public int GetResID() {
		return resId;
	}
	
	private String initLetter;
	public String GetInitLetter() {
		return initLetter;
	}
	
	private String finalLetter;
	public String GetFinalLetter() {
		return finalLetter;
	}
	
	// コンストラクタ
	public ImageInfo(int _resId, String _initLetter, String _finalLetter) {
		resId = _resId;
		initLetter = _initLetter;
		finalLetter = _finalLetter;
	}
}
