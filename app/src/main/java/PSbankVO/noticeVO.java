package PSbankVO;

public class noticeVO {

    private String notice_num;
    private String notice_title;
    private String notice_content;


    public noticeVO(String notice_num, String notice_title, String notice_content) {

        this.notice_num = notice_num;
        this.notice_title = notice_title;
        this.notice_content = notice_content;

    }

    public String getNotice_num() { return notice_num; }

    public void setNotice_num(String notice_num) { this.notice_num = notice_num; }

    public String getNotice_title() { return notice_title; }

    public void setNotice_title(String notice_title) { this.notice_title = notice_title; }

    public String getNotice_content() { return notice_content; }

    public void setNotice_content(String notice_content) { this.notice_content = notice_content; }


}
