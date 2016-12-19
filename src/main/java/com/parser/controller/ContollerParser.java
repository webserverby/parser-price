package com.parser.controller;

import com.parser.parsing.ParsingSelenium;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ContollerParser {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage() {
        return "index";
    }

    @RequestMapping(value ="/parser", method = RequestMethod.GET)
    @ResponseBody
    public String parser()  {
      ParsingSelenium parsingSelenium = new ParsingSelenium();
      String parser = parsingSelenium.parsing();
      return parser;
    }

}
