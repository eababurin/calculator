package ru.eababurin.calculator;


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

    public void setSymbol(String symbol) {
        this.symbol = symbol;
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

    public double getFirstVariable() {
        return firstVariable;
    }

    public void setFirstVariable(double firstVariable) {
        this.firstVariable = firstVariable;
    }

    public double getSecondVariable() {
        return secondVariable;
    }

    public void setSecondVariable(double secondVariable) {
        this.secondVariable = secondVariable;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
