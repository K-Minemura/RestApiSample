package jp.gr.java_conf.kmine27.spring.jiro.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Menu implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private long jiroId;

    @JsonIgnore
    private long id;

    private String name;

    private int price;
}
