/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.gestor.generico;

import java.util.List;

/**
 *
 * @author tritiummonoid
 */
public interface IGestor {
    String getNombre();
    List<IBaseDeDatos> getBasesDeDatos() throws Exception;
    IBaseDeDatos getBaseDeDatos(String nombre) throws Exception;
}
