package util;

import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation3 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Category> CategoryDao = context.getBean("categoryDaoImpl",IDao.class);

        Category category = new Category();
        category.setName("Category 1");

        CategoryDao.create(category);

        System.out.println("Category sauvegardé : " + category.getName());
    }
}