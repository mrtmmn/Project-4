package com.example.maratmamin.rentamate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    // Keep all Images in array
    public Integer[] mThumbIds = {
            R.drawable.homiestwo, R.drawable.homies,
            R.drawable.homies, R.drawable.homiestwo,
            R.drawable.homiestwo, R.drawable.homies,
            R.drawable.homies, R.drawable.homiestwo,
            R.drawable.homiestwo, R.drawable.homies,
            R.drawable.homies, R.drawable.homiestwo,
            R.drawable.homiestwo, R.drawable.homies,
            R.drawable.homies
    };

    // Constructor
    public ImageAdapter(Context c){
        mContext = c;
    }

    @Override
    public int getCount() {
        return mThumbIds.length;
    }

    @Override
    public Object getItem(int position) {
        return mThumbIds[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

//    https://auth.firebase.com/v2/<YOUR-FIREBASE-APP>/auth/facebook/callback

}
