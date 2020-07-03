package com.terraformersmc.cinderscapesold.mixinterface;

import com.terraformersmc.cinderscapesold.init.CinderscapesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

/**
 * @author <Wtoll> Will Toll on 2020-05-23
 * @project Cinderscapes
 */
public interface AshyBiome {
    default boolean canSetAsh(WorldView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        return blockState.isAir() && CinderscapesBlocks.ASH.getDefaultState().canPlaceAt(world, pos);
    }
}
