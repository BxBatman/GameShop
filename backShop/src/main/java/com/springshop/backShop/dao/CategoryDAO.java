package com.springshop.backShop.dao;

import com.springshop.backShop.dto.Category;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CategoryDAO {


    List<Category> list();
    Category get(int id);
    boolean add(Category category);
    boolean update(Category category);
    boolean delete(Category category);
}
