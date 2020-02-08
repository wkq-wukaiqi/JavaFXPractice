import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main extends Application  {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root=FXMLLoader.load(getClass().getResource("main.fxml"));
        Scene scene=new Scene(root,200,80);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(2000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            try{
                                Parent root=FXMLLoader.load(getClass().getResource("/sample.fxml"));
                                Scene scene=new Scene(root,900,600);
                                Stage newstage=new Stage();
                                newstage.setScene(scene);
                                primaryStage.close();
                                newstage.show();
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                        }
                    });
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


    修改：     build.gradle
    修改：     src/main/java/Controller/Controller.java
    修改：     src/main/java/Main.java
    修改：     src/main/java/Model/City.java
    修改：     src/main/java/Model/History.java
    修改：     src/main/java/Model/Message.java
    修改：     src/main/java/Model/Province.java
    修改：     src/main/resources/sample.fxml


    public static void main(String[] args){
        launch(args);
    }




    //test
//        TextArea textArea=new TextArea();
//        textArea.setWrapText(true);
//        ScrollPane scrollPane=new ScrollPane();
//        scrollPane.setContent(textArea);
//        scrollPane.setFitToWidth(true);
//        Scene scene=new Scene(scrollPane,500,500);
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//
//
//        try{
//            OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
//            HttpUrl.Builder builder=HttpUrl.parse("https://tianqiapi.com/api").newBuilder();
//            builder.addQueryParameter("appid","41135599")
//                    .addQueryParameter("appsecret","s4frVhQV")
//                    .addQueryParameter("version","epidemic");
//            Request request=new Request.Builder().url(builder.build()).build();
//            Response response = okHttpClient.newCall(request).execute();
//            String message=decode(response.body().string());
//            textArea.setText(message);
//        }catch (IOException e){
//
//        }
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

