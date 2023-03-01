package com.bcefit.projet.exposition.health;

import com.bcefit.projet.domain.user.GenreTv;
import com.bcefit.projet.exposition.user.dto.GenreTvDto;
import com.bcefit.projet.exposition.user.mapper.GenreTvMapper;
import com.bcefit.projet.exposition.user.rest.GenreTvAPI;
import com.bcefit.projet.service.user.IGenreTvService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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


