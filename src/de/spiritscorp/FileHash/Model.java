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

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class Model {
	
	/**
	 * 
	 * @param destPath
	 * @param algorithm
	 * @return	String 
	 */
	String getHash(Path destPath, String algorithm){
		MessageDigest messageDigest;
		StringBuffer sb = new StringBuffer();
		try(InputStream is = Files.newInputStream(destPath)){
			messageDigest = MessageDigest.getInstance(algorithm);
			byte[] input;
			while(is.available() != 0) {
				input = is.readNBytes(51200);
				messageDigest.update(input);
			}
			byte[] digest = messageDigest.digest();
			for(byte b : digest) {
				sb.append(Integer.toString((b&0xff) + 0x100,16).substring(1));
			}
		}catch(IOException | NoSuchAlgorithmException e) {e.printStackTrace();}
		return sb.toString();
	}
}
