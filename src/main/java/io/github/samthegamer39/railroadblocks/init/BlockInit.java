package io.github.samthegamer39.railroadblocks.init;

import io.github.samthegamer39.railroadblocks.common.blocks.PoleBlock;
import io.github.samthegamer39.railroadblocks.common.blocks.SignBlock;
import io.github.samthegamer39.railroadblocks.common.blocks.SmallSignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

/**
 * A list of all mod blocks and stores them for registry with Minecraft.
 */
public class BlockInit {

    // Block List
    public static final SignBlock IRON_CROSSBUCK_BLOCK = new SignBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2f)
    );

    public static final PoleBlock IRON_POLE_BLOCK = new PoleBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2f)
    );

    public static final SignBlock RXR_ADVANCE_SIGN_BLOCK = new SignBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2f)
    );

    public static final SmallSignBlock WHISTLE_SIGN_BLOCK = new SmallSignBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2f)
    );

    public static final SignBlock WOODEN_CROSSBUCK_BLOCK = new SignBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1f)
    );

    public static final PoleBlock WOODEN_POLE_BLOCK = new PoleBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1f)
    );

    /**
     * Registers blocks with Minecraft.
     */
    public static void RegisterBlocks() {
        Registry.register(Registries.BLOCK, new Identifier("railroadblocksaddon", "iron_crossbuck"), IRON_CROSSBUCK_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("railroadblocksaddon", "iron_pole"), IRON_POLE_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("railroadblocksaddon", "rxr_advance_sign"), RXR_ADVANCE_SIGN_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("railroadblocksaddon", "whistle_sign"), WHISTLE_SIGN_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("railroadblocksaddon", "wooden_crossbuck"), WOODEN_CROSSBUCK_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier("railroadblocksaddon", "wooden_pole"), WOODEN_POLE_BLOCK);
    }

}
