package com.example.calc;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;


public class CalcActivity extends AppCompatActivity {
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_0;
    Button btn_result;
    Button btn_ln;
    Button btn_root;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiple;
    Button btn_divide;
    Button btn_delete;
    Button btn_clear;
    Button btn_point;


        TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc);



        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String resultText = result.getText().toString();
                String[] resultArray = (resultText.split(" "));
                switch (view.getId()) {
                    case (R.id.button0):
                        result.append("0");
                        break;
                    case (R.id.button1):
                        result.append("1");
                        break;
                    case (R.id.button2):
                        result.append("2");
                        break;
                    case (R.id.button3):
                        result.append("3");
                        break;
                    case (R.id.button4):
                        result.append("4");
                        break;
                    case (R.id.button5):
                        result.append("5");
                        break;

                    case (R.id.button6):
                        result.append("6");
                        break;
                    case (R.id.button7):
                        result.append("7");
                        break;
                    case (R.id.button8):
                        result.append("8");
                        break;
                    case (R.id.button9):
                        result.append("9");
                        break;

                    case (R.id.buttonPoint):
                        if (resultArray.length > 0) {
                            if (resultArray[resultArray.length - 1].contains(".")) {
                                break;
                            }
                        }
                        result.append(".");
                        break;

                    case (R.id.buttonDivide):
                        setOperation("÷");
                        break;
                    case (R.id.buttonMultiple):
                        setOperation("×");
                        break;
                    case (R.id.buttonMinus):
                        setOperation("-");
                        break;
                    case (R.id.buttonPlus):
                        setOperation("+");
                        break;

                    case (R.id.buttonResult):
                        if (resultText.length() != 0) {
                            countResult();
                        }
                        break;

                    case (R.id.buttonLn):
                        if (resultText.length() == 0) {
                            result.append("ln");
                        } else if (String.valueOf(resultText.charAt(resultText.length() - 1)).equals(" ")) {
                            result.append("ln");
                        }
                        break;
                    case (R.id.buttonRoot):
                        if (resultText.length() == 0) {
                            result.append("√");
                        } else if (String.valueOf(resultText.charAt(resultText.length() - 1)).equals(" ")) {
                            result.append("√");
                        }
                        break;

                    case (R.id.buttonDelete):
                        if (resultText.length() > 0) {
                            if (String.valueOf(resultText.charAt(resultText.length() - 1)).equals(" ")) {
                                result.setText(resultText.substring(0, resultText.length() - 3));
                            } else if (String.valueOf(resultText.charAt(resultText.length() - 1)).equals("n")) {
                                result.setText(resultText.substring(0, resultText.length() - 2));
                            } else {
                                result.setText(resultText.substring(0, resultText.length() - 1));
                            }
                        }
                        break;
                    case (R.id.buttonClear):
                        result.setText("");
                        break;

                }
            }
        };
        //region Bind



        result = findViewById(R.id.result);
        btn_1 = findViewById(R.id.button1);
        btn_1.setOnClickListener(onClickListener);
        btn_2 = findViewById(R.id.button2);
        btn_2.setOnClickListener(onClickListener);
        btn_3 = findViewById(R.id.button3);
        btn_3.setOnClickListener(onClickListener);
        btn_4 = findViewById(R.id.button4);
        btn_4.setOnClickListener(onClickListener);

        btn_5 = findViewById(R.id.button5);
        btn_5.setOnClickListener(onClickListener);

        btn_6 = findViewById(R.id.button6);
        btn_6.setOnClickListener(onClickListener);

        btn_7 = findViewById(R.id.button7);
        btn_7.setOnClickListener(onClickListener);

        btn_8 = findViewById(R.id.button8);
        btn_8.setOnClickListener(onClickListener);

        btn_9 = findViewById(R.id.button9);
        btn_9.setOnClickListener(onClickListener);

        btn_0 = findViewById(R.id.button0);
        btn_0.setOnClickListener(onClickListener);
        btn_result = findViewById(R.id.buttonResult);
        btn_result.setOnClickListener(onClickListener);
        btn_ln = findViewById(R.id.buttonLn);
        btn_ln.setOnClickListener(onClickListener);
        btn_root = findViewById(R.id.buttonRoot);
        btn_root.setOnClickListener(onClickListener);
        btn_plus = findViewById(R.id.buttonPlus);
        btn_plus.setOnClickListener(onClickListener);
        btn_minus = findViewById(R.id.buttonMinus);
        btn_minus.setOnClickListener(onClickListener);
        btn_multiple = findViewById(R.id.buttonMultiple);
        btn_multiple.setOnClickListener(onClickListener);
        btn_divide = findViewById(R.id.buttonDivide);
        btn_divide.setOnClickListener(onClickListener);
        btn_delete = findViewById(R.id.buttonDelete);
        btn_delete.setOnClickListener(onClickListener);
        btn_clear = findViewById(R.id.buttonClear);
        btn_clear.setOnClickListener(onClickListener);
        btn_point = findViewById(R.id.buttonPoint);
        btn_point.setOnClickListener(onClickListener);

