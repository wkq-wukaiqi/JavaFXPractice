package Model;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getDiagnosed() {
        return diagnosed;
    }

    public void setDiagnosed(int diagnosed) {
        this.diagnosed = diagnosed;
    }

    public int getDiagnosedIncr() {
        return diagnosedIncr;
    }

    public void setDiagnosedIncr(int diagnosedIncr) {
        this.diagnosedIncr = diagnosedIncr;
    }

    public int getSuspect() {
        return suspect;
    }

    public void setSuspect(int suspect) {
        this.suspect = suspect;
    }

    public int getSuspectIncr() {
        return suspectIncr;
    }

    public void setSuspectIncr(int suspectIncr) {
        this.suspectIncr = suspectIncr;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getDeathIncr() {
        return deathIncr;
    }

    public void setDeathIncr(int deathIncr) {
        this.deathIncr = deathIncr;
    }

    public int getCured() {
        return cured;
    }

    public void setCured(int cured) {
        this.cured = cured;
    }

    public int getCuredIncr() {
        return curedIncr;
    }

    public void setCuredIncr(int curedIncr) {
        this.curedIncr = curedIncr;
    }

    public int getSerious() {
        return serious;
    }

    public void setSerious(int serious) {
        this.serious = serious;
    }

    public int getSeriousIncr() {
        return seriousIncr;
    }

    public void setSeriousIncr(int seriousIncr) {
        this.seriousIncr = seriousIncr;
    }

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }

    public History[] getHistory() {
        return history;
    }

    public void setHistory(History[] history) {
        this.history = history;
    }

    public Province[] getArea() {
        return area;
    }

    public void setArea(Province[] area) {
        this.area = area;
    }
}
