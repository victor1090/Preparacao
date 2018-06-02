/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendabd;

import java.util.Scanner;
import model.bean.Usuario;
import model.dao.UsuarioDAO;

/**
 *
 * @author Angel Of Dead
 */
public class AgendaBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TelaCadastro ta = new TelaCadastro();
        ta.setVisible(true);
        /* Cadastro
        user.create(usuario);
        */
        
        /* LOGIN
        boolean acesso = user.read(usuario);
        if(acesso == true)
            System.out.println("Bem Vindo "+usuario.getLogin());
        else
            System.out.println("Login ou Senha Invalidos!");
                
        */
        /* Deletar
        user.delete(usuario);
        */
    }
    
}
