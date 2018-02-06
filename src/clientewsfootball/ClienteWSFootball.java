/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientewsfootball;

import java.util.List;

/**
 *
 * @author entrar
 */
public class ClienteWSFootball {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        System.out.println("Yellow cards: " + yellowCardsTotal());
        System.out.println("Los defensas del España introducido son: " + allDefenders("Spain").getString());
        
        List<TCountryInfo> tcountryinfo=countryNames(true).getTCountryInfo();
        for (TCountryInfo tcountryinfo1 : tcountryinfo) {
            System.out.println(tcountryinfo1.getSName());
            String country=tcountryinfo1.getSName();
            System.out.println(allDefenders(country).getString());
        }
        
    }

    private static int yellowCardsTotal() {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.yellowCardsTotal();
    }

    private static ArrayOfString allDefenders(java.lang.String sCountryName) {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.allDefenders(sCountryName);
    }

    private static ArrayOftCountryInfo countryNames(boolean bWithCompetitors) {
        clientewsfootball.Info service = new clientewsfootball.Info();
        clientewsfootball.InfoSoapType port = service.getInfoSoap();
        return port.countryNames(bWithCompetitors);
    }
}
