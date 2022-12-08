/*
 * This is the latest source code of Pumpkillager's Quest.
 * Minecraft version: 1.19.3, mod version: 2.3.
 *
 * Please don't distribute without permission.
 * For all Minecraft modding projects, feel free to visit my profile page on CurseForge or Modrinth.
 *  CurseForge: https://curseforge.com/members/serilum/projects
 *  Modrinth: https://modrinth.com/user/serilum
 *  Overview: https://serilum.com/
 *
 * If you are feeling generous and would like to support the development of the mods, you can!
 *  https://ricksouth.com/donate contains all the information. <3
 *
 * Thanks for looking at the source code! Hope it's of some use to your project. Happy modding!
 */

package com.natamus.pumpkillagersquest.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestData {
    public static final String questbookOneNbtString = "{Count:1b,id:\"minecraft:written_book\",tag:{pages:['[\"\",{\"text\":\"The Quest\",\"underlined\":true},{\"text\":\"\\\\n\\\\nYou have accepted the Pumpkillager\\'s quest. Make sure that you\\'re prepared. You might need extra food and armour to make it through to the end of the quest. When you\\'re ready, gather the materials shown on the next page.\\\\n \",\"color\":\"reset\"}]','[\"\",{\"text\":\"The Ritual\",\"underlined\":true},{\"text\":\"\\\\n\\\\nFor the summoning ritual you\\'ll need 16 redstone and one tnt.\\\\n\\\\nPlace the redstone in the 7x7 pattern shown on the next page, with the TNT in the middle.\",\"color\":\"reset\"}]','[\"\",{\"text\":\"The Shape\",\"underlined\":true},{\"text\":\"\\\\n\\\\nPlace the redstone in the following shape, with a TNT in the middle:\\\\n\\\\n     \",\"color\":\"reset\"},{\"text\":\"_ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\" _ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_\",\"color\":\"#FCF6E9\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\" _ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_ _\",\"color\":\"#FCF6E9\"},{\"text\":\" R R R\",\"color\":\"red\"},{\"text\":\" _ _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"R\",\"color\":\"red\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\" T\",\"color\":\"dark_gray\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_\",\"color\":\"#FCF6E9\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\" R R R\",\"color\":\"red\"},{\"text\":\" _ _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_\",\"color\":\"#FCF6E9\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\" _ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\" R\",\"color\":\"red\"},{\"text\":\" _ _ _\",\"color\":\"#FCF6E9\"}]','[\"\",{\"text\":\"The Summoning\",\"underlined\":true},{\"text\":\"\\\\n\\\\nLight the TNT. The blast combined with the power of the shaped redstone should do the trick.. probably.\\\\n \",\"color\":\"reset\"}]'],title:\"Pumpkillager's Quest\",author:\"The Pumpkillager\"}}";
    public static final String questOneStoppingPumpkillagerBookNbtString = "{Count:1b,id:\"minecraft:written_book\",tag:{pages:['[\"\",{\"text\":\"The Pumpkillager\",\"underlined\":true},{\"text\":\"\\\\n\\\\nIf you\\'re reading this, it means that the Pumpkillager has been set loose on the world. This book with its knowledge has been passed down through generations in order to stop him.\\\\n \", \"color\":\"reset\"}]','[\"\",{\"text\":\"The Ritual\",\"underlined\":true},{\"text\":\"\\\\n\\\\nFor the summoning ritual you\\'ll need 16 candles and one pumpkin. Make sure it is night-time.\\\\n\\\\nPlace the candles in the 7x7 pattern shown on the next page, with the pumpkin in the middle. The candles have to be lit.\", \"color\":\"reset\"}]','[\"\",{\"text\":\"The Shape\",\"underlined\":true},{\"text\":\"\\\\n\\\\nPlace the lit candles in the following shape, with a pumpkin in the middle:\\\\n\\\\n     \", \"color\":\"reset\"},{\"text\":\"_ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\" _ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_\",\"color\":\"#FCF6E9\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\" _ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_ _\",\"color\":\"#FCF6E9\"},{\"text\":\" C C C\",\"color\":\"red\"},{\"text\":\" _ _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"C\",\"color\":\"red\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\" P\",\"color\":\"gold\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_\",\"color\":\"#FCF6E9\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\" C C C\",\"color\":\"red\"},{\"text\":\" _ _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_\",\"color\":\"#FCF6E9\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\" _ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\" _\",\"color\":\"#FCF6E9\"},{\"text\":\"\\\\n     \",\"color\":\"reset\"},{\"text\":\"_ _ _\",\"color\":\"#FCF6E9\"},{\"text\":\" C\",\"color\":\"red\"},{\"text\":\" _ _ _\",\"color\":\"#FCF6E9\"}]','[\"\",{\"text\":\"The Summoning\",\"underlined\":true},{\"text\":\"\\\\n\\\\nCompleting the ritual should draw in the Pumpkillager. To weaken him, you\\'ll need to shoot a spectral arrow at his feet. This will make him vulnerable to normal attacks. Good luck, for the sake of the whole world.\\\\n \",\"color\":\"reset\"}]'],title:\"Stopping the Pumpkillager\",author:\"Jax o\'Saturn\"}}";
    public static final List<Integer> questOneRitualBlockPositions = new ArrayList<Integer>(Arrays.asList(3, 8, 12, 16, 17, 18, 21, 23, 25, 27, 30, 31, 32, 36, 40, 45));
    public static final String questOneCoordinatePaperPrefix = "Prisoner Coordinates: ";
}
