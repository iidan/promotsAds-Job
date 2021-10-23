package net.ChangeWithMe.SpringBootWebApp.Controller;

import net.ChangeWithMe.SpringBootWebApp.Entity.*;
import net.ChangeWithMe.SpringBootWebApp.services.CampaignManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {
    private Logger log = LogManager.getLogger(CampaignController.class.getName());

    @Autowired
    CampaignManager campaignManager;

    @RequestMapping("/create-campaign")
    public Campaign createCampaign(Campaign campaign, String productsJson) {
        Campaign createdCampaign = null;
        try {
            createdCampaign = campaignManager.createNewCampaign(campaign, productsJson);
        } catch (Exception e) {
            log.error(String.format("Unable to create new campaign for campaign name : %, with error message %s"
                    , campaign.getName()
                    , e.getMessage()));
        }
        return createdCampaign;
    }

    @RequestMapping("/serve-ad")
    public Product serveAd(String category) {
        Product product = null;
        try {
            product = campaignManager.getPromotedProduct(category);
        } catch (Exception e) {
            log.error(String.format("Unable to get desired category : %, with error message %s"
                    , category
                    , e.getMessage()));
        }
        return product;
    }
}
