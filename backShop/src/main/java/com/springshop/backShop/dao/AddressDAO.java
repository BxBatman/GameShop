package com.springshop.backShop.dao;

import com.springshop.backShop.dto.Address;

public interface AddressDAO {
    Address getAddressByUserId(int userId);
}
