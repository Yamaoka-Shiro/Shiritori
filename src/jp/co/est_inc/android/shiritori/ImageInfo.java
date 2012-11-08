package jp.co.est_inc.android.shiritori;

public class ImageInfo {
	private int resId;
	public int GetResID() {
		return resId;
	}
	
	public static final int UNDEFINED_ID = -1;
	
	private int resPhotoId;
	public int GetResPhotoID() {
		return resPhotoId;
	}
	
	private String initLetter;
	public String GetInitLetter() {
		return initLetter;
	}
	
	private String finalLetter;
	public String GetFinalLetter() {
		return finalLetter;
	}
	
	private String kana;
	public String GetKana() {
		return kana;
	}
	
	// コンストラクタ
	public ImageInfo(int _resId, String _initLetter, String _finalLetter) {
		resId = _resId;
		resPhotoId = UNDEFINED_ID;
		initLetter = _initLetter;
		finalLetter = _finalLetter;
	}
	
	public ImageInfo(int _resId, int _resPhotoId, String _initLetter, String _finalLetter) {
		resId = _resId;
		resPhotoId = _resPhotoId;
		initLetter = _initLetter;
		finalLetter = _finalLetter;
	}

	public ImageInfo(int _resId, String _initLetter, String _finalLetter, String _kana) {
		resId = _resId;
		resPhotoId = UNDEFINED_ID;
		initLetter = _initLetter;
		finalLetter = _finalLetter;
		kana = _kana;
	}
	
	public ImageInfo(int _resId, int _resPhotoId, String _initLetter, String _finalLetter, String _kana) {
		resId = _resId;
		resPhotoId = _resPhotoId;
		initLetter = _initLetter;
		finalLetter = _finalLetter;
		kana = _kana;
	}
	
}
