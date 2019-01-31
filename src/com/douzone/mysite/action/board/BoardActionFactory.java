package com.douzone.mysite.action.board;

import com.douzone.mvc.action.AbstractActionFactory;
import com.douzone.mvc.action.Action;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("write".equals(actionName))
		{
			action = new WriteAction();
		}
		else if("writeform".equals(actionName))
		{
			action = new WriteFormAction();
		}
		else if("replyform".equals(actionName))
		{
			action = new ReplyFormAction();
		}
		else if("view".equals(actionName))
		{
			action = new BoardViewAction();
		}
		else if("delete".equals(actionName))
		{
			action = new DeleteAction();
		}
		else if("modifyform".equals(actionName))
		{
			action = new ModifyFormAction();
		}
		else if("modify".equals(actionName))
		{
			action = new ModifyAction();
		}
		else if("message".equals(actionName))
		{
			action = new MessageAction();
		}
		else if("deletemessage".equals(actionName))
		{
			action = new DeleteMessageAction();
		}
		else
		{
			action = new BoardAction();
		}
		
		return action;
	}

}
