/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estoque.DAO.imp;

import com.mycompany.estoque.banco.ConnectionFactory;
import com.mycompany.estoque.model.Fornecedor;
import com.mycompany.estoque.model.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ismaeldeazevedonascimento
 */
public class ItemDAO implements IGenericsDAO<Item, Integer>{

    @Override
    public void inserir(Item obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO item\n" +
                     "(`desc`, vl_unit, qtde, id_fornecedor)\n" +
                     "VALUES(?, ?, ?, ?);";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1, obj.getDesc());
        pst.setDouble(2, obj.getVl_unit());
        pst.setInt(3, obj.getQtde());
        pst.setObject(4, obj.getFornecedor());
        
        pst.execute();
    }

    @Override
    public void alterar(Item obj) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql= "UPDATE item\n" +
                    "SET `desc`=?, vl_unit=?, qtde=?, id_fornecedor=?\n" +
                    "WHERE id=?;";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setString(1, obj.getDesc());
        pst.setDouble(2, obj.getVl_unit());
        pst.setInt(3, obj.getQtde());
        pst.setObject(4, obj.getFornecedor());
        pst.setInt(5, obj.getId());
        
        pst.execute();
    }

    @Override
    public void apagar(Integer key) throws ClassNotFoundException, SQLException {
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM item\n" +
                     "WHERE id=?;";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        pst.setInt(1, key);
        
        pst.execute();
    }

    @Override
    public Item buscarPorChave(Integer key) throws ClassNotFoundException, SQLException {
         Connection c = ConnectionFactory.getConnection();

        String sql = "SELECT *\n" +
                     "FROM item\n" +
                     "WHERE id = ?";

        PreparedStatement pst = c.prepareStatement(sql);
        pst.setInt(1, key);

        ResultSet rs = pst.executeQuery();
        
        Item i = null;

        if (rs.next()) {
            i = new Item(
                    rs.getInt("id"), 
                    rs.getInt("qtde"), 
                    rs.getString("descricao"),
                    rs.getDouble("vl_unit"), 
                    new FornecedorDAO().buscarPorChave(rs.getInt("id_fornecedor")));
     
            return i;
        }
        else{
            return i;
                }
    }

    @Override
    public ArrayList<Item> buscarTodos() throws ClassNotFoundException, SQLException {
        
        Connection c = ConnectionFactory.getConnection();
        
        String sql = "SELECT i.*, f.nome\n" +
                     "FROM item i\n" +
                     "JOIN fornecedor f ON i.id_fornecedor = f.id";
        
        PreparedStatement pst = c.prepareStatement(sql);
        
        ResultSet rs = pst.executeQuery();
        
        ArrayList<Item> lista = new ArrayList<>();
        
         while (!rs.isAfterLast()) {
         
             Fornecedor f = new Fornecedor(
                     rs.getInt("id"),
                     rs.getString("nome"),
                     rs.getString("cnpj"),
                     rs.getString("endereco"));
             
             Item i = new Item(
                    rs.getInt("id"), 
                    rs.getInt("qtde"), 
                    rs.getString("descricao"),
                    rs.getDouble("vl_unit"), 
                    f);
         
             lista.add(i);
         }
         
         return lista;
        
    }
    
}
