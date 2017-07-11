package jp.gr.java_conf.kmine27.spring.jiro.service;

import java.math.BigDecimal;
import java.util.List;

import jp.gr.java_conf.kmine27.spring.jiro.domain.Jiro;

public interface SearchService {

    List<Jiro> searchAll();

    List<Jiro> searchNearly(BigDecimal lat, BigDecimal lon);

}
