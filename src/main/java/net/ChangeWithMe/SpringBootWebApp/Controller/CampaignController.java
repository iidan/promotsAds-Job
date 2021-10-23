package net.ChangeWithMe.SpringBootWebApp.Controller;

import com.amazonaws.services.securityhub.model.Product;
import net.ChangeWithMe.SpringBootWebApp.Entity.Campaign;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {
    private Logger log = LogManager.getLogger(CampaignController.class.getName());


    @RequestMapping("/create-campaign")
    public Campaign createCampaign(Campaign campaign) {
        Campaign createdCampaign = null;
        try {
            //return new Campaign();
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
            //return product;
        } catch (Exception e) {
            log.error(String.format("Unable to get desired category : %, with error message %s"
                    , category
                    , e.getMessage()));
        }
        return product;
    }
}
