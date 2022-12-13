/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import model.Covid;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Tinip
 */
@WebService(serviceName = "CovidWebService")
public class CovidWebService {
    @PersistenceContext(unitName = "CovidSoapServicePU")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction utx;
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "UpdateCovidWeek")
    public String UpdateCovidWeek() throws MalformedURLException, IOException {
        //TODO write your implementation code here:
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CovidSoapServicePU");
        EntityManager em = emf.createEntityManager();
        List<Covid> covidList = (List<Covid>) em.createNamedQuery("Covid.findAll").getResultList();
        em.close();
        Covid c = covidList.get(covidList.size()-1);
        return "ปีที่แถลง: "+c.getYears()+
                "\nสัปดาห์ที่แถลง: "+c.getWeeknum()+
                "\nจํานวนผู้ป่วยรายใหม่: "+c.getNewCase()+
                "\nจํานวนผู้ป่วยสะสม: "+c.getTotalCase()+
                "\nจํานวนผู้ป่วยรายใหม่ในประเทศไทย: "+c.getNewCaseExcludeabroad()+
                "\nจํานวนผู้ป่วยสะสมในประเทศไทย: "+c.getTotalCaseExcludeabroad()+
                "\nจํานวนผู้ป่วยตายรายใหม่: "+c.getNewDeath()+
                "\nจํานวนผู้ป่วยตายสะสม: "+c.getTotalDeath()+
                "\nจํานวนผู้ป่วยรักษาหายรายใหม่: "+c.getNewRecovered()+
                "\nจํานวนผู้ป่วยรักษาหายสะสม: "+c.getTotalRecovered()+
                "\nจํานวนผู้ป่วยที่มาจากต่างประเทศ: "+c.getCaseForeign()+
                "\nจํานวนผู้ป่วยที่อยู่ในเรือนจํา: "+c.getCasePrison()+
                "\nจํานวนผู้ป่วยที่เข้ามารับการตรวจ ณ จุดบริการ: "+c.getCaseWalkin()+
                "\nจํานวนผู้ป่วยวันก่อนหน้าของวันปัจจุบัน: "+c.getCaseNewPrev()+
                "\nจํานวนการเพิ่มขึ้น/ลดลง ของผู้ป่วย: "+c.getCaseNewDiff()+
                "\nจํานวนผู้เสียชีวิตวันก่อนหน้าของวันปัจจุบัน: "+c.getDeathNewPrev()+
                "\nจํานวนการเพิ่มขึ้น/ลดลง ของผู้เสียชีวิต: "+c.getDeathNewDiff()+
                "\nวันที่ปรับปรุง service ล่าสุด: "+c.getUpdateDate();
    }

    
    
    
}
