package PSbankVO;

public class event_ProductVO {

    private int event_img;
    private String event_tlt;
    private String event_time;

    public event_ProductVO(int event_img, String event_tlt, String event_time) {
        this.event_img = event_img;
        this.event_tlt = event_tlt;
        this.event_time = event_time;
    }

    public int getEvent_img() {
        return event_img;
    }

    public String getEvent_tlt() {
        return event_tlt;
    }

    public String getEvent_time() {
        return event_time;
    }


    public void setEvent_img(int event_img) {
        this.event_img = event_img;
    }

    public void setEvent_tlt(String event_tlt) {
        this.event_tlt = event_tlt;
    }

    public void setEvent_time(String event_time) {
        this.event_time = event_time;
    }
}


