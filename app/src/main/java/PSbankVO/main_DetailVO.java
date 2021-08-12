package PSbankVO;

public class main_DetailVO {



    private String machine_name;
    private String machine_lat;
    private String machine_lon;
    private String Detail_bottle_set_num;
    private String Detail_bottle_now_num;

    public main_DetailVO(  String machine_name, String machine_lat, String machine_lon, String detail_bottle_set_num, String detail_bottle_now_num) {

        this.machine_name = machine_name;
        this.machine_lat = machine_lat;
        this.machine_lon = machine_lon;
        Detail_bottle_set_num = detail_bottle_set_num;
        Detail_bottle_now_num = detail_bottle_now_num;

    }


    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
    }

    public String getMachine_lat() {
        return machine_lat;
    }

    public void setMachine_lat(String machine_lat) {
        this.machine_lat = machine_lat;
    }

    public String getMachine_lon() {
        return machine_lon;
    }

    public void setMachine_lon(String machine_lon) {
        this.machine_lon = machine_lon;
    }

    public String getDetail_bottle_set_num() {
        return Detail_bottle_set_num;
    }

    public void setDetail_bottle_set_num(String detail_bottle_set_num) {
        Detail_bottle_set_num = detail_bottle_set_num;
    }

    public String getDetail_bottle_now_num() {
        return Detail_bottle_now_num;
    }

    public void setDetail_bottle_now_num(String detail_bottle_now_num) {
        Detail_bottle_now_num = detail_bottle_now_num;
    }
}
