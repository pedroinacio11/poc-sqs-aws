package br.com.phinacio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Headers {

    @JsonProperty("correlation-id")
    private String correlationId;

    @JsonProperty("id")
    private String id;

    @JsonProperty("timestamp")
    private Timestamp timestamp;



}
