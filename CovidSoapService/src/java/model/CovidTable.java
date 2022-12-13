/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Tinip
 */
public class CovidTable {
    public static String  printCovidData(Covid c) {
        String data ="ปีที่แถลง: "+c.getYears()+
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
        return data; 
    }
    
    public static Covid findCovidById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CovidSoapServicePU");
        EntityManager em = emf.createEntityManager();
        Covid covid = em.find(Covid.class, id);
        em.close();
        return covid;
    }
    
    public static List<Covid> findAllCovid() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CovidSoapServicePU");
        EntityManager em = emf.createEntityManager();
        List<Covid> covidList = (List<Covid>) em.createNamedQuery("Covid.findAll").getResultList();
        em.close();
        return covidList;
    }
}
