package introduction;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.telluriumtech.chemistrycalculator.Help;
import com.telluriumtech.chemistrycalculator.R;
import com.telluriumtech.chemistrycalculator.Terms;

import combustion.activity_combustion;
import doublereplacement.Doublerep1Activity;
import singlereplacement.Singlerep1Activity;
import synthesis.FirstSynthesisActivity;

public class HomeScreen extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.help) {
            Intent i=new Intent(HomeScreen.this, Help.class);
            startActivity(i);
            }

        if (id == R.id.terms) {
            Intent i=new Intent(HomeScreen.this, Terms.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity_home_screen, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        /*
         AdView mAdView = (AdView) findViewById(R.id.banner_AdView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(TEST_EMULATOR).build();
        mAdView.loadAd(adRequest);
*/
        new SimpleEula(this).show();
        Button synthesisButton =(Button) findViewById(R.id.synthesis_button);
        synthesisButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(HomeScreen.this, FirstSynthesisActivity.class);
                startActivity(i);

            }
        });

        Button combustionButton = (Button) findViewById(R.id.combustion_button);
        combustionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(HomeScreen.this, activity_combustion.class);
                startActivity(i);
            }
        });

        Button singleReplacementButton = (Button) findViewById(R.id.single_replacement_button);
        singleReplacementButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(HomeScreen.this, Singlerep1Activity.class);
                startActivity(i);
            }
        });

        Button doubleReplacementButton = (Button) findViewById(R.id.double_replacement_button);
        doubleReplacementButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i=new Intent(HomeScreen.this, Doublerep1Activity.class);
                startActivity(i);
            }
        });
    }
}
