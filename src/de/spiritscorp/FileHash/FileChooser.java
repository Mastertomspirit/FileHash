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

import java.awt.Dimension;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

import javax.swing.JFileChooser;

class FileChooser extends JFileChooser {

	private static final long serialVersionUID = -4898558758203521262L;
	private final int width = 1000, height = 500;

	FileChooser(Path currentPath) {	
		if(currentPath != null && Files.exists(currentPath)) {
			setCurrentDirectory(currentPath.toFile());
		}else {
			setCurrentDirectory(new File(System.getProperty("user.home")));
		}
		setLocale(Locale.getDefault());
		setPreferredSize(new Dimension(width, height));
		setDialogTitle("Datei oder Verzeichnis auswählen");
		setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		setMultiSelectionEnabled(false);
		setAcceptAllFileFilterUsed(true);
			
		showDialog(FileChooser.this, "Auswählen");
	}
}
