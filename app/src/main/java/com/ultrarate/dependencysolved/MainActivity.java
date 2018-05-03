package com.ultrarate.dependencysolved;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int value = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        boolean check = checkBoxState();
        boolean chocolate = checkChokletBox();
        String name = getName();
        int price = calculatePrice(check, chocolate);
        String display = displayOrderSummary(price,name, check, chocolate);
        displayOrder(display);

    }

    private String getName()
    {
        EditText editText = findViewById(R.id.input_textview);
        return editText.getText().toString();
    }

    private boolean checkChokletBox()
    {
        CheckBox box = findViewById(R.id.chocolate_textbox);
        if(box.isChecked())
            return true;

        return false;
    }

    private boolean checkBoxState() {
        CheckBox box = findViewById(R.id.check_box);
        if (box.isChecked()) {
            return true;
        }

        return false;
    }


    private String displayOrderSummary(int price, String name, boolean check, boolean chocolate) {
        String display = "Name: "+ name;
        display += "\nAdd Whipped Cream? " + check;
        display += "\nAdd chocolate? " + chocolate;
        display += "\nQuantity: " + value;
        display += "\nTotal $: "+ price;
        display += "\nThank You!";
        return display;
    }


    private int calculatePrice(boolean check, boolean chocolate) {

        int addon = 5;
        addon += (check ? 1 : 0);
        addon += (chocolate ? 2 : 0);

        return value * addon;
    }

    private void displayOrder(String display) {
        TextView textview = findViewById(R.id.price_text_view);
        textview.setText(display);


    }

    private void display() {
        TextView textView = findViewById(R.id.quantity_text_view);
        textView.setText("" + value);
    }

    public void increment(View view) {
        value += 1;
        display();
    }

    public void decrement(View view) {
        if (value != 0) {
            value -= 1;
            display();
        }
    }

}
