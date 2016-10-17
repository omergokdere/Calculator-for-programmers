package com.og.calcog;

/**
 * Created by OG on 08/03/2016.
 */
public class Equation {
    private String equation;
    private int ecindex;
    private int numerationBase;

    public Equation(String equation, int base) {
        this.equation = equation + "T";;
        this.numerationBase = base;
        this.ecindex = 0;
    }
    public Equation(String equation) {
        this(equation, 10);
    }

    public String Result() {
        while (equation.charAt(equation.length() - 1) == '/' ||
                equation.charAt(equation.length() - 1) == '*' ||
                equation.charAt(equation.length() - 1) == '+' ||
                equation.charAt(equation.length() - 1) == '-') {
            equation = equation.substring(0, equation.length() - 1);
        }
        int result = EvalEquation();
        return Converter.ConvertInt(Integer.toString(result), 10, numerationBase);
    }

    private int EvalEquation() {
        int nr = EvalTermen();

        while (equation.charAt(ecindex) == '+' || equation.charAt(ecindex) == '-') {
            switch (equation.charAt(ecindex)) {
                case '+': {
                    ecindex++;
                    nr += EvalTermen();
                } break;

                case '-': {
                    ecindex++;
                    nr -= EvalTermen();
                } break;
            }
        }

        return nr;
    }
    private int EvalTermen() {
        int nr = EvalFactor();

        while (equation.charAt(ecindex) == '*' || equation.charAt(ecindex) == '/') {
            switch (equation.charAt(ecindex)) {
                case '*': {
                    ecindex++;
                    nr *= EvalFactor();
                } break;

                case '/': {
                    ecindex++;
                    nr /= EvalFactor();
                } break;
            }
        }

        return nr;
    }
    private int EvalFactor() {
        int nr;

        if (equation.charAt(ecindex) == '(') {
            ecindex++;
            nr = EvalEquation();
            ecindex++;
        } else {
            nr = ParseNumber();
        }

        return nr;
    }
    private int ParseNumber() {
        int nr = 0;

        while (IsNumber(equation.charAt(ecindex))) {
            nr = nr * numerationBase + CharDigitToInteger(equation.charAt(ecindex));
            ecindex++;
        }

        return nr;
    }
    private boolean IsNumber(char c) {
        if (('0' <= c && c <= '9') || ('a' <= c && c <= 'f')) {
            return true;
        }
        return false;
    }
    private int CharDigitToInteger(char c) {
        if ('a' <= c && c <= 'f') {
            return c - 'a' + 10;
        }
        return c - '0';
    }
}