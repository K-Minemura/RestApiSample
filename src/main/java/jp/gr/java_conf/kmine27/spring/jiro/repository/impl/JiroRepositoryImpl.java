package jp.gr.java_conf.kmine27.spring.jiro.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.gr.java_conf.kmine27.spring.jiro.domain.Jiro;
import jp.gr.java_conf.kmine27.spring.jiro.mapper.JiroMapper;
import jp.gr.java_conf.kmine27.spring.jiro.repository.JiroRepository;

@Repository
public class JiroRepositoryImpl implements JiroRepository {

    @Autowired
    private JiroMapper jiroMapper;

    @Override
    public List<Jiro> findAll() {
        return jiroMapper.findAll();
    }
}
