package com.example.fidelyss;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

public class Global extends Application {
    private String BaseUrl ="http://192.168.1.16:80/";
    private static final Map<String, Integer> mileprice = new HashMap<String, Integer>() {{
        put("Abidjan",24000);
        put("Alger",5000);
        put("Amsterdam",11000);
        put("Bamako",20000);
        put("Barcelone",5000);
        put("Belgrade",8000);
        put("Benghazi",7000);
        put("Berlin",11000);
        put("Beyrouth",14000);
        put("Bologne",5000);
        put("Bordeaux",8000);
        put("Bruxelles",10000);
        put("Casablanca",10000);
        put("Conakry",10000);
        put("Constantine",21000);
        put("Cotonou",21000);
        put("Dakar",23000);
        put("Djerba",1000);
        put("Duesseldorf",10000);
        put("Enfidha",1000);
        put("Frankfurt",10000);
        put("Gabes",1000);
        put("Gafsa",10000);
        put("Genève",7000);
        put("Hamburg",12000);
        put("Istanbul",10000);
        put("Jeddah",20000);
        put("Le Caire",13000);
        put("Lille",10000);
        put("Lisbonne",11000);
        put("Londres",11000);
        put("Lyon",7000);
        put("Madrid",8000);
        put("Malte",2000);
        put("Marseille",5000);
        put("Médine",1000);
        put("Milan",6000);
        put("Monastir",1000);
        put("Montréal",42000);
        put("Moscou",18000);
        put("Munich",8000);
        put("Nantes",10000);
        put("Naples",3000);
        put("Niamey",17000);
        put("Nice",5000);
        put("Nouakchott",21000);
        put("Oran",6000);
        put("Ouagadougou",18000);
        put("Palerme",10000);
        put("Paris",10000);
        put("Prague",9000);
        put("Rome",5000);
        put("Sfax",1000);
        put("Strasbourg",8000);
        put("Tabarka",1000);
        put("Toulouse",7000);
        put("Tozeur",1000);
        put("Tripoli",5000);
        put("Tunis",0);
        put("Venise",6000);
        put("Vérone",8000);
        put("Vienne",8000);
        put("Zurich",7000);

    }};
    private static final Map<String, String> aka = new HashMap<String, String>() {{
        put("Abidjan","ABJ");
        put("Alger","ALG");
        put("Amsterdam","AMS");
        put("Bâle","BSL");
        put("Bamako","BKO");
        put("Barcelone","BCN");
        put("Belgrade","BEG");
        put("Benghazi","BEN");
        put("Berlin","SXF");
        put("Beyrouth","BEY");
        put("Bologne","BLQ");
        put("Bordeaux","BOD");
        put("Bruxelles","BRU");
        put("Casablanca","CMN");
        put("Conakry","CKY");
        put("Constantine","CZL");
        put("Cotonou","COO");
        put("Dakar","DSS");
        put("Djerba","DJE");
        put("Duesseldorf","DUS");
        put("Enfidha","NBE");
        put("Frankfurt","FRA");
        put("Gabes","GAB");
        put("Gafsa","GAF");
        put("Genève","GVA");
        put("Hamburg","HAM");
        put("Istanbul","IST");
        put("Jeddah","JED");
        put("Le Caire","CAI");
        put("Lille","LIL");
        put("Lisbonne","LIS");
        put("Londres","LON");
        put("Lyon","LYS");
        put("Madrid","MAD");
        put("Malte","MLA");
        put("Marseille","MRS");
        put("Médine","MED");
        put("Milan","MXP");
        put("Monastir","MIR");
        put("Montréal","YUL");
        put("Munich","MUC");
        put("Nantes","NTE");
        put("Naples","NAP");
        put("Niamey","NIM");
        put("Nice","NCE");
        put("Nouakchott","NKC");
        put("Oran","ORN");
        put("Ouagadougou","OUA");
        put("Palerme","PMO");
        put("Paris","PAR");
        put("Prague","PRG");
        put("Rome","FCO");
        put("Sfax","SFA");
        put("Strasbourg","SXB");
        put("Tabarka","TBJ");
        put("Toulouse","TLS");
        put("Tozeur","TOE");
        put("Tripoli","MJI");
        put("Tunis","TUN");
        put("Venise","VCE");
        put("Vérone","VRN");
        put("Vienne","VIE");
        put("Zurich","ZRH");
    }};


    public String getBaseUrl() {
        return BaseUrl;
    }

    public static Map<String, Integer> getMileprice() {
        return mileprice;
    }

    public static Map<String, String> getAka() {
        return aka;
    }
}
