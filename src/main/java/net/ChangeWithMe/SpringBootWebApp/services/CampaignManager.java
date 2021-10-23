package net.ChangeWithMe.SpringBootWebApp.services;

import net.ChangeWithMe.SpringBootWebApp.Entity.Campaign;
import net.ChangeWithMe.SpringBootWebApp.Entity.Product;
import org.springframework.stereotype.Service;

@Service
public interface CampaignManager {

    Campaign createNewCampaign(Campaign campaign, String productsJson);

    Product getPromotedProduct(String category);
}
