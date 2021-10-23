package net.ChangeWithMe.SpringBootWebApp.services.Impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.ChangeWithMe.SpringBootWebApp.Entity.Campaign;
import net.ChangeWithMe.SpringBootWebApp.Entity.Product;
import net.ChangeWithMe.SpringBootWebApp.Repository.CampaignRepository;
import net.ChangeWithMe.SpringBootWebApp.Repository.ProductRepository;
import net.ChangeWithMe.SpringBootWebApp.services.CampaignManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service("CampaignManagerImpl")
public class CampaignManagerImpl implements CampaignManager {

    @Autowired
    CampaignRepository campaignRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public Campaign createNewCampaign(Campaign campaign, String productsJson) {
        Type listType = new TypeToken<ArrayList<Product>>() {}.getType();
        List<Product> list = new Gson().fromJson(productsJson, listType);
        campaign.setProductList(list);
        campaignRepository.save(campaign);
        return campaign;
    }

    @Override
    public Product getPromotedProduct(String category) {
        Product product = productRepository.getProductWithHighestBidByCategory(category);
        if (product == null) {
            product = productRepository.getPromotedProductWithHighestBid();
        }
        return product;
    }
}
