package com.maurihack.entregablewebdb.Views;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.maurihack.entregablewebdb.Controllers.Controller;
import com.maurihack.entregablewebdb.Model.Track;
import com.maurihack.entregablewebdb.R;
import com.maurihack.entregablewebdb.Util.ResultListener;

import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerViewMain);
        final TrackRecyclerViewAdapter adapter = new TrackRecyclerViewAdapter(this);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter);

        Controller controller = new TrackController();
        controller.getTracks(new ResultListener<List<Track>>() {
            @Override
            public void finish(List<Track> resultado) {

                adapter.setTrackList(resultado);
                adapter.notifyDataSetChanged();
            }
        });
    }

}
