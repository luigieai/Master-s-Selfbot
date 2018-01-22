package com.master.selfmaster.bot;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageEmbed;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public abstract class Command {

	protected String name;
	protected String description = "Sem descrição";
	protected Tipo tipo = Tipo.MANTER_E_ENVIAR;

	public abstract void execute(String[] args, MessageReceivedEvent e);

	/*
	 * Executa o comand
	 */
	public void run(String[] args, MessageReceivedEvent e) {
		// Se o tipo for editar original, manteremos
		if (tipo == Tipo.DELETAR_E_ENVIAR) {
			e.getMessage().delete().queue();
		}
			execute(args,e);
	}

	/*
	 * Repostas (para facilitar)
	 */

	protected void responder(String resposta, MessageReceivedEvent e) {
		if (tipo == Tipo.EDITAR_ORIGINAL) {
			e.getMessage().editMessage(resposta).queue();
		}
		else {
			e.getChannel().sendMessage(resposta).queue();
		}
	}
	
	protected void responder(MessageEmbed resposta, MessageReceivedEvent e) {
		if (tipo == Tipo.EDITAR_ORIGINAL) {
			e.getMessage().editMessage(resposta).queue();
		}
		else {
			e.getChannel().sendMessage(resposta).queue();
		}
	}
	
	protected void responder(Message resposta, MessageReceivedEvent e) {
		if (tipo == Tipo.EDITAR_ORIGINAL) {
			e.getMessage().editMessage(resposta).queue();
		}
		else {
			e.getChannel().sendMessage(resposta).queue();
		}
	}


	// O que fazer quando o comando for ativado
	public enum Tipo {
		DELETAR_E_ENVIAR, EDITAR_ORIGINAL, MANTER_E_ENVIAR;
	}


	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Tipo getTipo() {
		return tipo;
	}
	
	
}
