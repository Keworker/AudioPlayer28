package com.samsung.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class TrackListActivity extends AppCompatActivity {
    ArrayList<Track> arrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track_list);
        getMusic();
        ListView listView = findViewById(R.id.trackListV);
        TrackAdapter adapter = new TrackAdapter(this, arrayList);
        listView.setAdapter(adapter);
    }

    public void getMusic() {
        ContentResolver contentResolver = getContentResolver();
        Uri songUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query(songUri, null,
                null, null, null);
        if (songCursor != null && songCursor.moveToFirst()) {
            int songTitle = songCursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int songArtist = songCursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            int songId = songCursor.getColumnIndex(MediaStore.Audio.Media._ID);
            int songPath = songCursor.getColumnIndex(MediaStore.Audio.Media.DATA);
            int songDuration = songCursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            do {
                Track track = new Track(songCursor.getLong(songId), songCursor.getString(songTitle),
                        songCursor.getString(songArtist), songCursor.getString(songPath));
                track.setDuration(songCursor.getLong(songDuration));
                arrayList.add(track);
                Log.d("My", track.toString());
            } while (songCursor.moveToNext());
        }
        Log.d("My", String.valueOf(arrayList.size()));
    }
}