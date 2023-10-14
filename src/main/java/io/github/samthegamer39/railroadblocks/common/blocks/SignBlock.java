package io.github.samthegamer39.railroadblocks.common.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

/**
 * This class is designed for use with blocks which have a sign facing in one direction.
 */
public class SignBlock extends HorizontalFacingBlock implements Waterloggable {

    // Global Variables
    private static final DirectionProperty HORIZONTAL_FACING = Properties.HORIZONTAL_FACING;
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    /**
     * Constructor for blocks using the SignBlock class. These blocks have two properties, HORIZONTAL_FACING and WATERLOGGED.
     * @param settings Settings
     */
    public SignBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState()
                .with(HORIZONTAL_FACING, Direction.NORTH)
                .with(WATERLOGGED, false)); // Sets default waterlogged state to false.
    }

    /**
     * Adds the block's properties.
     * @param stateManager StateManager
     */
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(HORIZONTAL_FACING, WATERLOGGED);
    }

    /**
     * Gets the current WATERLOGGED state, presumably.
     * @param state Current block's state
     * @return Returns the current WATERLOGGED state, presumably.
     */
    @SuppressWarnings("deprecation") // Why is getFluidState() deprecated? Is there a better alternative?
    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state); //Displays water when waterlogged.
    }

    /**
     * Controls the outline of blocks using this class.
     * @param state Current block's state
     * @param view BlockView
     * @param pos Current position
     * @param context ShapeContext
     * @return Direction
     */
    @SuppressWarnings("deprecation") // Why is getOutlineShape()? deprecated? Is there a better alternative?
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        return switch (direction) {
            case NORTH -> VoxelShapes.cuboid(0.0625, 0.0, 0.375, 0.9375, 0.9375, 0.5625); //1, 0, 6, 15, 15, 9
            case SOUTH -> VoxelShapes.cuboid(0.0625, 0.0, 0.4375, 0.9375, 0.9375, 0.625); //1, 0, 7, 15, 15, 10
            case EAST -> VoxelShapes.cuboid(0.4375, 0.0, 0.0625, 0.625, 0.9375, 0.9375); //7, 0, 1, 10, 15, 15
            case WEST -> VoxelShapes.cuboid(0.375, 0.0, 0.0625, 0.5625, 0.9375, 0.9375); //6, 0, 1, 9, 15, 15
            default -> VoxelShapes.fullCube();
        };
    }

    /**
     * Controls the state of the block when placed.
     * @param context ItemPlacementContext
     * @return Returns the state of the block as it should be when placed.
     */
    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
        return this.getDefaultState()
                .with(HORIZONTAL_FACING, context.getHorizontalPlayerFacing().getOpposite())
                .with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER); //Sets waterlogged state based on the presence of water.
    }

    /**
     * I don't know what this does exactly. It's probably important.
     * @param state Current block's state
     * @param direction Direction
     * @param neighborState Neighboring block's state
     * @param world WorldAccess
     * @param position Current position
     * @param neighborPos Neighboring block's position
     * @return
     */
    @SuppressWarnings("deprecation") // Why is getStateForNeighborUpdate deprecated? Is there a better alternative?
    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos position, BlockPos neighborPos){
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(position, Fluids.WATER, Fluids.WATER.getTickRate(world));
            // 1.17 and Older Versions
            // world.getFluidTickScheduler().schedule(position, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, position, neighborPos);
    }
}
