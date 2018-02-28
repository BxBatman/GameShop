package com.springshop.backShop.daoImpl;

import com.springshop.backShop.dao.CategoryDAO;
import com.springshop.backShop.dto.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
    private static List<Category> categories = new ArrayList<>();

    static {
        Category category = new Category();
        category.setId(1);
        category.setName("gry ps3");
        category.setDescription("gry dla konsoli ps3");
        category.setImageURL("1.PNG");
        categories.add(category);

        //second


        category = new Category();
        category.setId(2);
        category.setName("gry ps4");
        category.setDescription("gry dla konsoli ps4");
        category.setImageURL("2.PNG");
        categories.add(category);


        //third

        category = new Category();
        category.setId(1);
        category.setName("gry xbox");
        category.setDescription("gry dla konsoli xbox");
        category.setImageURL("3.PNG");
        categories.add(category);

    }

    @Override
    public List<Category> list() {
        return categories;
    }
}
