import com.chain.Chain;
import com.chain.FiftyChain;
import com.chain.HundreadChain;
import com.chain.ThousandChain;
import org.junit.Test;

public class ChainTest {

    @Test
    public void testThousand(){
        Chain chain = new ThousandChain(null);
       int num =  chain.dispense(1000);
        System.out.println(num);

    }

    @Test
    public void testHundered(){
        Chain chain = new HundreadChain(null);
        int num =  chain.dispense(1000);
        System.out.println(num);

    }

    @Test
    public void testFifty(){
        Chain chain = new FiftyChain(null);
        int num =  chain.dispense(1000);
        System.out.println(num);
    }

}
