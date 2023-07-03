import entities.Product;
import entities.Sale;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = Persistence
                .createEntityManagerFactory("exercise")
                .createEntityManager();

//        entityManager.getTransaction().begin();
//
//        Sale sale = new Sale();
//        sale.setDate(LocalDateTime.now());
//
//        Product product = new Product();
//        product.setName("TestProduct");
//        product.setPrice(BigDecimal.TEN);
//        product.setQuantity(5.0);
//        product.getSales().add(sale);
//
//        sale.setProduct(product);
//
//        entityManager.persist(product);
//
//        Product found = entityManager.find(Product.class, 1L);
//        entityManager.remove(found);
//
//        entityManager.getTransaction().commit();
    }
}
