package io.github.samthegamer39.railroadblocks.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class SignBlock extends HorizontalFacingBlock {

    public SignBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING);
    }

    @SuppressWarnings("deprecation") //Why is getOutlineShape()? deprecated? Is there a better alternative?
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        return switch (direction) {
            case NORTH -> VoxelShapes.cuboid(0.0625, 0.0, 0.375, 0.9375, 0.9375, 0.5625);
            case SOUTH -> VoxelShapes.cuboid(0.0625, 0.0, 0.4375, 0.9375, 0.9375, 0.625);
            case EAST -> VoxelShapes.cuboid(0.4375, 0.0, 0.0625, 0.625, 0.9375, 0.9375);
            case WEST -> VoxelShapes.cuboid(0.375, 0.0, 0.0625, 0.5625, 0.9375, 0.9375);
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState().with(Properties.HORIZONTAL_FACING, context.getPlayerFacing().getOpposite());
    }

}
