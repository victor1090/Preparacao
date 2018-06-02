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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Contato;
import model.bean.Usuario;

/**
 *
 * @author Angel Of Dead
 */
public class ContatoDAO {
    
    public void create(Usuario user,Contato ct){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
           stmt = (PreparedStatement) con.prepareStatement("INSERT INTO `contato`(`nome`,`email`, `numero`, `login`) VALUES (?,?,?,?)");
           stmt.setString(1, ct.getNome());
           stmt.setString(2, ct.getEmail());
           stmt.setInt(3, ct.getNumero());
           stmt.setString(4, user.getLogin());
           
           stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null,"Salvo com Sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao salvar:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
    public ArrayList<Contato> read(Usuario user){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Contato> agenda = new ArrayList<Contato>();
        try {
           stmt = (PreparedStatement) con.prepareStatement("SELECT * FROM `contato` WHERE `login` LIKE  ?");
           stmt.setString(1, user.getLogin());
           
           rs = stmt.executeQuery();
           while(rs.next()){
              Contato contato = new Contato();
              contato.setNome(rs.getString("nome"));
              contato.setEmail(rs.getString("email"));
              contato.setNumero(rs.getInt("numero"));
              agenda.add(contato);
           }
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return agenda;
    }
    
    public void update(Usuario user,Contato ct){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
           stmt = (PreparedStatement) con.prepareStatement("UPDATE `contato` SET `nome`=?,`email`=?,`numero`=? WHERE login = ? AND nome = ?");
           stmt.setString(1, ct.getNome());
           stmt.setString(2, ct.getEmail());
           stmt.setInt(3, ct.getNumero());
           stmt.setString(4, user.getLogin());
           stmt.setString(5, ct.getNome());
           
           stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null,"Atualizado com Sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao atualizar:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    public void delete(Usuario user,Contato ct){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
           stmt = (PreparedStatement) con.prepareStatement("DELETE FROM `contato` WHERE login = ? AND nome = ?");
           stmt.setString(1, user.getLogin());
           stmt.setString(2, ct.getNome());
           
           stmt.executeUpdate();
           
            JOptionPane.showMessageDialog(null,"Excluido com Sucesso!");
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Erro ao Excluir:"+ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
}
