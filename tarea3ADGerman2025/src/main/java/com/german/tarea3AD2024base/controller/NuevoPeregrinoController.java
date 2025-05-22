package com.german.tarea3AD2024base.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import com.german.tarea3AD2024base.config.StageManager;
import com.german.tarea3AD2024base.view.FxmlView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class NuevoPeregrinoController{
	
	@FXML
	private ComboBox<String> cmbParadas;
	@FXML
	private TextField txtNombrePeregrino;
	@FXML
	private ComboBox<String> cmbNacionalidad;
	@FXML
	private TextField txtUsuario;
	@FXML
	private TextField txtContrasena;

	@Lazy
	@Autowired
	private StageManager stageManager;

	@FXML
	private void registrarPeregrino(){
		stageManager.switchScene(FxmlView.LOGIN);
	}
}
