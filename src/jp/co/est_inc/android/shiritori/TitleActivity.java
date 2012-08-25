package jp.co.est_inc.android.shiritori;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.support.v4.app.NavUtils;

public class TitleActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_title);
    }

    
    // GameActivityを起動するメソッド
    public void switchActivity(View v) {
    	// GameActivityを制御するためのインデントを生成
    	Intent varIntent = new Intent(this, GameActivity.class);
    	// GameActivityを起動
    	startActivity(varIntent);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_title, menu);
        return true;
    }

    
}
