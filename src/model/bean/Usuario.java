/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author Angel Of Dead
 */
public class Usuario {
    private String login;
    private String senha;
    private int acesso;

    public Usuario(String login, String senha, int acesso){
        this.login = login;
        this.senha = senha;
        this.acesso = acesso;
    }
    
     public Usuario(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getAcesso() {
        return acesso;
    }

    public void setAcesso(int acesso) {
        this.acesso = acesso;
    }
    
    
}
