package net.ChangeWithMe.SpringBootWebApp.Repository;

import net.ChangeWithMe.SpringBootWebApp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
