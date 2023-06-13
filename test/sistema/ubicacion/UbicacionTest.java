package sistema.ubicacion;

import org.junit.Assert;
import org.junit.Test;
import sistema.muestras.Muestra;
import sistema.ubicacion.Ubicacion;
import sistema.usuario.Usuario;
import sistema.webSite.Website;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UbicacionTest {

    Ubicacion ubi1 = new Ubicacion(7, 4);
    Ubicacion ubi2 = new Ubicacion(1, 2);
    Ubicacion ubi3 = new Ubicacion(52, 34);
    Ubicacion ubi4 = new Ubicacion(10, 14);
    Ubicacion ubi5 = new Ubicacion(52, 81);
    Ubicacion ubi6 = new Ubicacion(2, 19);

    ArrayList<Ubicacion> arrayDeUbi = new ArrayList<Ubicacion>(Arrays.asList(ubi1,ubi2,ubi3,ubi4,ubi5,ubi6));

    Usuario user = mock(Usuario.class);
    Muestra muestra = mock(Muestra.class);
    Website website = mock(Website.class);

    ArrayList<Muestra> muchasMuestras = new ArrayList<Muestra>(Arrays.asList(muestra,muestra,muestra,muestra));


    @Test
    public void distanciaHastaTest1(){
        assertEquals(ubi1.distanciaHasta(ubi2),6.32, 0.32);
        assertEquals(ubi2.distanciaHasta(ubi1),6.32, 0.32);
    }

    @Test
    public void distanciaHastaTest2(){
        assertEquals(ubi3.distanciaHasta(ubi1),54.08 , 0.01d);
        assertEquals(ubi1.distanciaHasta(ubi3),54.08 , 0.01d);
    }

    @Test
    public void aquellasAXKmsTest1(){
        assertEquals(1 , ubi1.aquellasAMenosDeXKm(arrayDeUbi, 1).size());
        assertEquals(3, ubi1.aquellasAMenosDeXKm(arrayDeUbi, 15).size());
    }

    @Test
    public void aquellasAXKmsTest2(){
        assertEquals(1 , ubi5.aquellasAMenosDeXKm(arrayDeUbi, 1).size());
        assertEquals(2 , ubi5.aquellasAMenosDeXKm(arrayDeUbi, 50).size());
    }

    @Test
    public void muestrasAMenosDeXKm(){
        when(muestra.getAutor()).thenReturn(user);
        when(user.dondeEstaRegistrado()).thenReturn(website);
        when(website.todasLasMuestras()).thenReturn(muchasMuestras);
        when(muestra.getUbicacion()).thenReturn(ubi1,ubi2,ubi3,ubi4,ubi5);
        assertEquals(2, (ubi1.muestrasAMenosDeXKm(muestra,15)).size());
    }

}
