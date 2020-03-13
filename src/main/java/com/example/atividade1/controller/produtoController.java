package com.example.atividade1.controller;

import java.util.HashMap;

import com.example.atividade1.model.Produto;
import com.example.atividade1.service.ProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

/**
 * produtoController
 */
@Controller
public class produtoController {

        @Autowired
        private ProdutoService ps;

        @GetMapping()
        public String produto()
        {
            return "menuView";
        }

        //Funcionando? : SIM
        @GetMapping("/produto/{id}")
        public ModelAndView getProduto(@PathVariable("id") int id)
        {
            ModelAndView mv = new ModelAndView("produtoView"); //Criar HTML produtoId
            Produto produto = ps.getProduto(Integer.toString(id));
            mv.addObject("produto", produto);
            return mv;
        }

        //Funcionando? : SIM
        @GetMapping("/produtosEmEstoque")
        public ModelAndView getProdutosEmEstoque()
        {
            ModelAndView mv = new ModelAndView("produtosEmEstoqueView"); //Criar HTML produtoId
            HashMap<String, Produto> produtos = ps.getProdutoEstoque();
            mv.addObject("produtos", produtos.values());
            return mv;
        }

        //Funcionando? : SIM
        @GetMapping("/produtosValorAcima/{valor}")
        public ModelAndView getProdutosByValorAcima(@PathVariable("valor") double valor)
        {
            ModelAndView mv = new ModelAndView("produtosValorAcima"); //Criar HTML produtoId
            HashMap<String, Produto> produtos = ps.getProdutosByValorAcima(valor);
            mv.addObject("produtos", produtos.values());
            return mv;
        }

        //Funcionando? : SIM
        @GetMapping("/produtosValorAbaixo/{valor}")
        public ModelAndView getProdutosByValorAbaixo(@PathVariable("valor") double valor)
        {
            ModelAndView mv = new ModelAndView("produtosValorAbaixo"); //Criar HTML produtoId
            HashMap<String, Produto> produtos = ps.getProdutosByValorAbaixo(valor);
            mv.addObject("produtos", produtos.values());
            return mv;
        }
}