package com.qa.ims.controller;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrdersDao;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.JavaUtilities;

public class OrdersController implements ICrudController<Orders> {
    public static final Logger LOGGER = LogManager.getLogger();

    private OrdersDao ordersDao;
    private JavaUtilities javaUtilities;

    public OrdersController(OrdersDao ordersDAO, JavaUtilities javaUtilities) {
    	super();
    	this.ordersDao = ordersDAO;
    	this.javaUtilities = javaUtilities;
    } 
    
    
    @Override
    public List<Orders> readAll() {
        List<Orders> order = ordersDao.readAll();
        for (Orders orders : order) {
            LOGGER.info(orders.toString());
        }
        return order;
    }

   
	@Override
	public Orders create () {
        LOGGER.info("Please enter your customer id");
        Long id = javaUtilities.getLong();
        Orders orders = ordersDao.create(new Orders (new Customer(id,null,null),0.0)); 
        LOGGER.info("order entered");
        return orders;
    }

    @Override
    public Orders update() {
    	Orders price= null;
    	LOGGER.info("Please enter your order id");
        Long o_id = javaUtilities.getLong();
        LOGGER.info("Would you like to add or remove an item?");
        String action = javaUtilities.getString();
        if (action.equals("add")) {
        	LOGGER.info("please enter the i_id you would like to add");
        	Long i_id = javaUtilities.getLong();
        	price = OrdersDao.addItems(o_id, i_id);
        } else if (action.equals("Remove")) {
        	LOGGER.info("Please enter the item i_id you would like to Remove");
        	Long i_id = javaUtilities.getLong();
        	price = OrdersDao.deleteItems(o_id, i_id);
        } else {
        	LOGGER.info("Invalid input, please choose add or Removee");
        }
      
      return price;
    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the item you would like to delete");
        Long i_id = javaUtilities.getLong();
        return ordersDao.delete(i_id);
    }


}