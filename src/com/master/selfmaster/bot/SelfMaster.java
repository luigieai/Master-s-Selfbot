package com.master.selfmaster.bot;

import java.awt.SystemTray;

import javax.security.auth.login.LoginException;

import com.master.selfmaster.bot.events.EventHandler;
import com.master.selfmaster.bot.util.TrayHandler;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class SelfMaster {

	private static String commandPrefix;
	private static CommandHandler commandHandler;
	private static JDA jda;
	private static TrayHandler trayHandler;
	private static EmojiHandler emojiHandler;

	public SelfMaster(String token) throws LoginException, IllegalArgumentException, InterruptedException, RateLimitedException {
		SelfMaster.jda = new JDABuilder(AccountType.CLIENT).setToken(token).buildBlocking();
		SelfMaster.commandPrefix = "$";
		SelfMaster.commandHandler = new CommandHandler();
		SelfMaster.emojiHandler = new EmojiHandler();
		SelfMaster.jda.addEventListener(new EventHandler());
		if (SystemTray.isSupported()) {
			SelfMaster.trayHandler = new TrayHandler();
			trayHandler.notificar("Master's Selfbot ativado!", "O bot foi inicializado com sucesso!");
		}
	}

	public JDA getJDA() {
		return jda;
	}

	public static String getCommandPrefix() {
		return commandPrefix;
	}

	public static CommandHandler getCommandHandler() {
		return commandHandler;
	}

	public static TrayHandler getTrayHandler() {
		return trayHandler;
	}

	public static EmojiHandler getEmojiHandler() {return  emojiHandler; }
}
