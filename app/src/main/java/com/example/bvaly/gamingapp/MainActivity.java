package com.example.bvaly.gamingapp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.igdb.api_android_java.callback.onSuccessCallback;
import com.igdb.api_android_java.model.APIWrapper;
import com.igdb.api_android_java.model.Parameters;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    HorizontalPagerAdapter adapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        APIWrapper wrapper = new APIWrapper(this, Constants.API_KEY);
        Parameters params = new Parameters()
                .addFields("*")
                .addFilter("[release_dates.date][gt]=2017-12-31")
                .addOrder("popularity:desc");

        wrapper.games(params, new onSuccessCallback(){
            @Override
            public void onSuccess(JSONArray result) {
                // Do something with resulting JSONArray
                Log.i("GAME ARRAY INFO","INFO HERE");
                ArrayList<GameData> mainCoverPagerArray = new ArrayList<>();
                for(int i = 0; i < result.length(); i++){
                    try {
                        GameData currentData = new GameData();

                        currentData.setId(result.getJSONObject(i).optInt("id"));
                        currentData.setName(result.getJSONObject(i).optString("name"));
                        currentData.setUrl(result.getJSONObject(i).optString("url"));
                        currentData.setSummary(result.getJSONObject(i).optString("summary"));
                        currentData.setCollection(result.getJSONObject(i).optInt("collection"));
                        currentData.setFranchise(result.getJSONObject(i).optInt("franchise"));
                        currentData.setFranchises(result.getJSONObject(i).optJSONArray("franchises"));
                        currentData.setHypes(result.getJSONObject(i).optInt("hypes"));
                        currentData.setPopularity(result.getJSONObject(i).optDouble("popularity"));
                        currentData.setGames(result.getJSONObject(i).optJSONArray("games"));
                        currentData.setTags(result.getJSONObject(i).optJSONArray("tags"));
                        currentData.setDevelopers(result.getJSONObject(i).optJSONArray("developers"));
                        currentData.setPublishers(result.getJSONObject(i).optJSONArray("publishers"));
                        currentData.setCategory(result.getJSONObject(i).optInt("category"));
                        currentData.setGameModes(result.getJSONObject(i).optJSONArray("game_modes"));
                        currentData.setKeywords(result.getJSONObject(i).optJSONArray("keywords"));
                        currentData.setThemes(result.getJSONObject(i).optJSONArray("themes"));
                        currentData.setFirstReleaseDate(result.getJSONObject(i).optLong("first_release_date"));
                        currentData.setPulseCount(result.getJSONObject(i).optInt("pulse_count"));
                        currentData.setPlatforms(result.getJSONObject(i).optJSONArray("platforms"));
                        currentData.setReleaseDates(result.getJSONObject(i).optJSONArray("release_dates"));
                        currentData.setScreenshots(result.getJSONObject(i).optJSONArray("screenshots"));
                        currentData.setVideos(result.getJSONObject(i).optJSONArray("videos"));
                        currentData.setCoverURL(result.getJSONObject(i).optJSONObject("cover"));
                        currentData.setEsrbRating(result.getJSONObject(i).optJSONObject("esrb"));
                        currentData.setWebsites(result.getJSONObject(i).optJSONArray("websites"));
                        currentData.setMultiplayerModes(result.getJSONObject(i).optJSONArray("multiplayer_modes"));

                        mainCoverPagerArray.add(currentData);
                    }
                    catch (JSONException e){
                            e.printStackTrace();
                    }

                }

                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container, GameFlowFragment.newInstance(mainCoverPagerArray))
                        .commit();
            }

            @Override
            public void onError(VolleyError error) {
                // Do something on error
            }
        });

    }

}
