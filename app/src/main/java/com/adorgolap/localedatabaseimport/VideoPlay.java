package com.adorgolap.localedatabaseimport;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by ifta on 11/5/15.
 */
public class VideoPlay extends Activity {
    Context context;
    VideoView vv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video);
        context = this;
        vv = (VideoView)findViewById(R.id.videoView);
        vv.setMediaController(new MediaController(context));
        vv.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.myvideo));
        vv.start();
    }
}
