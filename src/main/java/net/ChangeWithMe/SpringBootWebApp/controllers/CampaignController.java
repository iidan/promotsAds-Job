package net.ChangeWithMe.SpringBootWebApp.controllers;

import com.amazonaws.services.securityhub.model.Product;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CampaignController {

    @RequestMapping("/serve-ad")
    public Product serveAd(String category) {
        return new Product();
    }
}
