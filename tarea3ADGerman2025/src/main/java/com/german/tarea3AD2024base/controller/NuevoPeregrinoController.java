package com.german.tarea3AD2024base.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.german.tarea3AD2024base.config.StageManager;
import com.german.tarea3AD2024base.services.ParadaServicio;
import com.german.tarea3AD2024base.view.FxmlView;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

@Controller
public class NuevoPeregrinoController implements Initializable {

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

	@Autowired
	private ParadaServicio paradaServicio;

	private List<String> paradas;
	private List<String> paises;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		paradas = paradaServicio.nombreyRegiones();
		cmbParadas.getItems().addAll(paradas);
		paises = cargarPaises();
		cmbNacionalidad.getItems().addAll(paises);

	}

	@FXML
	private void salir() {
		stageManager.switchScene(FxmlView.LOGIN);
	}

	private List<String> cargarPaises() {
		List<String> ret = new ArrayList<>();
		File paises = new File("src/main/resources/paises.xml");

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(paises);
			doc.getDocumentElement().normalize();
			NodeList listapaises = doc.getElementsByTagName("pais");

			for (int i = 0; i < listapaises.getLength(); i++) {
				Node nodo = listapaises.item(i);

				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					Element pais = (Element) nodo;

					String nombrep = pais.getElementsByTagName("nombre").item(0).getTextContent();
					ret.add(nombrep);
				}
			}

		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return ret;
	}

}
