package com.springshop.backShop.dao;

import com.springshop.backShop.dto.Category;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface CategoryDAO {
    List<Category> list();
}
