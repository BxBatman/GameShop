package com.springshop.backShop.daoImpl;

import com.springshop.backShop.dao.AddressDAO;
import com.springshop.backShop.dto.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("addressDAO")
@Transactional
public class AddressDAOImpl implements AddressDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Address getAddressByUserId(int userId) {
       String selectQuery = "FROM Address WHERE user.id = :user_id and billing= :billing_val";
       try{
            return sessionFactory.getCurrentSession().createQuery(selectQuery,Address.class).setParameter("user_id",userId).setParameter("billing_val",true).getSingleResult();
       }catch(Exception ex){
           ex.printStackTrace();
           return null;
        }

    }
}
