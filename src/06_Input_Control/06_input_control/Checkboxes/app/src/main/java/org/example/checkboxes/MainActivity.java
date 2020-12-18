package org.example.checkboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox ch, ch1, ch2, ch3, ch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ch=(CheckBox)findViewById(R.id.checkBox);
        ch1=(CheckBox)findViewById(R.id.checkBox2);
        ch2=(CheckBox)findViewById(R.id.checkBox3);
        ch3=(CheckBox)findViewById(R.id.checkBox4);
        ch4=(CheckBox)findViewById(R.id.checkBox5);
    }

    public void Check(View v)
    {
        String msg="";

        // Concatenation of the checked options in if

        // isChecked() is used to check whether
        // the CheckBox is in true state or not.

        if(ch.isChecked())
            msg = msg + getString(R.string.chocolate_syrup);
        if(ch1.isChecked())
            msg = msg + getString(R.string.sprinkles);
        if(ch2.isChecked())
            msg = msg + getString(R.string.crushed_nuts);
        if(ch3.isChecked())
            msg = msg + getString(R.string.cheeries);
        if(ch4.isChecked())
            msg = msg + getString(R.string.orio_cookie_crumbles);

        // Toast is created to display the
        // message using show() method.
        Toast.makeText(this, "Toppings : "+msg ,
                Toast.LENGTH_LONG).show();
    }
}