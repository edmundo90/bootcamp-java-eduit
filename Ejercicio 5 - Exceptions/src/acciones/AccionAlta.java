package acciones;

import entidades.*;
import exceptions.SaveException;
import interfaces.IAccion;
import db.*;
public class AccionAlta implements IAccion {

	@Override
	public void exec(Articulo ctx) {

		//usa la base de datos en memoria
		try {
			InMemoryDB.save(ctx.getId(), ctx);
		} catch (SaveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
