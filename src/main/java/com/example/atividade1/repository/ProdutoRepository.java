package com.example.atividade1.repository;

import java.util.HashMap;

import com.example.atividade1.model.Produto;

import org.springframework.stereotype.Repository;

/**
 * ProdutoRepository
 */
@Repository
public class ProdutoRepository {

    public HashMap<String,Produto> hm = new HashMap<String,Produto>();

    public ProdutoRepository()
    {
        hm.put("1", new Produto(1, "Canivete", 12.00 , 0));
        hm.put("2", new Produto(2, "Facao", 79.45 , 15));
        hm.put("3", new Produto(3, "Espada", 150.50 , 10));
        hm.put("4", new Produto(4, "Cutelo", 99.60 , 35));
        hm.put("5", new Produto(5, "Revolver", 580.90 , 0));
        hm.put("6", new Produto(6, "Colete", 350.50 , 12));
        hm.put("7", new Produto(7, "Municao .50", 16.00 , 500));
        hm.put("8", new Produto(8, "Pistola", 599.90 , 50));
        hm.put("9", new Produto(9, "Oculos", 15.90 , 25));
        hm.put("10", new Produto(10, "Fuzil", 1250.90 , 45));
    }

    //Retorna produto pelo codigo
    public Produto getProdutoById(String i)
    {
        if(hm.containsKey(i))
        {
            return hm.get(i);
        }
        return null;
    }

    //Retorna HashMap de Produtos
    public HashMap<String,Produto> getProdutos()
    {
      return hm;
    }
}