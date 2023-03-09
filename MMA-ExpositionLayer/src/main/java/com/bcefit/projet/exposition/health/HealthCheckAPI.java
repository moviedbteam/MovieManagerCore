package com.bcefit.projet.exposition.health;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/health-check")
public class HealthCheckAPI {

    Logger logger = LoggerFactory.getLogger(HealthCheckAPI.class);

        @GetMapping("")
        public ResponseEntity<String> getHealth(){
            logger.debug("Contrôle HealthCheck");
            String controle = "All is good!";
            return ResponseEntity.status(HttpStatus.OK).body(controle);

        }
    }


