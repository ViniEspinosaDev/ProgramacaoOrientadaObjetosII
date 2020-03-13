package com.example.atividade1.service;

import java.util.HashMap;

import com.example.atividade1.model.Produto;
import com.example.atividade1.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProdutoService
 */
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository pr;

    //getProduto(int id): devolve o produto e se não existir devolve uma mensagem de erro que deve ser apresentado em uma view.
    public Produto getProduto(String id)
    {
        return pr.getProdutoById(id);   
    }
    
    //getProdutosEmEstoque(): Devolve somente os produtos em estoque.
    public HashMap<String, Produto> getProdutoEstoque()
    {
        HashMap<String, Produto> aux = new HashMap<String, Produto>();
        HashMap<String, Produto> emEstoque = new HashMap<String, Produto>();
        aux = pr.getProdutos();

		for(Produto produto : aux.values())
        {
            if(produto.getEstoque() > 0)
            {
                emEstoque.put(Integer.toString(produto.getCodigo()),produto);
            }
        }

        return emEstoque;
    }

    // getProdutosByValorAcima(double valor): Devolve todos os produtos acima do valor passado.
    public HashMap<String, Produto> getProdutosByValorAcima(double valor)
    {
        HashMap<String, Produto> aux = new HashMap<String, Produto>();
        HashMap<String, Produto> aCima = new HashMap<String, Produto>();
        aux = pr.getProdutos();

        for(Produto prod : aux.values())
        {
           if(prod.getValor()>= valor)
           {
                aCima.put(Integer.toString(prod.getCodigo()),prod);
           }
        }
        return aCima;
    }
    
    //getProdutosByValorAbaixo(double valor): Devolve todos os produtos abaixo de um valor passado.
    public HashMap<String, Produto> getProdutosByValorAbaixo(double valor)
    {
        HashMap<String, Produto> aux = new HashMap<String, Produto>();
        HashMap<String, Produto> aBaixo = new HashMap<String, Produto>();
        aux = pr.getProdutos();

        for(Produto prod : aux.values())
        {
           if(prod.getValor() < valor)
           {
                aBaixo.put(Integer.toString(prod.getCodigo()),prod);
           }
        }
        return aBaixo;
    }
}