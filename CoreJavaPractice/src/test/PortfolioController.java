package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

//@Controller
// ("/portfolio")
public class PortfolioController {
	
	
	//@GetMapping("/StockList", respone = "application/json")
	public List<String> getStocksFromPortfolio(){
		List<String> stocksList = new ArrayList<String>();

		Finance finance = new  Finance();
		
		
		List<Account> accounts = finance.getPortfolio().getAccounts();
		
		
		if (null != accounts && accounts.size() >0) {
			for (Account account : accounts) {
				List<Trade> trades = account.getTrade();		
				
				if (null != trades && trades.size() >0) {
	
					for (Trade trade : trades) {
	
						stocksList.add(trade.getStock())	;
					
				}
			}
		}
		}
		
	
		stocksList = Optional.ofNullable(finance.getPortfolio())
					.map(Portfolio::getAccounts)
					.orElse(Collections.emptyList())
				.stream().filter(Objects::nonNull)
				.flatMap( account -> Optional.ofNullable(account.getTrade())
											.orElse(Collections.emptyList())
											.stream())
				.filter(Objects::nonNull)
				.map(Trade ::getStock)
				.collect(Collectors.toList());
				
	
		return stocksList;
	
	}


}
