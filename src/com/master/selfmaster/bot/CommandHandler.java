package com.master.selfmaster.bot;

import java.util.ArrayList;
import java.util.List;

import com.master.selfmaster.bot.commands.CmdDev;
import com.master.selfmaster.bot.commands.CmdEvento;
import com.master.selfmaster.bot.commands.CmdReport;

public class CommandHandler {

	private List<Command> commands;
	
	public CommandHandler(){
		this.commands = new ArrayList<Command>();
		addCommand(new CmdDev());
		addCommand(new CmdReport());
		addCommand(new CmdEvento());
	}
	
	public void addCommand(Command c){
		this.commands.add(c);
	}
	
	public List<Command> getCommands(){
		return commands;
	}
	
}
