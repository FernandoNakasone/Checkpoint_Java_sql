package br.fiap.aplicacao;

import br.fiap.models.Venda;
import br.fiap.models.VendaDAO;

import java.text.DecimalFormat;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VendaDAO vendaDAO = new VendaDAO();
        DecimalFormat dF = new DecimalFormat("#,##0.00");

        Venda venda1 = new Venda();
        venda1.setId(1L);
        venda1.setVendedor("Fernando");
        venda1.setValor(1899.99);
        vendaDAO.inserir(venda1);

        Venda venda2 = new Venda();
        venda2.setId(2L);
        venda2.setVendedor("Rafael");
        venda2.setValor(100.99);
        vendaDAO.inserir(venda2);

        Venda venda3 = new Venda();
        venda3.setId(3L);
        venda3.setVendedor("Rafaela");
        venda3.setValor(10.99);
        vendaDAO.inserir(venda3);

        Venda venda4 = new Venda();
        venda4.setId(4L);
        venda4.setVendedor("Renata");
        venda4.setValor(1899.99);
        vendaDAO.inserir(venda4);;

        Venda venda5 = new Venda();
        venda5.setId(5L);
        venda5.setVendedor("Renato");
        venda5.setValor(199.99);
        vendaDAO.inserir(venda5);

        List<Venda> vendas = vendaDAO.relatorio();

        for (Venda v : vendas){
            System.out.println(v);
        }

        System.out.println("-----------------------------------");

        double valorTotal = vendaDAO.totalVendas(vendas);

        System.out.println("Valor total de vendas:" + dF.format(valorTotal));

        System.out.println("-----------------------------------");

        List<Venda> maioresVendas = vendaDAO.maioresVenda(vendas);

        for(Venda v : maioresVendas){
            System.out.println("Maior venda:" + dF.format(v.getValor()) + " | Vendedor:" + v.getVendedor());
        }
    }
}
