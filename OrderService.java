package MyProject_MsHoa.QuanLyBanHang;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderService extends Order {
    private static final boolean True = false;
    public void Order(){
        Scanner inputs = new Scanner (System.in);
        System.out.println("-----------------Mua sản phẩm:-------------------- ");
        try {
            System.out.println("Nhập mã khách hàng: ");
            int id = inputs.nextInt();
            
            inputs.nextLine();
            System.out.println("Nhập tên của khách hàng: ");
            String cusName = inputs.nextLine();

            inputs.nextLine();
            System.out.println("Nhập số điện thoại: ");
            String phone = inputs.nextLine();

           
            System.out.println("Nhập email: ");
            String email = inputs.nextLine();

            Order order = new Order(id, cusName, phone, email);
            Integer productId = -1;

            while (true) {
                inputs = new Scanner (System.in);
                System.out.println("Nhập mã sản phẩm muốn đặt: ");
                productId = inputs.nextInt();
                if (productId.equals(-1)){
                    break;
                }
                // Check lại sp tồn tại hay không

                System.out.println("Nhập số lượng sản phẩm: ");
                int quantity = inputs.nextInt();
                
                Product product = null;
                for (Product p : App. PRODUCTS) {
                    if (p.getId().equals(productId)){
                        product = p;
                        break;
                    }
                }
                if (product == null) {
                    System.out.println("Mã sảm phẩm tồn tại");
                }
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setId(1);
                orderDetail.setOrderId (order.getId());
                orderDetail.setPrice(product.getPrice());
                orderDetail.setProductId((productId));
                orderDetail.setQuantity(quantity);

                order.getOrderDetails().add(orderDetail);

            }
            App.ORDERS.add(order);
        }catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập sai giá trị, vui lòng nhập lại");
        }
        catch (Exception e) {
            System.out.println(e. getMessage());
        }
    }
    public void show(){
        System.out.println(".----------------------------------------> THÔNG TIN KHÁCH HÀNG <-----------------------------.");
        String header = String.format("|" + "%s%30s%30s%32s", "Mã", "Tên khách hàng", "Số điện thoại", "Email" + "|");
        System.out.println(header);
        ProductService productService = new ProductService();
        
        for (Order order : App.ORDERS) {
            
            String row = String.format ("|" + "%d%31s%31s%30s", order.getId(), order.getCusName(), order.getPhone(), order.getEmail() + "|");
            System.out.println(row);
            System.out.println("|" + "-----------------------------------------> ĐƠN ĐẶT HÀNG <----------------------------------- " + "|");
            String orderDetailHeader = String.format("|" + "%s%30s%30s%31s", "STT", "Tên sản phẩm", "Giá", "Số lượng" + "|");
            System.out.println((orderDetailHeader));

            int i = 1;
            for (OrderDetail od : order.getOrderDetails()){
                Product p = productService.getById(od.getProductId());
                String orderDetailRow = String.format("|" +"%s%30s%30s%33s", i, p.getName(), od.getPrice(), od.getQuantity() + "|");
                System.out.println(orderDetailRow);
                i++;
                System.out.println(".---------------------------------------------------------------------------------------------.");
            }
        }

        
    }
}
