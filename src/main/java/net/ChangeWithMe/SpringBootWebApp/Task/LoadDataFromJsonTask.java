package net.ChangeWithMe.SpringBootWebApp.Task;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.ChangeWithMe.SpringBootWebApp.Entity.Product;
import net.ChangeWithMe.SpringBootWebApp.Repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

@Component
public class LoadDataFromJsonTask {
    private Logger log = LogManager.getLogger(LoadDataFromJsonTask.class.getName());

    @Autowired
    ProductRepository productRepository;

    @PostConstruct
    public void init() throws IOException {
        try {

            // load json file from disk.
            String file = "src/main/Files/JsonProductsFile.txt";
            String json = new String(Files.readAllBytes(Paths.get(file)));
            Type listType = new TypeToken<ArrayList<Product>>() {}.getType();
            productRepository.saveAll(new Gson().fromJson(json, listType));

        } catch (Exception e) {
            log.error("Unable to load new Products from json file", e);
        }
    }
}
