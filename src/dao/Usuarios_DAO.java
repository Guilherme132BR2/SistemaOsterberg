/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UsuariosGvo;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Guilherme132BR
 */
public class Usuarios_DAO extends DAO_Abstract{
    @Override
    public void insert(Object object) {
    session.beginTransaction();
    session.save(object);
    session.getTransaction().commit();
    }

    @Override
    public void update(Object object) {
    session.beginTransaction();
    session.flush();
    session.clear();
    session.update(object);
    session.getTransaction().commit();
    }

    @Override
    public void delete(Object object) {
    session.beginTransaction(); 
    session.flush();
    session.clear();
    session.delete(object);
    session.getTransaction().commit();
    }

     @Override
    public Object list(int id) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(UsuariosGvo.class);
        criteria.add(Restrictions.eq("idUsuariosGvo", id)); 
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public List listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(Usuarios_DAO.class);
        List lista = criteria.list();
        session.getTransaction().commit();
        return(ArrayList) lista;
    }

}
