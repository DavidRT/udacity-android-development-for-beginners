package com.examle.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
        composeEmail(getString(R.string.order_summary_email_subject, name), summary);
    }

    private void composeEmail(String subject, String message){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if ( intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
    }

    public void increment(View view) {
        if ( quantity >= 100){
            Toast.makeText(MainActivity.this, getText(R.string.validation_quantity), Toast.LENGTH_SHORT).show();
            return;
        }
        quantity++;
        displayQuantity(quantity);
    }

    public void decrement(View view) {
        if  ( quantity <= 0 ){
            Toast.makeText(MainActivity.this, getText(R.string.validation_quantity), Toast.LENGTH_SHORT).show();
            return;
        }
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
        String summaryText = getString(R.string.order_summary_name, name);
        summaryText+= "\n" + getString(R.string.order_summary_whipped_cream,whippedCream);
        summaryText+= "\n" + getString(R.string.order_summary_chocolate,chocolate);
        summaryText+= "\n" + getString(R.string.order_quantity,quantity);
        summaryText+= "\n" + getString(R.string.order_price, price);
        return summaryText;
    }

    private void displayQuantity(int number) {
       TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
       quantityTextView.setText(""+quantity);
    }
}
