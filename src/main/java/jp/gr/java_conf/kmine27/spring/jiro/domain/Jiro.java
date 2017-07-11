package jp.gr.java_conf.kmine27.spring.jiro.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
public class Jiro implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @JsonIgnore
    private long id;

    private String name;

    private String address;

    @JsonIgnore
    private BigDecimal latitude;

    @JsonIgnore
    private BigDecimal longitude;

    private List<Menu> menus;
}
