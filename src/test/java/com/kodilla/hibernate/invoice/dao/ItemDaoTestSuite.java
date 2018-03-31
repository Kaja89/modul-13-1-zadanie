package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemDaoTestSuite {

    @Autowired
    private ItemDao itemDao;

    @Test
    public void testItemDaoSaveWithProduct(){
        //Given
        Item item = new Item(new BigDecimal(10.0), 2, new BigDecimal(1));
        Product product = new Product("book");
        item.setProduct(product);
        //When
        itemDao.save(item);
        //Then
        int id = item.getId();
        Assert.assertEquals(id, itemDao.findOne(id).getId());
        //CleanUp
        itemDao.delete(id);
    }
}
