package nenga;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NengaPrintCalculationTest {

	NengaPrintCalculation target = new NengaPrintCalculation();

	@Nested
	class _2019年12月2日以降に注文したとき {

		LocalDate standardRequestDate = LocalDate.of(2019, 12, 2);

		@Nested
		class _1_100枚はプリント料金合計は割引なし {

			@Test
			void _1枚の時の金額() {
				int price = target.calc(1, standardRequestDate);
				assertEquals(2110, price);
			}

			@Test
			void _2枚の時の金額() {
				int price = target.calc(2, standardRequestDate);
				assertEquals(2220, price);
			}

			@Test
			void _100枚の時の金額() {
				int price = target.calc(100, standardRequestDate);
				assertEquals(13000, price);
			}
		}

		@Nested
		class _101_1000枚はプリント料金合計は5パーセントオフ {

			@Test
			void _101枚の時の金額() {
				int price = target.calc(101, standardRequestDate);
				assertEquals(12857, price);
			}

			@Test
			void _1000枚の時の金額() {
				int price = target.calc(1000, standardRequestDate);
				assertEquals(109500, price);
			}
		}

		@Nested
		class _1001枚以上はプリント料金合計は15パーセントオフ {

			@Test
			void _1001枚の時の金額() {
				int price = target.calc(1001, standardRequestDate);
				assertEquals(104602, price);
			}

			@Test
			void _1000000枚の時の金額() {
				int price = target.calc(1_000_000, standardRequestDate);
				assertEquals(102_502_000, price);
			}

		}

	}

	@Nested
	class _2019年12月1日までに注文したとき {

		LocalDate earlyRequestDate = LocalDate.of(2019, 12, 1);

		@Test
		void _1枚の時の金額() {
			int price = target.calc(1, earlyRequestDate);
			assertEquals(2100, price);
		}

		@Test
		void _101枚の時の金額() {
			int price = target.calc(101, earlyRequestDate);
			assertEquals(11847, price);
		}

		@Test
		void _1001枚の時の金額() {
			int price = target.calc(1001, earlyRequestDate);
			assertEquals(99597, price);
		}

	}

}
