/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estoque.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ismaeldeazevedonascimento
 */
public class ConnectionFactory {
    public static Connection getConnection() throws ClassNotFoundException, SQLException  {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        return DriverManager.getConnection( "jdbc:mysql://localhost:3306/estoque",
                                            "gustil",
                                            "viannadba");
        
    }
    
//    public static void main(String[] args)   {
//
//         Connection c;
//        try {
//            c = ConnectionFactory.getConnection();
//        
//            System.out.println(""+c.getCatalog() );
//        
//        } catch (ClassNotFoundException | SQLException ex) {
//            System.out.println(ex.getMessage());
//        }
//        
//    }
}
