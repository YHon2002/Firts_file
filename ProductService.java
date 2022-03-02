package MyProject_MsHoa.QuanLyBanHang;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
// public static List<Product> PRODUCTS = new ArrayList<Product>();
public class ProductService extends Product{
    Scanner inputs = new Scanner (System.in);
    int reID;

    public void insert(){
        System.out.println("Nhập thông tin sản phẩm: ");
        
        try {
            System.out.print("Mã: ");
            int id = inputs.nextInt();
            setId(id);
            inputs.nextLine();

            System.out.println("Tên: ");
            String name = inputs.nextLine();
            setName(name);

            System.out.println("Số lượng: ");
            int quantity = inputs.nextInt();

            inputs.nextLine();
            
            System.out.println("Ghi chú: ");
            String description = inputs.nextLine();
            
            
            System.out.println("Giá: ");
            Float price = inputs.nextFloat();

            Product p = new Product(id, name, quantity, description, price);
            App.PRODUCTS.add(p);

        }catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập sai giá trị, vui lòng nhập lại");
        }
        catch (Exception e) {
            System.out.println(e. getMessage());
        }
    }

    
    
    public void show() {
        System.out.println(":---------------------------------------------------------------------------------:");
        String header = String.format("|" + "%s%15s%30s%15s%20s", "Mã", "Tên", "Số lượng", "Giá", "Ghi chú" +"|");
        System.out.println(header);
        ProductService productService = new ProductService();

        for (Product p : App.PRODUCTS) {
            String row = String.format("|" + "%d%15s%30d%15.2f%21s", p.getId(), p.getName(), p.getQuantity(), p.getPrice(), p.getDescription() +"   |");
            
            System.out.println(row);
            System.out.println(":---------------------------------------------------------------------------------:");
        }
    }
    public void update() {
        Scanner inputs = new Scanner (System.in);
       
        try {
            System.out.println("Nhập mã: ");
            Integer id = inputs.nextInt();
            Product product = null;

            for(Product p : App.PRODUCTS) {
                if (p.getId().equals(id)){
                    product = p;
                    break;
                }
            }
            if (product == null) {
                System.out.println("Mã sản phẩm không tồn tại. Xin vui lòng nhập lại!");
            }
            System.out.println("Thông tin sản phẩm");
            String row = String.format("%d%15s%30d%15.2f%20s", product.getId(), product.getName(), product.getQuantity(), product.getPrice(), product.getDescription());
            System.out.println(row);

            for (int i = 0; i < App.PRODUCTS.size(); i++){
                if (id.equals(App.PRODUCTS.get(i).getId())){
                    
                    inputs.nextLine();
                    
                    System.out.println("Tên: ");
                    String name = inputs.nextLine();

                    System.out.println("Số lượng: ");
                    int quantity = inputs.nextInt();

                    inputs.nextLine();
            
                    System.out.println("Ghi chú: ");
                    String description = inputs.nextLine();
            
            
                    System.out.println("Giá: ");
                    float price = inputs.nextFloat();
                    
                    App.PRODUCTS.get(i).setName(name);
                    App.PRODUCTS.get(i).setQuantity(quantity);
                    App.PRODUCTS.get(i).setDescription(description);
                    App.PRODUCTS.get(i).setPrice(price);

                    
                }
            }
        }catch (InputMismatchException ei) {
            System.out.println("Bạn đã nhập sai giá trị, vui lòng nhập lại");
        }
        catch (Exception e) {
            System.out.println(e. getMessage());
        }
        
    }
        public Product getById (int id){
        Product product = new Product();
        for(Product p : App.PRODUCTS) {
            if (p.getId().equals(id)){
                product = p;
                break;
                
            }
        }
        
        return product;
        }

        public void searchproduct(List<Product> PRODUCTS){
            if(0 == PRODUCTS.size()){
                System.out.println("null");
            }else{
                System.out.println("Nhập id sản phẩm bạn muốn tìm: ");
                id = inputs.nextInt();
                for(Product p : App.PRODUCTS) {

                    if(p.getId().equals(id)){
                        System.out.println("Sản phẩm bạn vừa tìm là:");
                        String row = String.format("%d%15s%30d%15.2f%20s", p.getId(), p.getName(), p.getQuantity(), p.getPrice(), p.getDescription());
                        System.out.println(row);
                            }
                }
            }       
        }
        public void searchproducbyname(List<Product> PRODUCTS){
            if(0 == PRODUCTS.size()){
                System.out.println("null");
            }else{
                System.out.println("Nhập tên sản phẩm bạn muốn tìm: ");
                name = inputs.nextLine();
                for(Product p : App.PRODUCTS) {

                    if(p.getName().equalsIgnoreCase(name)){
                        System.out.println("Sản phẩm bạn vừa tìm là:");
                        String row = String.format("%d%15s%30d%15.2f%20s", p.getId(), p.getName(), p.getQuantity(), p.getPrice(), p.getDescription());
                        System.out.println(row);
                    }
                }
            }       

        }
        
        public void removeProduct() {
            Scanner scn = new Scanner(System.in);
    
            try {
                System.out.println("Nhập mã sản phẩm bạn muốn xóa: ");
                Integer id = scn.nextInt();
                Product pro = null;
    
                for (Product p : App.PRODUCTS) {
                    if (p.getId() == id) {
                        pro = p;
                        break;
                    }
                }
    
                if (pro == null) {
                    System.out.println("Mã sản phẩm không tồn tại. Xin vui lòng nhập lại!");
                }
    
                for (int i = 0; i < App.PRODUCTS.size(); i++) {
                    if (id.equals(App.PRODUCTS.get(i).getId())) {
    
                        App.PRODUCTS.remove(i);
    
                    }
                        System.out.println(">>>>>>>>>>Bạn đã xóa sản phẩm thành công<<<<<<<<<<<<<< ");
                }
    
            } catch (InputMismatchException ei) {
                System.out.println("Bạn đã nhập sai giá trị, xin vui lòng nhập lại!");
    
            }
        }

        public void sortProduct() {
            Product temp = App.PRODUCTS.get(0);
            System.out.println("Sắp xếp giảm dần theo giá tiền");
            
        
            for (int i = 0; i < App.PRODUCTS.size(); i++) {
                    for (int j = 0; j < App.PRODUCTS.size(); j++) {
                        if (App.PRODUCTS.get(i).getPrice() > App.PRODUCTS.get(j).getPrice()) {
                            temp = App.PRODUCTS.get(j);
                            App.PRODUCTS.set(j, App.PRODUCTS.get(i));
                            App.PRODUCTS.set(i, temp);
                        }
                        
                    }
                    show();
        
                }
             
        }
        
        
}
