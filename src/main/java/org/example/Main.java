package org.example;

import org.example.controller.BancoDeDados;
import org.example.model.Item;

public class Main {
    public static void main(String[] args) {

        Item item1 = new Item("Filtro de Ar", 1);
        Item item2 = new Item("Rolamento 32026", 2);
        Item item3 = new Item("Roldana de Nylon", 3);
        Item item4 = new Item("Pinhao Caixa Redutora", 4);

        BancoDeDados bd = new BancoDeDados();
        bd.cadastrar(item1);
        bd.cadastrar(item2);
        bd.cadastrar(item3);
        bd.cadastrar(item4);
  }
}