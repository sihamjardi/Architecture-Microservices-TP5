package test;

import dao.IDao;
import entities.Product;
import entities.Category;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import util.HibernateConfig;
import metier.CategoryDaoImpl;
import metier.ProductDaoImpl;

public class Presentation2 {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        IDao<Product> productDao =  context.getBean("productDaoImpl", IDao.class);
        IDao<Category> categoryDao = context.getBean("categoryDaoImpl",IDao.class);

        Category category = new Category();
        category.setNom("Informatique");
        categoryDao.create(category);
        System.out.println("Catégorie sauvegardée : " + category.getNom());

        Product product = new Product();
        product.setName("Produit 1");
        product.setPrice(100.0);

        productDao.create(product);

        System.out.println("Produit sauvegardé : " + product.getName());

        Product product1 = new Product();
        product.setName("Produit 1");
        product.setPrice(500.0);
        product.setCategory(category);
        productDao.create(product);
        System.out.println("Produit sauvegardé : " + product.getName() + " dans la catégorie " +category.getNom());


    }
}