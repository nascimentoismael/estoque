/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.estoque.model;

/**
 *
 * @author ismaeldeazevedonascimento
 */
public class Item {
    private int id, qtde;
    private String desc;
    private double vl_unit;
    private Fornecedor fornecedor;

    public Item(int id, int qtde, String desc, double vl_unit, Fornecedor fornecedor) {
        this.id = id;
        this.qtde = qtde;
        this.desc = desc;
        this.vl_unit = vl_unit;
        this.fornecedor = fornecedor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getVl_unit() {
        return vl_unit;
    }

    public void setVl_unit(double vl_unit) {
        this.vl_unit = vl_unit;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
