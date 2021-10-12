package br.com.phinacio.controller;

import br.com.phinacio.model.TestRequest;
import br.com.phinacio.model.TestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

@RestController
public class SQSController {

    @Autowired
    private QueueMessagingTemplate queueMessagingTemplate;

    @Value("${cloud.aws.end-point.uri}")
    private String endPoint;

    @PostMapping("/postar")
    public void putMessagedToQueue(@RequestBody TestRequest testRequest) {

        this.queueMessagingTemplate.convertAndSend(endPoint, MessageBuilder.withPayload(testRequest)
                .setHeader("correlation-id", "5555-5555-8888")
                .build());
    }

    @SqsListener("poc-sqs-receiver-message")
    public void queueListener(TestResponse payload) {

        System.out.println("Nome: " + payload.getPaylod().getNome());
        System.out.println("Idade " + payload.getPaylod().getIdade());
        System.out.println("CorrelationId " + payload.getHeaders().getCorrelationId());

    }

}
