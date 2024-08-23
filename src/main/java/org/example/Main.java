package org.example;

import org.example.controller.BancoDeDados;
import org.example.model.Item;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BancoDeDados dados = new BancoDeDados();

        ArrayList<Item> items = dados.getItems();

        for (Item item : items) {
            System.out.println("Nome do Item: "+item.getNome());
            System.out.println("Codigo do Item: "+item.getCodigo());
        }
  }
}