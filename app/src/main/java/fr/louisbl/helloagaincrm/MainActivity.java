package fr.louisbl.helloagaincrm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import fr.louisbl.helloagaincrm.home.RegisterFragment;

public class MainActivity extends AppCompatActivity implements RegisterFragment.OnRegisterListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainContainer, new RegisterFragment())
                    .commit();
        }
    }

    @Override
    public void onRegisterClicked() {
        Log.d(TAG, "onRegisterClicked");
    }
}
