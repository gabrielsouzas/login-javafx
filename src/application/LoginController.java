package application;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import bean.Login;
import dao.LoginDAO;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class LoginController implements Initializable {
	
	@FXML
    private ImageView imageView;
	
	@FXML
    private AnchorPane anchorPaneLogin;

    @FXML
    private Pane paneLogin;

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;
    
    @FXML
    private void cliqueBtnEntrar(ActionEvent event) {
    	try {
    		efetuarLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void efetuarLogin() {
		LoginDAO loginDao = new LoginDAO();
		Login login = new Login();

		login.setUsuario("");
		login.setSenha("");
		
		login.setUsuario(txtUsuario.getText());
		login.setSenha(txtSenha.getText());

		try {
			Login loginRetorno = new Login();
			loginRetorno = loginDao.acesso(login);
			if (loginRetorno != null) {
				
				/*FECHAR A TELA DE LOGIN E ABRIR A TELA PRINCIPAL*/
			}else {
				JOptionPane.showMessageDialog(null, "Usuário ou Senha inexistentes.");
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao consultar Usuário. Erro:" + e);
		}
	}

}
