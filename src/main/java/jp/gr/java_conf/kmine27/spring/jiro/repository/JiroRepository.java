package jp.gr.java_conf.kmine27.spring.jiro.repository;

import java.util.List;

import jp.gr.java_conf.kmine27.spring.jiro.domain.Jiro;

public interface JiroRepository {

    List<Jiro> findAll();
}
