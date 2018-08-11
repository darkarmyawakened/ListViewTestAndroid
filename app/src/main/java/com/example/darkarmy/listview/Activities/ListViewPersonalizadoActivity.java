package com.example.darkarmy.listview.Activities;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.darkarmy.listview.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
/***
 * Esta clase contiene un ListView, interesantes propiedades han sido modificadas.
 *
 *
 * ***/
//Todo : Mirar con mas cuidado esta clase, tiene propiedades interesantes.
public class ListViewPersonalizadoActivity extends AppCompatActivity {
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
        MyAdapter adaptador = new MyAdapter(this, R.layout.list_item, datos);

        llView.setAdapter(adaptador);

        //Todo: estudiar evento OnItemClickListener del ListView | Interesante
        llView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //TextView tv = (TextView) view.findViewById(R.id.tvTexto);
                Toast.makeText(contexto, "Item Seleccionado: ", Toast.LENGTH_SHORT).show();
            }
        });
    }

    //Todo : estudiar este tipo de adaptadores personalizados

    class MyAdapter extends BaseAdapter{
        private Context contexto;
        private int layout;
        private List<String> nombres;

        public MyAdapter(Context contexto, int layout, List<String> nombres){
            this.contexto = contexto;
            this.layout = layout;
            this.nombres = nombres;
        }

        @Override
        public int getCount() {
            return this.nombres.size();
        }

        @Override
        public Object getItem(int i) {
            return this.nombres.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            View v = view;

            //inflando la vista que ha llegado, con el layout list__item
            LayoutInflater layoutInflater = LayoutInflater.from(contexto);
            v = layoutInflater.inflate(R.layout.list_item, null);

            //Se escoge el valor actual dependiente de la posicion
            String nombreActual = nombres.get(position);
            ImageView img = (ImageView) v.findViewById(R.id.imImagen);
            img.setImageResource(android.R.drawable.btn_radio);
            //nombreActual = (String) getItem(position);

            //referenciamos el elemento a modificar
            TextView tvNombre = (TextView) v.findViewById(R.id.tvTexto);
            //rellenando referenciado.
            tvNombre.setText(nombreActual);

            //devolvemos la vista inflada y modificada con nuestros datos.
            return v;
        }
    }

    public void OnAgregarClick(View v){
        //TextView tv = (TextView) v.findViewById(R.id.tvTexto);
        Toast.makeText(ListViewPersonalizadoActivity.this, "Agregado a tus amigos!", Toast.LENGTH_SHORT).show();
    }
    public void OnItemClick(View v){
        //TextView tv = (TextView) v.findViewById(R.id.tvTexto);
        Toast.makeText(ListViewPersonalizadoActivity.this, "Item Seleccionado!", Toast.LENGTH_SHORT).show();
    }

    public void OnImageClick(View v){
        //TextView tv = (TextView) v.findViewById(R.id.tvTexto);
        Toast.makeText(ListViewPersonalizadoActivity.this, "Cambiar Imagen!", Toast.LENGTH_SHORT).show();
    }
}