//endregion
    }

    private void setOperation(String s) {
        String resultText = result.getText().toString();
        if (resultText.length() != 0) {
            if (String.valueOf(resultText.charAt(resultText.length() - 1)).equals(" ")) {
                result.setText(resultText.substring(0, resultText.length() - 3));
                result.append(" " + s + " ");
            } else {
                result.append(" " + s + " ");
            }
            countResult();
        } else {
            Toast.makeText(this, "Введите число", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("SetTextI18n")
    private void countResult() {
        String lastOperation = "";
        String resultText = result.getText().toString();
        String[] resultArray = (resultText.split(" "));
        Log.d("LOG", Arrays.toString(resultArray));

        for (int i = 0; i < resultArray.length; i = i + 2) {
            try {
                Double num = Double.parseDouble(resultArray[i]);
            } catch (NumberFormatException ignored) {
                if (resultArray[i].contains("l")) {
                    resultArray[i] = String.valueOf(Math.log(Double.valueOf(resultArray[i].substring(2))));
                } else {
                    resultArray[i] = String.valueOf(Math.sqrt(Double.valueOf(resultArray[i].substring(1))));
                }
            }
        }
        double resultValue = Double.valueOf(resultArray[0]);
        int finishI;
        if (resultArray.length % 2 == 0) {
            finishI = resultArray.length - 1;
            lastOperation = resultArray[resultArray.length - 1];
        } else {
            finishI = resultArray.length;
        }
        for (int i = 1; i < finishI; i = i + 2) {
            switch (resultArray[i]) {
                case ("+"): {
                    resultValue += Double.valueOf(resultArray[i + 1]);
                    break;
                }
                case ("-"): {
                    resultValue -= Double.valueOf(resultArray[i + 1]);
                    break;
                }
                case ("×"): {
                    resultValue *= Double.valueOf(resultArray[i + 1]);
                    break;
                }
                case ("÷"): {
                    resultValue /= Double.valueOf(resultArray[i + 1]);
                    break;
                }
            }
//            String[] operand = new String[]{(String.valueOf('+')), "-", "×", "÷", "ln", "√"};
        }
        if (!lastOperation.equals("")) {
            result.setText(String.valueOf(resultValue) + " " + lastOperation + " ");
        } else {
            result.setText(String.valueOf(resultValue));
        }
    }


    public class MyClass {
        public  void main(String args[]) throws Exception {
            int numb = getNextItem();
            int lastItem=getNextItem();
            System.out.println(lastItem);
            int nextItem;
            for (int i = 0; i < numb - 1; i++) {
                nextItem = getNextItem();
                if (lastItem !=nextItem) {
                    lastItem=nextItem;
                    System.out.println(lastItem);
                }
            }

        }
        public  int getNextItem() throws IOException {
            ArrayList<Byte> nextElement = new ArrayList<>();
            byte item = (byte) System.in.read();
            while (item!= 0xa){
                nextElement.add(item);
                item =(byte) System.in.read();
            }
            ByteBuffer wrapped = ByteBuffer.wrap(ArrayUtils.toPrimitive(nextElement.toArray(new Byte[0]))); // big-endian by default
            return wrapped.getShort();
        }
    }


}

