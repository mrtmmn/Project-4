package is.great.maratmamin.rentamate;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.firebase.client.Firebase;
import com.great.maratmamin.rentamate.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<User> mUserArrayList = new ArrayList<User>();

    // Constructor
    public ImageAdapter(Context c, ArrayList<User> userArrayList){
        mContext = c;
        mUserArrayList = userArrayList;
    }

    @Override
    public int getCount() {
        return mUserArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 300));
        if (mUserArrayList.get(position).getProfileImageURL().contains("https://secure.gravatar.com/avatar")) {
            Picasso.with(mContext)
                    .load(R.drawable.homies)
                    .into(imageView);
        }
        else {
            Picasso.with(mContext)
                    .load(mUserArrayList.get(position).getProfileImageURL())
                    .placeholder(R.drawable.homiesliving_blackandwhite_stonehouse)
                    .error(R.drawable.homies)
                    .into(imageView);
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return imageView;
    }

}
