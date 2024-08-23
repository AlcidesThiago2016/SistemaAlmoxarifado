package org.example.controller;

import org.example.model.Item;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BancoDeDados {

    public BancoDeDados() {

    }

    public void cadastrar(Item item){

        String linha = "";

        try{
            OutputStream os = new FileOutputStream("produtos.txt", true);
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            linha = item.getNome()+","+item.getCodigo();
            bw.write(linha);
            bw.newLine();

            bw.close();
            osw.close();
            os.close();

            System.out.println(linha +" Arquivo cadastrado com sucesso!");
        } catch (Exception e){
            System.out.println("Erro ao cadastrar no banco de dados");
            System.out.println(e.getMessage());
        }

    }
}
