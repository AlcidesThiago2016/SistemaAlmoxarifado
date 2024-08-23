package org.example.controller;

import org.example.model.Item;

import java.io.*;
import java.util.ArrayList;

public class BancoDeDados {

    private ArrayList<String> linhas;
    private ArrayList<Item> items;

    public BancoDeDados() {
        linhas = new ArrayList<>();
        ler();
        items = new ArrayList<>();
        transformaLinhasemObjetos(linhas);
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

    public void ler(){
        String linha = "";
        try{
            InputStream is = new FileInputStream("produtos.txt");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            linha = br.readLine();

            while (linha != null){
                System.out.println(linha);
                linhas .add(linha);
                linha = br.readLine();
            }

            br.close();
            isr.close();
            is.close();
            System.out.println("Arquivo lido com sucesso!");
        }catch (Exception e){
            System.out.println("Erro ao ler no banco de dados");
        }
    }

    public void transformaLinhasemObjetos(ArrayList<String> linhas){

        String[] aux = new String[2];
        Item item;

        for(int i = 0; i < linhas.size(); i++){
            aux = linhas.get(i).split(",");
            item = new Item(aux[0], Integer.parseInt(aux[1]) );
            items.add(item);
        }

        System.out.println("Dados convertidos em Objetos Java.");
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
