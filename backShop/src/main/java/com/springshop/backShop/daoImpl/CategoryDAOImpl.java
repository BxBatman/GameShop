package com.springshop.backShop.daoImpl;

import com.springshop.backShop.dao.CategoryDAO;
import com.springshop.backShop.dto.Category;

import org.hibernate.SessionFactory;
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

    @Override
    public boolean delete(Category category) {
        return false;
    }

    @Override
    public List<Category> list() {
        return null;
    }


    //getting single category
    @Override
    public Category get(int id) {

        return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
    }
}
