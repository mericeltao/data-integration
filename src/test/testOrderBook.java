import OrderBook.Order;
import OrderBook.OrderBook;
import OrderBook.Side;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class testOrderBook {

	@Test
	void placeOneAsk() {
		// Init and checking start conditions
		OrderBook testSubject = new OrderBook();
		assertEquals(0, testSubject.asks.size());
		assertEquals(0, testSubject.bids.size());
		assertEquals(-1f, testSubject.bestAskPrice);
		assertEquals(-1f, testSubject.bestBidPrice);
		assertEquals(0f, testSubject.sittingVolume);
		// Operation
		Order newAsk = new Order(10.2f, 1.5f, Side.ASK, 1677539237L);
		testSubject.placeOrder(newAsk);
		// Checking Operation
		assertEquals(1, testSubject.asks.size());
		assertEquals(0, testSubject.bids.size());
		assertEquals(10.2f, testSubject.asks.getFirst().price);
		assertEquals(1.5f, testSubject.asks.getFirst().size);
		assertEquals(1677539237L, testSubject.asks.getFirst().createdTs);
		assertEquals(10.2f, testSubject.bestAskPrice);
		assertEquals(-1f, testSubject.bestBidPrice); // Should be unaffected
		assertEquals(1.5f, testSubject.sittingVolume);
	}

	@Test
	void placeOneBid() {
		// Init and checking start conditions
		OrderBook testSubject = new OrderBook();
		assertEquals(0, testSubject.asks.size());
		assertEquals(0, testSubject.bids.size());
		assertEquals(-1f, testSubject.bestAskPrice);
		assertEquals(-1f, testSubject.bestBidPrice);
		assertEquals(0f, testSubject.sittingVolume);
		// Operation
		Order newAsk = new Order(3.39f, 0.25f, Side.BID, 1677541289L);
		testSubject.placeOrder(newAsk);
		// Checking Operation
		assertEquals(0, testSubject.asks.size());
		assertEquals(1, testSubject.bids.size());
		assertEquals(3.39f, testSubject.bids.getFirst().price);
		assertEquals(0.25f, testSubject.bids.getFirst().size);
		assertEquals(1677541289L, testSubject.bids.getFirst().createdTs);
		assertEquals(-1f, testSubject.bestAskPrice); // Should be unaffected
		assertEquals(3.39f, testSubject.bestBidPrice);
		assertEquals(0.25f, testSubject.sittingVolume);
	}
}