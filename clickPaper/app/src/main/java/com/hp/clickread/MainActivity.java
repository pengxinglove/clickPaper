package com.hp.clickread;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.hp.clickread.view.ClickPaperView;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoViewAttacher;

public class MainActivity extends AppCompatActivity {

    private  ClickPaperView photoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        photoView = (ClickPaperView) findViewById(R.id.photo_view);
        Bitmap paperBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.timg);
        photoView.setImageResource(R.mipmap.timg);
        photoView.setImageSize(paperBitmap.getWidth(), paperBitmap.getHeight());
        setTrackInfo();
        photoView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {

           //     Toast.makeText(view.getContext(), "x = " + x + ", y = " + y, Toast.LENGTH_LONG).show();
                for(TrackInfo trackInfo : photoView.trackInfos){
                    if (contains(trackInfo, x, y))
                    {
                        clickTrack(trackInfo);
                        return;
                    }
                }

            }
        });
    }

    private void clickTrack(TrackInfo trackInfo) {
        Toast.makeText(this, "点中 第[" +trackInfo.track_id + "]题", Toast.LENGTH_LONG).show();
    }


    static boolean contains(TrackInfo trackInfo, float x, float y)
    {
        return (trackInfo.track_left < trackInfo.track_right) && (trackInfo.track_top < trackInfo.track_bottom) && (x >= trackInfo.track_left) && (x < trackInfo.track_right) && (y >= trackInfo.track_top) && (y < trackInfo.track_bottom);
    }

    private void setTrackInfo() {
        ArrayList<TrackInfo> trackInfos = new ArrayList<TrackInfo>();

        TrackInfo item = new TrackInfo(1, 0.1f, 0.1f, 0.3f, 0.2f);
        trackInfos.add(item);

        item = new TrackInfo(2, 0.4f, 0.3f, 0.6f, 0.5f);
        trackInfos.add(item);

        photoView.setTrackInfo(trackInfos);
    }
}
