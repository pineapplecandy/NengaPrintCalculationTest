package nenga;

import java.time.LocalDate;

public class NengaPrintCalculation {

	public int calc(int requestedNumberOfCards, LocalDate requestDate) {
		int discountRate = discountRate(requestedNumberOfCards, requestDate);

		// By casting double to int, printPrice truncates decimal places
		int printPrice = (int) (50 * requestedNumberOfCards * (1 - discountRate / 100.0));
		int price = 2000 + 60 * requestedNumberOfCards + printPrice;
		return price;

	}

	private int discountRate(int requestedNumberOfCards, LocalDate requestDate) {
		boolean earlyFlag = requestDate.isBefore(LocalDate.of(2019, 12, 2));
		int earlyDiscountRate;
		if (earlyFlag == true)
			earlyDiscountRate = 20;
		else
			earlyDiscountRate = 0;
		int discountRate;

		if (requestedNumberOfCards >= 1001)
			discountRate = 15;

		else if (requestedNumberOfCards >= 101)
			discountRate = 5;
		else
			// default not discount
			discountRate = 0;

		return discountRate + earlyDiscountRate;
	}

}
