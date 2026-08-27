package main.edu.ingsoft.formulario.registro.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import main.edu.ingsoft.formulario.registro.config.DataBaseConnection;
import main.edu.ingsoft.formulario.registro.service.AuthService;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import main.edu.ingsoft.formulario.registro.dto.request.LoginRequest;
import main.edu.ingsoft.formulario.registro.dto.response.LoginResponse;
import main.edu.ingsoft.formulario.registro.util.SceneManager;

public class LoginController implements Initializable {
    private final AuthService authService;
    private final SceneManager sceneManager;
    
    @FXML
    private TextField txtFieldEmail;
    
    @FXML
    private TextField txtFieldPass;
    
    public LoginController(AuthService authService, SceneManager sceneManager) {
        this.authService = authService;
        this.sceneManager = sceneManager;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("TODO LO QUE ESTA ACA, SE EJECUTA CUANDOSE MUESTRE LA VISTA ");
    }
    public void handleSayHello(){
        System.out.println("Hola mi nombre es: " + txtFieldEmail.getText());
    }
   //metodos
    public void handleTestDataBaseConncetion() throws Exception{
        try{
            DataBaseConnection.getConnectionDataBase();
            System.out.println("conectado");
        }catch(SQLException e){
            System.out.println("error al conectar: "+ e.getMessage());
        }
    }
    public void hadleLogin() throws Exception {
        if (txtFieldEmail.getText().isEmpty() || txtFieldPass.getText().isEmpty()) {
            //lanzamos una excepcion
            sceneManager.showInfoAlert("Campos faltantes", "Revisar la informacion", "uno o mas campos estan vacios", Alert.AlertType.CONFIRMATION);
        } else {
            LoginResponse responseService = authService.login(new LoginRequest(txtFieldEmail.getText(), txtFieldPass.getText()));
            sceneManager.showInfoAlert("Bienvenido", "Resvisar", "Uno o mas campos estan vacios",Alert.AlertType.INFORMATION);
                    
            LoginResponse userLogged = new LoginResponse(responseService.getNombre(), responseService.getApellido());
            System.out.println("Usuario loggeado: " + userLogged.getNombre() + ", Apellido usuario: " + userLogged.getApellido());
        }
    }
}