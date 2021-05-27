package sg.edu.rp.c346.id20047518.mylocalbanks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView dbs;
    TextView ocbc;
    TextView uob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs = findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);
        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId()==0) {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.dbs.com.sg"));
            startActivity(browserIntent);
        } else if (item.getItemId()==1) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: "+999));
            startActivity(intentCall);
        }
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            dbs.setText("星展银行");
            ocbc.setText("华商银行");
            uob.setText("大华银行");
            return true;
        } else {
            //tvTranslatedText.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}