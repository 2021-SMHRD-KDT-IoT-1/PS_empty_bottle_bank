package PSbankVO;

public class main_DetailVO {



    private String machine_name;
    private String Detail_bottle_set_num;
    private String Detail_bottle_now_num;

    public main_DetailVO(  String machine_name, String detail_bottle_set_num, String detail_bottle_now_num) {

        this.machine_name = machine_name;
        Detail_bottle_set_num = detail_bottle_set_num;
        Detail_bottle_now_num = detail_bottle_now_num;

    }


    public String getMachine_name() {
        return machine_name;
    }

    public void setMachine_name(String machine_name) {
        this.machine_name = machine_name;
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
