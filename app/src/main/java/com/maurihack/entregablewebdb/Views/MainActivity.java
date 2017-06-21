package com.maurihack.entregablewebdb.Views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.maurihack.entregablewebdb.Controllers.Controller;
import com.maurihack.entregablewebdb.DAOs.DAOTrackDatabase;
import com.maurihack.entregablewebdb.Model.Track;
import com.maurihack.entregablewebdb.R;
import com.maurihack.entregablewebdb.Util.ResultListener;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent intent= new Intent(this, TrackActivity.class);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMain);
        final TrackRecyclerViewAdapter adapter = new TrackRecyclerViewAdapter(this);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);
        recyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int position = recyclerView.getChildAdapterPosition(v);
                Track clickedTrack = adapter.getTrackList().get(position);
                Bundle bundle = new Bundle();
                bundle.putInt(DAOTrackDatabase.TRACK_ID,clickedTrack.getTrackId());
                bundle.putInt(DAOTrackDatabase.ALBUM_ID,clickedTrack.getAlbumId());
                bundle.putString(DAOTrackDatabase.TITLE,clickedTrack.getTitle());
                bundle.putString(DAOTrackDatabase.IMAGE_MAIN,clickedTrack.getImageMain());
                bundle.putString(DAOTrackDatabase.THUMBNAIL,clickedTrack.getThumbnail());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Controller controller = new Controller(this);
        controller.getTrackList(new ResultListener<List<Track>>() {
            @Override
            public void finish(List<Track> resultado) {

                adapter.setTrackList(resultado);
                adapter.notifyDataSetChanged();
            }
        });
    }

}
