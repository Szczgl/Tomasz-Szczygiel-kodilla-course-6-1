package com.kodilla.hibernate.invoice.dao;

import com.kodilla.hibernate.invoice.Invoice;
import com.kodilla.hibernate.invoice.Item;
import com.kodilla.hibernate.invoice.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class InvoiceDaoTestSuite {

    @Autowired
    private InvoiceDao invoiceDao;

    @Test
    void testInvoiceDaoSave() {
        //Given
        Product product = new Product();
        product.setName("Mleko");

        Item item1 = new Item();
        item1.setPrice(BigDecimal.valueOf(20));
        item1.setQuantity(10);
        item1.setValue(BigDecimal.valueOf(40));

        Item item2 = new Item();
        item2.setPrice(BigDecimal.valueOf(10));
        item2.setQuantity(1);
        item2.setValue(BigDecimal.valueOf(20));

        Invoice invoice = new Invoice();
        invoice.setNumber("12-34");

        product.getItems().add(item1);
        product.getItems().add(item2);

        item1.setProduct(product);
        item2.setProduct(product);

        item1.setInvoice(invoice);
        item2.setInvoice(invoice);


        //When
        invoiceDao.save(invoice);
        int id = invoice.getId();

        //Then
        assertNotEquals(0, id);
        //assertEquals("12-34", invoice.getNumber());

        //CleanUp
        invoiceDao.deleteById(id);
    }
}
