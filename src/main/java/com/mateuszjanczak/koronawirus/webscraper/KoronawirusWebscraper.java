package com.mateuszjanczak.koronawirus.webscraper;

import com.google.gson.*;
import com.mateuszjanczak.koronawirus.model.Report;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class KoronawirusWebscraper {

    private final String URL = "https://www.gov.pl/web/koronawirus/wykaz-zarazen-koronawirusem-sars-cov-2";

    public List<Report> loadList() {
        try {
            String json = this.scrapData();
            List<Report> list = this.convertFromJsonToObject(json);
            setIndexes(list);
            setCountryName(list);
            return list;
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }

    private String scrapData() throws IOException {
        Document document = Jsoup.connect(this.URL).get(); // Download document
        Element element = document.selectFirst("#registerData"); // Find element in DOM
        String rawJson = element.text(); // Take data from element
        JsonObject jsonObject = JsonParser.parseString(rawJson).getAsJsonObject(); // Parse raw JSON to JSON Object
        return jsonObject.get("parsedData").getAsString().replaceAll("\\s",""); // Get data, parse to string and remove all spaces
    }

    private List<Report> convertFromJsonToObject(String json) {
        Gson gson = new Gson();
        return Arrays.asList(gson.fromJson(json, Report[].class));
    }

    private void setIndexes(List<Report> list) {
        IntStream.range(0, list.size()).forEach(i -> list.get(i).setId(i));
    }

    private void setCountryName(List<Report> list) {
        String name = "Polska";
        list.get(0).setWojewodztwo(name);
    }

}
