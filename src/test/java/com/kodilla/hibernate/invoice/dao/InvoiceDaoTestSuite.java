package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
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
public class InvoiceDaoTestSuite {
    @Autowired
    InvoiceDao invoiceDao;

    @Test
    public void testInvoiceDaoSave() {
        //Given
        Product product1 = new Product("glasses");
        Product product2 = new Product("sunglasses");
        Product product3 = new Product("umbrella");

        Item item1 = new Item(new BigDecimal(100.0), 2, new BigDecimal(1.0));
        Item item2 = new Item(new BigDecimal(200.0), 4, new BigDecimal(1.0));
        Item item3 = new Item(new BigDecimal(300.0), 1, new BigDecimal(1.0));

        item1.setProduct(product1);
        item2.setProduct(product2);
        item3.setProduct(product3);

        Invoice invoice = new Invoice("2834789347");
        invoice.getItems().add(item1);
        invoice.getItems().add(item2);
        invoice.getItems().add(item3);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        item3.setInvoice(invoice);
        //When
        invoiceDao.save(invoice);
        //Then
        int id = invoice.getId();
        Assert.assertEquals(id, invoiceDao.findOne(id).getId());
        //CleanUp
        invoiceDao.delete(id);
    }
}
