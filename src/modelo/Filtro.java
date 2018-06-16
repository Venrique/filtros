/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author LN710Q
 */
public class Filtro {
    private int id;
    private String codigo;
    private int marca;
    private int stock;
    private boolean existencia;
    
    public Filtro(){
        
    }

    public Filtro(int id,String codigo ,int stock, boolean existencia,int marca) {
        this.id = id;
        this.codigo = codigo;
        this.stock = stock;
        this.marca = marca;
        this.existencia = existencia;
    }

    public Filtro(String codigo,int stock, boolean existencia, int marca) {
        this.stock = stock;
        this.codigo = codigo;
        this.marca = marca;
        this.existencia = existencia;
    }

    public Filtro(int marca,int stock, boolean existencia) {
        this.stock = stock;
        this.marca = marca;
        this.existencia = existencia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getMarca() {
        return marca;
    }

    public void setMarca(int marca) {
        this.marca = marca;
    }

    public boolean isExistencia() {
        return existencia;
    }

    public void setExistencia(boolean existencia) {
        this.existencia = existencia;
    }
    
    
}
