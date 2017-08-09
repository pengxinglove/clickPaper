package com.hp.clickread;

/**
 * Created by hasee on 2017/8/10.
 */

public class TrackInfo {
    public int track_id;
    public float track_bottom;
    public float track_left;
    public float track_right;
    public float track_top;

    public TrackInfo(int id , float left, float top, float right, float bottom) {
        track_id = id;
        track_left = left;
        track_top = top;
        track_right = right;
        track_bottom = bottom;
    }
}
