package sistema.organizaciones;

import org.junit.Before;
import org.junit.Test;
import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.ubicacion.ZonaDeCobertura;

import static org.mockito.Mockito.*;

public class OrganizacionTest {

    Muestra muestraMock;
    ZonaDeCobertura zonaDeCoMock;
    Ubicacion ubicacionMock;
    TipoDeOrg tipoMock;
    Organizacion orgDePrueba;
    FuncionalidadExterna funcExtM;
    FuncionalidadExterna funcExtV;

    @Before
    public void setUp() {
        muestraMock = mock(Muestra.class);
        zonaDeCoMock = mock(ZonaDeCobertura.class);
        ubicacionMock = mock(Ubicacion.class);
        tipoMock = mock(TipoDeOrg.class);

        funcExtM = mock(FuncionalidadExterna.class);
        funcExtV = mock(FuncionalidadExterna.class);

        orgDePrueba = spy(new Organizacion(ubicacionMock, tipoMock, 15, funcExtM, funcExtV));
    }

    @Test
    public void eventoNuevaMuestraTest(){
        orgDePrueba.eventoNuevaMuestra(muestraMock, zonaDeCoMock);
        verify(funcExtM).nuevoEvento(orgDePrueba, zonaDeCoMock, muestraMock);
    }

    @Test
    public void eventoNuevaValidacionTest(){
        orgDePrueba.eventoNuevaValidacion(muestraMock, zonaDeCoMock);
        verify(funcExtV).nuevoEvento(orgDePrueba, zonaDeCoMock, muestraMock);
    }

    @Test
    public void suscribirseAZona() {
        orgDePrueba.suscribirseAZona(zonaDeCoMock);
        verify(zonaDeCoMock).suscribirA(orgDePrueba);
    }

    @Test
    public void deSuscribirseDe() {
        orgDePrueba.deSuscribirseDe(zonaDeCoMock);
        verify(zonaDeCoMock).desuscribirA(orgDePrueba);
    }

}