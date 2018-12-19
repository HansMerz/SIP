/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Vehiculo;
/**
 *
 * @author robert
 */
public class Vehiculo {
    public int id;
    public String placa;
    public String modelo;
    public String color;
    public String marca;
    public int idUsuario;
    public String tipoplaca;
    public String tipovehiculo;

    public String getTipoplaca() {
        return tipoplaca;
    }

    public void setTipoplaca(String tipoplaca) {
        this.tipoplaca = tipoplaca;
    }

    public String getTipovehiculo() {
        return tipovehiculo;
    }

    public void setTipovehiculo(String tipovehiculo) {
        this.tipovehiculo = tipovehiculo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    
    public int Insertar() {
        Database d = new Database();
        return d.onInsert("INSERT INTO vehiculo values (null, '" + this.tipovehiculo + "', '" + this.placa + "', '" + this.tipoplaca + "', '" + this.modelo + "', '" + this.color + "', '" + this.marca + "', '" + this.idUsuario + "')");
    } 
}
