package com.maurihack.entregablewebdb.Controllers;


import android.content.Context;
import android.widget.Toast;

import com.maurihack.entregablewebdb.DAOs.DAOTrackDatabase;
import com.maurihack.entregablewebdb.DAOs.DAOTracksInternet;
import com.maurihack.entregablewebdb.Model.Track;
import com.maurihack.entregablewebdb.Util.HTTPConnectionManager;
import com.maurihack.entregablewebdb.Util.ResultListener;

import java.util.List;

public class Controller {


    private Context context;

    public Controller(Context context) {
        this.context = context;
    }


    public void getTrackList(final ResultListener<List<Track>> resultListenerFromView) {


        if(HTTPConnectionManager.isNetworkingOnline(context)) {
            DAOTracksInternet daoTracksInternet = new DAOTracksInternet();
            daoTracksInternet.getTracksFromWeb(new ResultListener<List<Track>>() {
                @Override
                public void finish(List<Track> tracks) {

                    //GUARDO EN LA BASE DE DATOS LA LISTA QUE TRAJE DE INTERNET
                    DAOTrackDatabase daoPersonDatabase = new DAOTrackDatabase(context);
                    daoPersonDatabase.addPersons(tracks);

                    resultListenerFromView.finish(tracks);
                }
            });
            Toast.makeText(context, "Estoy con internet", Toast.LENGTH_SHORT).show();
        }
        else {

            DAOTrackDatabase daoTrackDatabase = new DAOTrackDatabase(context);
            List<Track> tracks = daoTrackDatabase.getAllPersons();
            resultListenerFromView.finish(tracks);
            Toast.makeText(context, "Estoy con la base", Toast.LENGTH_SHORT).show();
        }
    }

}
