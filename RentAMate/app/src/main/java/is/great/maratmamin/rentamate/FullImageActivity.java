package is.great.maratmamin.rentamate;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.great.maratmamin.rentamate.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FullImageActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    ImageButton mImageButton;
    User userPassed;
    Firebase mRef = new Firebase("https://marat-mamin.firebaseio.com/");
    String mUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);

        // get intent data
        Intent i = getIntent();

        // Selected image id
        userPassed = (User) i.getSerializableExtra("passed");
        Log.d("nanananana", userPassed.getRequested());

        TextView userName = (TextView) findViewById(R.id.textview_name);
        if (userPassed.getDisplayName() != null) {
                mUserName = userPassed.getDisplayName();
                userName.setText(mUserName);
        } else {
            userName.setText(userPassed.getEmail());
        }

        TextView request = (TextView) findViewById(R.id.textview_request);
        try {
            final String userFacebookLink = userPassed.getCachedUserProfile().getLink();
            request.setText(userFacebookLink);
            request.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Uri uri = Uri.parse(userFacebookLink);
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        ImageView imageView = (ImageView) findViewById(R.id.full_image_view);
        if (userPassed.getProfileImageURL().contains("https://secure.gravatar.com/avatar")) {
            Picasso.with(FullImageActivity.this)
                    .load(R.drawable.homies)
                    .placeholder(R.drawable.homiesliving_blackandwhite_stonehouse)
                    .error(R.drawable.homies)
                    .into(imageView);
        }
        else {
            Picasso.with(FullImageActivity.this)
                    .load(userPassed.getProfileImageURL())
                    .placeholder(R.drawable.homiesliving_blackandwhite_stonehouse)
                    .error(R.drawable.homies)
                    .into(imageView);
        }

        mImageButton = (ImageButton) findViewById(R.id.imagebutton_request);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(mImageButton);
            }
        });

    }

//    ChildEventListener requestingChildEventListener = new ChildEventListener() {
//        @Override
//        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//
//        }
//
//        @Override
//        public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//            userPassed.;
//            mRef.getAuth().getUid();
//        }
//
//        @Override
//        public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//        }
//
//        @Override
//        public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//        }
//
//        @Override
//        public void onCancelled(FirebaseError firebaseError) {
//
//        }
//    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.image_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.request) {
            Log.d("authofuser", mRef.getAuth().getUid());
            Toast.makeText(FullImageActivity.this,(mUserName + " Will Recieve Your Request"), Toast.LENGTH_SHORT).show();
            //mRef.child("facebook:" + userPassed.getId()).child("request").setValue("requested by " + );
            //push() to node request and for each request have a unique id that correlates to each person who made the request

            
        }
        return true;
    }

}
