package demoapp.com.exampleapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText etInputValue;
    String strInputValue;
    TextView tvInputValue1,tvInputValue2,tvInputValue3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etInputValue=(EditText) findViewById(R.id.etInputValue);
        btnCalculate=(Button)findViewById(R.id.btnCalculate);

        tvInputValue1=(TextView) findViewById(R.id.tvInputValue1);
        tvInputValue2=(TextView) findViewById(R.id.tvInputValue2);
        tvInputValue3=(TextView) findViewById(R.id.tvInputValue3);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strInputValue=etInputValue.getText().toString().trim();
                if (TextUtils.isEmpty(strInputValue))
                {
                    Toast.makeText(MainActivity.this, "Please enter value", Toast.LENGTH_SHORT).show();
                }
                else {
                    //Fibonacci
                    String value1=getFib(Integer.parseInt(strInputValue));
                    if (!TextUtils.isEmpty(value1))
                    {
                        tvInputValue1.setText("Fibonacci  of " + strInputValue + " is : " + "\n\n" + "0" + value1);

                        //Exponential
                        String value2=fromStandartToExponent(strInputValue);
                        if (!TextUtils.isEmpty(value2))
                        {
                            tvInputValue3.setText("Exponential functions of " + strInputValue + " is : " + "\n\n" + value2);

                            //factorial series

                            int number=Integer.parseInt(strInputValue);
                            String value3= String.valueOf(factorial(number));
                            if (!TextUtils.isEmpty(value3)) {
                                tvInputValue2.setText("Factorial of " + strInputValue + " is : \n\n" + value3);
                            }
                        }
                    }
                }
            }
        });
    }

    //fibonacci series

    public static int fib(int n) {
        int number1 = 0, number2 = 1;
        for(int i = 0; i < n; i++) {
            int savenumber1 = number1;
            number1 = number2;
            number2 = savenumber1 + number2;
        }
        return number1;
    }

    public static String getFib(int n) {
        StringBuilder sb = new StringBuilder(fib(0));
        for (int i = 1; i < n; ++i) {
            sb.append(", ");
            sb.append(fib(i));
        }
        return sb.toString();
    }


    //factorial data
    public static BigInteger factorial(int number)
    {
        BigInteger factorial = BigInteger.ONE;
        for (int i = number; i > 0; i--)
        {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        } return factorial;
    }

    //Exponential
    public static String fromStandartToExponent(String strInputValue){
        return String.format("%e",Double.parseDouble(strInputValue));
    }
}
