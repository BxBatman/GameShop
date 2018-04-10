package com.springshop.backShop.dao;

import com.springshop.backShop.dto.Address;
import com.springshop.backShop.dto.Cart;
import com.springshop.backShop.dto.User;

import java.util.List;

public interface UserDAO {
    boolean addUser(User user);
    User getByEmail(String email);
    boolean addAddress(Address address);
    Address getBillingAddress(User user);
    List<Address> listShippingAddresses(User user);

}
