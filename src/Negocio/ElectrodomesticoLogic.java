package Negocio;

import java.util.ArrayList;

import Entidades.Electrodomestico;
import Entidades.Television;
import Entidades.Lavarropas;
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
    	
    	getElectroData().Save(electro);
    }

    public void Delete(Electrodomestico electro)
    {
    	electroData.Delete(electro);
    }    

}
