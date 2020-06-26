package com.mateuszjanczak.koronawirus.webscraper;

import com.google.gson.*;
import com.mateuszjanczak.koronawirus.domain.model.Raport;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.HashMap;

public class KoronawirusWebscraper {

    public static ArrayList<Raport> Scrap(){
        Document document;
        try {
            document = Jsoup.connect("https://www.gov.pl/web/koronawirus/wykaz-zarazen-koronawirusem-sars-cov-2").get();
            String raw = document.select("#registerData").text();

            JsonElement jsonElement = new JsonParser().parse(raw);
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            String json = jsonObject.get("parsedData").getAsString();
            JsonArray lista = new Gson().fromJson(json, JsonArray.class);
            ArrayList<Raport> raporty = new ArrayList<>();

           for(int i = 0; i < lista.size(); i++){
               JsonObject tmp = lista.get(i).getAsJsonObject();
               Raport Raport = new Raport();
               Raport.setId(i);
               Raport.setWojewodztwo(tmp.get("Województwo").getAsString());
               int zarazeni = tmp.get("Liczba").getAsString().isEmpty() ? 0 : Integer.parseInt(tmp.get("Liczba").getAsString().replaceAll("\\s",""));
               int martwi = tmp.get("Liczba zgonów").getAsString().isEmpty() ? 0 : Integer.parseInt(tmp.get("Liczba zgonów").getAsString().replaceAll("\\s",""));
               Raport.setZarazeni(zarazeni);
               Raport.setMartwi(martwi);
               raporty.add(Raport);
           }

            return raporty;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
