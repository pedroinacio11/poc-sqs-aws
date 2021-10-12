package br.com.phinacio.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TestRequest {

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("idade")
    private Integer idade;

}
