/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Apartamento;
/**
 *
 * @author robert
 */
public class Apartamento {

    public int ID;
    public int NumeroApartamento;
    public int Citofono;
    public String Torre;
    public String Telefono;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumeroApartamento() {
        return NumeroApartamento;
    }

    public void setNumeroApartamento(int NumeroApartamento) {
        this.NumeroApartamento = NumeroApartamento;
    }

    public int getCitofono() {
        return Citofono;
    }

    public void setCitofono(int Citofono) {
        this.Citofono = Citofono;
    }

    public String getTorre() {
        return Torre;
    }

    public void setTorre(String Torre) {
        this.Torre = Torre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int Insertar() {
        Database d = new Database();
        return d.onInsert("INSERT INTO apartamento values (null, '" + this.NumeroApartamento + "', '" + this.Citofono + "', '" + this.Torre + "', '" + this.Telefono + "')");
    }
}
