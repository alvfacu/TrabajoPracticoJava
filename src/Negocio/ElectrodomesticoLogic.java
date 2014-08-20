package Negocio;

import java.util.ArrayList;

import Entidades.Electrodomestico;
import Datos.ElectrodomesticoAdapter;;

public class ElectrodomesticoLogic {
	
	private ElectrodomesticoAdapter electroData;

    public ElectrodomesticoLogic()
    {
    	electroData = new ElectrodomesticoAdapter();
    }
    
    public ElectrodomesticoAdapter getElectroData()
    {
    	return electroData;
    }

    public ArrayList<Electrodomestico> GetAll()
    {
        return electroData.GetAll();
    }

    public Electrodomestico GetOne(Electrodomestico electro)
    {
        return electroData.GetOne(electro);
    }

    public void Delete(Electrodomestico electro)
    {
    	electroData.Delete(electro);
    }

    public void Save(Electrodomestico electro)
    {
    	getElectroData().Save(electro);
    }

}
