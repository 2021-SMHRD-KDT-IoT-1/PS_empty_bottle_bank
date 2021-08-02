package PSbankVO;

public class my_eventcontentVO {
    private String event_my_day;
    private String event_my_content;
    private String event_my_point;

    public my_eventcontentVO(String event_my_day, String event_my_content, String event_my_point) {
        this.event_my_day = event_my_day;
        this.event_my_content = event_my_content;
        this.event_my_point = event_my_point;
    }

    public String getEvent_my_day() {
        return event_my_day;
    }

    public void setEvent_my_day(String event_my_day) {
        this.event_my_day = event_my_day;
    }

    public String getEvent_my_content() {
        return event_my_content;
    }

    public void setEvent_my_content(String event_my_content) {
        this.event_my_content = event_my_content;
    }

    public String getEvent_my_point() {
        return event_my_point;
    }

    public void setEvent_my_point(String event_my_point) {
        this.event_my_point = event_my_point;
    }
}
