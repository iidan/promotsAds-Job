package net.ChangeWithMe.SpringBootWebApp.Repository;

import net.ChangeWithMe.SpringBootWebApp.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "SELECT \n" +
            "    p.*\n" +
            "FROM\n" +
            "    campaign c\n" +
            "        INNER JOIN\n" +
            "    product p ON c.id = p.campaign_id\n" +
            "        AND p.category= :category\n" +
            "        AND c.start_date >= (NOW() - INTERVAL 10 DAY)\n" +
            "WHERE\n" +
            "    c.id IN (SELECT \n" +
            "            id\n" +
            "        FROM\n" +
            "            campaign)\n" +
            "ORDER BY c.bid DESC\n" +
            "LIMIT 1;", nativeQuery = true)
    Product getProductWithHighestBidByCategory(@Param("category") String category);

    @Query(value = "SELECT \n" +
            "    p.*\n" +
            "FROM\n" +
            "    campaign c\n" +
            "        INNER JOIN\n" +
            "    product p ON c.id = p.campaign_id\n" +
            "WHERE\n" +
            "    c.bid IN (SELECT \n" +
            "            MAX(bid)\n" +
            "        FROM\n" +
            "            campaign\n" +
            "        WHERE\n" +
            "            start_date >= (NOW() - INTERVAL 10 DAY))\n" +
            "LIMIT 1;", nativeQuery = true)
    Product getPromotedProductWithHighestBid();
}
