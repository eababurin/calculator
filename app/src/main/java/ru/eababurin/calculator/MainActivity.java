package ru.eababurin.calculator;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {

    Calculator calculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getSharedPreferences("THEME", Context.MODE_PRIVATE);
        if (Configuration.UI_MODE_NIGHT_YES == sharedPreferences.getInt("THEME", AppCompatDelegate.MODE_NIGHT_NO)) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView symbolTextView = findViewById(R.id.symbol_text_view);

        calculator = new Calculator();

        TextView textIndicator = findViewById(R.id.result);
        textIndicator.setText(calculator.getTextIndicator());

        if (savedInstanceState != null) {
            calculator.setFirstVariable(savedInstanceState.getDouble("firstVariable"));
            calculator.setSecondVariable(savedInstanceState.getDouble("secondVariable"));
            calculator.setSymbol(savedInstanceState.getString("symbol"));
            calculator.setResult(savedInstanceState.getDouble("result"));
            textIndicator.setText(Double.toString(savedInstanceState.getDouble("lastValue")));
        }

        findViewById(R.id.key_clear).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
                return true;
            }
        });

        View.OnClickListener clickListener = view -> {
            switch (view.getId()) {
                case R.id.key_1:
                    calculator.appendKey('1');
                    break;
                case R.id.key_2:
                    calculator.appendKey('2');
                    break;
                case R.id.key_3:
                    calculator.appendKey('3');
                    break;
                case R.id.key_4:
                    calculator.appendKey('4');
                    break;
                case R.id.key_5:
                    calculator.appendKey('5');
                    break;
                case R.id.key_6:
                    calculator.appendKey('6');
                    break;
                case R.id.key_7:
                    calculator.appendKey('7');
                    break;
                case R.id.key_8:
                    calculator.appendKey('8');
                    break;
                case R.id.key_9:
                    calculator.appendKey('9');
                    break;
                case R.id.key_0:
                    calculator.appendKey('0');
                    break;
                case R.id.key_dot:
                    calculator.appendKey('.');
                    break;
                case R.id.key_clear:
                    calculator.setTextIndicator("0");
                    break;
                case R.id.key_reverse:
                    calculator.changePositiveOrNegativeNumber();
                    break;
                case R.id.key_del:
                    calculator.deleteLastNumber();
                    break;
                case R.id.key_percent:
                    calculator.operationKey("%");
                    break;
                case R.id.key_division:
                    calculator.operationKey("/");
                    break;
                case R.id.key_multiplication:
                    calculator.operationKey("*");
                    break;
                case R.id.key_plus:
                    calculator.operationKey("+");
                    break;
                case R.id.key_minus:
                    calculator.operationKey("-");
                    break;
                case R.id.key_eq:
                    calculator.operationKey("=");
                    break;
            }
            textIndicator.setText(calculator.getTextIndicator());
            symbolTextView.setText(calculator.getSymbol());
        };

        findViewById(R.id.key_0).setOnClickListener(clickListener);
        findViewById(R.id.key_1).setOnClickListener(clickListener);
        findViewById(R.id.key_2).setOnClickListener(clickListener);
        findViewById(R.id.key_3).setOnClickListener(clickListener);
        findViewById(R.id.key_4).setOnClickListener(clickListener);
        findViewById(R.id.key_5).setOnClickListener(clickListener);
        findViewById(R.id.key_6).setOnClickListener(clickListener);
        findViewById(R.id.key_7).setOnClickListener(clickListener);
        findViewById(R.id.key_8).setOnClickListener(clickListener);
        findViewById(R.id.key_9).setOnClickListener(clickListener);
        findViewById(R.id.key_dot).setOnClickListener(clickListener);
        findViewById(R.id.key_clear).setOnClickListener(clickListener);
        findViewById(R.id.key_reverse).setOnClickListener(clickListener);
        findViewById(R.id.key_del).setOnClickListener(clickListener);
        findViewById(R.id.key_percent).setOnClickListener(clickListener);
        findViewById(R.id.key_division).setOnClickListener(clickListener);
        findViewById(R.id.key_multiplication).setOnClickListener(clickListener);
        findViewById(R.id.key_plus).setOnClickListener(clickListener);
        findViewById(R.id.key_minus).setOnClickListener(clickListener);
        findViewById(R.id.key_eq).setOnClickListener(clickListener);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putDouble("firstVariable", calculator.getFirstVariable());
        outState.putDouble("secondVariable", calculator.getSecondVariable());
        outState.putDouble("result", calculator.getResult());
        outState.putString("symbol", calculator.getSymbol());

        TextView textIndicator = findViewById(R.id.result);
        outState.putDouble("lastValue", Double.parseDouble((String) textIndicator.getText()));
    }
}
