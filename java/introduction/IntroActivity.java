package introduction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.telluriumtech.chemistrycalculator.R;

public class IntroActivity extends AppCompatActivity {
    public static final int WELCOME_TIMEOUT = 3000; //milliseconds

    public TextView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        //This is to make the title logo invisible in the beginning so that it can appear after 1 second
        logo = (TextView) findViewById(R.id.title_logo);
        logo.setVisibility(View.INVISIBLE);

        //This is to make the title logo appear after 1 second with a cool fade in animation
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                TextView textview= (TextView) findViewById(R.id.title_logo);
            Animation fadeIn = AnimationUtils.loadAnimation(IntroActivity.this, R.anim.fade_in);
                textview.startAnimation(fadeIn);
                logo.setVisibility(View.VISIBLE);

        }
        }, 1000);

        //After the cool animation of the logo comes on this will go to the next activity being homescreen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i =new Intent(IntroActivity.this,HomeScreen.class);
                startActivity(i);
                //fades logo out
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, WELCOME_TIMEOUT);
    }

}
