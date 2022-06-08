import com.service.ATM2;
import org.junit.Test;

public class AtmStateTest {

    @Test
    public void testAtmState(){
        ATM2 atm2 = ATM2.getATM();
        atm2.insertDebitCard();
        System.out.println(atm2.getState());

    }
}
