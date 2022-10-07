package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txt = findViewById(R.id.textView);

        registerForContextMenu(txt);
    }

//    this method is used to create context menu on long press of any component
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu,menu);
    }

//    this will perform action on selected item of context menu - long press
    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         iv = findViewById(R.id.imgv);
        switch (item.getItemId())
        {
            case R.id.alpha:
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
                iv.startAnimation(animation);
                break;

            case R.id.rotate:
                animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
                iv.startAnimation(animation);
                break;
        }
        return super.onContextItemSelected(item);
    }

//    create context menu on 3 dot..

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }
}