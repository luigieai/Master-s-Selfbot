package com.master.selfmaster.bot.util;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrayHandler {

	private SystemTray tray;
	private TrayIcon trayIcon;
	public TrayHandler(){
		this.tray = SystemTray.getSystemTray();
		Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/res/icon.png"));
		//Menuzin
		PopupMenu  sysMenu = new PopupMenu();
		trayIcon = new TrayIcon(img, "Master's SelfBot",sysMenu);
		trayIcon.setImageAutoSize(true);
		MenuItem sair = new MenuItem("Sair");
		sair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				tray.remove(trayIcon);
				System.exit(0);
			}
		});
		sysMenu.add(sair);
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	public void notificar(String titulo,String msg){
		trayIcon.displayMessage(titulo, msg, MessageType.INFO);
	}
}
