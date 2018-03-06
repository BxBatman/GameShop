package com.springshop.backShop.daoImpl;

import com.springshop.backShop.dao.CategoryDAO;
import com.springshop.backShop.dto.Category;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {


    @Autowired
    private SessionFactory sessionFactory;


    @Override

    public boolean add(Category category) {
        try {

            sessionFactory.getCurrentSession().persist(category);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    //updating a single category
    @Override
    public boolean update(Category category) {
        try {

            sessionFactory.getCurrentSession().update(category);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    //deleting single category
    @Override
    public boolean delete(Category category) {
        //set unactive to not available to see
        category.setActive(false);
        try {

            sessionFactory.getCurrentSession().update(category);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Category> list() {
        String selectActiveCategory = "FROM Category WHERE active = 'TRUE'";
        Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
        //query.setParameter("active",true);


        return query.getResultList();
    }


    //getting single category
    @Override
    public Category get(int id) {

        return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
    }


}
