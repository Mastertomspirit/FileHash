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

enum Algorithm {

	MD5 ("MD5"),
	SHA ("SHA"),
	SHA256 ("SHA-256"),
	SHA384 ("SHA384"),
	SHA512 ("SHA-512"), 
	SHA3_256 ("SHA3-256"),
	SHA3_384 ("SHA3-384"),
	SHA3_512 ("SHA3-512");

	String algo;
	
	Algorithm(String algo) {
		this.algo = algo;
	}

	String getValue() {
		return algo;
	}
	
	static String[] getValues() {
		Algorithm[] al = Algorithm.values();
		String[] ret = new String[al.length];
		for(int i = 0; i < al.length; i++) {
			ret[i] = al[i].getValue();
		}
		return ret;
	}
}
