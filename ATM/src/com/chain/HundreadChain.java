package com.chain;

import com.enums.Currency;

public class HundreadChain extends Chain {
	private Chain next;

	public HundreadChain(Chain next) {
		this.next = next;
	}

	@Override
	public Integer dispense(int money) {
		int availableNotes = atm.getAvailableDenominationCount(Currency.HUNDREAD);
		int num = 0;
		if (money >= 100 && availableNotes > 0) {
			 num = money / 100;
			int rem = 0;
			if (availableNotes < num) {
				rem = money % 100 + (num - availableNotes) * 100;
				num = availableNotes;
			} else {
				rem = money % 100;
			}
			atm.setBalance(atm.getBalance() - (100 * num));
			atm.setTotalWithdraw(atm.getTotalWithdraw() + (100 * num));
			System.out.println("Dispensing " + num + " notes of 100 RS");
			atm.deuctCurrency(Currency.HUNDREAD, num);
			if (rem > 0) {
				next.dispense(rem);
			}
		} else {
			next.dispense(money);
		}
		return num;
	}
}
