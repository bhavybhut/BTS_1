package admin;

import org.zkoss.zk.ui.Component;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zul.Combobox;

public class StoreComponent extends GenericForwardComposer
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Combobox desig;
	
	@SuppressWarnings("unchecked")
	public void doAfterCompose(Component comp) throws Exception
	{
		super.doAfterCompose(comp);
		comp.getFellowIfAny("desig");
	}
}
