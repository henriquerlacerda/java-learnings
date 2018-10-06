package Frame;

import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BuildJanela extends Application {
	
	private Group container;
	private Scene conteudo;
	private Dimension screenSize;
	
	public BuildJanela() {
		this.screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		this.container = new Group();
	}
	
	@Override
	public void start(Stage cenario) throws Exception {
		cenario.setMaximized(true);
		cenario.setTitle("Arcevo Biblioteca de DVDs");
		cenario.centerOnScreen();
		cenario.setScene(conteudoPagina());
    	cenario.show();
	}
	
	public Scene conteudoPagina() {
		this.conteudo = new Scene(this.container,screenSize.getWidth(),screenSize.getHeight(), Color.LIGHTGRAY);
		this.container.getChildren().addAll(layoutHome());
		PatternEffects.fadeEffect(this.container, "FadeIn");
		return conteudo;
	}
	
	public BorderPane layoutHome() {
		BorderPane layout = new BorderPane();
		layout.setTop(menusPadrao());
		layout.setLeft(botoesPadrao());
		
		return layout;
	}
	
	public VBox menusPadrao() {
		MenuBar barra = new MenuBar();
		Menu arquivo = new Menu("Arquivo");
		Menu editar = new Menu("Editar");
		Menu registar = new Menu("Registrar");
		Menu ajuda = new Menu("Ajuda");
		barra.getMenus().addAll(arquivo,editar,registar,ajuda);
		VBox complemento = new VBox();
		complemento.setPrefSize(screenSize.getWidth(), 20);
		complemento.getChildren().add(barra);
		
		return complemento; 
	}
	
	public StackPane botoesPadrao() {
		StackPane imageContainer = new StackPane();
		Image imgtest = new Image("file:/Users/1414950/Documents/eclipse-workspace/Arcevo/src/imagens/Imagem1.jpg");
		Image imgtest2 = new Image("file:/Users/1414950/Documents/eclipse-workspace/Arcevo/src/imagens/Imagem3.png");
		Image imgtest3 = new Image("file:/Users/1414950/Documents/eclipse-workspace/Arcevo/src/imagens/Imagem");
		
		ImageView iv1 = new ImageView();
		ImageView iv2 = new ImageView();
		ImageView iv3 = new ImageView();
		
	    iv1.setImage(imgtest);	
		iv2.setImage(imgtest2);
		iv3.setImage(imgtest3);
	    
	    imageContainer.getChildren().addAll(iv1,iv2,iv3);
	    
		return imageContainer;
	}
	
	public void finalizarAplicacao() {
		Platform.exit();
		System.exit(0);
	}
}
