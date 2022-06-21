package io.github.samthegamer39.railroadblocks.init;

import io.github.samthegamer39.railroadblocks.RailroadBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static io.github.samthegamer39.railroadblocks.init.BlockInit.*;

public class ItemInit {

    public static final Item FLAG_GREEN =
            new Item(new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static final Item FLAG_RED =
            new Item(new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static final Item FLAG_YELLOW =
            new Item(new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static final Item IRON_CROSSBUCK_ITEM =
            new BlockItem(IRON_CROSSBUCK_BLOCK, new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static final Item IRON_POLE_ITEM =
            new BlockItem(IRON_POLE_BLOCK, new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static final Item RXR_ADVANCE_SIGN_ITEM =
            new BlockItem(RXR_ADVANCE_SIGN_BLOCK, new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static final Item WHISTLE_SIGN_ITEM =
            new BlockItem(WHISTLE_SIGN_BLOCK, new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static final Item WOODEN_CROSSBUCK_ITEM =
            new BlockItem(WOODEN_CROSSBUCK_BLOCK, new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static final Item WOODEN_POLE_ITEM =
            new BlockItem(WOODEN_POLE_BLOCK, new FabricItemSettings()
                    .group(RailroadBlocks.RAILROAD_BLOCKS));

    public static void RegisterItems() {
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "flag_green"), FLAG_GREEN);
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "flag_red"), FLAG_RED);
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "flag_yellow"), FLAG_YELLOW);
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "iron_crossbuck"), IRON_CROSSBUCK_ITEM);
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "iron_pole"), IRON_POLE_ITEM);
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "rxr_advance_sign"), RXR_ADVANCE_SIGN_ITEM);
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "whistle_sign"), WHISTLE_SIGN_ITEM);
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "wooden_crossbuck"), WOODEN_CROSSBUCK_ITEM);
        Registry.register(Registry.ITEM, new Identifier("railroadblocksaddon", "wooden_pole"), WOODEN_POLE_ITEM);
    }

}
