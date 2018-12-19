/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Models.Usuario;

/**
 *
 * @author robert
 */
public class Usuario {

    public int ID;
    public String Nombres;
    public String Apellido1;
    public String Apellido2;
    public String Telefono;
    public int Identificacion;
    public String NumeroParqueadero;
    public int IdRol;
    public int IdApartamento;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellido1() {
        return Apellido1;
    }

    public void setApellido1(String Apellido1) {
        this.Apellido1 = Apellido1;
    }

    public String getApellido2() {
        return Apellido2;
    }

    public void setApellido2(String Apellido2) {
        this.Apellido2 = Apellido2;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getIdentificacion() {
        return Identificacion;
    }

    public void setIdentificacion(int Identificacion) {
        this.Identificacion = Identificacion;
    }

    public String getNumeroParqueadero() {
        return NumeroParqueadero;
    }

    public void setNumeroParqueadero(String NumeroParqueadero) {
        this.NumeroParqueadero = NumeroParqueadero;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }

    public int getIdApartamento() {
        return IdApartamento;
    }

    public void setIdApartamento(int IdApartamento) {
        this.IdApartamento = IdApartamento;
    }

    public int Insertar() {
        Database d = new Database();
        return d.onInsert("INSERT INTO usuario values (null, '" + this.Nombres + "', '" + this.Apellido1 + "', '" + this.Apellido2 + "', '" + this.Telefono + "', '" + this.Identificacion + "', '" + this.NumeroParqueadero + "', '" + IdRol + "', '" + IdApartamento + "')");
    }
    
    public int Actualizar()
    {
        Database d = new Database();
        return d.onInsert("update usuario set nombres = '" + this.Nombres + "', apellido_1 = '" + this.Apellido1 + "', apellido_2 = '" + this.Apellido2 + "', telefono = '" + this.Telefono + "', identificacion = '" + this.Identificacion + "', num_parqueadero = '" + this.NumeroParqueadero + "', idRol = '" + IdRol + "', idApartamento = '" + IdApartamento + "' where idUsuario = " + this.ID);
    }

}
