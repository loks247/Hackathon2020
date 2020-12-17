package com.cms.secretsantabot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

//@EnableMongoRepositories(basePackageClasses = com.cms.secretsantabot.controller.BotController.class)
@SpringBootApplication
@EnableMongoRepositories("com.cms.secretsantabot.repository")
//@ComponentScan("com.cms.secretsantabot.controller")
public class SecretSantaBotApplication {

   /* @Autowired
    private EmployeeRepository repository;*/

    public static void main(String[] args) {
        SpringApplication.run(SecretSantaBotApplication.class, args);
    }

    /*@Override
    public void run(String... args) throws Exception {
       repository.deleteAll();

        // save a couple of customers
        repository.save(new Employee("100", "Alice", "alias@appdirect.com"));
        repository.save(new Employee("101", "Bob", "Bob@appdirect.com"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Employee employee : repository.findAll()) {
            System.out.println(employee);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByName("Alice"));
    }*/
}
