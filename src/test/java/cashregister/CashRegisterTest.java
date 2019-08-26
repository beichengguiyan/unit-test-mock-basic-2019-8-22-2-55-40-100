package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class CashRegisterTest {

	private static 	MockPrice mockPrice;
	private static 	CashRegister cashRegister;
	
	
@BeforeAll
private static void setup() {
	mockPrice = new MockPrice();
	cashRegister = new CashRegister(mockPrice);
}
		
	
    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
    	Item item = new Item("test product",1);
    	Item[] items = {item};
    	Purchase purchase = new Purchase(items);

        //when
    	cashRegister.process(purchase);
    	String printString = mockPrice.getPrintString();
        //then
    	Assertions.assertEquals("test product\t1.0\n",printString);
    }

    @Test
    public void should_print_the_stub_purchase_when_call_process() {
        //given
    	StubPurchase stubPurchase = new StubPurchase();
        //when
    	cashRegister.process(stubPurchase);
        //then
    	Assertions.assertEquals("test product\t1.0\n",mockPrice.getPrintString());
    }

    @Test
    public void should_verify_with_process_call_with_mockito() {
        //given
    	Printer printer = Mockito.mock(Printer.class);
    	Purchase purchase = Mockito.mock(Purchase.class);
    	Mockito.when(purchase.asString()).thenReturn("test product");
    	
        //when
    	
    	CashRegister cashRegister = new CashRegister(printer);
    	cashRegister.process(purchase);
        //then
    	Mockito.verify(printer).print("test product");
    	
    }

}
