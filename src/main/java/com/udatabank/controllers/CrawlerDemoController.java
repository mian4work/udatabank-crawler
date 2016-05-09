package com.udatabank.controllers;

import com.udatabank.crawler.UdatabankCrawlerController;
import com.udatabank.database.MemoryDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.*;

/**
 * Created by miazhang on 4/21/16.
 */

@Controller
public class CrawlerDemoController {

    @Autowired
    UdatabankCrawlerController controller;

    @RequestMapping(value = "/start", method = RequestMethod.GET)
    public String start() throws Exception {

        controller.start();

        return "start";
    }

    @RequestMapping(value = "/links", method = RequestMethod.GET)
    public String getLinks() {

        return "links";
    }


}
