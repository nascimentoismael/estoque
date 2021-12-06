/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estoque.DAO.imp;

import com.mycompany.estoque.banco.ConnectionFactory;
import com.mycompany.estoque.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ismaeldeazevedonascimento
 */
public class FornecedorDAO implements IGenericsDAO<Fornecedor, Integer> {

    @Override
    public void inserir(Fornecedor obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO fornecedor\n" +
                     "(nome, cnpj, endereco)\n" +
                     "VALUES(?, ?, ?);";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCnpj());
        pst.setString(3, obj.getEndereco());
        
        pst.execute();
    }

    @Override
    public void alterar(Fornecedor obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "UPDATE fornecedor\n" +
                     "SET nome=?, cnpj=?, endereco=?\n" +
                     "WHERE id=?;";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1, obj.getNome());
        pst.setString(2, obj.getCnpj());
        pst.setString(3, obj.getEndereco());
        pst.setInt(4, obj.getId());
        
        pst.execute();
    }

    @Override
    public void apagar(Integer key) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM fornecedor\n" +
                     "WHERE id=?;";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setInt(1, key);
        
        pst.execute();
    }

    @Override
    public Fornecedor buscarPorChave(Integer key) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT *\n" +
                     "FROM fornecedor\n" +
                     "WHERE id = ?";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, key);

        ResultSet rs = pst.executeQuery();
        
        Fornecedor f = null;
        
        if (rs.next()) {
            f = new Fornecedor(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cnpj"),
                    rs.getString("endereco"));
            return f;
        }else{
            return f;
        }
    }

    @Override
    public ArrayList<Fornecedor> buscarTodos() throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT *\n" +
                     "FROM fornecedor";

        PreparedStatement pst = c.prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        
        ArrayList<Fornecedor> lista = new ArrayList<>();
        
        while (!rs.isAfterLast()) {
            Fornecedor f = new Fornecedor(
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getString("cnpj"),
            rs.getString("endereco"));
            
            lista.add(f);
        }
        
        return lista;
    }
    
}
