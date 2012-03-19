
package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
 
public class VarastoTest {
 
    Varasto varasto,varasto2,varasto3;
    double vertailuTarkkuus = 0.0001;
 
    @Before
    public void setUp() {
        varasto = new Varasto(10);
    }
    @Before
    public void setUpB() {
        varasto2 = new Varasto(-1,11);
    }
     @Before
    public void setUpB2() {
        varasto2 = new Varasto(-1,-1);
    }
      @Before
    public void setUpC() {
        varasto3 = new Varasto(-1);
    }
    @Test
    public void setUp2() {
        varasto = new Varasto(10,10);
        double saatuMaara = varasto.otaVarastosta(10);
        assertEquals(10,saatuMaara,vertailuTarkkuus);
    }
    @Test
    public void setUp3() {
        varasto = new Varasto(10,10);
        //double saatuMaara = varasto.otaVarastosta(10);
        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
 
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
 
    
    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);
 
        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
 @Test
    public void lisaysYliLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(18);
 
        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 0
        assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);
 
        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(2);
 
        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }
    @Test
    public void ottaminenAliPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);
 
        double saatuMaara = varasto.otaVarastosta(12);
 
        assertEquals(8, saatuMaara, vertailuTarkkuus);
    }
 
    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(2);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void YliottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);
 
        varasto.otaVarastosta(12);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 12 eli 14
        assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void AlleNollanOttaminen() {
        varasto.lisaaVarastoon(-1);
 
        //varasto.otaVarastosta(12);
 
        // varastossa pitäisi olla tilaa 10 - 8 + 12 eli 14
        //assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void AlleNollanOttaimnen() {
        double pois=varasto.otaVarastosta(-1);
        assertEquals(0,pois, vertailuTarkkuus);
        varasto.toString();
 
        // varastossa pitäisi olla tilaa 10 - 8 + 12 eli 14
        //assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void merkkijono() {
        varasto = new Varasto(10,10);
        String merkki=varasto.toString();
        //assertEquals("saldo = 10 , vielä tilaa 0",merkki);
        assertEquals("saldo2 = " + varasto.getSaldo() + ", vielä tilaa " + varasto.paljonkoMahtuu(),merkki);
        // varastossa pitäisi olla tilaa 10 - 8 + 12 eli 14
        //assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
}