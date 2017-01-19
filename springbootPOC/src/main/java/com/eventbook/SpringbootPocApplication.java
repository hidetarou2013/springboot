package com.eventbook;

import com.datastax.driver.core.utils.UUIDs;
import com.eventbook.bean.Publisher;
import com.eventbook.bean.Viewer;
import com.eventbook.repository.PublisherRepository;
import com.eventbook.repository.ViewerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class SpringbootPocApplication implements CommandLineRunner {

    @Autowired
    private PublisherRepository publisherRepository;
            
    @Autowired
    private ViewerRepository viewerRepository;

    @Override
    public void run(String... args) throws Exception {
        this.publisherRepository.deleteAll();
        saveViewers();
        fetchAllViewers();        
        savePublishers();
        fetchAllPublishers();
        fetchIndividualPublishers();
    }

    private void savePublishers() {
        this.publisherRepository.save(new Publisher("1", "Publisher1"));
        this.publisherRepository.save(new Publisher("2", "Publisher2"));
    }
    
    private void saveViewers() {
        this.viewerRepository.save(new Viewer(UUIDs.timeBased(), "Viewer1"));
        this.viewerRepository.save(new Viewer(UUIDs.timeBased(), "Viewer2"));
    }
    
    private void fetchAllViewers() {
        System.out.println("Viewers found with findAll():");
        System.out.println("-------------------------------");
        for (Viewer viewers : this.viewerRepository.findAll()) {
            System.out.println(viewers);
        }
        System.out.println();
    }

    private void fetchAllPublishers() {
        System.out.println("Publishers found with findAll():");
        System.out.println("-------------------------------");
        for (Publisher publisher : this.publisherRepository.findAll()) {
            System.out.println(publisher);
        }
        System.out.println();
    }

    private void fetchIndividualPublishers() {
        System.out.println("Publisher found with findById('1'):");
        System.out.println("--------------------------------");
        System.out.println(this.publisherRepository.findById("1"));

        System.out.println("Publisher found with findByUsername('Publisher1'):");
        System.out.println("--------------------------------");
        System.out.println(this.publisherRepository.findByUsername("Publisher1"));
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(SpringbootPocApplication.class);
        springApplication.addListeners(new ApplicationPidFileWriter());
        springApplication.run(args);
    }
}
