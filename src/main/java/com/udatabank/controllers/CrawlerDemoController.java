package com.udatabank.controllers;

import com.udatabank.crawler.UdatabankCrawlerController;
import com.udatabank.database.MemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by miazhang on 4/21/16.
 */

@Controller
public class CrawlerDemoController {

    @Autowired
    UdatabankCrawlerController controller;

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String getLinks(ModelMap model) throws Exception {

        controller.start();
        model.addAttribute("links", MemoryDatabase.getLinks());
        return "links";
    }
}
