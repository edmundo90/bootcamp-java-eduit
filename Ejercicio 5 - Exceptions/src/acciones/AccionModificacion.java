package acciones;
import interfaces.*;

import entidades.*;
import exceptions.GetArtByIdException;
import exceptions.UpdateException;
import interfaces.IAccion;
import db.*;

public class AccionModificacion implements IAccion{

	@Override
	public void exec(Articulo ctx) {
		
		Articulo art;
		try {
			art = InMemoryDB.getById(ctx.getId());
		} catch (GetArtByIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//System.out.println("Ingrese titulo nuevo");
		
		if(ctx != null) {
			try {
				InMemoryDB.update(ctx.getId(), ctx);
			} catch (UpdateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
