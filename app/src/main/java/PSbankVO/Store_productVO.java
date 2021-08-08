package PSbankVO;

public class Store_productVO {

    private int product_img;
    private String product_name;
    private String product_price;

    public Store_productVO(int product_img, String product_name, String product_price) {
        this.product_img = product_img;
        this.product_name = product_name;
        this.product_price = product_price;
    }

    public int getProduct_img() { return product_img; }

    public void setProduct_img(int product_img) { this.product_img = product_img; }

    public String getProduct_name() { return product_name; }

    public void setProduct_name(String product_name) { this.product_name = product_name; }

    public String getProduct_price() { return product_price; }

    public void setProduct_price(String product_price) { this.product_price = product_price; }


}
