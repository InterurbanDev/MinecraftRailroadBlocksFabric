package io.github.samthegamer39.railroadblocks.common.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

public class SmallSignBlock extends HorizontalFacingBlock implements Waterloggable {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public SmallSignBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false)); //Sets default waterlogged state to false.
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(Properties.HORIZONTAL_FACING, WATERLOGGED);
    }

    @SuppressWarnings("deprecation") //Why is getOutlineShape()? deprecated? Is there a better alternative?
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        return switch (direction) {
            case NORTH -> VoxelShapes.cuboid(0.25, 0.0, 0.375, 0.75, 0.9375, 0.5625); //4, 0, 6, 12, 15, 9
            case SOUTH -> VoxelShapes.cuboid(0.25, 0.0, 0.4375, 0.75, 0.9375, 0.625); //4, 0, 7, 12, 15, 10
            case EAST -> VoxelShapes.cuboid(0.4375, 0.0, 0.25, 0.625, 0.9375, 0.75); //7, 0, 4, 10, 15, 12
            case WEST -> VoxelShapes.cuboid(0.375, 0.0, 0.25, 0.5625, 0.9375, 0.75); //6, 0, 4, 9, 15, 12
            default -> VoxelShapes.fullCube();
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState()
                .with(Properties.HORIZONTAL_FACING, context.getPlayerFacing().getOpposite())
                .with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER); //Sets waterlogged state based on the presence of water.
    }

    @SuppressWarnings("deprecation")
    @Override//Why is getFluidState() deprecated? Is there a better alternative?
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state); //Displays water when waterlogged.
    }

    @SuppressWarnings("deprecation") //Why is getStateForNeighborUpdate deprecated? Is there a better alternative?
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos position, BlockPos neighborPos){
        if (state.get(WATERLOGGED)) {
            //1.18+ Versions
            world.createAndScheduleFluidTick(position, Fluids.WATER, Fluids.WATER.getTickRate(world));
            //1.17 and Older Versions
            //world.getFluidTickScheduler().schedule(position, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, position, neighborPos);
    }
}
