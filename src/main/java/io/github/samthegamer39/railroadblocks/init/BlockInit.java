package io.github.samthegamer39.railroadblocks.init;

import io.github.samthegamer39.railroadblocks.common.blocks.PoleBlock;
import io.github.samthegamer39.railroadblocks.common.blocks.SignBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ToolItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockInit {

    public static final SignBlock WOODEN_CROSSBUCK_BLOCK = new SignBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1)
            .sounds(BlockSoundGroup.WOOD)
    );

    public static final SignBlock IRON_CROSSBUCK_BLOCK = new SignBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2)
            .sounds(BlockSoundGroup.METAL)
    );

    public static final SignBlock RXR_ADVANCE_SIGN_BLOCK = new SignBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2)
            .sounds(BlockSoundGroup.METAL)
    );

    public static final PoleBlock WOODEN_POLE_BLOCK = new PoleBlock(FabricBlockSettings.of(Material.WOOD)
            .strength(1)
            .sounds(BlockSoundGroup.WOOD)
    );

    public static final PoleBlock IRON_POLE_BLOCK = new PoleBlock(FabricBlockSettings.of(Material.METAL)
            .strength(2)
            .sounds(BlockSoundGroup.METAL)
    );

    public static void RegisterBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("railroadblocksaddon", "wooden_crossbuck"), WOODEN_CROSSBUCK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("railroadblocksaddon", "iron_crossbuck"), IRON_CROSSBUCK_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("railroadblocksaddon", "rxr_advance_sign"), RXR_ADVANCE_SIGN_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("railroadblocksaddon", "wooden_pole"), WOODEN_POLE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier("railroadblocksaddon", "iron_pole"), IRON_POLE_BLOCK);
    }

}
