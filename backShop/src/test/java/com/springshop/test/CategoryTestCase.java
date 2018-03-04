package com.springshop.test;

import com.springshop.backShop.dao.CategoryDAO;
import com.springshop.backShop.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.transaction.TransactionScoped;

import static org.junit.Assert.assertEquals;

public class CategoryTestCase {

    private static AnnotationConfigApplicationContext context;

    private static CategoryDAO categoryDAO;

    private Category category;


    @BeforeClass
    public static void init() {
        context = new AnnotationConfigApplicationContext();
        context.scan("com.springshop.backShop");
        context.refresh();

        categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

    }

   /* @Test
    public void testAddCategory(){
        category = new Category();

        category.setName("XBOX");
        category.setDescription("gry dla konsoli xbox");
        category.setImageURL("3.PNG");

        assertEquals("Sukces! dodano kategorie",true,categoryDAO.add(category));

        }
*/

   /*@Test
    public void getCategory(){
       category = categoryDAO.get(3);
       assertEquals("Sukces! fetch a single from the table","XBOX",category.getName());
   }*/

   /*@Test
    public void updateCategory(){
        category = categoryDAO.get(3);
        category.setName("XBOX360");
        assertEquals("Sukces! updated a single from the table",true,categoryDAO.update(category));
    }
*/



  /* @Test
    public void testListCategory(){
       assertEquals("succesfuly fetched the list of active categories",2,categoryDAO.list().size());
   }*/

    @Test
    public void testCRUDCategory() {

        category = new Category();

        category.setName("PS3");
        category.setDescription("gry dla konsoli ps3");
        category.setImageURL("1.PNG");

        assertEquals("Sukces! dodano kategorie", true, categoryDAO.add(category));


        category = new Category();

        category.setName("PS4");
        category.setDescription("gry dla konsoli ps4");
        category.setImageURL("2.PNG");

        assertEquals("Sukces! dodano kategorie", true, categoryDAO.add(category));


        category = new Category();

        category.setName("XBOX");
        category.setDescription("gry dla konsoli xbox");
        category.setImageURL("3.PNG");

        assertEquals("Sukces! dodano kategorie", true, categoryDAO.add(category));

        category = categoryDAO.get(2);
        category.setName("PS4");
        assertEquals("Sukces! updated a single from the table",true,categoryDAO.update(category));

        assertEquals("Sukces! updated a single from the table",true,categoryDAO.delete(category));

        assertEquals("succesfuly fetched the list of active categories",2,categoryDAO.list().size());




    }


}
