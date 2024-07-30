package rodriguez.miguel.practica3_multimedia_segundo_parcial_miguel;

import androidx.appcompat.app.AppCompatActivity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class activity_audio extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        Button playButton = findViewById(R.id.button_play_audioo);
        Button pauseButton = findViewById(R.id.button_pause_audioo);
        Button backButton = findViewById(R.id.button_back_audioo);

        mediaPlayer = MediaPlayer.create(this, R.raw.mi_audio);

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}