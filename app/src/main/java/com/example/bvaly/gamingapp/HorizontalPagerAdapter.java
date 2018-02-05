package com.example.bvaly.gamingapp;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.request.RequestOptions;
import com.example.bvaly.gamingapp.GameData;
import com.squareup.picasso.Picasso;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.gpu.KuwaharaFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.PixelationFilterTransformation;
import jp.wasabeef.glide.transformations.gpu.VignetteFilterTransformation;

/**
 * Created by bvaly on 11/9/2017.
 */

public class HorizontalPagerAdapter extends PagerAdapter {

    private Context mContext;
    private LayoutInflater mLayoutInflater;
    private HashMap<String,GameData> mData;
    private ArrayList<GameData> list;
    String coverString = "https://images.igdb.com/igdb/image/upload/t_cover_big/";
    String coverString2 = "https://images.igdb.com/igdb/image/upload/t_1080p/";
    View mLayout;
    final ImageView background;
    MultiTransformation multi = new MultiTransformation(
            new VignetteFilterTransformation());

    public HorizontalPagerAdapter(final Context context, ArrayList<GameData> data, View mainLayout) throws JSONException {
        mContext = context;
        mLayout = mainLayout;
        mLayoutInflater = LayoutInflater.from(context);
        list = data;
        background = (ImageView) mLayout.findViewById(R.id.background);

        String coverPath = coverString + list.get(0).getCoverURL().getString("cloudinary_id")+ ".png";
        Glide.with(mContext).load(coverString2 + list.get(0).getCoverURL().getString("cloudinary_id")+ ".png").into(background);
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        final View view;

        view = mLayoutInflater.inflate(R.layout.game_page_layout, container, false);
        TextView heroNameView = (TextView) view.findViewById(R.id.game_name);
        ImageView heroImageView = (ImageView) view.findViewById(R.id.game_cover);
        heroNameView.setText(list.get(position).getName());
        String coverPath = null;
        try {
            coverPath = coverString + list.get(position).getCoverURL().getString("cloudinary_id")+ ".png";
            Glide.with(mContext).load(coverPath).apply(RequestOptions.bitmapTransform(multi)).into(heroImageView);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        heroNameView.setVisibility(View.VISIBLE);
        container.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    public void destroyItem(final ViewGroup container, final int position, final Object object) {
        container.removeView((View) object);
    }
    public void pageChanged(int position) throws JSONException {

        String coverPath = coverString2 + list.get(position).getCoverURL().getString("cloudinary_id")+ ".png";
        Glide.with(mContext).load(coverPath).into(background);
    }



}
