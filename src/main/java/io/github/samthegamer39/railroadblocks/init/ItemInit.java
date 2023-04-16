package io.github.samthegamer39.railroadblocks.init;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

import static io.github.samthegamer39.railroadblocks.RailroadBlocks.RAILROAD_BLOCKS;
import static io.github.samthegamer39.railroadblocks.init.BlockInit.*;

/**
 * A list of all mod items and stores them for registry with Minecraft.
 */
public class ItemInit {

    // Item List
    public static final Item FLAG_BLUE =
            new Item(new FabricItemSettings());

    public static final Item FLAG_GREEN =
            new Item(new FabricItemSettings());

    public static final Item FLAG_RED =
            new Item(new FabricItemSettings());

    public static final Item FLAG_YELLOW =
            new Item(new FabricItemSettings());

    public static final Item IRON_CROSSBUCK_ITEM =
            new BlockItem(IRON_CROSSBUCK_BLOCK, new FabricItemSettings());

    public static final Item IRON_POLE_ITEM =
            new BlockItem(IRON_POLE_BLOCK, new FabricItemSettings());

    public static final Item RXR_ADVANCE_SIGN_ITEM =
            new BlockItem(RXR_ADVANCE_SIGN_BLOCK, new FabricItemSettings());

    public static final Item WHISTLE_SIGN_ITEM =
            new BlockItem(WHISTLE_SIGN_BLOCK, new FabricItemSettings());

    public static final Item WOODEN_CROSSBUCK_ITEM =
            new BlockItem(WOODEN_CROSSBUCK_BLOCK, new FabricItemSettings());

    public static final Item WOODEN_POLE_ITEM =
            new BlockItem(WOODEN_POLE_BLOCK, new FabricItemSettings());

    /**
     * Registers items with Minecraft.
     */
    public static void RegisterItems() {
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "flag_blue"), FLAG_BLUE);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "flag_green"), FLAG_GREEN);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "flag_red"), FLAG_RED);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "flag_yellow"), FLAG_YELLOW);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "iron_crossbuck"), IRON_CROSSBUCK_ITEM);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "iron_pole"), IRON_POLE_ITEM);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "rxr_advance_sign"), RXR_ADVANCE_SIGN_ITEM);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "whistle_sign"), WHISTLE_SIGN_ITEM);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "wooden_crossbuck"), WOODEN_CROSSBUCK_ITEM);
        Registry.register(Registries.ITEM, new Identifier("railroadblocksaddon", "wooden_pole"), WOODEN_POLE_ITEM);

        ItemGroupEvents.modifyEntriesEvent(RAILROAD_BLOCKS).register(content -> {
            content.add(FLAG_BLUE);
            content.add(FLAG_GREEN);
            content.add(FLAG_RED);
            content.add(FLAG_YELLOW);
            content.add(IRON_CROSSBUCK_ITEM);
            content.add(IRON_POLE_ITEM);
            content.add(RXR_ADVANCE_SIGN_ITEM);
            content.add(WHISTLE_SIGN_ITEM);
            content.add(WOODEN_CROSSBUCK_ITEM);
            content.add(WOODEN_POLE_ITEM);
        });
    }

}
