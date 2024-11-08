package com.scaler.nivedita.productservice.jobs;

import com.scaler.nivedita.productservice.model.Product;
import com.scaler.nivedita.productservice.repository.ProductRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ScheduleJobTask {
    private ProductRepository productRepository;

    public ScheduleJobTask(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    //sec, min, hour,dayofMonth,Month,WeekDay
    // * anything
    @Scheduled(cron = "0 * * * * *") // every minute
    public void executeJob() {
        Optional<Product> product = productRepository.findById(1);
        if (product.isPresent()) {
            System.out.println("Fetched Product with Id:" + product.get().getId());
        }
    }
}