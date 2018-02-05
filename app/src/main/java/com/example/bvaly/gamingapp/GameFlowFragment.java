package com.example.bvaly.gamingapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by bvalyan on 1/30/18.
 */

public class GameFlowFragment extends Fragment {

    static ArrayList<GameData> currentGameList;

    public static GameFlowFragment newInstance(ArrayList<GameData> games) {

        Bundle args = new Bundle();
        currentGameList = games;
        GameFlowFragment fragment = new GameFlowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.game_flow_fragment, container,false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final HorizontalInfiniteCycleViewPager horizontalInfiniteCycleViewPager =
                (HorizontalInfiniteCycleViewPager) view.findViewById(R.id.new_release_covers);
        HorizontalPagerAdapter adapter = null;
        try {
            adapter = new HorizontalPagerAdapter(getContext(),currentGameList, view);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        horizontalInfiniteCycleViewPager.setAdapter(adapter);
        final HorizontalPagerAdapter finalAdapter = adapter;
        horizontalInfiniteCycleViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int state) {}
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {}
            public void onPageSelected(int position) {
                try {
                    finalAdapter.pageChanged(horizontalInfiniteCycleViewPager.getRealItem());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        horizontalInfiniteCycleViewPager.notifyDataSetChanged();
    }
}
