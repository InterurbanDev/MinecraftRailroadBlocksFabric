package io.github.samthegamer39.railroadblocks;

import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static io.github.samthegamer39.railroadblocks.init.BlockInit.RegisterBlocks;
import static io.github.samthegamer39.railroadblocks.init.ItemInit.RegisterItems;

public class RailroadBlocks implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger("railroadblockaddon");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		RegisterBlocks();
		RegisterItems();
	}
}
