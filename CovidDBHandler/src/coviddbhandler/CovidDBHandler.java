/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coviddbhandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Covid;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Tinip
 */
public class CovidDBHandler {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, MalformedURLException, ParseException {
        // TODO code application logic here
        int id = 1;
        URL api = new URL("https://covid19.ddc.moph.go.th/api/Cases/today-cases-all");
        Covid c = insertCovidData(api);
        while(findCovidById(id)!=null){
            id++;
        }
        c.setId(id);
        persist(c);
    }
    
    public static String stream(URL url) throws IOException {
    try (InputStream input = url.openStream()) {
        InputStreamReader isr = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(isr);
        StringBuilder json = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            json.append((char) c);
        }
        return json.toString();
        }
    }
    
     public static Covid findCovidById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CovidDBHandlerPU");
        EntityManager em = emf.createEntityManager();
        Covid covid = em.find(Covid.class, id);
        em.close();
        return covid;
    }
     
    public static Covid insertCovidData(URL url) throws MalformedURLException, IOException, ParseException{
        String json = stream(url);
        //System.out.println(json);
        JSONArray array = new JSONArray(json);
        JSONObject object = array.getJSONObject(0);
        int years = object.getInt("year");
        int weeknum = object.getInt("weeknum");
        int newcase = object.getInt("new_case");
        int totalcase = object.getInt("total_case");
        int newcaseexcludeabroad = object.getInt("new_case_excludeabroad");
        int totalcaseexcludeabroad = object.getInt("total_case_excludeabroad");
        int newrecovered = object.getInt("new_recovered");
        int totalrecovered = object.getInt("total_recovered");
        int newdeath = object.getInt("new_death");
        int totaldeath = object.getInt("total_death");
        int caseforeign = object.getInt("case_foreign");
        int caseprison = object.getInt("case_prison");
        int casewalkin = object.getInt("case_walkin");
        int casenewprev = object.getInt("case_new_prev");
        int casenewdiff = object.getInt("case_new_diff");
        int deathnewprev = object.getInt("death_new_prev");
        int deathnewdiff = object.getInt("death_new_diff");
        String updatedateString = object.getString("update_date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date updatedate = sdf.parse(updatedateString);
        
        Covid c = new Covid();
        //c.setId(1);
        c.setYears(years);
        c.setWeeknum(weeknum);
        c.setNewCase(newcase);
        c.setTotalCase(totalcase);
        c.setNewCaseExcludeabroad(newcaseexcludeabroad);
        c.setTotalCaseExcludeabroad(totalcaseexcludeabroad);
        c.setNewRecovered(newrecovered);
        c.setTotalRecovered(totalrecovered);
        c.setNewDeath(newdeath);
        c.setTotalDeath(totaldeath);
        c.setCaseForeign(caseforeign);
        c.setCasePrison(caseprison);
        c.setCaseWalkin(casewalkin);
        c.setCaseNewPrev(casenewprev);
        c.setCaseNewDiff(casenewdiff);
        c.setDeathNewPrev(deathnewprev);
        c.setDeathNewDiff(deathnewdiff);
        c.setUpdateDate(updatedate);
        
        return c;
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CovidDBHandlerPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
    
}
