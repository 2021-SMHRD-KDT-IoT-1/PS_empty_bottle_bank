package PSbankVO;

public class s_my_storeVO {

    private String S_my_store_day;
    private String S_my_store_content;
    private String S_my_point;

    public s_my_storeVO(String s_my_store_day, String s_my_store_content, String s_my_point) {
        S_my_store_day = s_my_store_day;
        S_my_store_content = s_my_store_content;
        S_my_point = s_my_point;
    }

    public String getS_my_store_day() {
        return S_my_store_day;
    }

    public void setS_my_store_day(String s_my_store_day) {
        S_my_store_day = s_my_store_day;
    }

    public String getS_my_store_content() {
        return S_my_store_content;
    }

    public void setS_my_store_content(String s_my_store_content) {
        S_my_store_content = s_my_store_content;
    }

    public String getS_my_point() {
        return S_my_point;
    }

    public void setS_my_point(String s_my_point) {
        S_my_point = s_my_point;
    }
}
