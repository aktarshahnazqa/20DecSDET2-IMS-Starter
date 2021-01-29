package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.sql.rowset.serial.SQLOutputImpl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DatabaseUtilities;
import com.qa.ims.utils.JavaUtilities;

public class OrdersDao implements IDomainDao<Orders> {

    public static final Logger LOGGER = LogManager.getLogger();
    
    private ItemsDao itemsDao;
    private CustomerDao customerDao; 
    
    public OrdersDao(ItemsDao itemsDao, CustomerDao customerDao) {
		super();
		this.itemsDao = itemsDao; 
		this.customerDao = customerDao;
	}
    
    public List<Items> getAllItems(Long o_id, List<Items> finalItems){
    	List<Long>itemi_id = new ArrayList<>();
    	try(Connection connection = DatabaseUtilities.getInstance().getConnection();
    			PreparedStatement statement = connection
    					.prepareStatement("SELECT * FROM orderitems WHERE fkoid =?");){
    						statement.setLong(1, o_id);
    						try(ResultSet resultSet = statement.executeQuery();){
    							while (resultSet.next()) {
    								itemi_id.add(resultSet.getLong("fkiid"));
    							}
    						}
    					}catch (Exception e) {
    						LOGGER.debug(e);
    						LOGGER.error(e.getMessage());
    					}
    	for (Long i: itemi_id) {
    		finalItems.add(itemsDao.read(i));
    	}
    	return finalItems;
    }


//  public double calcprice1 (Long o_id) {
//	   double price = this.getAllItems(o_id).stream().map(item -> 
//	   item.getPrice ()).reduce ((acc, next) -> acc + next)
//		.orElse(0,0);
//	   this.update(new Orders(o_id, price, null));
//	   return price;
// }

//  public double calcprice (Long o_id) {
//	  List<Long>Itemi_id = new ArrayList<>();
//	  List<Items> priceItem = new ArrayList<>();
//	  for ( double d = 0.0 ;
//			priceItem + = resultSet.getDouble("price"));
//	  /
//		
//	  }
  
    
   public Orders addItems (Long o_id, Long i_id){
	   try (Connection connection = DatabaseUtilities.getInstance().getConnection();
               PreparedStatement statement = connection
            		   .prepareStatement("INSERT INTO orderitems(fko_id, fki_id) VALUES(?,?)");){
		   statement.setLong(1, o_id);
		   statement.setLong(2, i_id);
		   statement.executeUpdate();
		   return readLatest();
		   } catch (Exception e) {
			   LOGGER.debug(e);
			   LOGGER.error(e.getMessage());
		   }
	   calcprice(o_id);
	   return read (o_id); 
   }
   
   public Orders deleteItems (Long o_id, Long i_id){
	   try (Connection connection = DatabaseUtilities.getInstance().getConnection();
               PreparedStatement statement = connection
            		   .prepareStatement("DELETE FROM orderitems(fko_id, fki_id) VALUES(?,?)");){
		   statement.setLong(1, o_id);
		   statement.setLong(2, i_id);
		   statement.executeUpdate();
		   return readLatest();
		   } catch (Exception e) {
			   LOGGER.debug(e);
			   LOGGER.error(e.getMessage());
		   }
	   calcprice(o_id);
	   return read (o_id);
       
   }
    
	@Override
    public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long o_id = resultSet.getLong("o_id");
        Customer customer = customerDao.read(resultSet.getLong("id"));
        double price = calcprice(o_id);
//        List <Items> orderItems = new ArrayList<>();
		return new Orders(o_id, price, customer); 
	}
    
    @Override
    public List<Orders> readAll() {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("select * from orders");) {
            List<Orders> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(modelFromResultSet(resultSet));
            }
            return orders;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public Orders readLatest() {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders BY id DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Orders create(Orders order) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement("INSERT INTO orders(fk_id) Values (?)");) {
        			statement.setLong(1,  order.getCustomer().getId());
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    public Orders read(Long o_id) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM orders where o_id = " + o_id);) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Orders update(Orders order) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            statement.executeUpdate("update orders set Price'" + order.getPrice() + "', Price ='"
                    + order.geto_id());
            return read(order.geto_id());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }
 
    @Override
    public int delete(long o_id) {
        try (Connection connection = DatabaseUtilities.getInstance().getConnection();
                Statement statement = connection.createStatement();) {
            return statement.executeUpdate("delete from orders where id = " + o_id);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

}
