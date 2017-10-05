package br.com.fiap.exemplobancodedadossqlite;

import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by cabral on 21/08/17.
 */

public class Cliente implements Serializable {

      private int id;
      private String nome;
      private String email;
      private long dataCadastro;

      public Cliente() {
      }

      public Cliente(int id, String nome, String email, long dataCadastro) {
            this.id = id;
            this.nome = nome;
            this.email = email;
            this.dataCadastro = dataCadastro;
      }

      public int getId() {
            return id;
      }

      public void setId(int id) {
            this.id = id;
      }

      public String getNome() {
            return nome;
      }

      public void setNome(String nome) {
            this.nome = nome;
      }

      public String getEmail() {
            return email;
      }

      public void setEmail(String email) {
            this.email = email;
      }

      public long getDataCadastro() {
            return dataCadastro;
      }

      public void setDataCadastro(long dataCadastro) {
            this.dataCadastro = dataCadastro;
      }

      @Override
      public String toString() {
            return this.nome;
      }
}
