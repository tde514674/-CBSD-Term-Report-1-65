/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covidsoapclient;

import service.IOException_Exception;
import service.MalformedURLException_Exception;

/**
 *
 * @author Tinip
 */
public class CovidSoapClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException_Exception, MalformedURLException_Exception {
        // TODO code application logic here
        System.out.println("UPDATE COVID DATA LAST WEEK");
        System.out.println(updateCovidWeek());
        System.out.println("----------------------------------------------");
        
        int id =1;
        System.out.println("FIND BY ID");
        System.out.println("ID = "+id);
        System.out.println(findCovidWeekDataById(id));
    }

    private static String updateCovidWeek() throws IOException_Exception, MalformedURLException_Exception {
        service.CovidWebService_Service service = new service.CovidWebService_Service();
        service.CovidWebService port = service.getCovidWebServicePort();
        return port.updateCovidWeek();
    }

    private static String findCovidWeekDataById(int id) {
        service.CovidWebService_Service service = new service.CovidWebService_Service();
        service.CovidWebService port = service.getCovidWebServicePort();
        return port.findCovidWeekDataById(id);
    }
    
    

    
    
}
