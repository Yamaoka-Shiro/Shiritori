package jp.co.est_inc.android.shiritori;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;

public class GameActivity extends Activity implements OnClickListener {

	private MainView mainView;
	private MainImageView imageView;
	private ImageButton imageButton1;
	private ImageButton imageButton2;
	private ImageButton imageButton3;
	
	private ImageData imageData;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_game);
        
        imageData = new ImageData();
 
        WindowManager wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(display.getWidth() / 3, display.getWidth() / 3);
        
        imageView = (MainImageView)findViewById(R.id.imageView1);
        imageView.setImageResource(imageData.GetMainImageResId());
        
        imageButton1 = (ImageButton)findViewById(R.id.imageButton1);
        imageButton1.setImageResource(imageData.GetAnswerButtonResId(0));
        imageButton1.setOnClickListener(this);
        imageButton1.setLayoutParams(params);
        
        imageButton2 = (ImageButton)findViewById(R.id.imageButton2);
        imageButton2.setImageResource(imageData.GetAnswerButtonResId(1));
        imageButton2.setOnClickListener(this);
        imageButton2.setLayoutParams(params);

        imageButton3 = (ImageButton)findViewById(R.id.imageButton3);
        imageButton3.setImageResource(imageData.GetAnswerButtonResId(2));
        imageButton3.setOnClickListener(this);
        imageButton3.setLayoutParams(params);

    }

 
    public void onClick(View v) {
    	int numButton;
        if (v == imageButton1){
            numButton = 0;
        } else if (v == imageButton2) {
            numButton = 1;
        } else {
        	numButton = 2;
        }
        
        if (imageData.GetNumCorrectButton() == numButton) {
        	imageView.drawCircle();
        	imageView.invalidate();
        	
        	imageData.SetMainImageByButton(numButton);
        	imageView.setImageResource(imageData.GetMainImageResId());

        	// 正解の音を鳴らす
        	MediaPlayer se = MediaPlayer.create(this, R.raw.se_true);
        	se.start();
        	
            // この時点で，別スレッドに処理をゆだねる
            final Activity activity = this;
            new Thread(new Runnable(){

                @Override
                public void run() {
                    // これは別スレッド上での処理


                    // ２秒待って，タイムラグを生む
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignore) {
                    }


                    // UIスレッド上で，
                    // ２つ目の画像を表示する（フロッピーの保存アイコン）
                    activity.runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                        	imageView.clearChart();
                            imageView.invalidate(); // ビューを再描画し，UI上で画像変更を反映
                        }
                    });
                }

            }).start();
        	
        	
        	
        	
        	// 回答ボタンを変更
        	imageData.SetSelectImages();
            imageButton1.setImageResource(imageData.GetAnswerButtonResId(0));
            imageButton2.setImageResource(imageData.GetAnswerButtonResId(1));
            imageButton3.setImageResource(imageData.GetAnswerButtonResId(2));

        } else {
        	// メインの画像を一時的に不正解の画像に変更する
			final int currentImageId = imageData.GetMainImageResId();
        	imageView.setImageResource(imageData.GetAnswerButtonResPhotoId(numButton));
        	
        	// ✕表示
        	imageView.drawCross();
        	imageView.invalidate();

        	// 不正解の音を鳴らす
        	MediaPlayer seFalse = MediaPlayer.create(this, R.raw.se_false);
        	seFalse.start();

        	
            // この時点で，別スレッドに処理をゆだねる
            final Activity activity = this;
            new Thread(new Runnable(){

                @Override
                public void run() {
                    // これは別スレッド上での処理

                	imageButton1.setClickable(false);
                	imageButton2.setClickable(false);
                	imageButton3.setClickable(false);

                    // ２秒待って，タイムラグを生む
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ignore) {
                    }


                    // UIスレッド上で，
                    // ２つ目の画像を表示する（フロッピーの保存アイコン）
                    activity.runOnUiThread(new Runnable(){
                        @Override
                        public void run() {
                        	imageView.clearChart();
                        	// メインの画像を元に戻す
                        	imageView.setImageResource(currentImageId);
                            imageView.invalidate(); // ビューを再描画し，UI上で画像変更を反映
                        }
                    });

                	imageButton1.setClickable(true);
                	imageButton2.setClickable(true);
                	imageButton3.setClickable(true);
 
                }

            }).start();
        	
        	
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game, menu);
        return true;
    }

    
}
