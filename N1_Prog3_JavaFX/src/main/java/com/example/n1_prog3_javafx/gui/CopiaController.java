package com.example.n1_prog3_javafx.gui;

import com.example.n1_prog3_javafx.dao.CopiaDao;
import com.example.n1_prog3_javafx.dao.LivrosDao;
import com.example.n1_prog3_javafx.model.Autor;
import com.example.n1_prog3_javafx.model.Copia;
import com.example.n1_prog3_javafx.model.Genero;
import com.example.n1_prog3_javafx.model.Livros;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

public class CopiaController {

    CopiaDao copiaDao = new CopiaDao();
    LivrosDao livrosDao = new LivrosDao();

    @FXML
    private ListView<Copia> LstCopias;

    @FXML
    private Button BtnAdicionar;

    @FXML
    private Button BtnDeletar;

    @FXML
    private Button BtnGravar;

    //--//

    @FXML
    private TextField TxtCodigo;

    @FXML
    private ComboBox<Livros> CboLivros;

    //--//

    private void limparTela() {
        TxtCodigo.setText("");
        CboLivros.setValue(null);
    }

    //--//
    private void limparInterface(){
        TxtCodigo.setText("");
        CboLivros.setValue(null);
    }

    private void habilitarInterface(Boolean incluir){
        TxtCodigo.setDisable(!incluir);
        CboLivros.setDisable(!incluir);
        BtnGravar.setDisable(!incluir);
        BtnDeletar.setDisable(incluir);
        BtnAdicionar.setDisable(incluir);
        LstCopias.setDisable(incluir);
    }

    private void exibirAutores(){
        Copia copiass = LstCopias.getSelectionModel().getSelectedItem();
        TxtCodigo.setText(copiass.getCodigo().toString());
        CboLivros.setValue(copiass.getlOriginal());
    }

    @FXML
    private void LstAutores_MouseClicked(MouseEvent evento){
        exibirAutores();
    }

    @FXML
    private void LstAutores_KeyPressed(KeyEvent evento){
        exibirAutores();
    }

    @FXML
    protected void BtnAdicionar_Action(ActionEvent evento){
        System.out.println("Adicionar");
        habilitarInterface(true);
        limparInterface();
        TxtCodigo.requestFocus();
    }

    @FXML
    protected void BtnDeletar_Action(ActionEvent evento){
        Copia copia = LstCopias.getSelectionModel().getSelectedItem();
        if (copia==null) return;
        try {
            copiaDao.excluir(copia);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        limparInterface();
        System.out.println("Excluir");
    }

    @FXML
    protected void BtnGravar_Action(ActionEvent evento){
        System.out.println("Gravar");
        Copia copia = new Copia();
        //copia.setCodigo(TxtCodigo.getText());

        try {
            copiaDao.gravar(copia);
        } catch (Exception e) {
            e.printStackTrace();
        }
        atualizarLista();
        habilitarInterface(false);
    }

    private void atualizarLista() {
        List<Livros> livros;
        List<Copia> copias;

        try {
            livros = livrosDao.listar();
            copias = copiaDao.listar();

        } catch (Exception e) {
            livros = new ArrayList<Livros>();
            copias = new ArrayList<Copia>();

        }
        ObservableList<Copia> copiasOb = FXCollections.observableArrayList(copias);
        LstCopias.setItems(copiasOb);

        ObservableList<Livros> livrosOb = FXCollections.observableArrayList(livros);
        CboLivros.setItems(livrosOb);

    }
}
