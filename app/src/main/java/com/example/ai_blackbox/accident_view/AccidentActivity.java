package com.example.ai_blackbox.accident_view;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.example.ai_blackbox.R;

public class AccidentActivity extends AppCompatActivity {

    public ItemData nowItemData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setProgress(70);

        // 비디오뷰 가져오기
        VideoView accidentVideoView = (VideoView) findViewById(R.id.videoView);

        // sample.mp4 설정
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/raw/test");
        accidentVideoView.setVideoURI(uri);

        // 리스너 등록
        accidentVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                // 준비 완료되면 비디오 재생
                mp.start();
            }
        });
    }
}