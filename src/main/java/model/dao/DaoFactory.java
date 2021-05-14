/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

/**
 *
 * @author Lucas Martins Ribeiro
 */
public class DaoFactory {
    
    public static JogoDaoJpa novoJogoDao() throws Exception{
        return new JogoDaoJpa();
    }
    
}
