package rodriguez.miguel.practica3_multimedia_segundo_parcial_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class activity_media_player extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media_player);

        videoView = findViewById(R.id.video_view2);
        Button playButton = findViewById(R.id.button_play_video2);
        Button pauseButton = findViewById(R.id.button_pause_video2);
        Button backButton = findViewById(R.id.button_back_video2);

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.mi_video);
        videoView.setVideoURI(videoUri);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!videoView.isPlaying()) {
                        videoView.start();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (videoView.isPlaying()) {
                        videoView.pause();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}