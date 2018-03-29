package com.springshop.backShop.dao;

import com.springshop.backShop.dto.Address;
import com.springshop.backShop.dto.Cart;
import com.springshop.backShop.dto.User;

public interface UserDAO {
    boolean addUser(User user);
    boolean addAddress(Address address);
    boolean addCart(Cart cart);
}
