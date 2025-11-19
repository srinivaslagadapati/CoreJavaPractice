package test;


/**
 * 
 * {
"portfolio": {
 "id": 100,
 "name": "myPortfolio",
 "action" : "Buy",
 "totalPrice": 0,
 "accounts": [
   {
     "number": 101,
     "name": "xyz",
     "trade": [
       {
         "code": "Buy",
         "price": 101.99,
         "quantity": 100,
         "stock": "DELL"
       },
       {
         "code": "Buy",
         "price": 99,
         "quantity": 200,
         "stock": "IBM"
       }
     ]
   },
 
   {
     "number": 102,
     "name": "xyz",
     "trade": [
       {
         "code": "Buy",
         "price": 101.34,
         "quantity": 10,
         "stock": "SCHW"
       },
       {
         "code": "Sell",
         "price": 9,
         "quantity": 201,
         "stock": "X"
       }
     ]
   }
 ]
}
}
 
 */
public class Finance {
	
	private Portfolio portfolio;

	public Portfolio getPortfolio() {
		return portfolio;
	}

	public void setPortfolio(Portfolio portfolio) {
		this.portfolio = portfolio;
	}
	
	

}
