package fr.louisbl.helloagaincrm;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.firebase.client.Firebase;

import fr.louisbl.helloagaincrm.home.RegisterFragment;

public class MainActivity extends AppCompatActivity implements RegisterFragment.OnRegisterListener {

    private static final String TAG = "MainActivity";
    private Toolbar mToolbar;
    private Firebase mFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Firebase.setAndroidContext(this);
        mFirebaseRef = new Firebase("https://glowing-torch-7716.firebaseio.com/");

        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentContainer, new RegisterFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menuMainRegisterItem) {
            Log.d(TAG, "menuMainRegisterItem clicked");
            Snackbar.make(findViewById(R.id.mainContainer), "Menu item clicked", Snackbar.LENGTH_LONG)
                    .show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRegisterClicked() {
        Log.d(TAG, "onRegisterClicked");
        mFirebaseRef.child("registering").setValue("registered");
    }
}
