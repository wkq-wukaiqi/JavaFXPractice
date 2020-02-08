package Model;
public class History {
    //更新时间
    private String date;

    //确诊人数
    private int confirmedNum;

    //疑似人数
    private int suspectedNum;

    //治愈人数
    private int cruesNum;

    //死亡人数
    private int deathsNum;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getConfirmedNum() {
        return confirmedNum;
    }

    public void setConfirmedNum(int confirmedNum) {
        this.confirmedNum = confirmedNum;
    }

    public int getSuspectedNum() {
        return suspectedNum;
    }

    public void setSuspectedNum(int suspectedNum) {
        this.suspectedNum = suspectedNum;
    }

    public int getCruesNum() {
        return cruesNum;
    }

    public void setCruesNum(int cruesNum) {
        this.cruesNum = cruesNum;
    }

    public int getDeathsNum() {
        return deathsNum;
    }

    public void setDeathsNum(int deathsNum) {
        this.deathsNum = deathsNum;
    }
}
