/*
 * This is the latest source code of Collective.
 * Minecraft version: 1.19.2, mod version: 4.51.
 *
 * Please don't distribute without permission.
 * For all Minecraft modding projects, feel free to visit my profile page on CurseForge or Modrinth.
 *  CurseForge: https://curseforge.com/members/serilum/projects
 *  Modrinth: https://modrinth.com/user/serilum
 */

package com.natamus.collective_fabric.functions;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFunctions {
	public static String ymdhisToReadable(String ymdhis) {
		DateFormat ymdhisformat = new SimpleDateFormat("yyyyMMddhhmmss");
		DateFormat readableformat = new SimpleDateFormat("yyyy/MM/dd, hh:mm:ss");
		
		try {
			return readableformat.format(ymdhisformat.parse(ymdhis));
		} catch (ParseException e) {
			return ymdhis;
		}
	}
	
	public static String getNowInYmdhis() {
		Date now = new Date();
		return new SimpleDateFormat("yyyyMMddhhmmss").format(now);
	}
}
