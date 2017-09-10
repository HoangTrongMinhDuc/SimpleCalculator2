package com.hoangtrongminhduc.dev.simplecalculator2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btncong, btntru, btnnhan, btnchia;
    private EditText edtA, edtB;
    private TextView tvkq;
    private ListView lv;
    ArrayList<String>arrList=null;
    ArrayAdapter<String> adapter=null;
    private View.OnClickListener myVarListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tvkq=(TextView) findViewById(R.id.tvkq);
            int A=Integer.parseInt(edtA.getText()+"");
            int B=Integer.parseInt(edtB.getText()+"");
            if(v==btncong){
                arrList.add(A+"+"+B+"="+(A+B));
                adapter.notifyDataSetChanged();
            }else
            if(v==btntru){
                arrList.add(A+"-"+B+"="+(A-B));
                adapter.notifyDataSetChanged();
            }else
            if(v==btnnhan){
                arrList.add(A+"x"+B+"="+(A*B));
                adapter.notifyDataSetChanged();
            }else {
                arrList.add(A+"/"+B+"="+(A/B));
                adapter.notifyDataSetChanged();
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA=(EditText) findViewById(R.id.edtA);
        edtB=(EditText) findViewById(R.id.edtB);
        btncong=(Button) findViewById(R.id.btncong);
        btntru=(Button) findViewById(R.id.btntru);
        btnnhan=(Button) findViewById(R.id.btnnhan);
        btnchia=(Button) findViewById(R.id.btnchia);
        lv=(ListView) findViewById(R.id.lv);
        arrList=new ArrayList<String>();
        adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(adapter);
        btntru.setOnClickListener(myVarListener);
        btncong.setOnClickListener(myVarListener);
        btnnhan.setOnClickListener(myVarListener);
        btnchia.setOnClickListener(myVarListener);
    }
}
