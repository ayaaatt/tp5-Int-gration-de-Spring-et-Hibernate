package util;

import dao.IDao;
import entities.Category;
import entities.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao = context.getBean("productDaoImpl",IDao.class);
        IDao<Category> CategoryDao = context.getBean("categoryDaoImpl",IDao.class);


        Category category = CategoryDao.findById(1);
        Product product = new Product();
        product.setName("Produit 1");
        product.setCategory(category);
        product.setPrice(100.0);

        productDao.create(product);

        System.out.println("Produit sauvegardé : " + product.getName());


        for (Product p : productDao.findAll()) {
            System.out.println(p);
        }
    }
}