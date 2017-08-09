package com.hp.clickread.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;

import com.hp.clickread.R;
import com.hp.clickread.TrackInfo;

import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;

/**
 * Created by hasee on 2017/8/10.
 */

public class ClickPaperView extends PhotoView {
    private Paint rectPaint;
    public ArrayList<TrackInfo> trackInfos = new ArrayList<TrackInfo>();
    private int width;
    private int height;
    private RectF questionRect = new RectF();
    private float rx = 5.0f;

    public ClickPaperView(Context context) {
        super(context);
        this.rectPaint = new Paint();
        this.rectPaint.setStyle(Paint.Style.STROKE);
        this.rectPaint.setFlags(1);
        this.rectPaint.setStrokeWidth(4.0F);
    }

    public ClickPaperView(Context context, AttributeSet attr) {
        super(context, attr);
        this.rectPaint = new Paint();
        this.rectPaint.setStyle(Paint.Style.STROKE);
        this.rectPaint.setFlags(1);
        this.rectPaint.setStrokeWidth(4.0F);
    }

    public ClickPaperView(Context context, AttributeSet attr, int defStyle) {
        super(context, attr, defStyle);

        this.rectPaint = new Paint();
        this.rectPaint.setStyle(Paint.Style.STROKE);
        this.rectPaint.setFlags(1);
        this.rectPaint.setStrokeWidth(4.0F);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(width == 0 || height == 0)
            return ;

        canvas.save();
        canvas.concat(getImageMatrix());

       for(TrackInfo trackInfo : trackInfos){
           this.rectPaint.setColor(getResources().getColor(R.color.colorAccent));
           this.rectPaint.setStyle(Paint.Style.STROKE);
           this.rectPaint.setAlpha(100);
           this.questionRect.left = (trackInfo.track_left * this.width);
           this.questionRect.top = (trackInfo.track_top * this.height);
           this.questionRect.right = (trackInfo.track_right * this.width);
           this.questionRect.bottom = (trackInfo.track_bottom * this.height);
           canvas.drawRoundRect(this.questionRect, rx, rx, this.rectPaint);
       }
        canvas.restore();
    }


    public void setImageSize(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void setTrackInfo(ArrayList<TrackInfo> trackInfos)
    {
        this.trackInfos = trackInfos;
    }

}
