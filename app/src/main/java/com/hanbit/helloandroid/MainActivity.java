package com.hanbit.helloandroid;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    int iResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context=MainActivity.this;
        final EditText num1= (EditText) findViewById(R.id.num1);
        final EditText num2= (EditText) findViewById(R.id.num2);
        final TextView result= (TextView) (TextView) findViewById(R.id.result);
        final HashMap<String, String> map=new HashMap<>();
        final Calculator calc=new Calculator() {
            @Override
            public int execute(Map<?, ?> map) {
                int result=0;
                int sNum1=num1.getText().toString().equals("")?0:Integer.parseInt(num1.getText().toString());
                int sNum2=num2.getText().toString().equals("")?0:Integer.parseInt(num2.getText().toString());
                switch ((String)(map.get("opcode"))){
                    case "+": result=sNum1+sNum2; break;
                }
                return result;
            }
        };

        findViewById(R.id.plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // iResult=sNum1+sNum2;
                map.put("opcode","+");
                iResult=calc.execute(map);
                Toast.makeText(context, ""+iResult, Toast.LENGTH_LONG).show();
            }
        });
     findViewById(R.id.minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.put("opcode","-");
                iResult=calc.execute(map);
                Toast.makeText(context, ""+iResult, Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.multi).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.put("opcode","*");
                iResult=calc.execute(map);
                Toast.makeText(context, ""+iResult, Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                map.put("opcode","/");
                iResult=calc.execute(map);
                Toast.makeText(context, ""+iResult, Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.equal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setText(String.valueOf("결과: "+iResult));
                Toast.makeText(context, ""+iResult, Toast.LENGTH_LONG).show();
            }
        });
    }
    interface Calculator{
        public int execute(Map<?,?>map);
    }
}
