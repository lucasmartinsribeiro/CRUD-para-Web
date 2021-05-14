/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import model.Jogos;

import java.util.List;

/**
 * @param <T>
 * @author Lucas Martins Ribeiro
 */
public interface InterfaceDao<T> {

    public abstract void incluir(T entidade) throws Exception;

    public abstract void editar(T entidade) throws Exception;

    public abstract void excluir(T entidade) throws Exception;

    public abstract T pesquisarporId(int id) throws Exception;

    public List<Jogos> pesquisarporNome(String nome) throws Exception;

    public abstract List<T> listar() throws Exception;

}
