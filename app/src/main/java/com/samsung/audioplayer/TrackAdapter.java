package com.samsung.audioplayer;

import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import java.util.zip.Inflater;

public class TrackAdapter extends ArrayAdapter<Track> {
    List<Track> list;

    public TrackAdapter(@NonNull Context context, @NonNull List<Track> objects) {
        super(context, R.layout.track_item, objects);
        list = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.track_item, null);
        }

        Track track = list.get(position);

        TextView title = convertView.findViewById(R.id.trackTitle);
        title.setText(track.getTitle());

        TextView author = convertView.findViewById(R.id.trackAuto);
        author.setText(track.getAuthor());

        TextView duration = convertView.findViewById(R.id.trackDuration);
        duration.setText(MainActivity.timeFormatter((int) track.getDuration()));

        return convertView;
    }
}
