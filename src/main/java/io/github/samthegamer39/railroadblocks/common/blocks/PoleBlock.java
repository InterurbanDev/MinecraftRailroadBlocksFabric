package io.github.samthegamer39.railroadblocks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class PoleBlock extends Block {

    public PoleBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("deprecation") //Why is getOutlineShape()? deprecated? Is there a better alternative?
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.cuboid(0.4375, 0.0, 0.4375, 0.5625, 1.0, 0.5625);
    }

}
