package MyProject_MsHoa.QuanLyBanHang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Order extends Product{
    private Integer id; //int :0    Integer:null
    private String cusName;
    private String phone;
    private String email;

    private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
    
    public Order(){
    }
    public Order(Integer id, String cusName, String phone, String email) {
        this.id = id;
        this.cusName = cusName;
        this.phone = phone;
        this.email = email;
        
    }
        
    
    public List<OrderDetail> getOrderDetails() {
        return orderDetails;
    }


    public void setOrderDetails(List<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCusName() {
        return cusName;
    }
    public void setCusName(String cusName) {
        this.cusName = cusName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    // public void nhapOrder(){
    //     Scanner sc = new Scanner(System.in);
    //     System.out.println("Nhập mã đặt hàng: ");
    //     id = sc.nextInt();
    //     System.out.println("Nhập tên đặt hàng: ");
    //     cusName = sc.nextLine();
    //     System.out.println("Số điện thoại khách hàng: ");
    //     phone = sc.nextLine();
    //     System.out.println("Nhập email: ");
    //     email = sc.nextLine();
        
        
    // }
    
}
