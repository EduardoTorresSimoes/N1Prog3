package com.example.n1_prog3_javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainViewController {
    @FXML
    private Button BtnCadLivro;

    @FXML
    private Button BtnCadAutor;

    @FXML
    private Button BtnCadGenero;

    @FXML
    protected void BtnCadLivro_Action(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Livros");
            stage.setScene(new Scene(rootOne));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    protected void BtnCadGenero_Action(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("genero-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Genero");
            stage.setScene(new Scene(rootOne));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    protected void BtnCadAutor_Action(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("autor-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Autor");
            stage.setScene(new Scene(rootOne));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    @FXML
    protected void BtnCadCopias_Action(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("copia-view.fxml"));
            Parent rootOne = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Copias");
            stage.setScene(new Scene(rootOne));
            stage.show();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
