package vitu.modao;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vitu.modao.item.ModItemGroups;
import vitu.modao.item.ModItems;

public class Modaomod implements ModInitializer {
	public static final String MOD_ID = "modaomod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}