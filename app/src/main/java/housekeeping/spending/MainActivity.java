package housekeeping.spending;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String[] CURRENCIES = {"PLN", "EUR", "RUB"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView currencyView = (AutoCompleteTextView) findViewById(R.id.currency);
        currencyView.setAdapter(new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, CURRENCIES));
    }

    @Override
    public void onClick(View view) {
        TextView amountView = (TextView) findViewById(R.id.amount);
        String amountAsString = amountView.getText().toString();
        double amount = Double.parseDouble(amountAsString);
        String currency = ((TextView) findViewById(R.id.currency)).getText().toString();
        TextView expenseDetailsView = (TextView) findViewById(R.id.expenseDetails);
        String expenseDetails = expenseDetailsView.getText().toString();
//        ((TextView)findViewById(R.id.debug)).setText(amount);
        amountView.setText("");
        expenseDetailsView.setText("");
        getCurrentFocus().clearFocus();
        Toast.makeText(this, R.string.toast_expenseSaved, Toast.LENGTH_LONG).show();
    }
}
