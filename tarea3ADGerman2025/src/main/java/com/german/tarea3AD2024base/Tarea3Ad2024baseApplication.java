package com.german.tarea3AD2024base.view;

import java.util.ResourceBundle;

public enum FxmlView {
	USER {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("user.title");
		}

		@Override
		public String getFxmlFile() {
			return "/fxml/User.fxml";
		}
	},
	LOGIN {
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("login.title");
		}

		@Override
		public String getFxmlFile() {
			return "/fxml/Login.fxml";
		}
	},
	MENU_RESPONSABLE{
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("menuResponsable.title");
		}

		@Override
		public String getFxmlFile() {
			return "/fxml/MenuResponsable.fxml";
		}
	},
	REGISTRAR_PEREGRINO{
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("nuevoPeregrino.title");
		}

		@Override
		public String getFxmlFile() {
			return "/fxml/NuevoPeregrino.fxml";
		}
		
	},
	MENU_PEREGRINO{
		@Override
		public String getTitle() {
			return getStringFromResourceBundle("menuPeregrino.title");
		}

		@Override
		public String getFxmlFile() {
			return "/fxml/MenuPeregrino.fxml";
		}
	};

	public abstract String getTitle();

	public abstract String getFxmlFile();

	String getStringFromResourceBundle(String key) {
		return ResourceBundle.getBundle("Bundle").getString(key);
	}
}
