package com.master.selfmaster;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import javax.security.auth.login.LoginException;
import javax.swing.JOptionPane;

import com.master.selfmaster.bot.SelfMaster;

import net.dv8tion.jda.core.exceptions.RateLimitedException;

public class Core {

	public static void main(String[] args) throws IOException {
		if (!fileExist("config.properties")) {
			OutputStream out = new FileOutputStream("config.properties");
			Properties prop = new Properties();
			prop.setProperty("token", "seutoken");
			prop.store(out, null);
			out.close();
			showDialog("Foi detectado que não há nenhum arquivo de configuração!"
					+ "\nNa pasta desse arquivo foi criado um 'config.properties', por favor, configurar o bot la");
			return;
		}
		InputStream input = new FileInputStream("config.properties");
		Properties prop = new Properties();
		prop.load(input);
		input.close();
		if (prop.getProperty("token") == null) {
			showDialog("Não foi achado um token na config.properties");
			return;
		}
		String token = prop.getProperty("token");
		try {
			new SelfMaster(token);
		} catch (LoginException e) {
			showDialog("Não foi possivel fazer o login, verifique seu token em config.properties!");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (RateLimitedException e) {
			e.printStackTrace();
		}
	}

	private static void showDialog(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}

	private static boolean fileExist(String nome) {
		File f = new File(nome);
		return f.exists() && !f.isDirectory();
	}
}
