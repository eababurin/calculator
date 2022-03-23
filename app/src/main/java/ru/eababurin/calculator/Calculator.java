package ru.eababurin.calculator;

import android.util.Log;

public class Calculator {
    private String textIndicator = "0";
    private String symbol = "";

    private double firstVariable = 0;
    private double secondVariable = 0;
    private double result = 0;

    protected String getTextIndicator() {
        return textIndicator;
    }

    protected void setTextIndicator(String textIndicator) {
        this.textIndicator = textIndicator;
    }

    protected String getSymbol() {
        return symbol;
    }

    protected void appendKey(char value) {
        if (textIndicator.length() == 1 && textIndicator.startsWith("0")) {
            if (value == 0) {
            } else {
                textIndicator = String.valueOf(value);
            }
        } else {
            textIndicator = getTextIndicator() + value;
        }
    }

    protected void changePositiveOrNegativeNumber() {
        if (textIndicator.equals("0")) {
            return;
        }

        if (textIndicator.startsWith("-")) {
            textIndicator = textIndicator.substring(1);
        } else {
            textIndicator = "-" + textIndicator;
        }
    }

    protected void deleteLastNumber() {
        if (textIndicator.length() != 0) {
            textIndicator = textIndicator.substring(0, textIndicator.length() - 1);
        }
    }

    protected void calculate() {
        secondVariable = Double.parseDouble(textIndicator);
        Log.d("test", "1 = " + firstVariable + " 2=" + secondVariable);

        switch (symbol) {
            case "+":
                result = firstVariable + secondVariable;
                break;
            case "-":
                result = firstVariable - secondVariable;
                break;
            case "*":
                result = firstVariable * secondVariable;
                break;
            case "/":
                result = firstVariable / secondVariable;
                break;
            case "%":
                result = 100 * secondVariable / firstVariable;
                break;
        }
        symbol = "";
        textIndicator = Double.toString(result);
    }

    protected void operationKey(String operation) {
        switch (operation) {
            case "/":
                symbol = "/";
                firstVariable = Double.parseDouble(textIndicator);
                textIndicator = "0";
                break;
            case "*":
                symbol = "*";
                firstVariable = Double.parseDouble(textIndicator);
                textIndicator = "0";
                break;
            case "%":
                symbol = "%";
                firstVariable = Double.parseDouble(textIndicator);
                textIndicator = "0";
                break;
            case "-":
                symbol = "-";
                firstVariable = Double.parseDouble(textIndicator);
                textIndicator = "0";
                break;
            case "+":
                symbol = "+";
                firstVariable = Double.parseDouble(textIndicator);
                textIndicator = "0";
                break;
            case "=":
                calculate();
                break;
        }

    }
}
