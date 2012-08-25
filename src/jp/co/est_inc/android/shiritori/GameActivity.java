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
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.v4.app.NavUtils;

public class GameActivity extends Activity implements OnClickListener {

	private MainView mainView;
	private ImageView imageView;
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
        
        imageView = (ImageView)findViewById(R.id.imageView1);
        //imageView = (ImageView)findViewById(R.id.mainView1);
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
        	
        	imageData.SetMainImageByButton(numButton);
        	imageView.setImageResource(imageData.GetMainImageResId());

        	// 正解の音を鳴らす
        	MediaPlayer se = MediaPlayer.create(this, R.raw.se_true);
        	se.start();
        	
        	// 回答ボタンを変更
        	imageData.SetSelectImages();
            imageButton1.setImageResource(imageData.GetAnswerButtonResId(0));
            imageButton2.setImageResource(imageData.GetAnswerButtonResId(1));
            imageButton3.setImageResource(imageData.GetAnswerButtonResId(2));

        } else {
        	// 不正解の音を鳴らす
        	MediaPlayer seFalse = MediaPlayer.create(this, R.raw.se_false);
        	seFalse.start();
        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_game, menu);
        return true;
    }

    
}
