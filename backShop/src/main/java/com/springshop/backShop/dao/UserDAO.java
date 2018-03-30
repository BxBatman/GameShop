package com.springshop.backShop.dao;

import com.springshop.backShop.dto.Address;
import com.springshop.backShop.dto.Cart;
import com.springshop.backShop.dto.User;

public interface UserDAO {
    boolean addUser(User user);
    User getByEmail(String email);
    boolean addAddress(Address address);
    boolean updateCart(Cart cart);
}
