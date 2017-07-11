package jp.gr.java_conf.kmine27.spring.jiro.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jp.gr.java_conf.kmine27.spring.jiro.domain.Jiro;
import jp.gr.java_conf.kmine27.spring.jiro.service.SearchService;

@RestController
@RequestMapping("search")
public class SearchController {

    @Autowired
    private SearchService service;

    @RequestMapping("all")
    public List<Jiro> all() {
        return service.searchAll();
    }

    @RequestMapping("sort")
    public List<Jiro> sort(@RequestParam("lat") BigDecimal lat, @RequestParam("lon") BigDecimal lon) {
        return service.searchNearly(lat, lon);
    }
}
