package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductDaoTestSuite {

    @Autowired
    private ProductDao productDao;

    @Test
    public void testProductDaoSave(){
        //Given
        Product product = new Product("Toothbrush");
        //When
        productDao.save(product);
    }
}
