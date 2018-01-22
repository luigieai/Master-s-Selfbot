package com.master.selfmaster.bot.commands;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.master.selfmaster.bot.Command;
import com.master.selfmaster.bot.SelfMaster;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CmdReport extends Command {

	/*
	 * Report
	 *  $report <nome> <puni??o> <modo de jogo> <prova> <motivo>
	 */
	
	public CmdReport() {
		this.name = "report";
		this.description = "Report especial pro dreamcraft";
		this.tipo = Tipo.DELETAR_E_ENVIAR;
	}
	
	@Override
	public void execute(String[] args, MessageReceivedEvent e) {
		if(args.length <= 4){
			if(args.length == 1 && args[0].equalsIgnoreCase("help") || args.length == 1 && args[0].equalsIgnoreCase("ajuda")){
				responder("Sintaxe: "+SelfMaster.getCommandPrefix() + "report <nome> <punição> <modo de jogo> <prova> <motivo>"
						+ "\nO motivo pode conter espaço, o resto não!", e);
			}else{
				responder("Sintaxe errada! Digite "+SelfMaster.getCommandPrefix()+"report ajuda",e);
			}
		}else{
			String nome = args[0];
			String pun = args[1];
			String modo = args[2];
			String prova = args[3];
			String motivo = "";
			LocalDate da = LocalDate.now();
			DateTimeFormatter dataFormat = DateTimeFormatter.ofPattern("dd/MM");
			String data = da.format(dataFormat);
			if(args.length == 5){
				motivo = args[4];
			}else{
				StringBuilder sb = new StringBuilder();
				for(int i = 4; i< args.length;i++){
					sb.append(args[i] + " ");
				}
				motivo = sb.toString();
			}
			responder("Nome: " + nome
					 +"\nPunição: " + pun
					 +"\nModo de jogo: "+modo
					 +"\nMotivo: " + motivo
					 +"\nProva: " + prova
					 +"\nData: "+data,e);
		}
	}
}
