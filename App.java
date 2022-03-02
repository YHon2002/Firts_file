package MyProject_MsHoa.QuanLyBanHang;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    static Product delete = new Product();
    public static List<Product> PRODUCTS = new ArrayList<Product>();
    public static List<Order> ORDERS = new ArrayList<Order>();
    public static Product[] arrProduct;
    public static void menu(){
        System.out.println(" +========================================DANH SÁCH CHỨC NĂNG=================================+");
        System.out.println(" |                                                                                            |");
        System.out.println(" |                                        1. Thêm mới sản phẩm                                |");
        System.out.println(" |                                        2. Hiển thị sản phẩm                                |");
        System.out.println(" |                                        3. Sửa sản phẩm                                     |");
        System.out.println(" |                                        4. Tìm kiếm sản phẩm                                |");
        System.out.println(" |                                        5. Sắp xếp sản phẩm                                 |");
        System.out.println(" |                                        6. Xóa sản phẩm                                     |");
        System.out.println(" |                                        7. Mua hàng                                         |");
        System.out.println(" |                                        8. Hiển thị danh sách đơn hàng                      |");
        System.out.println(" |                                        9. Thoát.                                           |");
        System.out.println(" +============================================================================================+");
        



    }
    public static void main(String[] args) {
        int function = 0;
        String name;

        
        do {
            menu();
            Scanner inputs = new Scanner (System.in);
            try {
                System.out.println("Chọn chức năng: ");
                function = inputs.nextInt();
                ProductService productService = new ProductService();
                OrderService orderService = new OrderService();
                switch (function) {
                    case 1:
                    System.out.println("========>>Nhập số lần nhập: ");
                    int n=inputs.nextInt();
                    for (int i=0;i<n;i++){
                        productService.insert();
                    }
                        break;
                    case 2:
                        System.out.println("                            HIỂN THỊ SẢN PHẨM                              ");
                        productService.show();
                        break;
                    case 3:
                        productService.update();
                        
                        break;  
                    case 4:
                        System.out.println("Tìm kiếm sản phẩm");
                        System.out.println("-------Menu-------");
                        System.out.println("1: Tìm theo id");
                        System.out.println("2: Tìm theo tên");
                        System.out.println("Lựa chọn của bạn là: ");
                        function = inputs.nextInt();
                        switch (function) {
                            case 1:
                                productService.searchproduct(PRODUCTS);;
                                break;
                            case 2:
                                productService.searchproducbyname(PRODUCTS);
                                break;
                        
                        } 
                        break;
                    case 5:
                        
                        productService.sortProduct();
                    
                        break;
                    case 6:
                        productService.removeProduct();  
                        break;
                    case 7:
                        orderService.Order();
                        break;  
                    case 8:
                        orderService.show();
                        break;
                        
                
                    default:
                        break;
                }
            }catch (InputMismatchException ei) {
                System.out.println("Bạn đã nhập sai giá trị, vui lòng nhập lại");
            }
            catch (Exception e) {
                System.out.println(e. getMessage());
            }
        }while (function != 8);
        System.out.println("Cảm ơn bạn đã sử dụng phần mềm!");
    }
}
