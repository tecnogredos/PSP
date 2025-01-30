import com.medac.t14.MessageDigestAlgorithms;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 
 */
public class MessageDigestAlgorithmsTest {
    
    private static MessageDigestAlgorithms algoritmos;
    
    public MessageDigestAlgorithmsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        algoritmos = new MessageDigestAlgorithms();
    }
    
    @AfterClass
    public static void tearDownClass() {
        algoritmos = null;
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void test_Hash_MD2() {
        String resumenHas1 = algoritmos.hash_MD2("Hola");
        String resumenHas2 = algoritmos.hash_MD2("HolA");
        
        assertNotEquals(String.format("No deben ser iguales \\n", resumenHas1, resumenHas2),
                resumenHas1, resumenHas2);        
    }
    @Test
    public void test_Hash_MD5() {
        String resumenHas1 = algoritmos.hash_MD5("Hola");
        String resumenHas2 = algoritmos.hash_MD5("HolA");
        
        assertNotEquals(String.format("No deben ser iguales \\n", resumenHas1, resumenHas2),
                resumenHas1, resumenHas2);        
    }
    @Test
    public void test_Hash_SHA_1() {
        String resumenHas1 = algoritmos.hash_SHA_1("Hola");
        String resumenHas2 = algoritmos.hash_SHA_1("HolA");
        
        assertNotEquals(String.format("No deben ser iguales \\n", resumenHas1, resumenHas2),
                resumenHas1, resumenHas2);        
    }
    @Test
    public void test_Hash_SHA_256() {
        String resumenHas1 = algoritmos.hash_SHA_256("Hola");
        String resumenHas2 = algoritmos.hash_SHA_256("HolA");
        
        assertNotEquals(String.format("No deben ser iguales \\n", resumenHas1, resumenHas2),
                resumenHas1, resumenHas2);        
    }
    @Test
    public void test_Hash_SHA_512() {
        String resumenHas1 = algoritmos.hash_SHA_512("Hola");
        String resumenHas2 = algoritmos.hash_SHA_512("HolA");
        
        assertNotEquals(String.format("No deben ser iguales \\n", resumenHas1, resumenHas2),
                resumenHas1, resumenHas2);        
    }
}
