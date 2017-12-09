package com.master.selfmaster.bot.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.master.selfmaster.bot.Command;
import com.master.selfmaster.bot.SelfMaster;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CmdEvento extends Command {

	/**
	 * Evento $evento [modo] [evento] [tag] [premio] [ganhadores]
	 */

	public CmdEvento() {
		this.name = "evento";
		this.description = "Evento especial pro dreamcraft";
		this.tipo = Tipo.DELETAR_E_ENVIAR;
	}

	@Override
	public void execute(String[] args, MessageReceivedEvent e) {
		if(args.length <= 4){
			if(args.length == 1 && args[0].equalsIgnoreCase("help") || args.length == 1 && args[0].equalsIgnoreCase("ajuda")){
				responder("Sintaxe: "+SelfMaster.getCommandPrefix() + "evento <modo de jogo> <evento> <tag> <premio> <ganhadores>"
						+ "\nO evento e o premio podem conter o caractere **_** para fazer um espaço!"
						+ "\nSe tiver mais de um ganhador, separe-os com o caractere **,**", e);
			}
			else {
				responder("Sintaxe errada! Digite " + SelfMaster.getCommandPrefix() + "evento ajuda", e);
			}
			return;
		}
		String modo = args[0];
		String evento = args[1].replace('_', ' ');
		String tag = args[2];
		String premio = args[3].replace('_', ' ');
		String ganhadores = args[4].replace(",", ", ");
		LocalDate da = LocalDate.now();
		DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM");
		String data = da.format(dataFormat);
		responder("Modo de Jogo: " + modo
				 +"\nEvento: " + evento 
				 +"\nData: "+data
				 +"\nTag: " + tag
				 +"\nPremio: " + premio
				 +"\nGanhadores: "+ganhadores,e);
	}
}
