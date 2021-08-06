package PSbankVO;

public class fg_MyinfoVO {

    private String s_myinfo_name;
    private String s_myinfo_current_money_view;
    private String s_myinfo_ranking_view;

    public fg_MyinfoVO(String s_myinfo_name, String s_myinfo_current_money_view, String s_myinfo_ranking_view) {
        this.s_myinfo_name = s_myinfo_name;
        this.s_myinfo_current_money_view = s_myinfo_current_money_view;
        this.s_myinfo_ranking_view = s_myinfo_ranking_view;
    }

    public String getS_myinfo_name() {
        return s_myinfo_name;
    }

    public void setS_myinfo_name(String s_myinfo_name) {
        this.s_myinfo_name = s_myinfo_name;
    }

    public String getS_myinfo_current_money_view() {
        return s_myinfo_current_money_view;
    }

    public void setS_myinfo_current_money_view(String s_myinfo_current_money_view) {
        this.s_myinfo_current_money_view = s_myinfo_current_money_view;
    }

    public String getS_myinfo_ranking_view() {
        return s_myinfo_ranking_view;
    }

    public void setS_myinfo_ranking_view(String s_myinfo_ranking_view) {
        this.s_myinfo_ranking_view = s_myinfo_ranking_view;
    }
}
