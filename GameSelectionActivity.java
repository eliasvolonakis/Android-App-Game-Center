package a207phase1.fall2018.gamecentre;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

public class GameSelectionActivity extends AppCompatActivity {
    Spinner spinner;
    String spinnerSelection;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_choice);

        spinner = findViewById(R.id.spinner);
        spinnerSelection = "default";

        ArrayList<String> list = new ArrayList<>();
        list.add("Sliding Tiles");
        list.add("Hangman");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, list);

        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerSelection = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        addPlayButtonListener();
    }
    private void addPlayButtonListener(){
        Button playButton = findViewById(R.id.PlayButton);
        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (spinnerSelection.equals("Sliding Tiles")){
                    switchToSlidingTiles();
                }

            }
        });
    }
    private void switchToSlidingTiles(){
        Intent slidingMenu = new Intent(this, SlidingTilesMenuActivity.class);
        startActivity(slidingMenu);
    }


}
