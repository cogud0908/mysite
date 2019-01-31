package com.douzone.mysite.action.guestbook;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;
import com.douzone.mysite.action.main.IndexAction;

public class GuestBookActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("insert".equals(actionName))
		{
			action = new InsertAction();
		} 
		else if("delete".equals(actionName))
		{
			action = new DeleteAction();
		}
		else if("deleteform".equals(actionName))
		{
			action = new DeleteFormAction();
		}
		else
		{
			action = new GuestBookAction();
		}
		
		return action;
	}

}