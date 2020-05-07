package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class producer extends AppCompatActivity {
    ArrayList<String> selection = new ArrayList<String>();
    ArrayList<String> qnt = new ArrayList<String>();
    TextView final_text;
    TextView final_amt;
    TextView tot_amt;
    TextView quantity;
    TextView veg_quantity;
    TextView mqt;
    TextView pqt;
    TextView poqt;
    TextView tqt;
    TextView bqt;
    TextView oqt;
    int[] cost=new int[10];
    int[] cost1=new int[10];
    int[] qty=new int[10];
    Button obtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_producer);
        final_text = (TextView) findViewById(R.id.vegetables);
        final_amt = (TextView) findViewById(R.id.veg_amt);
        tot_amt = (TextView) findViewById(R.id.total_amt);
        quantity = (TextView) findViewById(R.id.veg_qt);
        veg_quantity = (TextView) findViewById(R.id.qnt);
        mqt = (TextView) findViewById(R.id.mQ);
        pqt = (TextView) findViewById(R.id.pQ);
        poqt = (TextView) findViewById(R.id.poQ);
        oqt = (TextView) findViewById(R.id.oQ);
        tqt = (TextView) findViewById(R.id.tQ);
        bqt = (TextView) findViewById(R.id.bQ);

        obtn = (Button)findViewById(R.id.orderbtn);
        final_text.setEnabled(false);
        final_amt.setEnabled(false);
        tot_amt.setEnabled(false);
        quantity.setEnabled(false);
        veg_quantity.setEnabled(false);
        orderPlaced();
    }

    public void orderPlaced(){
        obtn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                            Toast.makeText(producer.this,"Order has confirmed",Toast.LENGTH_LONG).show();
                            Intent int2 = new Intent(producer.this, MainActivity.class);
                            startActivity(int2);
                    }
                }
        );
    }

    public void selectItem(View view)
    {
        boolean checked = ((CheckBox) view).isChecked();
        switch(view.getId())
        {
            case R.id.methi:
                int index=0;
                if(checked)
                {
                    selection.add("Methi");
                    cost1[0]=40;
                    qnt.add(index,mqt.getText().toString());
//                    String q = mqt.getText().toString();
//                    int qtt = new Integer(q).intValue();
//                    qty[0] = qtt;
//                    cost[0] = cost1[0] * qty[0];
                }
                else
                {
                    selection.remove("Methi");
                    qnt.remove(mqt.getText().toString());
                    cost[0]=0;
                    cost1[0]=0;
                }
                break;
            case R.id.palak:
                if(checked)
                {
                    selection.add("Palak");
                    cost1[1]=30;
//                    qty[1]=Integer.valueOf(pqt.getText().toString());

//                    qnt.add(pqt.getText().toString());
//                    qty[1]=(Integer)R.id.pQ;
//                    cost[1] = cost1[1] * qty[1];
                }
                else
                {
                    selection.remove("Palak");
                    qnt.remove(pqt.getText().toString());
                    cost[1]=0;
                    cost1[1]=0;
                }
                break;
            case R.id.onion:
                if(checked)
                {
                    selection.add("Onion");
                    cost1[2]=80;
                    qnt.add(oqt.getText().toString());
//                    qty[2]=(Integer)R.id.oQ;
//                    cost[2] = cost1[2] * qty[2];
                }
                else
                {
                    selection.remove("Onion");
                    qnt.remove(oqt.getText().toString());
                    cost[2]=0;
                    cost1[2]=0;
                }
                break;
            case R.id.tomato:
                if(checked)
                {
                    selection.add("Tomato");
                    cost1[3]=50;
                    qnt.add(tqt.getText().toString());
//                    qty[3]=(Integer)R.id.tQ;
//                    cost[3] = cost[3] * qty[3];
                }
                else
                {
                    selection.remove("Tomato");
                    qnt.remove(tqt.getText().toString());
                    cost[3]=0;
                    cost1[3]=0;
                }
                break;
            case R.id.potato:
                if(checked)
                {
                    selection.add("Potato");
                    cost1[4]=35;
                    qnt.add(poqt.getText().toString());
//                    qty[4]=(Integer)R.id.poQ;
//                    cost[4] = cost[4] * qty[4];
                }
                else
                {
                    selection.remove("Potato");
                    qnt.remove(poqt.getText().toString());
                    cost[4]=0;
                    cost1[4]=0;
                }
                break;
            case R.id.Bhendi:
                if(checked)
                {
                    selection.add("Bhendi");
                    cost1[5]=25;
                    qnt.add(bqt.getText().toString());
//                    qty[5]=(Integer)R.id.bQ;
//                    cost[5] = cost[5] * qty[5];
                }
                else
                {
                    selection.remove("Bhendi");
                    qnt.remove(bqt.getText().toString());
                    cost[5]=0;
                    cost1[5]=0;
                }
                break;
//            case R.id.fruits:
//                if(checked)
//                {
//                    selection.add("Fruits");
//                    cost1[6]=90;
////                    qty[6]=(Integer)R.id.fQ;
////                    cost[6] = cost[6] * qty[6];
//                }
//                else
//                {
//                    selection.remove("Fruits");
//                    cost[6]=0;
//                    cost1[6]=0;
//                }
//                break;
//            case R.id.rice:
//                if(checked)
//                {
//                    selection.add("Rice");
//                    cost1[7]=80;
////                    qty[7]=(Integer)R.id.rQ;
////                    cost[7] = cost[7] * qty[7];
//                }
//                else
//                {
//                    selection.remove("Rice");
//                    cost[7]=0;
//                    cost1[7]=0;
//                }
//                break;

        }
    }

    public void finalSelection(View view)
    {
        String final_veg_selection="";
        String final_cost = "";
        String final_qty="";
        int total_cost = 0;
        int fqty = 0;
        for(String selections: selection)
        {
            final_veg_selection = final_veg_selection + selections + "\n";
        }
        for(String qt: qnt)
        {
            final_qty = final_qty + qnt + "\n";
        }
        for(int i = 0 ; i< cost1.length ; i++)
        {
            if(cost1[i] != 0)
            {
                final_cost = final_cost + (Integer.toString(cost1[i])) + "\n";
//                final_qty = final_qty + (Integer.toString(qty[i])) + "\n";
                fqty = fqty + qty[i] ;
                total_cost = total_cost + cost1[i];
            }
        }
        final_text.setText(final_veg_selection);
        final_amt.setText((final_cost));
        tot_amt.setText(Integer.toString(total_cost));
        quantity.setText(final_qty);
        final_text.setEnabled(true);
        final_amt.setEnabled(true);
        tot_amt.setEnabled(true);
        quantity.setEnabled(true);
    }
}
