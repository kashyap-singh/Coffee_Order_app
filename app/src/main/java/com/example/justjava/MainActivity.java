package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=0;
    boolean c,w;
    public void increment(View view)
    {
        if(quantity==100)
        {
            quantity=100;
        }
        else {
            quantity = quantity + 1;
        }
        show_quantity();
    }
    public void decrement(View view)
    {
        if(quantity==0)
        {
            quantity=0;
        }
        else {
            quantity = quantity - 1;
        }
        show_quantity();
    }
    public void show_quantity()
    {
        TextView quantity_updater=(TextView) findViewById(R.id.quantity_text);
        quantity_updater.setText(""+quantity);
    }

    public void order_summary(View view)
    {
        EditText name_set =(EditText) findViewById(R.id.name_text);
        String name=name_set.getText().toString();
        CheckBox chocolate=(CheckBox) findViewById(R.id.chocolate);
        c=chocolate.isChecked();
        CheckBox w_cream=(CheckBox) findViewById(R.id.cream);
        w=w_cream.isChecked();
        String str=create_string(name,w,c);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "My First App");
        intent.putExtra(Intent.EXTRA_TEXT, str);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    public String create_string(String name,boolean w,boolean c)
    {
        String st="NAME :" + name;
        st += "\nAdd whipped cream? " + w;
        st +="\nAdd chocolate? "+c;
        st+="\nQuantity :"+quantity+"\nTotal_price :"+5*quantity+"\nThankyou";
        return st;

    }
    
}