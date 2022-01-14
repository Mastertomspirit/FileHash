/*
		Copyright (c) 2022 Tom Spirit
		
		This program is free software; you can redistribute it and/or modify
		it under the terms of the GNU General Public License as published by
		the Free Software Foundation; either version 3 of the License, or
		(at your option) any later version.
		
		This program is distributed in the hope that it will be useful,
		but WITHOUT ANY WARRANTY; without even the implied warranty of
		MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
		GNU General Public License for more details.
		
		You should have received a copy of the GNU General Public License
		along with this program; if not, write to the Free Software Foundation,
		Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package de.spiritscorp.FileHash;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Controller implements ActionListener, MouseListener {

	private Gui gui;
	private Controller controller;
	private Model model;
	private Path path;
	
	Controller(){
		controller = this;
		EventQueue.invokeLater(()->{
			gui = new Gui(controller);
		});
		model = new Model();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		gui.getPopup().setVisible(false);
		
		if(e.getSource() == gui.getFileChooseButton()) {
			try {			
				path = new FileChooser(Paths.get(System.getProperty("user.home"),"Downloads")).getSelectedFile().toPath();
				if(Files.exists(path))	gui.setFileChooseLabel(path.toString());
				else path = null;
			}catch(NullPointerException ex) {}
		}
		
		if(e.getSource() == gui.getStartHashingButton()) {
			if(path != null) {
				String hashInput = gui.getHashInputField().getText().trim();
				String hashOutput = model.getHash(path, gui.getAlgorithm().getValue());
				if(hashInput.length() != hashOutput.length())		gui.getHashInputField().setText("			Falscher Eingabe Hash");
				gui.setOutputLabelGiven(hashInput);
				gui.setOutputLabel(hashOutput);
				gui.setConfirmIcon(hashInput.equals(hashOutput));
			}
		}
		
		if(e.getSource() == gui.getPaste()) {
			Clipboard sys = Toolkit.getDefaultToolkit().getSystemClipboard();
			String str = "";
			try {
				str = (String) sys.getData(DataFlavor.stringFlavor);
			} catch (UnsupportedFlavorException | IOException e1) {e1.printStackTrace();}
			gui.getHashInputField().setText(str);
		}
		
		if(e.getSource() == gui.getDelete()) {
			gui.getHashInputField().setText("");
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		gui.getPopup().setVisible(false);
		if(e.getSource() == gui.getHashInputField()) {
			if(e.getButton() == 3) {
				gui.getPopup().setLocation(e.getXOnScreen() + 15, e.getYOnScreen() + 15);
				gui.getPopup().setVisible(true);
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
}
