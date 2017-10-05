package br.com.fiap.exemplobancodedadossqlite;

import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

      private EditText nome;
      private EditText email;
      private MeuBanco db;
      private Cliente cliente;
      private Button btnExcluir;


      @Override
      protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cadastro);

            nome  = (EditText) findViewById(R.id.edtNome);
            email = (EditText) findViewById(R.id.edtEmail);
            btnExcluir = (Button) findViewById(R.id.btnExcluir);

            db = new MeuBanco(this);

            Bundle extras;

            extras = getIntent().getExtras();
            if (extras != null) {
                  cliente = (Cliente) extras.get("cliente");
                  nome.setText( cliente.getNome() );
                  email.setText( cliente.getEmail() );

                  btnExcluir.setVisibility( View.VISIBLE );
            }
      }


      public void salvar(View view) {
            if (cliente == null) {
                  long dataCadastro = System.currentTimeMillis() / 1000L ;

                  cliente.setNome(nome.getText().toString());
                  cliente.setEmail(email.getText().toString());
                  cliente.setDataCadastro(dataCadastro);

                  db.inserir(cliente);

                  Toast.makeText(this, R.string.inserido_com_sucesso, Toast.LENGTH_SHORT).show();
            } else {
                  cliente.setNome(nome.getText().toString());
                  cliente.setEmail(email.getText().toString());

                  db.alterar(cliente);

                  Toast.makeText(this, "Alterado com sucesso!", Toast.LENGTH_SHORT).show();
            }

            finish();
      }

      public void excluir(View view) {
            db.excluir( cliente.getId() );
            Toast.makeText(this, "Excluído com sucesso!", Toast.LENGTH_SHORT).show();
            finish();
      }
}
