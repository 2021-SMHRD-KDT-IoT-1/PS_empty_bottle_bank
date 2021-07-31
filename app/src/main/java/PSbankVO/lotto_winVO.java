package PSbankVO;

public class lotto_winVO {

    private String lotto_round;
    private String lotto_win1;
    private String lotto_win2;
    private String lotto_win3;

    public lotto_winVO(String lotto_round, String lotto_win1, String lotto_win2, String lotto_win3) {
        this.lotto_round = lotto_round;
        this.lotto_win1 = lotto_win1;
        this.lotto_win2 = lotto_win2;
        this.lotto_win3 = lotto_win3;

    }

    public String getLotto_round() {
        return lotto_round;
    }

    public void setLotto_round(String lotto_round) {
        this.lotto_round = lotto_round;
    }

    public String getLotto_win1() {
        return lotto_win1;
    }

    public void setLotto_win1(String lotto_win1) {
        this.lotto_win1 = lotto_win1;
    }

    public String getLotto_win2() {
        return lotto_win2;
    }

    public void setLotto_win2(String lotto_win2) {
        this.lotto_win2 = lotto_win2;
    }

    public String getLotto_win3() {
        return lotto_win3;
    }

    public void setLotto_win3(String lotto_win3) {
        this.lotto_win3 = lotto_win3;
    }
}
