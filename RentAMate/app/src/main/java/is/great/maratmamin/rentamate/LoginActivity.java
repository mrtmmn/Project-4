package is.great.maratmamin.rentamate;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.ui.auth.core.AuthProviderType;
import com.firebase.ui.auth.core.FirebaseLoginBaseActivity;
import com.firebase.ui.auth.core.FirebaseLoginError;
import com.great.maratmamin.rentamate.R;

import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends FirebaseLoginBaseActivity{
    private Firebase mRef = new Firebase("https://marat-mamin.firebaseio.com/");

//    private static final String TAG = LoginActivity.class.getSimpleName();
//
//    protected EditText emailEditText;
//    protected EditText passwordEditText;
//    protected Button loginButton;
//    protected TextView signUpTextView;
//
//    protected LoginButton facebookLB;
//    protected CallbackManager callbackManager;
//    protected AccessTokenTracker accessTokenTracker;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//
//        final Firebase ref = new Firebase("https://marat-mamin.firebaseio.com/");
//
//        signUpTextView = (TextView)findViewById(R.id.signUpText);
//        emailEditText = (EditText)findViewById(R.id.emailField);
//        passwordEditText = (EditText)findViewById(R.id.passwordField);
//        loginButton = (Button)findViewById(R.id.loginButton);
//
//        callbackManager = CallbackManager.Factory.create();
//        facebookLB = (LoginButton)findViewById(R.id.login_button);
//        facebookLB.setReadPermissions("user_photos");
//        LoginManager.getInstance().registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                Log.i("[]", loginResult.getAccessToken().toString());
////                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
////                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
////                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
////                startActivity(intent);
//            }
//
//            @Override
//            public void onCancel() {
//
//            }
//
//            @Override
//            public void onError(FacebookException error) {
//                Log.i("hlhlhlhlhl", error.getMessage());
//            }
//        });
//
//        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "user_friends", "user_photos"));
//
//        accessTokenTracker = new AccessTokenTracker() {
//            @Override
//            protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
////                currentAccessToken.getToken();
//                // Set the access token using
//                // currentAccessToken when it's loaded or set.
//            }
//        };
//
//        Bundle params = new Bundle();
//        params.putString("fields", "id,email,gender,cover,picture.type(large)");
//        new GraphRequest(AccessToken.getCurrentAccessToken(), "me", params, HttpMethod.GET,
//                new GraphRequest.Callback() {
//                    @Override
//                    public void onCompleted(GraphResponse response) {
//                        if (response != null) {
//                            try {
//                                JSONObject data = response.getJSONObject();
//                                if (data.has("picture")) {
//                                    String profilePicUrl = data.getJSONObject("picture").getJSONObject("data").getString("url");
//                                    Bitmap profilePic = getFacebookProfilePicture(profilePicUrl);
//                                    Log.d("prettypicture", profilePicUrl);
//                                    // set profilePic bitmap to imageview
//                                }
//                            } catch (Exception e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                }).executeAsync();
//
//        signUpTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String email = emailEditText.getText().toString();
//                String password = passwordEditText.getText().toString();
//
//                email = email.trim();
//                password = password.trim();
//
//                if (email.isEmpty() || password.isEmpty()) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                    builder.setMessage(R.string.login_error_message)
//                            .setTitle(R.string.login_error_title)
//                            .setPositiveButton(android.R.string.ok, null);
//                    AlertDialog dialog = builder.create();
//                    dialog.show();
//                } else {
//                    final String emailAddress = email;
//
//                    //Login with an email/password combination
//                    ref.authWithPassword(email, password, new Firebase.AuthResultHandler() {
//                        @Override
//                        public void onAuthenticated(AuthData authData) {
//                            // Authenticated successfully with payload authData
//                            Map<String, Object> map = new HashMap<String, Object>();
//                            map.put("email", emailAddress);
//                            ref.child("users").child(authData.getUid()).setValue(map);
//
//                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
//                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//                            startActivity(intent);
//                        }
//
//                        @Override
//                        public void onAuthenticationError(FirebaseError firebaseError) {
//                            // Authenticated failed with error firebaseError
//                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
//                            builder.setMessage(firebaseError.getMessage())
//                                    .setTitle(R.string.login_error_title)
//                                    .setPositiveButton(android.R.string.ok, null);
//                            AlertDialog dialog = builder.create();
//                            dialog.show();
//                        }
//                    });
//                }
//            }
//        });
    }

    @Override
    protected Firebase getFirebaseRef() {
        return mRef;
    }

    @Override
    protected void onFirebaseLoginProviderError(FirebaseLoginError firebaseLoginError) {
        Log.d("firebaseerror", firebaseLoginError.message);
    }

    @Override
    protected void onFirebaseLoginUserError(FirebaseLoginError firebaseLoginError) {
        Log.d("firebaseerror", firebaseLoginError.message);
    }

    @Override
    public void onFirebaseLoggedIn(AuthData authData) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("email", authData.getProviderData().get("email"));
//        Log.d("snickerypokery", authData.getProviderData().get("email").toString());
//        mRef.child("users").child(authData.getUid()).setValue(map);
        // didn't allow me to get it bc the key hash wasn't go through when i tried to get
        // the user's email address

        Map<String, Object> map = new HashMap<String, Object>();
        map = authData.getProviderData();
        Log.d("jiggery-pokery", String.valueOf(map.get("accessToken")));
        Log.d("jiggery-pokery2", String.valueOf(map.get("cachedUserProfile")));

        mRef.child("users").child(authData.getUid()).setValue(map);

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        intent.putExtra("picture", authData.getUid());
        //or make static class separately
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    @Override
    public void onFirebaseLoggedOut() {

    }

    @Override
    protected void onStart() {
        super.onStart();
        // All providers are optional! Remove any you don't want.
        setEnabledAuthProvider(AuthProviderType.FACEBOOK);
        setEnabledAuthProvider(AuthProviderType.TWITTER);
        setEnabledAuthProvider(AuthProviderType.PASSWORD);
        if (mRef.getAuth() == null) {
            showFirebaseLoginPrompt();
        }
    }
//
//    public static Bitmap getFacebookProfilePicture(String url){
//        URL facebookProfileURL= null;
//        try {
//            facebookProfileURL = new URL(url);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        Bitmap bitmap = null;
//        try {
//            bitmap = BitmapFactory.decodeStream(facebookProfileURL.openConnection().getInputStream());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return bitmap;
//    }

}
