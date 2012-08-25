package jp.co.est_inc.android.shiritori;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MainImageView extends ImageView  {

	private Bitmap mBmp = null;
	public MainImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFocusable(true);
		requestFocus();
	}
	private void drawChart() {
		
		int width = getWidth();
		int height = getHeight();
		int margin = 6;
		int r = (width/2 + height/2) / 3;
		int rxCenter = width / 2;
		int ryCenter = height / 2 - margin;
		
		//Bitmap画像を作成
		if (mBmp == null) {
			mBmp = Bitmap.createBitmap(
					getWidth(), getHeight(),Bitmap.Config.ARGB_8888);
		}
		Canvas canvas = new Canvas(mBmp);
		
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setStyle(Paint.Style.FILL);
		
		//背景を塗りつぶす
		paint.setColor(getResources().getColor(R.color.black));
		canvas.drawRect(0.0f, 0.0f, width, height, paint);
		//円を描く
		paint.setColor(getResources().getColor(R.color.pink));
		canvas.drawCircle(rxCenter, ryCenter, r, paint);
		//ImageViewにセットする
		this.setImageBitmap(mBmp);
	}
}
