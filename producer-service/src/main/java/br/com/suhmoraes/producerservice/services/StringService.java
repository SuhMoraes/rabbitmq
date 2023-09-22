package br.com.suhmoraes.producerservice.services;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import static br.com.suhmoraes.producerservice.configs.RabbitMQConfig.EXCG_NAME_MARLKETPLACE;
import static br.com.suhmoraes.producerservice.configs.RabbitMQConfig.RK_PRODUCT_LOG;

@Service
@Log4j2
public class StringService {

    private final RabbitTemplate rabbitTemplate;

    public StringService(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void produce(String message){
        log.info("Receive message ::: " + message);
        rabbitTemplate.convertAndSend(EXCG_NAME_MARLKETPLACE, RK_PRODUCT_LOG, message);
    }
}
