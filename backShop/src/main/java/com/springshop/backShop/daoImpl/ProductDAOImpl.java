package com.springshop.backShop.daoImpl;

import com.springshop.backShop.dao.ProductDAO;
import com.springshop.backShop.dto.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Product get(int productId) {
        try {
            return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> list() {
        return sessionFactory.getCurrentSession().createQuery("FROM PRODUCT", Product.class).getResultList();
    }

    @Override
    public boolean add(Product product) {
        try {
            sessionFactory.getCurrentSession().persist(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean update(Product product) {
        try {
            sessionFactory.getCurrentSession().update(product);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean delete(Product product) {
        try {
            product.setActive(false);
            return this.update(product);

        } catch (Exception ex) {
            ex.printStackTrace();
        }


        return false;
    }

    @Override
    public List<Product> listActiveProducts() {
        String selectActiveProducts = "FROM Product WHERE active = TRUE ";

        return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class).getResultList();
    }

    @Override
    public List<Product> listActiveProductsByCategory(int categoryId) {
        String listAcitveProductsByCategory = "FROM Product WHERE active = TRUE and categoryID = " + categoryId;
        return sessionFactory.getCurrentSession().createQuery(listAcitveProductsByCategory, Product.class).getResultList();
    }

    @Override
    public List<Product> getLatestActiveProducts(int count) {
        return sessionFactory.getCurrentSession().createQuery("FROM Product WHERE active = TRUE ORDER BY id", Product.class)
                .setFirstResult(0)
                .setMaxResults(count)
                .getResultList();
    }
}
