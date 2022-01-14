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

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.JPanel;

class Background extends JPanel{

	private static final long serialVersionUID = 8925287342002919173L;
	private String[] images = new String[] {
			"/resources/wallpapertip_colorful-smoke-wallpaper_315681.jpg",
			"/resources/wallpapertip_colorful-smoke-wallpaper_315778.jpg",
			"/resources/wallpapertip_smoke-wallpaper_1052662.jpg",
			"/resources/wallpapertip_smoke-wallpaper-hd_1509609.jpg",
			"/resources/wallpapertip_smoke-wallpaper-hd_64871.jpg",
			"/resources/wallpapertip_smoke-wallpaper-hd_64874.jpg",
			"/resources/wallpapertip_smoke-wallpaper-hd_64875.jpg",
	};
	private Image icon;
	private int rand = new Random().nextInt(images.length);
	
	Background()  {
		icon = getToolkit().getImage(getClass().getResource(images[rand]));
		setLayout(null);
		setBackground(null);
		setDoubleBuffered(true);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(icon, 0, 0, Gui.WIDTH, Gui.HEIGHT, null);
		repaint();
	}	
}
