
import com.medac.t13.ExpresionesRegulares;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author
 */
public class TestEpresionesRegulares {

    private static ExpresionesRegulares exp;
    private static List<String> listaDniIncorrectos;
    private static List<String> listaDniCorrectos;
    private static List<String> listaTelfIncorrectos;
    private static List<String> listaTelfCorrectos;

    public TestEpresionesRegulares() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Se ejecuta ...setUpClass...");
        System.out.println("\tCreo los recursos necesarios");
        System.out.println("\tCreando clase y Lista de textos ...");
        exp = new ExpresionesRegulares();
        listaDniIncorrectos = new ArrayList<>();
        listaDniIncorrectos.add("1234567T");
        listaDniIncorrectos.add("1234567t");
        listaDniIncorrectos.add("12345678-T");
        listaDniIncorrectos.add("12345678-t");
        listaDniIncorrectos.add("12345678t");
        
        listaDniCorrectos = new ArrayList<>();
        listaDniCorrectos.add("12345678T");
        listaDniCorrectos.add("11111111W");
        listaDniCorrectos.add("00112211F");
        
        listaTelfIncorrectos = new ArrayList<>();
        listaTelfIncorrectos.add("+35123456789");
        listaTelfIncorrectos.add("123456789_");
        listaTelfIncorrectos.add("+34123456789_");
        listaTelfIncorrectos.add("aa123456789");
        
        listaTelfCorrectos = new ArrayList<>();
        listaTelfCorrectos.add("+34952843185");
        listaTelfCorrectos.add("952843185");
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Se ejecuta ...tearDownClass...");
        System.out.println("\tBorro, cierro conexión, etc...");
        exp = null;
        listaDniIncorrectos = null;
    }

    @Before
    public void setUp() {
        System.out.println("/////...setUp.../////");

    }

    @After
    public void tearDown() {
        System.out.println("/////...tearDown.../////");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    @Test(expected = IllegalArgumentException.class)
    public void compruebaParametroEntradaVacio() {
        System.out.println("Ejecutando test .... compruebaParametroEntradaVacio");
        exp.validaDNI("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void compruebaParametroEntradaNull() {
        System.out.println("Ejecutando test .... compruebaParametroEntradaNull");
        exp.validaDNI(null);
    }

    @Test
    public void compruebaValidaDNI_Incorrectos() {
        System.out.println("Ejecutando test .... compruebaValidaDNI_Incorrectos");
        String dni;
        for (int i=0; i < listaDniIncorrectos.size(); i++) {
            dni = (String)listaDniIncorrectos.get(i);
            assertFalse("DNI (" + dni + ") es incorrecto", exp.validaDNI(dni));
            System.out.println("DNI (" + dni + ") es incorrecto");
        }
    }
    @Test
    public void compruebaValidaDNI_Correctos() {
        System.out.println("Ejecutando test .... compruebaValidaDNI_Correctos");
        String dni;
        for (int i=0; i < listaDniCorrectos.size(); i++) {
            dni = (String)listaDniCorrectos.get(i);
            assertTrue("DNI (" + dni + ") es Correcto", exp.validaDNI(dni));
            System.out.println("DNI (" + dni + ") es CORRECTO");
        }
    }
    @Test
    public void compruebaValidaTelf_Incorrectos() {
        System.out.println("Ejecutando test .... compruebaValidaTelf_Incorrectos");
        String telf;
        for (int i=0; i < listaTelfIncorrectos.size(); i++) {
            telf = (String)listaTelfIncorrectos.get(i);
            assertFalse("Telefono (" + telf + ") es Incorrecto", exp.validaTelefono(telf));
            System.out.println("Telefono (" + telf + ") es Incorrecto");
        }
    }
    @Test
    public void compruebaValidaTelf_Correctos() {
        System.out.println("Ejecutando test .... compruebaValidaTelf_Correctos");
        String telf;
        for (int i=0; i < listaTelfCorrectos.size(); i++) {
            telf = (String)listaTelfCorrectos.get(i);
            assertTrue("Telefono (" + telf + ") es Correcto", exp.validaTelefono(telf));
            System.out.println("Telefono (" + telf + ") es CORRECTO");
        }
    }

}
