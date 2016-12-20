package com.parser.parsing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.LogFactory;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class ParsingSelenium {

    public String parsing() {

        LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

        HtmlUnitDriver driver = new HtmlUnitDriver(true);
        driver.get("http://www.msenergyservices.com");
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);

        String htmlContent = driver.getPageSource();
        driver.close();

        Document document = Jsoup.parse(htmlContent);
        String elementRig =  document.select( "#newsticker-block > div > table > tbody > tr > td:nth-child(1)" ).text();
        String[] arrRig = elementRig.trim().split("\\s+");

        String elementOil =  document.select( "tr[valign=bottom]" ).text();
        String[] arrOil = elementOil.trim().split("\\s+");

        String elementPF = document.select(".custom.topcontact").text();
        String[] arrPF = elementPF.trim().split("\\s+");

        LinkedHashMap<String, String> data = new LinkedHashMap<String, String>();
        data.put( arrRig[0] + " " + arrRig[1] + " " + arrRig[2], arrOil[3] );
        data.put( arrOil[0] + " " + arrOil[1] + " " + arrOil[2], arrOil[3] + " " + arrOil[4] );
        data.put( arrOil[5] + " " + arrOil[6] + " " + arrOil[7], arrOil[8] + " " + arrOil[9] );
        data.put( arrOil[10] + " " + arrOil[11], arrOil[12] + " " + arrOil[13] );
        data.put( arrPF[0], arrPF[1] );
        data.put( arrPF[3], arrPF[4] );

        ObjectMapper mapper = new ObjectMapper();
        String   jsonFromMap = null;
        try {
            jsonFromMap = mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(arrOil));
        System.out.println(Arrays.toString(arrPF));
        System.out.println(jsonFromMap);

        return jsonFromMap;
    }


}
