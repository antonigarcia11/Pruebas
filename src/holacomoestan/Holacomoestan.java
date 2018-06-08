package holacomoestan;


import com.holacomoestan.controller.LoginController;
import java.io.IOException;
import java.io.InputStream;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Holacomoestan extends Application {    
    //Escenario principal
    private Stage escenarioPrincipal;
    private final String PAQUETE_VISTA = "/com/holacomoestan/view/";
    @Override
    //Metodo que iniciar la carga del escenario principal
    public void start(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("andres");
        //mostrarHelloWorld();
        mostrarLogin();
        this.escenarioPrincipal.show();
    }
    
    public void mostrarLogin(){
        try{
            LoginController login = (LoginController)cambiarEscena("LoginView.fxml",600,400);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Metodo para cambiar el escenario principal
    public Initializable cambiarEscena(String fxml, int ancho, int alto) throws IOException{
        Initializable resultado = null;
        //Cargador del archivo FXML
        FXMLLoader cargadorFXML = new FXMLLoader();
        //Asignacion del archivo logico
        InputStream archivo = Holacomoestan.class.getResourceAsStream(PAQUETE_VISTA + fxml);
        //Cargdor de fabrica para cargar el archivo FXML
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        //Direccion de la ruta del archivo FXML
        cargadorFXML.setLocation(Holacomoestan.class.getResource(PAQUETE_VISTA + fxml));        
        //Creacion de la escena
        Scene escena = new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto); 
        //Asignacion de la escena en el escenario principal
        this.escenarioPrincipal.setScene(escena);
        //Ajustar el tamaño del escenario a la escena
        this.escenarioPrincipal.sizeToScene();
        //Retornar el objeto initializable del controlador
        resultado = (Initializable)cargadorFXML.getController();
        return resultado;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
