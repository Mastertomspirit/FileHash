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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JSeparator;

import java.awt.Font;
import java.awt.Toolkit;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;

class Gui extends JFrame {

	private static final long serialVersionUID = 9221600233720303169L;
	private Controller controller;
	private JButton startHashingButton, fileChooseButton;
	private JComboBox<Algorithm> algoBox;
	private JLabel algoInfoLabel, shaInfoLabel, outputLabel, copiedLabel, checkPic, outputLabelGiven, fileInfoLabel, fileChooseLabel, versionInfoLabel;
	private JTextField hashInputField;
	private JMenuItem paste, delete;
	private JPopupMenu popup;
	private ImageIcon checkOk = new ImageIcon(Gui.class.getResource("/resources/ok_accept_128.png"));
	private ImageIcon checkNonOk = new ImageIcon(getClass().getClassLoader().getResource("resources/exit_close_error_128.png"));
	private ImageIcon waiting = new ImageIcon(getClass().getClassLoader().getResource("resources/my_computer_icon-128.png"));
	private Font font = new Font("Comic Sans MS", 1, 13);
	private Color fgColor = Color.white;
	private Color okColor = Color.green;

	public static final int WIDTH = 1100;
	public static final int HEIGHT = 640;
	
	public Gui(Controller controller) {
		this.controller = controller;
		initComponents();
		setVisible(true);
	}

	private void initComponents() {
		setTitle("File Hash");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Gui.WIDTH, Gui.HEIGHT);
		setLocale(Locale.getDefault());
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/resources/secure-shell-information_64.png")));
		setContentPane(new Background());
		getContentPane().addMouseListener(controller);
		
		checkPic = new JLabel("CheckPic");
		checkPic.setBounds(888, 11, 125, 125);
		checkPic.setIcon(waiting);
		getContentPane().add(checkPic);

		fileInfoLabel = new JLabel("Zu überprüfende Datei auswählen");
		fileInfoLabel.setBounds(10, 153, 313, 50);
		fileInfoLabel.setFont(font);
		fileInfoLabel.setForeground(fgColor);
		getContentPane().add(fileInfoLabel);
		
		fileChooseLabel = new JLabel("Downloads:");
		fileChooseLabel.setBounds(333, 161, 433, 35);
		fileChooseLabel.setFont(font);
		fileChooseLabel.setForeground(fgColor);
		getContentPane().add(fileChooseLabel);
		
		algoInfoLabel = new JLabel("Hash Algorithmus auswählen");
		algoInfoLabel.setBounds(10, 204, 313, 50);
		algoInfoLabel.setFont(font);
		algoInfoLabel.setForeground(fgColor);
		getContentPane().add(algoInfoLabel);
		
		shaInfoLabel = new JLabel("Referenz Hash");
		shaInfoLabel.setBounds(10, 265, 157, 50);
		shaInfoLabel.setFont(font);
		shaInfoLabel.setForeground(fgColor);
		getContentPane().add(shaInfoLabel);
		
		paste = new JMenuItem("einfügen");
		paste.setBackground(Color.BLACK);
		paste.setForeground(Color.GREEN);
		paste.setFont(font);
		paste.setPreferredSize(new Dimension(125, 25));
		paste.addActionListener(controller);
		
		delete = new JMenuItem("löschen");
		delete.setBackground(Color.BLACK);
		delete.setForeground(Color.GREEN);
		delete.setFont(font);
		delete.setPreferredSize(new Dimension(125, 25));
		delete.addActionListener(controller);
		
		popup = new JPopupMenu();
		popup.setLightWeightPopupEnabled(true);
		popup.setBorder(new BevelBorder(10, Color.BLACK, Color.RED));
		popup.setBackground(Color.RED);
		popup.setForeground(Color.BLACK);
		popup.add(paste);
		popup.add(new JSeparator());
		popup.add(delete);
				
