package singlereplacement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import com.telluriumtech.chemistrycalculator.R;

import customadapter.CustomArrayAdapter;

public class Singlerep2Activity extends AppCompatActivity {


    public static String element1OfCompound;

    private static String[] cations;

    //searchview, listview and arrayadapter objects
    ListView lv;
    SearchView sv;
    Button button;
    CustomArrayAdapter<String> adapter;

    public static String[] getArray()
    {
        return cations;
    }

    public static void setArray(String[] a)
    {
        cations = a;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singlerep2);

        //Initializing the objects
        button = (Button) findViewById(R.id.singlerep2_NextElementButton);
        lv = (ListView) findViewById(R.id.singlerep2_Element2List);
        sv = (SearchView) findViewById(R.id.singlerep2_search);
        adapter = new CustomArrayAdapter<> (this, android.R.layout.simple_list_item_1
                ,Singlerep2Activity.cations);



        //adding adapter and setting listview Invisible at the start
        lv.setAdapter(adapter);
        lv.setVisibility(View.INVISIBLE);

        //Goes to Results Tab and sets the which result to do
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Singlerep2Activity.this,Singlerep3Activity.class);
                startActivity(i);
            }
        });

//when you have nothing in searchview the list appears and this also sorts listview when you type
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length() == 0)
                {
                    lv.setVisibility(View.VISIBLE);
                    button.setVisibility(View.INVISIBLE);
                    adapter.getFilter().filter(newText);
                }else {
                    adapter.getFilter().filter(newText.substring(0, 1).toUpperCase() + newText.substring(1));
                }
                return false;
            }
        });

        //when you start searching the list view pops up
        sv.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lv.setVisibility(View.VISIBLE);
            }
        });

        //when you click anywhere on searchview you start it up
        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv.setIconified(false);
            }
        });

//Sets current item selected to searchview box and makes listview invisible
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {

                element1OfCompound = (String) adapter.getItemAtPosition(position).toString();
                CharSequence cs = element1OfCompound;
                sv.setQuery(cs, true);
                lv.setVisibility(View.INVISIBLE);
                button.setVisibility(View.VISIBLE);
                // MyClass selItem = (MyClass) adapter.getItem(position);
            }
        });

//Makes listview invisible when you close searchview
        sv.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                lv.setVisibility(View.INVISIBLE);
                return false;
            }
        });
    }

    /*
    //Makes keyboard invisible when you touch outside the widgets
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.
                INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        return true;
    }
    */
    }

