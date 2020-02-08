public class Message {
    //更新时间
    private String date;

    //确诊人数
    private int diagnosed;
    //新增确诊
    private int diagnosedIncr;

    //疑似人数
    private int suspect;
    //新增疑似
    private int suspectIncr;

    //死亡人数
    private int death;
    //新增死亡
    private int deathIncr;

    //治愈人数
    private int cured;
    //新增治愈
    private int curedIncr;

    //重症人数
    private int serious;
    //新增重症
    private int seriousIncr;

    //全国省份数据
    private String[] list;

    //历史数据
    private History[] history;

    //具体省市区人数
    private Province[] area;

    
}
