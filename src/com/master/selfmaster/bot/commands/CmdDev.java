package com.master.selfmaster.bot.commands;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.master.selfmaster.bot.Command;

import net.dv8tion.jda.core.entities.ChannelType;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CmdDev extends Command {

	public CmdDev() {
		this.name = "dev";
		this.description = "Cmd teste para o desenvolvedor!";
		this.tipo = Tipo.MANTER_E_ENVIAR;

	}

	@Override
	public void execute(String[] args, MessageReceivedEvent e) {
		// Pegar a data e hora atual
		LocalDate data = LocalDate.now();
		LocalTime hora = LocalTime.now();
		DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter horaFormat = DateTimeFormatter.ofPattern("HH:mm", new Locale("pt", "BR"));
		String h = hora.format(horaFormat);
		String d = data.format(dataFormat);
		
		//Pegar o server/pessoa atual
			String sv = "";
			if(e.getChannelType() == ChannelType.PRIVATE){
				sv = "Esse é um chat privado! Você esta conversando com a bela companhia de: **"+e.getPrivateChannel().getUser().getAsMention() + "**";
			}else{
				sv = "Você esta no adoravel chat: **#" + e.getChannel().getName() + "**";
			}
		// Manda msg
		responder("-------------------------------------"
				+ "\nComando do MasterSelfBot ativado!\nOlá " + e.getJDA().getSelfUser().getName() +", como vai?"
				+ "\nHoje é dia "+ d +"\nO horario atual é: "+ h
				+ "\n" + sv
				+ "\n**Feito por Luigi!**"
				+ "\n-------------------------------------",e);
	}
}
