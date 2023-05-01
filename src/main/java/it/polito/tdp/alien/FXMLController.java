package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
    private Model model;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TxtParole;

    @FXML
    private Button buttonClear;

    @FXML
    private Button buttonTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    void doClear(ActionEvent event) {
    	txtRisultato.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String input = TxtParole.getText().toLowerCase();
    	if(input==null)
    		return;
       String array[];
       array= input.split(" ");
       if(model.controllo(array[0])==false) {
    	   txtRisultato.setText("Inserisci solo lettere");
    	   return;
       }
       if(array.length==2 ) {
    	   if(model.controllo(array[1])==false) {
        	   txtRisultato.setText("Inserisci solo lettere");
        	   return;
           }
    	model.addString(array);   
       }else {
    	  String ris= model.traduzione(array[0]);
    	  if(ris!=null)
    	   txtRisultato.setText(ris);
    	  else
    		  txtRisultato.setText("Traduzione inesistente");
       }
       
       TxtParole.clear();
    }
    
public void setModel( Model model) {
	this.model=model;
}
    @FXML
    void initialize() {
        assert TxtParole != null : "fx:id=\"TxtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonClear != null : "fx:id=\"buttonClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert buttonTranslate != null : "fx:id=\"buttonTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";

    }

}
