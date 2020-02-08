package Controller;

import Model.Data;
import Model.Message;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class Controller {
    @FXML
    private Text updateTime;
    @FXML
    private JFXTextArea dianosedAll;
    @FXML
    private JFXTextArea suspectAll;
    @FXML
    private JFXTextArea curedAll;
    @FXML
    private JFXTextArea deathAll;
//    @FXML
//    private Button showEpidemic;
    @FXML
    private Button updateEpidemic;

//    @FXML
//    public void showEpidemic(ActionEvent event)throws IOException {
//            Parent root=FXMLLoader.load(getClass().getResource("/sample.fxml"));
//            Scene scene=new Scene(root,900,600);
//            Stage oldstage=(Stage)((Node)event.getSource()).getScene().getWindow();
//            Stage newstage=new Stage();
//            newstage.setScene(scene);
//            oldstage.close();
//            newstage.show();
//    }

    @FXML
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
                Data data=gson.fromJson(response.body().string(), Data.class);
                updateTime.setText("更新时间： "+data.getMessage().getDate());
                dianosedAll.setText(data.getMessage().getDiagnosed()+"");
                suspectAll.setText(data.getMessage().getSuspect()+"");
                curedAll.setText(data.getMessage().getCured()+"");
                deathAll.setText(data.getMessage().getDeath()+"");
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

















    public static String decode(String unicodeStr) {
        if (unicodeStr == null) {
            return null;
        }
        StringBuffer retBuf = new StringBuffer();
        int maxLoop = unicodeStr.length();
        for (int i = 0; i < maxLoop; i++) {
            if (unicodeStr.charAt(i) == '\\') {
                if ((i < maxLoop - 5) && ((unicodeStr.charAt(i + 1) == 'u') || (unicodeStr.charAt(i + 1) == 'U')))
                    try {
                        retBuf.append((char) Integer.parseInt(unicodeStr.substring(i + 2, i + 6), 16));
                        i += 5;
                    } catch (NumberFormatException localNumberFormatException) {
                        retBuf.append(unicodeStr.charAt(i));
                    }
                else
                    retBuf.append(unicodeStr.charAt(i));
            } else {
                retBuf.append(unicodeStr.charAt(i));
            }
        }
        return retBuf.toString();
    }




}
