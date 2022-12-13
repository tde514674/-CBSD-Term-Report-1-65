/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myservice;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import model.Covid;
import model.CovidTable;

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
        List<Covid> covidList = CovidTable.findAllCovid();
        String covidData = CovidTable.printCovidData(covidList.get(covidList.size()-1));
        return covidData;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "FindCovidWeekDataById")
    public String FindCovidWeekDataById(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
        Covid c = CovidTable.findCovidById(id);
        String covidData = CovidTable.printCovidData(c);
        return covidData;
    }
    
    
    
    

    
    
    
}
