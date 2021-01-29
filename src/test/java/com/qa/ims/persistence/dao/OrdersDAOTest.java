//package com.qa.ims.persistence.dao;
//
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.persistence.domain.Items;
//import com.qa.ims.persistence.domain.Orders;
//import com.qa.ims.utils.DatabaseUtilities;
//
//public class OrdersDAOTest {
//
//    private final OrdersDao DAO = new OrdersDao(); 
//
//    @Before
//    public void setup() { 
//        DatabaseUtilities.connect();
//        DatabaseUtilities.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
//        List<Items> itemList = new ArrayList<>();
//        itemList.add(new Items (1L, "DeadPool",6.99, "Action"));
//        itemList.add(new Items (2L, "Girls Trip", 5.99, "Comdey")); 
//        Orders o = new Orders (3L, 11.99 , new Customer (1L, "shahnaz", "aktar"), itemList); 
//    }
//
//    @Test
//    public void testCreate() { 
//        final Orders created = new Orders(3L, 11.99, new Customer(1L, "shahnaz","aktar"));
//        assertEquals(created, DAO.create(created));
//    }
//
//    @Test
//    public void testReadAll() {
//        List<Orders> expected = new ArrayList<>();
//        expected.add (new Orders(3L, 11.99, new Customer (1L, "shahnaz", "aktar")));
//        assertEquals(expected, DAO.readAll());
//    } 
//
//    @Test
//    public void testReadLatest() {
//        assertEquals(new Orders(3L, 11.99, new Customer (1L, "shahnaz","aktar"), DAO.readLatest());
//    }
//
//    @Test
//    public void testRead() {
//        final long ID = 1L;
//        assertEquals(new Orders(1L, 6.99, new Customer(1L, "shahnaz","aktar"), DAO.read(ID));
//    }
//
//    @Test
//    public void testUpdate() {
//        final Orders updated = new 
//        Orders(2L, 1.99, new Customer(1L, "shahnaz","aktar"));
//        assertEquals(updated, DAO.update(updated));
//
//    }
//
//    @Test
//    public void testDelete() {
//        assertEquals(1, DAO.delete(1));
//    }
//}
