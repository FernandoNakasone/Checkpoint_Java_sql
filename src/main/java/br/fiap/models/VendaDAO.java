package br.fiap.models;

import br.fiap.conexao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {
    private PreparedStatement ps;
    private ResultSet rs;
    private Conexao conexao;
    private Connection connection;

    public VendaDAO() {
        this.conexao = new Conexao();
        this.connection = conexao.conectar();
    }

    public void inserir(Venda venda){
        String sql = "insert into java_venda values(?,?,?)";

        try (Connection connection = conexao.conectar()){
            ps = connection.prepareStatement(sql);
            ps.setLong(1,venda.getId());
            ps.setString(2,venda.getVendedor());
            ps.setDouble(3,venda.getValor());
            ps.execute();
        }
        catch (SQLException e){
            System.out.println("Falha ao registrar venda!\n" + e.getMessage() );
        }
    }

    public List<Venda> relatorio(){
        List<Venda> vendas = new ArrayList<>();
        String sql = "select * from java_venda";

        try(Connection connection = conexao.conectar()){
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()){
                Venda venda = new Venda();

                venda.setId(rs.getLong("id"));
                venda.setVendedor(rs.getString("vendedor"));
                venda.setValor(rs.getDouble("valor"));

                vendas.add(venda);
            }
        }
        catch (SQLException e){
            System.out.println("Erro ao listar vendas\n" + e.getMessage());
        }

        return vendas;
    }

    public double totalVendas(List<Venda> vendas){
        double valorTotal = 0;

        for (Venda v : vendas){
            valorTotal += v.getValor();
        }

        return valorTotal;
    }

    public List<Venda> maioresVenda(List<Venda> vendas){
        List<Venda> maiorVenda = new ArrayList<>();
        double maiorValor = 0;
        for(Venda v : vendas){
            if(maiorValor < v.getValor()){
                maiorValor = v.getValor();
            }
        }
        for(Venda v : vendas){
            if(maiorValor == v.getValor()){
                maiorVenda.add(v);
            }
        }

        return maiorVenda;
    }
}
