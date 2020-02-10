import Controller.Controller;
import Model.Data;
import com.google.gson.Gson;
import com.jfoenix.controls.JFXTextArea;
import com.sun.javafx.application.LauncherImpl;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class Main extends Application  {
    @FXML
    private Text updateTime;
    @FXML
    private Text dianosedAll;
    @FXML
    private Text suspectAll;
    @FXML
    private Text curedAll;
    @FXML
    private Text deathAll;
    @FXML
    private Text dianosedIncr;
    @FXML
    private Text suspectIncr;
    @FXML
    private Text curedIncr;
    @FXML
    private Text deathIncr;
    @FXML
    private Button updateEpidemic;
    private Data data;
    @Override
    public void init() throws Exception {
        Gson gson=new Gson();
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://tianqiapi.com/api").newBuilder();
        urlBuilder.addQueryParameter("appid", "41135599")
                .addQueryParameter("appsecret", "s4frVhQV")
                .addQueryParameter("version", "epidemic");
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .build();
        Response response=client.newCall(request).execute();
        data=gson.fromJson(response.body().string(), Data.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene=new Scene(root,800,800);
        primaryStage.setScene(scene);
        primaryStage.show();
        Text updateTime=(Text)root.lookup("#updateTime");
        Text dianosedAll=(Text)root.lookup("#dianosedAll");
        Text suspectAll=(Text)root.lookup("#suspectAll");
        Text curedAll=(Text)root.lookup("#curedAll");
        Text deathAll=(Text)root.lookup("#deathAll");
        Text dianosedIncr=(Text)root.lookup("#dianosedIncr");
        Text suspectIncr=(Text)root.lookup("#suspectIncr");
        Text curedIncr=(Text)root.lookup("#curedIncr");
        Text deathIncr=(Text)root.lookup("#deathIncr");
        updateTime.setText("更新时间： "+data.getMessage().getDate());
        dianosedAll.setText(data.getMessage().getDiagnosed()+"");
        suspectAll.setText(data.getMessage().getSuspect()+"");
        curedAll.setText(data.getMessage().getCured()+"");
        deathAll.setText(data.getMessage().getDeath()+"");
        dianosedIncr.setText(data.getMessage().getDiagnosedIncr()+"");
        suspectIncr.setText(data.getMessage().getSuspectIncr()+"");
        curedIncr.setText(data.getMessage().getCuredIncr()+"");
        deathIncr.setText(data.getMessage().getDeathIncr()+"");
    }


    public static void main(String[] args){
        LauncherImpl.launchApplication(Main.class,MyPreloader.class,args);
    }

    public void updateEpidemic(ActionEvent event)throws IOException{
        Gson gson=new Gson();
        OkHttpClient client = new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse("https://tianqiapi.com/api").newBuilder();
        urlBuilder.addQueryParameter("appid", "41135599")
                .addQueryParameter("appsecret", "s4frVhQV")
                .addQueryParameter("version", "epidemic");
        Request request = new Request.Builder()
                .url(urlBuilder.build())
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                data=gson.fromJson(response.body().string(), Data.class);
                updateTime.setText("更新时间： "+data.getMessage().getDate());
                dianosedAll.setText(data.getMessage().getDiagnosed()+"");
                suspectAll.setText(data.getMessage().getSuspect()+"");
                curedAll.setText(data.getMessage().getCured()+"");
                deathAll.setText(data.getMessage().getDeath()+"");
                dianosedIncr.setText(data.getMessage().getDiagnosedIncr()+"");
                suspectIncr.setText(data.getMessage().getSuspectIncr()+"");
                curedIncr.setText(data.getMessage().getCuredIncr()+"");
                deathIncr.setText(data.getMessage().getDeathIncr()+"");
            }
        });
    }

    @FXML
    public void updateMouseEntered(MouseEvent event){
        Button button=(Button)event.getSource();
        button.setStyle("-fx-background-color: #d3d3d3");
    }

    @FXML
    public void updateMouseExited(MouseEvent event){
        Button button=(Button)event.getSource();
        button.setStyle("-fx-background-color: #00000000");
    }

    @FXML
    public void Entered(MouseEvent event){
        ImageView imageView=(ImageView)event.getSource();
        imageView.setScaleX(1.2);
        imageView.setScaleY(1.2);
    }
    @FXML
    public void Exited(MouseEvent event){
        ImageView imageView=(ImageView)event.getSource();
        imageView.setScaleX(1.0);
        imageView.setScaleY(1.0);
    }
    @FXML
    public void Clicked(MouseEvent event){

    }
//    public static String decode(String unicodeStr) {
//        if (unicodeStr == null) {
//            return null;
//        }
//        StringBuffer retBuf = new StringBuffer();
//        int maxLoop = unicodeStr.length();
//        for (int i = 0; i < maxLoop; i++) {
//            if (unicodeStr.charAt(i) == '\\') {
//                if ((i < maxLoop - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U')))
//                    try {
//                        retBuf.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));
//                        i += 5;
//                    } catch (NumberFormatException localNumberFormatException) {
//                        retBuf.append(unicodeStr.charAt(i));
//                    }
//                else
//                    retBuf.append(unicodeStr.charAt(i));
//            } else {
//                retBuf.append(unicodeStr.charAt(i));
//            }
//        }
//        return retBuf.toString();
//    }
}

