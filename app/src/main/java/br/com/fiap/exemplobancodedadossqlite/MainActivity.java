package br.com.fiap.exemplobancodedadossqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

      private MeuBanco db;
      private ListView lstClientes;
      private List<Cliente> clientes;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            db = new MeuBanco(this);
      }


      @Override
      protected void onStart() {
            super.onStart();

            clientes = db.listarTodos();

            lstClientes = (ListView) findViewById(R.id.lstClientes);
            lstClientes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                  @Override
                  public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                        Cliente cliente = clientes.get(position);

                        Intent it = new Intent(MainActivity.this, CadastroActivity.class);
                        it.putExtra("cliente", cliente);

                        startActivity(it);
                  }
            });

            ArrayAdapter<Cliente> adapter =
                    new ArrayAdapter<Cliente>(this, android.R.layout.simple_list_item_1, clientes);

            lstClientes.setAdapter(adapter);
      }


      public void novoCadastro(View view) {
            Intent it = new Intent(this, CadastroActivity.class);
            startActivity(it);
      }
}
