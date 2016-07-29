package com.examle.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submitOrder(View view) {
        CheckBox whippedCreamCheck = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean statusWhippedCream = whippedCreamCheck.isChecked();

        EditText nameText = (EditText) findViewById(R.id.name_edit_text);
        String name = nameText.getText().toString();

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean statusChocolate = chocolate.isChecked();

        int price = calculatePrice(statusChocolate, statusWhippedCream);
        String summary = createOrderSummary(price, statusWhippedCream, statusChocolate, name);
        displayMessage(summary);
    }

    public void increment(View view) {
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        quantity--;
        displayQuantity(quantity);
    }

    private int calculatePrice(boolean chocolate, boolean whippedCream){
        int coffePrice = 5;
        if ( chocolate ) coffePrice++;
        if ( whippedCream ) coffePrice++;
        return quantity * coffePrice;
    }

    private String createOrderSummary(int price, boolean whippedCream, boolean chocolate, String name){

       return "Name: "+name+"\nAdd whipped cream? "+whippedCream+"\nQuantity: "+quantity+"\nTotal: $"+price+"\n Thank u!";
    }
    private void displayQuantity(int number) {
       TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
       quantityTextView.setText(""+quantity);
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
