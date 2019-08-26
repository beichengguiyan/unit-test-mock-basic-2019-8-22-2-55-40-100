package cashregister;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class CashRegisterTest {


    @Test
    public void should_print_the_real_purchase_when_call_process() {
        //given
    	Item item = new Item("test product",1);
    	Item[] items = {item};
    	Purchase purchase = new Purchase(items);
    	MockPrice mockPrice = new MockPrice();
    	CashRegister cashRegister = new CashRegister(mockPrice);
        //when
    	cashRegister.process(purchase);
    	String printString = mockPrice.getPrintString();
        //then
    	Assertions.assertEquals("test product\t1.0\n",printString);
    }

//    @Test
//    public void should_print_the_stub_purchase_when_call_process() {
//        //given
//        //when
//        //then
//    }
//
//    @Test
//    public void should_verify_with_process_call_with_mockito() {
//        //given
//        //when
//        //then
//    }

}
