package egg;

import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Before;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Test;

import egg.Entidades.Cuenta;
import egg.Servicios.ServicioCuenta;


/**
 * Unit test for simple App.
 */
public class BancoTest
    //extends TestCase
{
    /**
     * Create the test case
     *
     */
    public BancoTest()    {
    }

ServicioCuenta sc;

    @BeforeClass
    public static void setUpClass() throws Exception {
        System.out.println("* BancoTest: @BeforeClass method");
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
        System.out.println("* BancoTest: @AfterClass method");
        
    }

    @Before
    public void setUp() {
        System.out.println("* BancoTest: @Before method, se inicializa un servicio cuenta");
        sc = new ServicioCuenta();
        
    }

    @After
    public void tearDown() {
        System.out.println("* BancoTest: @After method");
       
    }

    @Test
    public void deberiaInicializarBalanceCuenta() {
        assertNotNull(new Cuenta("admin","admin",true).getBalance());
    }

    @Test
    public void deberiaCrearCuentaAdmin() {
        assertNotNull(sc.crearAdmin());
    }

    @Test
    public void deberiaInicializarBalanceCuentaCero() {
        assertEquals(0, sc.crearAdmin().getBalance(), 0.0);

    }
}

