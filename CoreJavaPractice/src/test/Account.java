package test;

import java.util.List;

public class Account {
	

    private String number;
    
    private String name;
    
    private List<Trade> trade;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Trade> getTrade() {
		return trade;
	}

	public void setTrade(List<Trade> trade) {
		this.trade = trade;
	}
    
    
    

}

class Trade{
	
	private String code;
	
    private double price;
    
    private String quantity;
    
    private String stock;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}
    
    
    
}
