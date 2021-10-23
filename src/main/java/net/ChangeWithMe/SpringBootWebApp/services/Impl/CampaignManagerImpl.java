package net.ChangeWithMe.SpringBootWebApp.services.Impl;

import net.ChangeWithMe.SpringBootWebApp.Entity.Campaign;
import net.ChangeWithMe.SpringBootWebApp.Entity.Product;
import net.ChangeWithMe.SpringBootWebApp.Repository.CampaignRepository;
import net.ChangeWithMe.SpringBootWebApp.Repository.ProductRepository;
import net.ChangeWithMe.SpringBootWebApp.services.CampaignManager;
import org.springframework.beans.factory.annotation.Autowired;

public class CampaignManagerImpl implements CampaignManager {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Campaign createNewCampaign(Campaign campaign, String productsJson) {
        return null;
    }

    @Override
    public Product getPromotedProduct(String category) {
        return null;
    }
}
