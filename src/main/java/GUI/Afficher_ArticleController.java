/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entites.Article;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
 import java.net.URI;
import java.sql.SQLException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import service.Articlegestion;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class Afficher_ArticleController implements Initializable {
    @FXML
    private Text tiitre_article;
    @FXML
    private TextArea desc_artcile;
    @FXML
    private Label lire;
    
    @FXML
    private ImageView image_article;
    
   Article A=new Article();
   
    private Desktop desktop = Desktop.getDesktop();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        A=AcceuilController.A1;
        int id=(A.getId());
        Articlegestion a1=new Articlegestion();
   

        image_article.setImage(AcceuilController.m);
          String url2;
        try {
            url2 = a1.get_image1(id);
              Image image1=new Image(url2);
              image_article.setImage(new Image(url2));
        } catch (SQLException ex) {
            Logger.getLogger(Afficher_ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Afficher_ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
      
        
        System.out.println(A);
        tiitre_article.setText(A.getNom_article());
        desc_artcile.setText(A.getDescriptionarticle());
    }
    @FXML
    private void retour_accuiel(ActionEvent event) {
          Parent root = null;
        try {
             root = FXMLLoader.load(getClass().getResource("/fxml/acceuil.fxml"));
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilController.class.getName()).log(Level.SEVERE, null, ex);
                }
        
        Scene scene = new Scene(root);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.hide();
                stage.setScene(scene);
                stage.show(); 
    }

    @FXML
    private void lirelasuite(MouseEvent event) {
        A=AcceuilController.A1;
        String s1 =(A.getSources());
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.browse(URI.create(s1));
            } catch (IOException ex) {
            Logger.getLogger(Afficher_ArticleController.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    }
    
    

  

  

