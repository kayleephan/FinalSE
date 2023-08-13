package com.example.finalexam;

import com.example.finalexam.entities.Salesman;
import com.example.finalexam.respositories.SalesmanRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class FinalExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalExamApplication.class, args);
    }

}

//    @Bean
//    CommandLineRunner commandLineRunner(SalesmanRepository salesmanRepository){
//
//        return args -> {
//            salesmanRepository.save(new Salesman(null, 14.8, new Date(), "Washing Machine", "Josh"));
//            salesmanRepository.save(new Salesman(null, 26.0, new Date(), "Refrigerator", "Kaylee"));
//            salesmanRepository.save(new Salesman(null, 44.0, new Date(), "Music System", "May"));
//            salesmanRepository.save(new Salesman(null, 66.0, new Date(), "Washing Machine", "Tom"));
//            salesmanRepository.findAll().forEach(p->{
//                System.out.println(p.getName());
//            });
//        };
//    }
