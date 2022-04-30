package acciones;

import entidades.*;
import exceptions.DeleteException;
import interfaces.IAccion;
import db.*;
public class AccionBaja implements IAccion {
	
	@Override
	public void exec(Articulo ctx) {
		
		//dar de baja por id
		try {
			InMemoryDB.delete(ctx.getId());
		} catch (DeleteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Se ha elminado el articulo de id:" + ctx.getId());
	}

}
