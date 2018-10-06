package Frame;

import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.util.Duration;

public class PatternEffects {

	public static FadeTransition fade;
	
	public static void fadeEffect(Group conteudo, String efeito) {
		fade = new FadeTransition(Duration.seconds(4),conteudo);
	   
		switch(efeito){
		case "FadeIn": 
	    	fade.setFromValue(0);
	    	fade.setToValue(1);
	    	System.out.println("FadeOut efetuado com sucesso");
	    	break;
		case "FadeOut":
			fade.setFromValue(1);
			fade.setToValue(0);
			System.out.println("FadeOut efetuado com sucesso");
			break;	    
		default:
			    System.out.println("Parametro "+ efeito +" está incorreto");
	   }
	    fade.setCycleCount(1);
	    fade.play();
	}
	
}
