package MyProject_MsHoa.QuanLyBanHang;

import java.util.Scanner;

public class Product {
    protected Integer id;
    protected String name;
    protected Integer quantity;
    protected String description;
    protected Float price;
   

    public Product() {
    }
    
    public Product(Integer id, String name, Integer quantity, String description, Float price ){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
    }
    
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Float getPrice(){
        return price = price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }
    public void show() {
    }
    public void insert(){
        Scanner inputs = new Scanner(System.in);
        System.out.println("Nhập thông tin sản phẩm: ");
        
        System.out.print("Mã: ");
        int id = inputs.nextInt();
            
        inputs.nextLine();

        System.out.println("Tên: ");
        String name = inputs.nextLine();

        System.out.println("Số lượng: ");
        int quantity = inputs.nextInt();

        inputs.nextLine();
            
        System.out.println("Ghi chú: ");
        String description = inputs.nextLine();
            
            
        System.out.println("Giá: ");
        Float price = inputs.nextFloat();

        Product p = new Product(id, name, quantity, description, price);
        App.PRODUCTS.add(p);
        
        
    }

    
}
