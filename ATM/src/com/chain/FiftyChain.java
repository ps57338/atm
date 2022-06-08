package com.chain;

import com.enums.Currency;

public class FiftyChain extends Chain {

	private Chain next;

	public FiftyChain(Chain next) {
		this.next = next;
	}

	@Override
	public Integer dispense(int money) {
		int availableNotes = atm.getAvailableDenominationCount(Currency.FIFTY);
		int num=0;
		if (money >= 50 && availableNotes > 0) {
			 num = money / 50;
			int rem = 0;
			if (availableNotes < num) {
				rem = money % 50 + (num - availableNotes) * 50;
				num = availableNotes;
			} else {
				rem = money % 50;
			}
			System.out.println("Dispensing " + num + " notes of 50 RS");
			atm.deuctCurrency(Currency.FIFTY, num);
			atm.setBalance(atm.getBalance() - (50 * num));
			atm.setTotalWithdraw(atm.getTotalWithdraw() + (50 * num));
			if (rem > 0) {
				next.dispense(rem);
			}
		} else {
			next.dispense(money);
		}
return num;
	}
}
