/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estoque.DAO.imp;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ismaeldeazevedonascimento
 */
public interface IGenericsDAO<C, Integer> {
    public void inserir(C obj) throws ClassNotFoundException, SQLException;
    public void alterar(C obj) throws ClassNotFoundException, SQLException;
    public void apagar(Integer obj) throws ClassNotFoundException, SQLException;    
    public C buscarPorChave(Integer obj) throws ClassNotFoundException, SQLException;    
    public ArrayList<C> buscarTodos() throws ClassNotFoundException, SQLException;
}