		hashInputField = new JTextField();
		hashInputField.setBorder(new BevelBorder(BevelBorder.RAISED, Color.red, fgColor));
		hashInputField.setBounds(307, 277, 767, 28);
		hashInputField.setBackground(Color.black);
		hashInputField.setForeground(Color.green);
		hashInputField.setFont(font);
		hashInputField.setEditable(true);
		hashInputField.addMouseListener(controller);
		getContentPane().add(hashInputField);
		
		outputLabelGiven = new JLabel("Eingabe Hash");
		outputLabelGiven.setHorizontalAlignment(SwingConstants.CENTER);
		outputLabelGiven.setAlignmentX(Component.CENTER_ALIGNMENT);
		outputLabelGiven.setBounds(10, 414, 1064, 35);
		outputLabelGiven.setFont(font);
		outputLabelGiven.setForeground(fgColor);
		getContentPane().add(outputLabelGiven);
		
		outputLabel = new JLabel("Ausgabe Hash");
		outputLabel.setHorizontalAlignment(SwingConstants.CENTER);
		outputLabel.setAlignmentX(0.5f);
		outputLabel.setBounds(10, 460, 1064, 35);
		outputLabel.setFont(font);
		outputLabel.setForeground(fgColor);
		outputLabel.addMouseListener(controller);
		getContentPane().add(outputLabel);
		
		copiedLabel = new JLabel();
		copiedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		copiedLabel.setAlignmentX(0.5f);
		copiedLabel.setBounds(210, 490, 664, 35);
		copiedLabel.setFont(font.deriveFont(3));
		copiedLabel.setForeground(okColor);
		getContentPane().add(copiedLabel);
		
		startHashingButton = new JButton("Prüfsumme berechnen");
		startHashingButton.setBounds(888, 506, 186, 35);
		startHashingButton.addActionListener(controller);
		startHashingButton.setFont(font);
		getContentPane().add(startHashingButton);
	
		fileChooseButton = new JButton("Datei auswählen");
		fileChooseButton.setBounds(888, 161, 186, 35);
		fileChooseButton.addActionListener(controller);
		fileChooseButton.setFont(font);
		getContentPane().add(fileChooseButton);

		algoBox = new JComboBox<Algorithm>();
		algoBox.setModel(new DefaultComboBoxModel<Algorithm>(Algorithm.values()));
		algoBox.setBounds(888, 215, 186, 28);
		algoBox.setFont(font);
		algoBox.setSelectedItem(Algorithm.SHA256);
		algoBox.addMouseListener(controller);
		getContentPane().add(algoBox);
		
		versionInfoLabel = new JLabel("V 1.1.0 FileHash    @TomSpirit");
		versionInfoLabel.setFont(font.deriveFont(10f));
		versionInfoLabel.setBackground(null);
		versionInfoLabel.setForeground(Color.gray);
		versionInfoLabel.setBounds(10, 500, 200, 35);
		getContentPane().add(versionInfoLabel);
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
       SwingUtilities.updateComponentTreeUI(this);
	}
	
	void setCopiedLabel(String str) {
		copiedLabel.setText(str);
	}

	void setConfirmIcon(boolean valid) {
		if(valid) checkPic.setIcon(checkOk);
		else checkPic.setIcon(checkNonOk);
	}
	void setOutputLabelGiven(String label) {
		outputLabelGiven.setText(label);
		outputLabelGiven.setToolTipText(label);
	}
	void setOutputLabel(String label) {
		outputLabel.setText(label);
		outputLabel.setToolTipText(label);
	}
	void setFileChooseLabel(String label) {
		fileChooseLabel.setText(label);
		fileChooseLabel.setToolTipText(label);
	}
	Algorithm getAlgorithm() {
		return (Algorithm) algoBox.getSelectedItem();
	}
	JTextField getHashInputField() {
		return hashInputField;
	}
	JLabel getOutputLabel() {
		return outputLabel;
	}
	JButton getStartHashingButton() {
		return startHashingButton;
	}
	JButton getFileChooseButton() {
		return fileChooseButton;
	}
	JPopupMenu getPopup() {
		return popup;
	}
	JMenuItem getPaste() {
		return paste;
	}
	JMenuItem getDelete() {
		return delete;
	}
}
