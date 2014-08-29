package Datos;

import java.util.ArrayList;

import Entidades.Electrodomestico;

public class ElectrodomesticoAdapter {
	
	private static ArrayList<Electrodomestico> _Electrodomestico;	
	
	private static ArrayList<Electrodomestico> getElectrodomestico()
    {
        if (_Electrodomestico == null)
            {
        		_Electrodomestico = new ArrayList<Electrodomestico>();
        	
        		Entidades.Electrodomestico lava;
                lava = new Entidades.Lavarropas(100, 30, "rojo", 'F', 100);
                _Electrodomestico.add(lava);
                
                lava = new Entidades.Lavarropas(100, 600, "violeta", 'F', 100);
                _Electrodomestico.add(lava);
                
                Entidades.Electrodomestico tv;
                tv = new Entidades.Television(99, 90, "Negro", 'A', 99, true);
                _Electrodomestico.add(tv);
                
                tv = new Entidades.Television();
                _Electrodomestico.add(tv);                
            }
            return _Electrodomestico;
    }

    public ArrayList<Electrodomestico> GetAll()
    {
        return new ArrayList<Electrodomestico>(getElectrodomestico());
    }

    public Electrodomestico GetOne(Electrodomestico electro)
    {
        int ID = _Electrodomestico.indexOf(electro);
    	return _Electrodomestico.get(ID);
    }

    public void Delete(Electrodomestico electro)
    {
    	_Electrodomestico.remove(electro);
    }

    public void Save(Electrodomestico el)
    {
        	getElectrodomestico().add(el);
    }    

}
