package rodriguez.miguel.practica3_multimedia_segundo_parcial_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class activity_surface_view extends AppCompatActivity {


    private MediaPlayer mediaPlayer;
    private SurfaceView surfaceView;
    private SurfaceHolder surfaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surface_view);

        surfaceView = findViewById(R.id.surface_view3);
        Button playButton = findViewById(R.id.button_play_surface3);
        Button pauseButton = findViewById(R.id.button_pause_surface3);
        Button backButton = findViewById(R.id.button_back_surface3);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                mediaPlayer = new MediaPlayer();
                try {
                    Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video2);
                    mediaPlayer.setDataSource(activity_surface_view.this, videoUri);
                    mediaPlayer.setDisplay(surfaceHolder);
                    mediaPlayer.prepare();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {}

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                if (mediaPlayer != null) {
                    mediaPlayer.release();
                    mediaPlayer = null;
                }
            }
        });

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (!mediaPlayer.isPlaying()) {
                        mediaPlayer.start();
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
                    if (mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
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