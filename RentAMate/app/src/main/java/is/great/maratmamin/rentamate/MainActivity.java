package is.great.maratmamin.rentamate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.FirebaseListAdapter;
import com.firebase.ui.auth.core.AuthProviderType;
import com.firebase.ui.auth.core.FirebaseLoginBaseActivity;
import com.firebase.ui.auth.core.FirebaseLoginError;
import com.great.maratmamin.rentamate.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private Firebase mRef = new Firebase("https://marat-mamin.firebaseio.com/");
    private Firebase mRefUser = mRef.child("users");
    private ArrayList<User> userList = new ArrayList<User>();
    private ImageButton mImageButton;
    private ImageAdapter mImageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (mRef.getAuth() == null) {
            loadLoginView();
        }

//        Intent intent = getIntent();
//        logIn = intent.getStringExtra("Login");
//        if (logIn == null) {emergeAlertDialog();}

        GridView gridView = (GridView) findViewById(R.id.grid_view);

        mImageButton = (ImageButton) findViewById(R.id.imagebutton);
        mImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopup(mImageButton);
            }
        });

        // Instance of ImageAdapter Class
        mImageAdapter = new ImageAdapter(this, userList);
        gridView.setAdapter(mImageAdapter);

        mRefUser.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                userList.add(dataSnapshot.getValue(User.class));

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        /**
         * On Click event for Single Gridview Item
         * */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), FullImageActivity.class);
                // passing array index
//                i.putExtra("id", position);
                User userPassed = (User)mImageAdapter.getItem(position);
                i.putExtra("passed", userPassed);
                startActivity(i);
            }
        });

//        Firebase mRef = new Firebase(getResources().getString(R.string.firebase_url));
//        mRef.createUser("bobtony@firebase.com", "correcthorsebatterystaple", new Firebase.ValueResultHandler<Map<String, Object>>() {
//            @Override
//            public void onSuccess(Map<String, Object> result) {
//                System.out.println("Successfully created user account with uid: " + result.get("uid"));
//            }
//
//            @Override
//            public void onError(FirebaseError firebaseError) {
//                // there was an error
//            }
//        });

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_logout) {
//            mRef.unauth();
//            loadLoginView();
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.main_menu, popup.getMenu());
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
//            mRef.unauth();
//            loadLoginView();
            signout();
        }
        return true;
    }

    private void loadLoginView() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void signout() {
        try {
            //clearing app data
            Runtime runtime = Runtime.getRuntime();
            runtime.exec("pm clear is.great.maratmamin.rentamate");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //    public void emergeAlertDialog() {
//        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
//
//        //inflate dialog layout
////        LayoutInflater inflater = MainActivity.this.getLayoutInflater();
//
//        // Inflate and set the layout for the dialog
//        // Pass null as the parent view because its going in the dialog layout
////        alertDialogBuilder.setView(inflater.inflate(R.layout.login_dialog, null))
//        // set title
//        alertDialogBuilder.setTitle("Login");
////
////        // set dialog message
//        alertDialogBuilder
//                .setMessage("You Must Login To Proceed")
//                .setCancelable(false)
//                .setPositiveButton("Login",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//                        startActivity(intent);
//                        // if this button is clicked, close
//                        // current activity
////                        MainActivity.this.finish();
//                    }
//                })
//                .setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog,int id) {
//                        Toast.makeText(MainActivity.this, "You Must Login To Proceed", Toast.LENGTH_SHORT).show();
////                        dialog.cancel();
//                    }
//                });
//
//        // create alert dialog
//        AlertDialog alertDialog = alertDialogBuilder.create();
//
//        // show it
//        alertDialog.show();
//    }
}
