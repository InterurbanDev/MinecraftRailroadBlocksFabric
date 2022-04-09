package io.github.samthegamer39.railroadblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.samthegamer39.railroadblocks.init.BlockInit.RegisterBlocks;
import static io.github.samthegamer39.railroadblocks.init.BlockInit.WOODEN_CROSSBUCK_BLOCK;
import static io.github.samthegamer39.railroadblocks.init.ItemInit.RegisterItems;

public class RailroadBlocks implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("railroadblockaddon");

	public static final ItemGroup RAILROAD_BLOCKS = FabricItemGroupBuilder.create(
			new Identifier("railroadblocksaddon", "general"))
			.icon(() -> new ItemStack(WOODEN_CROSSBUCK_BLOCK))
			.build();

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		RegisterBlocks();
		RegisterItems();
	}
}
