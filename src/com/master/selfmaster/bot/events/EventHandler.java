package com.master.selfmaster.bot.events;

import java.util.Arrays;

import com.master.selfmaster.bot.Command;
import com.master.selfmaster.bot.EmojiHandler;
import com.master.selfmaster.bot.SelfMaster;

import com.master.selfmaster.bot.util.TrayHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class EventHandler extends ListenerAdapter {

	@Override
	public void onMessageReceived(MessageReceivedEvent e) {
		// Selfbot apenas podem responder apenas conta que esta utilizando-o
		if (e.getAuthor().equals(e.getJDA().getSelfUser())) {
			// Verifica se tem o prefix de comando do bot
			if (e.getMessage().getRawContent().startsWith(SelfMaster.getCommandPrefix())) {
				// Tira o prefix do comando, e monta os args
				String msg = e.getMessage().getRawContent().substring(1);
				String[] args = msg.split(" ");
				String cmd = args[0];
				args = Arrays.copyOfRange(args, 1, args.length);
				// Checa se o cmd existe, se sim executa
				for (Command cmds : SelfMaster.getCommandHandler().getCommands()) {
					if (cmd.equalsIgnoreCase(cmds.getName())) {
						cmds.run(args, e);
						break; // Se teoricamente n�o pode ter comandos com nomes iguais, para que continuar o loop?
					}
				}
			}else{
				String newMsg = e.getMessage().getRawContent();
				boolean modify = false;
				for(String key : SelfMaster.getEmojiHandler().getEmojis().keySet()){
					if(newMsg.contains(key)){
						newMsg = newMsg.replace(key, SelfMaster.getEmojiHandler().getEmojis().get(key));
						modify = true;
					}
				}
				if(modify)
					e.getMessage().editMessage(newMsg).queue();
			}
		}
	}
}
