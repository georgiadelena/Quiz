package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method calculates the score. 1 point is awarded for every right answer (max 7 points for all 7 questions)
     */
    public void calculateScore(){
        //question 1
        RadioButton wildeRadioButton = (RadioButton) findViewById(R.id.q12_radio_button);
        if (wildeRadioButton.isChecked()) score++;

        //question 2
        RadioButton miltonRadioButton = (RadioButton) findViewById(R.id.q21_radio_button);
        if (miltonRadioButton.isChecked()) score++;

        //question 3 - you get 1 point for selecting all three right checkboxes, otherwise it's a 0
        CheckBox neverwhereBox = (CheckBox) findViewById(R.id.neverwhere);
        CheckBox graveyardBox = (CheckBox) findViewById(R.id.graveyard);
        CheckBox godsBox = (CheckBox) findViewById(R.id.gods);
        CheckBox thingsBox = (CheckBox) findViewById(R.id.things);
        CheckBox oceanBox = (CheckBox) findViewById(R.id.ocean);
        if(godsBox.isChecked() || thingsBox.isChecked()){
            score += 0;
        }else if(neverwhereBox.isChecked() && graveyardBox.isChecked() && oceanBox.isChecked()){
            score++;
        }else{
            score += 0;
        }

        //question 4
        RadioButton charlotteRadioButton = (RadioButton) findViewById(R.id.q41_radio_button);
        if (charlotteRadioButton.isChecked()) score++;

        //question 5
        RadioButton scarletRadioButton = (RadioButton) findViewById(R.id.q53_radio_button);
        if (scarletRadioButton.isChecked()) score++;

        //question 6 - you get 1 point for selecting all three right checkboxes, otherwise it's a 0
        CheckBox salemsBox = (CheckBox) findViewById(R.id.salems_lot);
        CheckBox omensBox = (CheckBox) findViewById(R.id.good_omens);
        CheckBox petBox = (CheckBox) findViewById(R.id.pet_sematary);
        CheckBox standBox = (CheckBox) findViewById(R.id.the_stand);
        CheckBox nightBox = (CheckBox) findViewById(R.id.night_watch);
        if (omensBox.isChecked() || nightBox.isChecked()){
            score += 0;
        }else if (salemsBox.isChecked() && petBox.isChecked() && standBox.isChecked()){
            score++;
        }else{
            score += 0;
        }

        //question 7
        EditText editLastName = (EditText) findViewById(R.id.q7_edit_text);
        String lastName = editLastName.getText().toString().trim();
        if(lastName.equalsIgnoreCase("Bradbury")){
            score++;
        }
    }

    /**
     * This method is called when the submit button is clicked, to display the score.
     */
    public void showScore(View view) {
            calculateScore();
            EditText insertName = (EditText) findViewById(R.id.name_view);
            String name = insertName.getText().toString().trim();
            //Show a message as a toast
            Toast.makeText(this, "Hey " + name + "! " + getString(R.string.your_score)+ " " + score + "/7.", Toast.LENGTH_SHORT).show();
            score = 0;
    }
}