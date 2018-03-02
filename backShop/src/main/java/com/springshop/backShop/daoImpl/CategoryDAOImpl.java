package com.springshop.backShop.daoImpl;

import com.springshop.backShop.dao.CategoryDAO;
import com.springshop.backShop.dto.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {


    @Autowired
    private SessionFactory sessionFactory;

    private static List<Category> categories = new ArrayList<>();

    static {
        Category category = new Category();
        category.setId(1);
        category.setName("gryps3");
        category.setDescription("gry dla konsoli ps3");
        category.setImageURL("1.PNG");
        categories.add(category);

        //second


        category = new Category();
        category.setId(2);
        category.setName("gryps4");
        category.setDescription("gry dla konsoli ps4");
        category.setImageURL("2.PNG");
        categories.add(category);


        //third

        category = new Category();
        category.setId(3);
        category.setName("gryxbox");
        category.setDescription("gry dla konsoli xbox");
        category.setImageURL("3.PNG");
        categories.add(category);

    }

    @Override
    @Transactional
    public boolean add(Category category) {
        try {
            sessionFactory.getCurrentSession().persist(category);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Category> list() {
        return categories;
    }


    //enhancede for loop
    @Override
    public Category get(int id) {
        for (Category category : categories) {
            if (category.getId() == id) {
                return category;
            }
        }
        return null;
    }
}
