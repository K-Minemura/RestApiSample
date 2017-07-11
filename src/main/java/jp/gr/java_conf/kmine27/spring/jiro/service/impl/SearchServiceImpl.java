package jp.gr.java_conf.kmine27.spring.jiro.service.impl;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.gr.java_conf.kmine27.spring.jiro.domain.Jiro;
import jp.gr.java_conf.kmine27.spring.jiro.repository.JiroRepository;
import jp.gr.java_conf.kmine27.spring.jiro.service.SearchService;
import lombok.AllArgsConstructor;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private JiroRepository jiroRepository;

    @Transactional(readOnly = true)
    @Override
    public List<Jiro> searchAll() {
        return jiroRepository.findAll();
//        return JIRO_LIST;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Jiro> searchNearly(BigDecimal lat, BigDecimal lon) {
        List<Jiro> list = jiroRepository.findAll();
        Collections.sort(list, new JiroComparator(lat, lon));
        return list;
    }


    @AllArgsConstructor
    public static class JiroComparator implements Comparator<Jiro> {

        private final BigDecimal lat;
        private final BigDecimal lon;
        @Override
        public int compare(Jiro o1, Jiro o2) {
            double o1Range = computeRange(o1);
            double o2Range = computeRange(o2);
            if (o1Range < o2Range) {
                return -1;
            } else if (o1Range == o2Range) {
                return 0;
            } else {
                return 1;
            }
        }

        private double computeRange(Jiro jiro) {
            BigDecimal v = jiro.getLatitude().abs().subtract(lat.abs()).abs();
            BigDecimal h = jiro.getLongitude().abs().subtract(lon.abs()).abs();
            return Math.sqrt(v.pow(2).add(h.pow(2)).doubleValue());
        }
    }
}
