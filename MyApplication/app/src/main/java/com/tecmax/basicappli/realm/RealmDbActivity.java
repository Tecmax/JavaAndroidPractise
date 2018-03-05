package com.tecmax.basicappli.realm;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.tecmax.basicappli.R;

import java.util.List;

import io.realm.Realm;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class RealmDbActivity extends AppCompatActivity {
    EditText una, pas;
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_db);
        una = findViewById(R.id.una);
        pas = findViewById(R.id.pas);
        realm = Realm.getDefaultInstance();
        Typeface fComic = Typeface.createFromAsset(getAssets(),
                "fonts/test.ttf");
        una.setTypeface(fComic);
        List<Profile> profileList = realm.where(Profile.class).findAll();
        Log.d("LEts Check", "ds"+profileList.get(0).getUserName());
    }
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public void login(View view) {
        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Number currentIdNum = realm.where(Profile.class).max("id");
                int nextId;
                if (currentIdNum == null) {
                    nextId = 1;
                } else {
                    nextId = currentIdNum.intValue() + 1;
                }
                Profile cc = new Profile();
                cc.setId(nextId);
                cc.setUserName(una.getText().toString().trim());
                cc.setPassword(pas.getText().toString().trim());
                realm.insert(cc);
            }
        },new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                // Transaction was a success.
            }
        }, new Realm.Transaction.OnError() {
            @Override
            public void onError(Throwable error) {
                // Transaction failed and was automatically canceled.
            }
        });
    }


}
