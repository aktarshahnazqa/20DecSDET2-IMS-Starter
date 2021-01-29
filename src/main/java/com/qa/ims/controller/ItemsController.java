package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDao;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.JavaUtilities;

public class ItemsController implements ICrudController<Items> {
    public static final Logger LOGGER = LogManager.getLogger();

    private ItemsDao itemsDao;
    private JavaUtilities javaUtilities;

    public ItemsController(ItemsDao itemsDao, JavaUtilities javaUtilities) {
        super();

        this.itemsDao = itemsDao; 

        this.itemsDao = itemsDao;

        this.javaUtilities = javaUtilities;
       }
    
    
    @Override
    public List<Items> readAll() {
        List<Items> items = itemsDao.readAll();
        for (Items item : items) {

            LOGGER.info(item.toString()); 

            LOGGER.info(item.toString());

        }
        return items;
    }

   
	@Override
	public Items create () {
        LOGGER.info("Please enter the item_name");
        String item_name = javaUtilities.getString();
        LOGGER.info("Please enter a price");
        Double price = javaUtilities.getDouble();
        LOGGER.info("Please enter the genre ");
        String genre = javaUtilities.getString();
        Items items = itemsDao.create(new Items(item_name, price, genre));
        LOGGER.info("Items created");
        return items;
    }

    @Override
    public Items update() {
        LOGGER.info("Please enter the item_name");
        String itemname = javaUtilities.getString();
        LOGGER.info("Please enter a price");
        Double price = javaUtilities.getDouble();

        LOGGER.info("Please enter the price of your item");

        LOGGER.info("Please enter description for your item");

        String genre = javaUtilities.getString();
        Items items = itemsDao.update (new Items(itemname, price, genre));
        LOGGER.info("Items updated");
        return items;
    }

    @Override
    public int delete() {
        LOGGER.info("Please enter the id of the item you would like to delete");
        Long i_id = javaUtilities.getLong();
        return itemsDao.delete(i_id);
    }



}

}

