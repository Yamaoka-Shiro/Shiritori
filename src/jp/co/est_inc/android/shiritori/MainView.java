package jp.co.est_inc.android.shiritori;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class MainView extends View {
	
//	private Paint paint = new Paint();
//	private Bitmap bmpImage;
	
    public MainView(Context context) {
        super(context);
    }
    
    //描画処理
    @Override
    public void onDraw(Canvas c) {
    	/*
    	if (bmpImage != null) {
    		c.drawBitmap(bmpImage, 0, 0, paint);
    	} else {
    		Resources res = this.getContext().getResources();
    		bmpImage = BitmapFactory.decodeResource(res, R.drawable.ame);
    		c.drawBitmap(bmpImage, 0, 0, paint);
    	}
    	*/
    }
    
    /*
    // 指定画像を表示
    public void SetImage(int imageId)
    {
    	Resources res = this.getContext().getResources();
        bmpImage = BitmapFactory.decodeResource(res, imageId);

    }
    */
}
