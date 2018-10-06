package Frame;

import javafx.animation.FadeTransition;
import javafx.application.Preloader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class BuildPreLoad extends Preloader{
	
	@Override
	public void start(Stage load) throws Exception {
		StackPane conteudo = new StackPane(fundoImagem(),iconeCarregamento());
	    Scene scene = new Scene(conteudo);
	   fadeInOutFinish(conteudo, load);	
	    load.initStyle(StageStyle.UNDECORATED);
	    load.setWidth(800);
	    load.setHeight(600);
	    load.setScene(scene);
	    load.show();
	}
	
	public ImageView fundoImagem() {
		ImageView fundo = new ImageView();
		Image imagem = new Image("file:/Users/1414950/Documents/eclipse-workspace/Arcevo/src/imagens/Imagem2.png");
		fundo.setImage(imagem);
		fundo.setSmooth(true);
		fundo.setFitWidth(1000);
		fundo.setFitHeight(600);
		
		return fundo;
	}
	
	public BorderPane iconeCarregamento() {
		VBox loading = new VBox(20);
		loading.setMaxWidth(Region.USE_PREF_SIZE);
	    loading.setMaxHeight(Region.USE_PREF_SIZE);
	    loading.getChildren().add(new ProgressBar());
	    loading.getChildren().add(new Label("Please wait..."));
	    BorderPane borda = new BorderPane(loading);
	    
	    return borda;
	}
	
	public Text textWelcome() {
		Text welcome = new Text();
		welcome.setText("Welcome to Arcevo");
		welcome.setFont(Font.font("Verdana", 65));
		welcome.setFill(Color.WHITESMOKE);
		return welcome;
	}
	
	public void fadeInOutFinish(StackPane conteudo, Stage load) {
		FadeTransition fade = new FadeTransition(Duration.seconds(4),conteudo);
		
		fade.setFromValue(0);
    	fade.setToValue(1);	
    	fade.setCycleCount(1);
		fade.play();
		fade.setOnFinished((e) -> {
			conteudo.getChildren().remove(1);
			conteudo.getChildren().add(textWelcome());
			fade.setFromValue(1);
			fade.setToValue(0);
			fade.play();
			System.out.println("FadeInOut efetuado com sucesso");
			fade.setOnFinished((r) -> {
				load.hide();
				
			});
		});	
	}
	
}