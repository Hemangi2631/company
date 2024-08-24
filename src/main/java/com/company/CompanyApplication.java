package com.company;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryFactoryBean;
import org.springframework.data.jpa.datatables.repository.DataTablesRepositoryImpl;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@Log4j2
@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = DataTablesRepositoryImpl.class, repositoryFactoryBeanClass = DataTablesRepositoryFactoryBean.class)
public class CompanyApplication {

    public static void main(String[] args) {

        try {
            SpringApplication springApplication = new SpringApplication(CompanyApplication.class);
            springApplication.addListeners(new ApplicationPidFileWriter());
            springApplication.run(args);
        } catch (Exception exception) {
            log.error("Exception while starting Product view spring boot app. Error Message: {}", exception.getMessage(), exception);
        }
    }
}
