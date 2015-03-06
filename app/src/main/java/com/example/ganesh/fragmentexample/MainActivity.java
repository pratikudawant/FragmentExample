package com.example.ganesh.fragmentexample;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.media.RemoteController;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {
    boolean a1 = true;
    Fragment thirdF, FourthF, fragOne, fragTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b1 = (Button) findViewById(R.id.button);

        final FragmentManager manager = getFragmentManager();
       final FragmentTransaction transaction = manager.beginTransaction();

               fragOne = new FragmentOne();

                fragTwo = new FragmentTwo();
        transaction.add(R.id.fragView, fragOne, "Fragment1");
        transaction.add(R.id.fragView, fragTwo, "Fragment2");
        transaction.commit();


       b1.setOnClickListener (new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                        thirdF = new FragmentOne();
                        FourthF= new FragmentTwo();

              if (!a1){
                  FragmentTransaction ft = manager.beginTransaction();
                  ft.replace(R.id.fragView,thirdF,"Frag1");
                  ft.replace(R.id.fragView,FourthF,"Frag2");
                  ft.commit();
              a1 = true;
              }
               else {
                  FragmentTransaction ft = manager.beginTransaction();
                  ft.replace(R.id.fragView,FourthF,"Frag2");
                  ft.replace(R.id.fragView,thirdF,"Frag1");
                  ft.commit();
                  a1=false;
              }
           }
       });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
