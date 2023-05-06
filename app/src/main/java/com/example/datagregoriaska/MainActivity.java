package com.example.datagregoriaska;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    Button btn;
    EditText ejd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        ejd=findViewById(R.id.ejd);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double r=0,m=0,d=0,jd=0;
                double w=0,x=0,u=0,y=0,z=0,a=0,b=0,c=0,e=0,f=0;
                tv.setText("");
                try{
                    jd=Double.parseDouble(ejd.getText().toString());

                    w = jd + 0.5;
                    x = (int)(w);
                    u=w-x;
                    y=(int)((x+32044.5)/36524.25);
                    z=x+y-(int)(y/4)-38;
                    a=z+1524;
                    b=(int)((a-122.1)/365.25);
                    c=a-(int)(365.25*b);
                    e=(int)(c/30.61);
                    f=(int)(e/14);
                    r=b-4716+f;
                    m=e-1-12*f;
                    d=c+u-(int)(153*e/5);
                    tv.setText("Dzień juliański "+jd+"\r\nData kalendarza gregoriańskiego "+(int)r+"-"+
                            (int)m+"-"+(int)d+".");
                }catch (Exception blad){
                    Toast.makeText(MainActivity.this,blad.getMessage(),
                            Toast.LENGTH_LONG).show();
                }finally {
                    ejd.setText("");
                }
            }
        });
    }
}