package com.liziczh.ddd.mesh.app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@SpringBootApplication
public class DddMeshAppApplication {

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();

        SpringApplication.run(DddMeshAppApplication.class, args);

        long cost = System.currentTimeMillis() - startTime;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        log.info("########### Application is Started! now={}, cost={} ##########", format.format(new Date()), cost);

    }

}
