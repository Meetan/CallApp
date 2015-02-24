package com.example.miyuu.callapp;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class AllActivity extends ActionBarActivity {

    private SoundPool soundPool;

    int soundID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all);
        //音楽再生用の音量調節で音量決められる
        setVolumeControlStream(AudioManager.STREAM_MUSIC);


    }

    @Override
    protected void onResume(){
        super.onResume();

        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        //soundPool = new SoundPool(読み込む最大の数, なんのタイプのMUSICか, サンプリングレートのクオリティ)
        //なんのタイプの～は普通はSTREAM_MUSIC
        //サンプリングレートの～はデフォルトは０

        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (status == 0) {
                    Log.d("", "ロードできたよ");
                }

            }
        });
        soundPool.load(getApplicationContext(), R.raw.music, 0);
    }

    public void play5 (View v) {
        AudioManager audio = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        //音量の設定
        int musicVol = audio.getStreamVolume(AudioManager.STREAM_MUSIC);

        soundPool.play(soundID, (float)musicVol,(float)musicVol, 0, 0, 1.0F);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_all, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
