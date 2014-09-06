package Negocio;


import Datos.ConsumoAdapter;

public class ConsumoLogic {
	
	private ConsumoAdapter consumoData;

    public ConsumoLogic()
    {
    	consumoData = new ConsumoAdapter();
    }
    
    public ConsumoAdapter getConsumoData()
    {
    	return consumoData;
    }

    public Character[] getLetras()
    {
    	return new ConsumoAdapter().getLetras();
    }

}
