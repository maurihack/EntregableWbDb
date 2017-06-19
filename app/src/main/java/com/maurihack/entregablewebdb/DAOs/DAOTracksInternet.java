package com.maurihack.entregablewebdb.DAOs;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.maurihack.entregablewebdb.Model.Track;
import com.maurihack.entregablewebdb.Model.TrackContainer;
import com.maurihack.entregablewebdb.Util.DAOException;
import com.maurihack.entregablewebdb.Util.HTTPConnectionManager;
import com.maurihack.entregablewebdb.Util.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class DAOTracksInternet {

    public void getTracksFromWeb(ResultListener<List<Track>> listenerDelController){
        getTracksTask getTracksTask = new getTracksTask();
        getTracksTask.setControllerListener(listenerDelController);
        getTracksTask.execute();
    }

    public class getTracksTask extends AsyncTask<String,Void,List<Track>> {

        private ResultListener controllerListener;

        public void setControllerListener(ResultListener controllerListener) {
            this.controllerListener = controllerListener;
        }

        @Override
        protected List<Track> doInBackground(String... params) {

            List<Track> trackList = new ArrayList<>();
            String urlJson = "https://api.myjson.com/bins/zwe9v";
            try {
                HTTPConnectionManager httpConnectionManager = new HTTPConnectionManager();
                String json = httpConnectionManager.getRequestString(urlJson);
                Gson gson = new Gson();
                TrackContainer container = gson.fromJson(json,TrackContainer.class);
                trackList = container.getTracks();

            } catch (DAOException e) {
                e.printStackTrace();
            }
            return trackList;
        }

        @Override
        protected void onPostExecute(List<Track> trackList) {
            controllerListener.finish(trackList);
        }
    }
}
