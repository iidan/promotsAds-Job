package net.ChangeWithMe.SpringBootWebApp.Repository;

import net.ChangeWithMe.SpringBootWebApp.Entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampaignRepository extends JpaRepository<Campaign, Long>  {

}
