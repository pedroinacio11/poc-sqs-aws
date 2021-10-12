package br.com.phinacio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestResponse {

    @JsonProperty("payload")
    private Payload paylod;

    @JsonProperty("headers")
    private Headers headers;

}
