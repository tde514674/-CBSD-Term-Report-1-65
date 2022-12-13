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
        System.out.println(updateCovidWeek());
    }

    private static String updateCovidWeek() throws IOException_Exception, MalformedURLException_Exception {
        service.CovidWebService_Service service = new service.CovidWebService_Service();
        service.CovidWebService port = service.getCovidWebServicePort();
        return port.updateCovidWeek();
    }

    
    
}
