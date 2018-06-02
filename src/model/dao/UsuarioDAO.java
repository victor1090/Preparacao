/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import com.mysql.jdbc.PreparedStatement;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.bean.Contato;
import model.bean.Usuario;

/**
 *
 * @author Angel Of Dead
 */
public class UsuarioDAO {
    public void create(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `usuario`(`login`,`senha`,`acesso`) VALUES (?,?,?)");
           stmt.setString(1, user.getLogin());
           stmt.setString(2, user.getSenha());
           stmt.setInt(3, user.getAcesso());
           
           stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Criado com Sucesso!");

        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao Criar:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public boolean read(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
           stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM `usuario` WHERE `login` LIKE ? AND `senha` LIKE ?");
           stmt.setString(1, user.getLogin());
           stmt.setString(2, user.getSenha());
           
           rs = stmt.executeQuery();
           if(rs.next()){
               user.setAcesso(rs.getInt("acesso"));
               return true;
           }               
           else
               return false;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro:"+ex);
             return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void update(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = (PreparedStatement) con.prepareStatement("UPDATE `usuario` SET `login`=?,`senha`=? WHERE login = ?");
           stmt.setString(1, user.getLogin());
           stmt.setString(2, user.getSenha());
           stmt.setString(3, user.getLogin());
           
           stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null,"Atualizado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao atualizar:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    public void delete(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
           stmt = (PreparedStatement) con.prepareStatement("DELETE FROM `usuario` WHERE login = ?");
           stmt.setString(1, user.getLogin());
           
           
           stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null,"Usuario Excluido com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro ao Excluir:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
