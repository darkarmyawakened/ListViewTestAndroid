package com.example.darkarmy.listview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darkarmy.listview.Activities.ListViewPersonalizadoActivity;

import java.util.ArrayList;
import java.util.List;
/***
 * Esta clase contiene un ListView, interesantes propiedades han sido modificadas.
 *
 *
 * ***/
//Todo : Mirar con mas cuidado esta clase, tiene propiedades interesantes.
public class MainActivity extends AppCompatActivity {
    ListView llView;
    Context contexto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        llView = (ListView) findViewById(R.id.llView);
        contexto = this;
        List<String> datos = new ArrayList(){{
            add("Luis");
            add("Juan");
            add("Pedro");
            add("Maria");
        }};

        //Todo: jugar con este metodo un poco mas.
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);


                //cambia el tamano de los elementos
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
                tv.setGravity(Gravity.CENTER);

                if (position % 2 == 1) {
                    view.setBackgroundColor(Color.parseColor("#ccccb3"));
                } else {
                    view.setBackgroundColor(Color.parseColor("#e0e0d1"));
                }

                return view;
            }
        };
        llView.setAdapter(adapter);

        //Todo: estudiar evento OnItemClickListener del ListView | Interesante
        llView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                Toast.makeText(contexto, "Item Seleccionado: "+tv.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


        Intent i = new Intent(this, ListViewPersonalizadoActivity.class);
        startActivity(i);
    }


}
