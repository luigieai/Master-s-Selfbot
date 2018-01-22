package com.master.selfmaster.bot.commands;

import com.master.selfmaster.bot.Command;
import com.master.selfmaster.bot.SelfMaster;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 * Mostra os emojis
 */
public class CmdEmojis extends Command {

    public CmdEmojis() {
        this.name = "emoji";
        this.description = "Mostra os emojis disponiveis!";
        this.tipo = Tipo.EDITAR_ORIGINAL;
    }

    @Override
    public void execute(String[] args, MessageReceivedEvent e) {
        StringBuilder sb = new StringBuilder();
        sb.append("Emojis: \n");
        for(String key : SelfMaster.getEmojiHandler().getEmojis().keySet()){
            sb.append(key + " - " + SelfMaster.getEmojiHandler().getEmojis().get(key));
            sb.append("\n");
        }
        responder(sb.toString(),e);
    }
}
