package com.og.calcog;

/**
 * Created by OG on 08/03/2016.
 */
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class main extends AppCompatActivity {

    private Button btnBin;
    private Button btnDec;
    private Button btnHex;
    private Button[] numericalButtons;
    private Button[] hexButtons;
    private Button btnDel;
    private Button btnClear;
    private Button btnPlus;
    private Button btnMinus;
    private Button btnMult;
    private Button btnDiv;
    private Button btnOP;
    private Button btnCP;
    private Button btnComma;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btnA;
    private Button btnB;
    private Button btnC;
    private Button btnD;
    private Button btnE;
    private Button btnF;


    private TextView input;
    private TextView output;
    private int numerationBase;


    public main() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (TextView) findViewById(R.id.input);
        output = (TextView) findViewById(R.id.output);
        btnBin = (Button) findViewById(R.id.btnBin);
        btnDec = (Button) findViewById(R.id.btnDec);
        btnHex = (Button) findViewById(R.id.btnHex);
        btnComma=(Button) findViewById(R.id.btnComma);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnA = (Button) findViewById(R.id.btnA);
        btnB = (Button) findViewById(R.id.btnB);
        btnC = (Button) findViewById(R.id.btnC);
        btnD = (Button) findViewById(R.id.btnD);
        btnE = (Button) findViewById(R.id.btnE);
        btnF = (Button) findViewById(R.id.btnF);



        numericalButtons = new Button[]{
                (Button) findViewById(R.id.btn0),
                (Button) findViewById(R.id.btn1),
                (Button) findViewById(R.id.btn2),
                (Button) findViewById(R.id.btn3),
                (Button) findViewById(R.id.btn4),
                (Button) findViewById(R.id.btn5),
                (Button) findViewById(R.id.btn6),
                (Button) findViewById(R.id.btn7),
                (Button) findViewById(R.id.btn8),
                (Button) findViewById(R.id.btn9)};

        hexButtons = new Button[]{
                (Button) findViewById(R.id.btnA),
                (Button) findViewById(R.id.btnB),
                (Button) findViewById(R.id.btnC),
                (Button) findViewById(R.id.btnD),
                (Button) findViewById(R.id.btnE),
                (Button) findViewById(R.id.btnF)
        };

        btnDel = (Button) findViewById(R.id.btnDel);
        btnClear = (Button) findViewById(R.id.btnClear);
        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        btnMult = (Button) findViewById(R.id.btnMult);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnOP = (Button) findViewById(R.id.btnOP);
        btnCP = (Button) findViewById(R.id.btnCP);

        btnBin.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnBinClicked();
                    }
                }
        );
        btnDec.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnDecClicked();
                    }
                }
        );
        btnHex.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnHexClicked();
                    }
                }
        );
        btnComma.setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        btnCommaClicked();
                    }
                }
        );
        for (int i = 0; i <= 9; i++) {
            numericalButtons[i].setTag(i);
            numericalButtons[i].setOnClickListener(
                    new Button.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            numericalButtonsClicked((int) v.getTag());
                        }
                    });
        }
        for (int i = 0; i < 6; i++) {
            hexButtons[i].setTag(i);
            hexButtons[i].setOnClickListener(
                    new Button.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            hexButtonsClicked((int) v.getTag());
                        }
                    }
            );
        }
        btnDel.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnDelClicked();
                    }
                });
        btnClear.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        input.setText("");
                        output.setText("");
                    }
                }
        );
        btnPlus.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnPlusClicked();
                    }
                });
        btnMinus.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnMinusClicked();
                    }
                });
        btnMult.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnMultClicked();
                    }
                });
        btnDiv.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnDivClicked();
                    }
                });

        btnOP.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnOPClicked();
                    }
                }
        );
        btnCP.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        btnCPClicked();
                    }
                }
        );

        btnDecClicked();
    }

    private void ButtonStateInInterval(int start, int stop, boolean state) {
        for (int i = start; i <= Math.min(9, stop); i++) {
            numericalButtons[i].setEnabled(state);
        }
        for (int i = Math.max(start, 10); i < 16; i++) {
            hexButtons[i - 10].setEnabled(state);
        }
    }

    private void SetNumerationBase(int base) {
        int previousBase = numerationBase;
        numerationBase = base;

        ButtonStateInInterval(0, base - 1, true);
        ButtonStateInInterval(base, 15, false);

        String previousOutput = output.getText().toString();
        output.setText(Converter.ConvertInt(previousOutput, previousBase, numerationBase));
    }

    private void btnBinClicked() {
        SetNumerationBase(2);
        btnBin.setBackgroundColor(Color.GRAY);
        btnBin.setTextColor(Color.BLACK);
        btnDec.setBackgroundColor(Color.BLACK);
        btnDec.setTextColor(Color.WHITE);
        btnHex.setBackgroundColor(Color.BLACK);
        btnHex.setTextColor(Color.WHITE);
        btn2.setBackgroundColor(Color.GRAY);
        btn3.setBackgroundColor(Color.GRAY);
        btn4.setBackgroundColor(Color.GRAY);
        btn5.setBackgroundColor(Color.GRAY);
        btn6.setBackgroundColor(Color.GRAY);
        btn7.setBackgroundColor(Color.GRAY);
        btn8.setBackgroundColor(Color.GRAY);
        btn9.setBackgroundColor(Color.GRAY);
        btnA.setBackgroundColor(Color.GRAY);
        btnB.setBackgroundColor(Color.GRAY);
        btnC.setBackgroundColor(Color.GRAY);
        btnD.setBackgroundColor(Color.GRAY);
        btnE.setBackgroundColor(Color.GRAY);
        btnF.setBackgroundColor(Color.GRAY);
        btn0.setBackgroundColor(Color.BLACK);
        btn1.setBackgroundColor(Color.BLACK);

    }

    private void btnDecClicked() {

        SetNumerationBase(10);
        btnDec.setBackgroundColor(Color.GRAY);
        btnDec.setTextColor(Color.BLACK);
        btnBin.setBackgroundColor(Color.BLACK);
        btnBin.setTextColor(Color.WHITE);
        btnHex.setBackgroundColor(Color.BLACK);
        btnHex.setTextColor(Color.WHITE);
        btnA.setBackgroundColor(Color.GRAY);
        btnB.setBackgroundColor(Color.GRAY);
        btnC.setBackgroundColor(Color.GRAY);
        btnD.setBackgroundColor(Color.GRAY);
        btnE.setBackgroundColor(Color.GRAY);
        btnF.setBackgroundColor(Color.GRAY);
        btn0.setBackgroundColor(Color.BLACK);
        btn1.setBackgroundColor(Color.BLACK);
        btn2.setBackgroundColor(Color.BLACK);
        btn3.setBackgroundColor(Color.BLACK);
        btn4.setBackgroundColor(Color.BLACK);
        btn5.setBackgroundColor(Color.BLACK);
        btn6.setBackgroundColor(Color.BLACK);
        btn7.setBackgroundColor(Color.BLACK);
        btn8.setBackgroundColor(Color.BLACK);
        btn9.setBackgroundColor(Color.BLACK);
    }

    private void btnHexClicked() {
        SetNumerationBase(16);
        btnHex.setBackgroundColor(Color.GRAY);
        btnHex.setTextColor(Color.BLACK);
        btnBin.setBackgroundColor(Color.BLACK);
        btnBin.setTextColor(Color.WHITE);
        btnDec.setBackgroundColor(Color.BLACK);
        btnDec.setTextColor(Color.WHITE);
        btnA.setBackgroundColor(Color.BLACK);
        btnB.setBackgroundColor(Color.BLACK);
        btnC.setBackgroundColor(Color.BLACK);
        btnD.setBackgroundColor(Color.BLACK);
        btnE.setBackgroundColor(Color.BLACK);
        btnF.setBackgroundColor(Color.BLACK);
        btn0.setBackgroundColor(Color.BLACK);
        btn1.setBackgroundColor(Color.BLACK);
        btn2.setBackgroundColor(Color.BLACK);
        btn3.setBackgroundColor(Color.BLACK);
        btn4.setBackgroundColor(Color.BLACK);
        btn5.setBackgroundColor(Color.BLACK);
        btn6.setBackgroundColor(Color.BLACK);
        btn7.setBackgroundColor(Color.BLACK);
        btn8.setBackgroundColor(Color.BLACK);
        btn9.setBackgroundColor(Color.BLACK);
    }

    private void numericalButtonsClicked(int nr) {
        input.setText(input.getText().toString() + Integer.toString(nr));
        updateOutput();
    }
    private void hexButtonsClicked(int nr) {
        input.setText(input.getText().toString() + (char) ('a' + nr));
        updateOutput();
    }
    private void btnDelClicked() {
        String text = input.getText().toString();
        if (text.length() > 0) {
            text = text.substring(0, text.length() - 1);
        }
        input.setText(text);
    }

    private void btnPlusClicked()  { input.setText(input.getText().toString() + '+');  }
    private void btnMinusClicked() { input.setText(input.getText().toString() + '-');  }
    private void btnMultClicked()  { input.setText(input.getText().toString() + '*');  }
    private void btnDivClicked()   { input.setText(input.getText().toString() + '/');  }
    private void btnOPClicked()    { input.setText(input.getText().toString() + '(');  }
    private void btnCPClicked()    { input.setText(input.getText().toString() + ')');  }
    private void btnCommaClicked() { input.setText(input.getText().toString() + ',');  }

    private void updateOutput(boolean force) {
        try {
            Equation equation = new Equation(input.getText().toString(), numerationBase);
            output.setText(equation.Result());
        } catch (Exception e) {
            if (force) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            }
        }
    }

    private void updateOutput() {
        updateOutput(false);
    }
}