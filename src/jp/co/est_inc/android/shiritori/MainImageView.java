package jp.co.est_inc.android.shiritori;

import android.annotation.SuppressLint;
import android.app.Notification.Style;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

public class MainImageView extends ImageView  {

	/**
	 * BMP
	 */
	private Bitmap mBmp = null;
	/**
	 * ○✕状態(0:なし、1:○、2:✕)
	 */
	private int mStatus = 0;
	
	public MainImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		setFocusable(true);
		requestFocus();
	}
	
	
	/**
	 * ○を描画
	 */
	public void drawCircle() {
		mStatus = 1;
		Bitmap newBitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(newBitmap);
		onDraw(canvas);
	}
	
	
	public void drawCross() {
		mStatus = 2;
		
		Bitmap newBitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(newBitmap);
		onDraw(canvas);
	}

	
	public void clearChart() {
		mStatus = 0;
		Bitmap newBitmap = Bitmap.createBitmap(this.getWidth(), this.getHeight(), Bitmap.Config.ARGB_8888);
		Canvas canvas = new Canvas(newBitmap);
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
	
	
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		// 何もなし
		if (mStatus == 0) {
			return;
		}
		
		// ImageView のサイズ、中心を取得
		Rect r = new Rect();
		this.getGlobalVisibleRect(r);
		Paint p = new Paint();
		p.setColor(Color.RED);
		p.setStrokeWidth(30);
		p.setAntiAlias(true);
		p.setStyle(Paint.Style.STROKE);
		float radius = (float) ((r.width() > r.height()) ? r.height() / 2.5 : r.width() / 2.5);

		
		
		
		if (mStatus == 1) {
			canvas.drawCircle(r.exactCenterX(), r.exactCenterY(), radius, p);
		} else if (mStatus == 2) {
			p.setColor(Color.BLUE);
			canvas.drawLine(r.left + 30, r.top + 30, r.right - 30, r.bottom - 100, p);
			canvas.drawLine(r.left + 30, r.bottom - 100, r.right - 30, r.top + 30, p);
		}

	}
	
}
