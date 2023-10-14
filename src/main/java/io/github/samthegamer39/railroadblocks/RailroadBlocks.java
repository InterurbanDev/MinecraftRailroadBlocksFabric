package io.github.samthegamer39.railroadblocks;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.github.samthegamer39.railroadblocks.init.BlockInit.RegisterBlocks;
import static io.github.samthegamer39.railroadblocks.init.BlockInit.WOODEN_CROSSBUCK_BLOCK;
import static io.github.samthegamer39.railroadblocks.init.ItemInit.*;
import static io.github.samthegamer39.railroadblocks.init.ItemInit.RegisterItems;

/**
 * Main class for the RailroadBlocks mod. Initializes the mod and adds all associated blocks and items to Minecraft.
 */
public class RailroadBlocks implements ModInitializer {

	// Global Variables
	public static final Logger LOGGER = LoggerFactory.getLogger("railroadblockaddon"); // Debugging logger
	public static final ItemGroup RAILROAD_BLOCKS = FabricItemGroup.builder() // Creates an ItemGroup for the mod.
			.displayName(Text.translatable("itemGroup.railroadblocksaddon.general"))
			.icon(() -> new ItemStack(WOODEN_CROSSBUCK_BLOCK))
			.entries((context, entries) -> {
				entries.add(FLAG_BLUE);
				entries.add(FLAG_GREEN);
				entries.add(FLAG_RED);
				entries.add(FLAG_YELLOW);
				entries.add(IRON_CROSSBUCK_ITEM);
				entries.add(IRON_POLE_ITEM);
				entries.add(RXR_ADVANCE_SIGN_ITEM);
				entries.add(WHISTLE_SIGN_ITEM);
				entries.add(WOODEN_CROSSBUCK_ITEM);
				entries.add(WOODEN_POLE_ITEM);
			})
			.build();

	/**
	 * This function initializes the mod and registers all blocks and items to the game.
	 */
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		RegisterBlocks();
		RegisterItems();
		Registry.register(Registries.ITEM_GROUP, new Identifier("railroadblocksaddon", "general"), RAILROAD_BLOCKS);
		LOGGER.info("Railroad Blocks successfully loaded.");
	}
}
