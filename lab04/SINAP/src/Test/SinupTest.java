package test;

import aplicacion.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class SinupTest
{
	@Test
	public void debeAdicionar() throws SINAPExcepcion
	{
		Sinap sinap = new Sinap();
		Area[] areas={new Area("Parque nacional del Chicamocha","Chicamocha national park", "San Gil","264.000" , 
	        "Es un parque temático de reciente creación, es uno de los pocos parques naturales de Colombia dedicados al ecoturismo, siendo por tanto uno de los sitios turísticos más importantes del país"+
            " Propender por la recuperación del modelo hidráulico del complejo lagunar CGSM en el área del Santuario,"+
            " Fue abierto al público el sábado 2 de diciembre de 2006."+
            " El Parque comprende un conjunto urbanístico conformado por diferentes elementos y lugares que representan la cultura santandereana."),
            new Area( "Valle de Cocora","Cocora valley", "Quindio","1.200 km²",
            "Parque natural"+
            " paisaje natural localizado en la cordillera central de los Andes colombianos, específicamente en el departamento del Quindío, en el área de influencia del Parque nacional natural Los Nevados."+
            "Cuenta con algunas poblaciones del árbol nacional de Colombia, la palma de cera del Quindío (Ceroxylon quindiuense), así como de una gran variedad de flora y fauna,  "+
            "así como de una gran variedad de flora y fauna, mucha de ella en peligro de extinción, protegida bajo el estatus de parque nacional natural."+
            "El valle, así como la localidad cercana de Salento, se ubican entre los principales destinos turísticos de Colombia.")
			};
		for(Area ar:areas)
		{
			sinap.adicioneDetalles(ar);
			assertEquals(ar,sinap.getDetalles(ar.getNombre(),ar.getName()));
		}
	}
	@Test
	public void debeListar() throws SINAPExcepcion
	{
		Sinap sinap = new Sinap();
		Area[] areas={new Area("Parque nacional del Chicamocha","Chicamocha national park", "San Gil","264.000" , 
	        "Es un parque temático de reciente creación, es uno de los pocos parques naturales de Colombia dedicados al ecoturismo, siendo por tanto uno de los sitios turísticos más importantes del país"+
            " Propender por la recuperación del modelo hidráulico del complejo lagunar CGSM en el área del Santuario,"+
            " Fue abierto al público el sábado 2 de diciembre de 2006."+
            " El Parque comprende un conjunto urbanístico conformado por diferentes elementos y lugares que representan la cultura santandereana."),
            new Area( "Valle de Cocora","Cocora valley", "Quindio","1.200 km²",
            "Parque natural"+
            " paisaje natural localizado en la cordillera central de los Andes colombianos, específicamente en el departamento del Quindío, en el área de influencia del Parque nacional natural Los Nevados."+
            "Cuenta con algunas poblaciones del árbol nacional de Colombia, la palma de cera del Quindío (Ceroxylon quindiuense), así como de una gran variedad de flora y fauna,  "+
            "así como de una gran variedad de flora y fauna, mucha de ella en peligro de extinción, protegida bajo el estatus de parque nacional natural."+
            "El valle, así como la localidad cercana de Salento, se ubican entre los principales destinos turísticos de Colombia.")
			};
		StringBuffer answer=new StringBuffer();
		for(Area ar:areas)
		{
			sinap.adicioneDetalles(ar);
			answer.append(ar.toString());
			answer.append('\n');
			answer.append('\n');
			assertEquals(answer.toString(),sinap.toString());
		}
	}
	@Test 
	public void nodebeTenerNombreNulo() throws SINAPExcepcion
	{
		Sinap sinap = new Sinap();
		
		try
		{
			sinap.adicione("Tuparro","","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeñoscaños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocascristalinas en forma de cerros redondeados.");		
		}catch(SINAPExcepcion e)
		{
			assertEquals(SINAPExcepcion.AREA_NULA,e.getMessage());
		}
	}
	@Test
	public void nodebeTenerRepetidos() throws SINAPExcepcion
	{
		Sinap sinap = new Sinap();
		try
		{
			sinap.adicione("Tuparro","","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeñoscaños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocascristalinas en forma de cerros redondeados.");
			sinap.adicione("Tuparro","","Vichada","548.000","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeñoscaños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocascristalinas en forma de cerros redondeados.");
		}catch(SINAPExcepcion e)
		{
			assertEquals(SINAPExcepcion.AREA_REPETIDA,e.getMessage());
		}
	}
	@Test
	public void areaDeberiaSerMayorAcero() throws SINAPExcepcion
	{
		Sinap sinap= new Sinap();
		try
		{
			sinap.adicione("Tuparro","","Vichada","-10","Es una extensa sabana verde surcada por grandes ríos con potentes raudales y playas doradas, pequeñoscaños de aguas cristalinas, bosques de galería, morichales y saladillales, además de enormes rocascristalinas en forma de cerros redondeados.");
		}catch(SINAPExcepcion e)
		{
			assertEquals(SINAPExcepcion.AREA_INVALIDA,e.getMessage());
		}
		
	}
	
}
