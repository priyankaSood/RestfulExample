package com.infosys.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.infosys.model.Category;
import com.infosys.model.Item;
import com.infosys.model.Payload;
import com.infosys.util.DBUtilImpl;
public class ItemDAOImpl implements ItemDAO {
	

	@SuppressWarnings("unchecked")
	@Override
	public Payload listItems() {
		Connection conn = null;
		DBUtilImpl dbUtil = new DBUtilImpl();
		Payload payload =new Payload();
		List<Category> categories = new ArrayList<Category>();
		List<Item> itemList = new ArrayList<Item>();
		Category category =null;
		InputStream is =null;
		String previousCategory = null;
		String currentCategory =null;
		try {
			
			Properties props =new Properties();
			is= this.getClass().getResourceAsStream("/com/infosys/resources/config.properties");
			props.load(is);
			String tableName =props.getProperty("tablename");
			
			conn = dbUtil.getConnection();
			//PreparedStatement ps=conn.prepareStatement("select * from FURNITUREGURU");	
			PreparedStatement ps=conn.prepareStatement("select * from "+tableName);
			ResultSet rs=ps.executeQuery();
			while (rs.next()){
				//read catgegory				
				currentCategory = rs.getString(2);
				//new category
				if(currentCategory!=previousCategory){
					//add previous category to the list
					if(previousCategory!=null){
						categories.add(category);
					}
					category =new Category();
					category.setCat_name(currentCategory);
				Item item =new Item();
				item.setSku(rs.getString(1));
				item.setItem_name(rs.getString(3));
				item.setPrice(rs.getString(4));
				item.setColor(rs.getString(5));
				item.setDescription(rs.getString(6));
				itemList.add(item);
				category.setItems(itemList);
				categories.add(category);
				previousCategory = currentCategory;
			}
			}
			payload.setCategory(categories);
			payload.setWebsite_name(tableName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return payload;
	}

}
