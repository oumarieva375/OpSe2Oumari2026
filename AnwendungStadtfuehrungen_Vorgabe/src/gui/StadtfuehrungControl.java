package gui;

import java.io.IOException;
import business.Stadtfuehrung;
import business.StadtfuehrungModel;
import javafx.stage.Stage;

public class StadtfuehrungControl {
	private StadtfuehrungView view;
	private StadtfuehrungModel model;
	
	public StadtfuehrungControl(Stage primaryStage) {
	
		this.model = new StadtfuehrungModel();
		this.view =  new StadtfuehrungView(this, this.model, primaryStage);
	}
	
	public void nehmeStadtfuehrungAuf(String titel, String identnummer, String kurzbeschreibung, String startuhrzeit, String daten){
    	try{ 
    		Stadtfuehrung s = new Stadtfuehrung(
    			titel, 
   	        Integer.parseInt(identnummer),
   	        kurzbeschreibung,
   	        Float.parseFloat(startuhrzeit),
    		    daten.split(";"));
    		model.setStadtfuehrung(s);
    		view.zeigeInformationsfensterAn("Die Stadtfuehrung wurde aufgenommen!");
       	}
       	catch(Exception exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getMessage());
     	}
    }
   
        	  
    public void leseAusDatei(String typ){
    	try {
      	if("csv".equals(typ)){
      		model.leseAusDatei();
      	  		view.zeigeInformationsfensterAn(
      	  	   		"Das Stadtfuehrung wurde gelesen!");
      		}
       		else{
	   			view.zeigeInformationsfensterAn(
	   				"Noch nicht implementiert!");
	   		}
		}
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Lesen!");
		}
	}
		
	public void schreibeStadtfuehrungenInCsvDatei() {
		try {
			model.leseAusDatei();
   			view.zeigeInformationsfensterAn(
	   			"Die Stadtfuehrungen wurden gespeichert!");
		}	
		catch(IOException exc){
			view.zeigeFehlermeldungsfensterAn(
				"IOException beim Speichern!");
		}
		catch(Exception exc){
			view.zeigeFehlermeldungsfensterAn(
				"Unbekannter Fehler beim Speichern!");
		}
	}

}
