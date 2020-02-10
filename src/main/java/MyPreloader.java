import javafx.application.Preloader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MyPreloader extends Preloader {
    private Stage preStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.preStage=primaryStage;
        Parent root= FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(root,200,80);
        this.preStage.initStyle(StageStyle.UNDECORATED);
        this.preStage.setResizable(false);
        this.preStage.setScene(scene);
        this.preStage.show();
    }

    @Override
    public void handleStateChangeNotification(StateChangeNotification info) {
        if(info.getType()== StateChangeNotification.Type.BEFORE_START){
            preStage.close();
        }
    }
}
