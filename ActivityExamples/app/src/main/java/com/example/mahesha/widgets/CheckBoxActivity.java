package com.example.mahesha.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class CheckBoxActivity extends AppCompatActivity {
    private static final String TAG = "CheckBoxActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);
        CheckBox sandWich = (CheckBox) findViewById(R.id.checkbox_sandwich);
        sandWich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                    Toast.makeText(CheckBoxActivity.this, "sandwich Ready", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(CheckBoxActivity.this, "sandwich in Process", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.checkbox_meat:
                if (checked)
                    // Put some meat on the sandwich
                    Toast.makeText(this, "Put some meat on the sandwich", Toast.LENGTH_SHORT).show();
                else
                    // Remove the meat
                    Toast.makeText(this, "Remove the meat", Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkbox_cheese:
                if (checked)
                    // Cheese me.
                    Toast.makeText(this, "Put some Cheese on the sandwich", Toast.LENGTH_SHORT).show();
                else
                    // I'm lactose intolerant
                    Toast.makeText(this, "Remove the Cheese", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
