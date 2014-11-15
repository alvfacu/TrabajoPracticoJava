package Negocio;

import java.io.Serializable;
import java.util.ArrayList;

import Entidades.Electrodomestico;
import Entidades.Television;
import Entidades.Lavarropas;
import Datos.ElectrodomesticoAdapter;;

public class ElectrodomesticoLogic implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
        return electroData.getTodosElectrodomesticos();
    }
    
    public void AddLavarropas()
    {
    	Save(new Lavarropas());
    }
    
    public void AddLavarropas(double precBase, double peso)
    {
    	Save(new Lavarropas(precBase,peso));
    }
    
    public void AddLavarropas(double precBase, double peso, String color, char consumo, double carga)
    {
    	Save(new Lavarropas(precBase, peso, color, consumo, carga));
    }
    
    public void AddTelevision()
    {
    	Save(new Television());
    }
    
    public void AddTelevision(double precBase, double peso)
    {
    	Save(new Television(precBase,peso));
    }
    
    public void AddTelevision(double precBase, double peso, String color, char consumo, double reso, boolean sint)
    {
    	Save(new Television(precBase, peso, color, consumo, reso, sint));
    }
    
    public void Save(Electrodomestico electro)
    {
    	getElectroData().addElectrodomestico(electro);
    }

    public void Delete(Electrodomestico electro)
    {
    	electroData.deleteElectrodomestico(electro);
    }    
}
