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
 * This class is EXPERIMENTAL and does not function properly. Use at your own risk.
 */
public class LightBlock extends HorizontalFacingBlock implements Waterloggable {

    // Variables
    private static final DirectionProperty HORIZONTAL_FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty LIT = BooleanProperty.of("lit"); // Unclear whether this should be private.
    private static final BooleanProperty POWERED = Properties.POWERED;
    private static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    /**
     * [EXPERIMENTAL] Constructor for blocks using the LightBlock class.
     * @param settings Settings
     */
    public LightBlock(Settings settings) {
        super(settings);
        setDefaultState(this.stateManager.getDefaultState()
                .with(HORIZONTAL_FACING, Direction.NORTH)
                //.with(LIT, false) // Sets the default light state to false.
                .with(WATERLOGGED, false) // Sets default waterlogged state to false.
        );
    }

    /**
     * Adds the block's properties.
     * @param stateManager StateManager
     */
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(HORIZONTAL_FACING, LIT, WATERLOGGED);
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
     * Controls the outline of blocks using this class. This function is under development.
     * @param state Current block's state
     * @param view BlockView
     * @param pos Current position
     * @param context ShapeContext
     * @return
     */
    @SuppressWarnings("deprecation") // Why is getOutlineShape()? deprecated? Is there a better alternative?
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        // Block size has not yet been determined, so a full cube is returned currently.
        return switch (direction) {
            // Establishes the correction size for the block in every direction.
            //case NORTH -> VoxelShapes.cuboid(0.0625, 0.0, 0.375, 0.9375, 0.9375, 0.5625); //1, 0, 6, 15, 15, 9
            //case SOUTH -> VoxelShapes.cuboid(0.0625, 0.0, 0.4375, 0.9375, 0.9375, 0.625); //1, 0, 7, 15, 15, 10
            //case EAST -> VoxelShapes.cuboid(0.4375, 0.0, 0.0625, 0.625, 0.9375, 0.9375); //7, 0, 1, 10, 15, 15
            //case WEST -> VoxelShapes.cuboid(0.375, 0.0, 0.0625, 0.5625, 0.9375, 0.9375); //6, 0, 1, 9, 15, 15
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
                .with(HORIZONTAL_FACING, context.getPlayerFacing().getOpposite())
                .with(WATERLOGGED, context.getWorld().getFluidState(context.getBlockPos()).getFluid() == Fluids.WATER); //Sets waterlogged state based on the presence of water.
    }

    /**
     * This function is a mess since this class is in development. I apologize in advance.
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
        // Handles waterlogging.
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(position, Fluids.WATER, Fluids.WATER.getTickRate(world));
            // 1.17 and Older Versions
            //world.getFluidTickScheduler().schedule(position, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        // Handles power and light.
        //if (!world.isClient()) {
            // Turns light off.
            if (state.get(LIT) == true && world.getStrongRedstonePower(position, direction) == 0) {
                world.setBlockState(position, state.with(LIT, false), 2);
            } // Turns light on.
            else if (state.get(LIT) == false && world.getStrongRedstonePower(position, direction) > 0) {
                world.setBlockState(position, state.with(LIT, true), 2);
            }
        //}

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, position, neighborPos);
    }
}
