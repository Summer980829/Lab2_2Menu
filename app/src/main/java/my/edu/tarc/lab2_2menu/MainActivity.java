package my.edu.tarc.lab2_2menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textViewMessage;
    private float size; //to store font size
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewMessage = findViewById(R.id.textViewMessage);
        size = textViewMessage.getTextSize()/getResources().getDisplayMetrics().density;
        //to find the screen density. text on screen / current screen density


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
        }else if(id == R.id.action_zoom_in){
            //TODO : write code to increase font size
            //float tempSize = size+2;
            //textViewMessage.setTextSize(tempSize);
            size++;
            textViewMessage.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);

        }else if(id == R.id.action_zoom_out){
            //TODO : write code to decrease font size
//            float tempSize = size-2;
//            textViewMessage.setTextSize(tempSize);
            size = size - 2;
            textViewMessage.setTextSize(size);
        }else if(id == R.id.action_about_us){
            //TODO : Create an Explicit Intent and start the About Us Activity
            Intent intent = new Intent(this, AboutUsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
