package results;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.telluriumtech.chemistrycalculator.R;

import combustion.Combustion;
import combustion.activity_combustion;
import doublereplacement.DoubleRep;
import doublereplacement.Doublerep1Activity;
import doublereplacement.Doublerep2Activity;
import doublereplacement.Doublerep3Activity;
import doublereplacement.Doublerep4Activity;
import introduction.HomeScreen;
import singlereplacement.SingleRep;
import singlereplacement.Singlerep1Activity;
import singlereplacement.Singlerep2Activity;
import singlereplacement.Singlerep3Activity;
import synthesis.FirstSynthesisActivity;
import synthesis.SecondSynthesisActivity;
import synthesis.SynthesisReaction;


public class Results extends AppCompatActivity {
    public static String reaction;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);



/*
       AdView mAdView = (AdView) findViewById(R.id.banner_AdView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
*/



        TextView synthesisText = (TextView) findViewById(R.id.SynthesisResult);
        TextView combustionText = (TextView) findViewById(R.id.combustionResult);
        TextView singleRepText = (TextView) findViewById(R.id.results_SingleRepResults);
        TextView doubleRepText = (TextView) findViewById(R.id.results_doubleReplacementResults);
        TextView redoxText = (TextView) findViewById (R.id.redoxTextView);
    TextView redoxTextSyn = (TextView) findViewById (R.id.redoxTextViewForSynthesis);
        if(reaction.equals("FirstSynthesisActivity"))
        {
            //Checks user input to see which elements he or she wants to balance
            SynthesisReaction.check(FirstSynthesisActivity.element1, SecondSynthesisActivity.element2);
            //synthesizes elements
            SynthesisReaction.synthesis();
            //Diatomic
            SynthesisReaction.diatomic();
            //Hydrogen test
            SynthesisReaction.hydrogen();
            // hydride
            SynthesisReaction.hydride();


            redoxTextSyn.setText(SynthesisReaction.getRedoxResult());

            synthesisText.setText(SynthesisReaction.finalResult);

            SynthesisReaction.setRedoxResult();



        }else if(reaction.equals("Combustion"))
        {
            Combustion.startCombustion(activity_combustion.selectedHydrocarbon);
            combustionText.setText(Combustion.finalResult);
        }else if(reaction.equals("single replacement"))
        {
            SingleRep.startSingleRep(Singlerep1Activity.loneMetal, Singlerep2Activity.element1OfCompound,
                    Singlerep3Activity.element2OfCompound);
            singleRepText.setText(SingleRep.getFinalResult());
            redoxText.setText(SingleRep.getRedoxResult());
            SingleRep.setRedoxResult();

        }else if(reaction.equals("Double Replacement"))
        {
            DoubleRep.startDoubleRep(Doublerep1Activity.cation1, Doublerep2Activity.anion1,
                    Doublerep3Activity.cation2, Doublerep4Activity.anion2);
            doubleRepText.setText(DoubleRep.getResult());

        }

        Button doubleReplacementButton = (Button) findViewById(R.id.results_ReturnButton);
        doubleReplacementButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(Results.this, HomeScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
